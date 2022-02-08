import pygame
import neat
import random
import os
pygame.font.init()

WINDOW_WIDTH = 600
WINDOW_HEIGHT = 800
window = pygame.display.set_mode((WINDOW_WIDTH,WINDOW_HEIGHT))

BIRD_IMAGES =  [pygame.transform.scale2x(pygame.image.load(os.path.join("imgs","bird" + str(x) + ".png"))) for x in range(1,4)]

BASE_IMAGE = pygame.transform.scale2x(pygame.image.load(os.path.join("imgs","base.png")).convert_alpha())

BACKGROUND_IMAGE =  pygame.transform.scale(pygame.image.load(os.path.join("imgs","bg.png")).convert_alpha(), (600, 900))

PIPE_IMAGE = pygame.transform.scale2x(pygame.image.load(os.path.join("imgs","pipe.png")).convert_alpha())

STAT_FONT = pygame.font.SysFont("comicsans",60)

class Bird:
    IMAGES = BIRD_IMAGES
    MAX_ROTATION = 45 #For the direction of the bird
    ROTATION_VEL = 20
    ANIMATION_TIME = 5

    def __init__(self,x,y):
        self.x=x
        self.y = y
        self.rotation = 0 
        self.tick_count=0
        self.vel = 0
        self.height = self.y
        self.img_count = 0
        self.img = self.IMAGES[0]

    def jump(self):
        self.vel = -6.5 # Negative because top left corner is (0,0), so for going up in y axe we need negative values, and for going down we need positive ones
        self.tick_count = 0 #Reset tick count
        self.height = self.y

    def draw(self,window):
        self.img_count+=1
        if self.img_count < self.ANIMATION_TIME:
            self.img=self.IMAGES[0]
        elif self.img_count < self.ANIMATION_TIME*2:
            self.img=self.IMAGES[1]
        elif self.img_count < self.ANIMATION_TIME*3:
            self.img=self.IMAGES[2]
        elif self.img_count < self.ANIMATION_TIME*4:
            self.img=self.IMAGES[1]
        elif self.img_count == self.ANIMATION_TIME*4 + 1:
            self.img=self.IMAGES[0]
            self.img_count=0

        if self.rotation <= -80:
            self.img = self.IMAGES[1]
            self.img_count = self.ANIMATION_TIME*2
        
        rotated_image = pygame.transform.rotate(self.img,self.rotation)
        new_rect = rotated_image.get_rect(center= self.img.get_rect(topleft = (self.x,self.y)).center)
        window.blit(rotated_image,new_rect.topleft)
    
    #For check collides
    def get_mask(self):
        return pygame.mask.from_surface(self.img)


    def cycle(self):
        self.tick_count+=1
        #
        d = self.vel * self.tick_count + 1.5 * self.tick_count**2 
        #Dont decelerate too fast
        if d >16:
            d = 16
        if d < 0:
            d-=2

        self.y += d

        #Rotate bird slightly up
        if d < 0 or self.y < self.height + 50:
            if self.rotation < self.MAX_ROTATION:
                self.rotation=self.MAX_ROTATION
        else:
            #Rotate bird 90 degrees down
            if self.rotation > -90:
                self.rotation -= self.ROTATION_VEL


class Pipe:
    GAP = 100
    VEL = 10

    def __init__(self,x):
        self.x=x
        self.height = 0
        self.top = 0
        self.bottom = 0
        self.PIPE_TOP = pygame.transform.flip(PIPE_IMAGE,False,True)
        self.PIPE_BOTTOM = PIPE_IMAGE
        self.passed=False
        self.set_height()
    
    def set_height(self):
        self.height = random.randrange(40,450)
        self.top = self.height - self.PIPE_TOP.get_height()
        self.bottom = self.height + self.GAP
    
    def draw(self,window):
        window.blit(self.PIPE_TOP,(self.x,self.top))
        window.blit(self.PIPE_BOTTOM,(self.x,self.bottom))

    def collide(self,bird):
        bird_mask = bird.get_mask()
        top_mask = pygame.mask.from_surface(self.PIPE_TOP)
        bottom_mask = pygame.mask.from_surface(self.PIPE_BOTTOM)
        top_offset = (self.x - bird.x,self.top - round(bird.y))
        bottom_offset = (self.x - bird.x, self.bottom - round(bird.y))

        collition_b_point = bird_mask.overlap(bottom_mask,bottom_offset)
        collition_t_point = bird_mask.overlap(top_mask,top_offset)
        if collition_b_point or collition_t_point:
            return True
        return False

    def cycle(self):
        self.x-= self.VEL



class Base:
    VEL = 10
    WIDTH = BASE_IMAGE.get_width()
    IMG = BASE_IMAGE

    def __init__(self,y):
        self.y=y
        self.x1=0
        self.x2=self.WIDTH
    
    def draw(self,window):
        window.blit(self.IMG,(self.x1,self.y))
        window.blit(self.IMG,(self.x2,self.y))
    def cycle(self):
        #Vamos moviendo las dos imagenes hacia la izquiera de manera circular
        self.x1 -=self.VEL
        self.x2 -=self.VEL
        if self.x1 + self.WIDTH < 0:
            self.x1 = self.x2 + self.WIDTH
        if self.x2 + self.WIDTH <0:
            self.x2=self.x1 + self.WIDTH


def draw_window(window,birds,pipes,base,score):
    window.blit(BACKGROUND_IMAGE,(0,0)) #Top lef position of the image
    for pipe in pipes:
        pipe.draw(window)
    text = STAT_FONT.render("Score: " + str(score),1,(255,255,255))
    window.blit(text,(WINDOW_WIDTH - text.get_width()-15,10))
    base.draw(window)  
    for bird in birds:  
        bird.draw(window)
    pygame.display.update()



def main(genomes,config):

  

    birds =[]
    ge = []
    nns = [] 

    for _,g in genomes:
        nn = neat.nn.FeedForwardNetwork.create(g,config)
        nns.append(nn)
        birds.append(Bird(230,350))
        g.fitness = 0
        ge.append(g)


    base = Base(730)
    pipes = [Pipe(700)]
    score = 0
    clock = pygame.time.Clock()
    run  = True

    while run:
        #30 tick per second
        clock.tick(30)
        for event in pygame.event.get():
            if(event.type == pygame.QUIT):
                run= False
                pygame.quit()
                quit()
        #bird.cycle()

        pipe_ind = 0
        if len(birds) > 0:
            if len(pipes) > 1 and birds[0].x > pipes[0].x + pipes[0].PIPE_TOP.get_width():
                pipe_ind=1
        else:
            run = False
            break
        for x, bird in enumerate(birds):
            bird.cycle()
            ge[x].fitness += 0.1
            output = nns[x].activate((bird.y,abs(bird.y - pipes[pipe_ind].height),abs(bird.y - pipes[pipe_ind].bottom)))
            if output[0] > 0.5:
                bird.jump()
        add_pipe=False
        rem = []
        for pipe in pipes:
            for x,bird in enumerate(birds):
                if pipe.collide(bird):
                    ge[x].fitness-=1
                    birds.pop(x)
                    nns.pop(x)
                    ge.pop(x)
                if not pipe.passed and pipe.x < bird.x:
                    pipe.passed=True
                    add_pipe= True
            if pipe.x + pipe.PIPE_TOP.get_width() < 0:
                rem.append(pipe)
            pipe.cycle()

        if add_pipe:
            score +=1
            for g in ge:
                g.fitness+=5
            pipes.append(Pipe(700))
        #remove old pipes
        for r in rem:
            pipes.remove(r)

        for x,bird in enumerate(birds):
            if bird.y + bird.img.get_height() >=730 or bird.y < 0:
                birds.pop(x)
                nns.pop(x)
                ge.pop(x)

        base.cycle()
        draw_window(window,birds,pipes,base,score)


def run(config_path):
    config = neat.config.Config(neat.DefaultGenome,neat.DefaultReproduction,neat.DefaultSpeciesSet,neat.DefaultStagnation,config_path)
    population = neat.Population(config)
    population.add_reporter(neat.StdOutReporter(True))
    stats= neat.StatisticsReporter()
    population.add_reporter(stats)

    best = population.run(main,50)

if __name__ == "__main__":
    local_dir = os.path.dirname(__file__)
    config_path = os.path.join(local_dir,"config-neat.txt")
    run(config_path)
