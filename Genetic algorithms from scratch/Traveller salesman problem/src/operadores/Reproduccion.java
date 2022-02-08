package operadores;

import java.util.ArrayList;


import funcionalidadGenetica.Individuo;

public class Reproduccion{

	ArrayList<Individuo> pob;
	
	public Reproduccion(ArrayList<Individuo> pob) {
		this.pob=pob;	
	}
	

	Individuo CXReproduccion(Individuo padre1, Individuo padre2){
		Individuo x=new Individuo();
		ArrayList<Integer> posFijas= new ArrayList<Integer>();
		boolean completed=false;
		int ini_ciclo= padre1.getGenes().get(0);
		
		int pos=0;/// posicion en el array
		while(!completed) {
		
			if(ini_ciclo==padre2.getGenes().get(pos))
				completed=true;
			else {
				x.getGenes().set(pos,padre2.getGenes().get(pos));
				posFijas.add(pos);
				pos= perteneceAsubcadena(padre2.getGenes().get(pos),padre1.getGenes());
			}
			
		
		}
		for(int j=0; j < padre2.getLong_indv();++j) {
			if(perteneceAsubcadena(j,posFijas)==-1){
				x.getGenes().set(j,padre2.getGenes().get(j));
			}
			
		}
		
		return x;
		
	}
	
	 Individuo VoxReproduccionPos(Individuo padre1, Individuo padre2,int numelems) { 
		 ArrayList<Integer> pos_rand= new ArrayList<Integer>(numelems);
		Individuo x=new Individuo();
		boolean exito=true;
		 for(int i=0; i < numelems;i++) {
			pos_rand.add(i,(int) (Math.random() * (padre1.getLong_indv()-1)));
			x.getGenes().set(pos_rand.get(i),padre2.getGenes().get(pos_rand.get(i)));
		 }
		 int pos=pos_rand.get(0);
		 for(int i=pos+1; i < padre1.getLong_indv()+pos;i++) {
			 while(perteneceAsubcadena(padre1.getGenes().get(pos%padre1.getLong_indv()),pos_rand)!=-1) {
					++pos;
					if(pos>=padre1.getLong_indv())return padre1;
				}
			 x.getGenes().set(i%padre1.getLong_indv(),padre1.getGenes().get(pos%padre1.getLong_indv()));
			pos++;
		     
		 }
				
				
			return x;
			
					
	}
	
	 Individuo VoxReproduccion(Individuo padre1, Individuo padre2,int numelems){
		
		Individuo x= new Individuo();
		int [] selected=new int[numelems];
		int [] pos= new int[numelems];
		ArrayList<Integer> posEnPadre= new ArrayList<Integer>(numelems);
		
		for(int i=0; i < numelems;++i) {
			selected[i]=(int) (Math.random() * (padre1.getLong_indv()-1)) + 1;
			pos[i]=perteneceAsubcadena(selected[i],padre1.getGenes());
			posEnPadre.add(i,perteneceAsubcadena(selected[i],padre2.getGenes()));
		}	
		
		burbuja(pos,selected);
		int num=0;
		for(int i=0; i < pob.get(0).getLong_indv();++i) {
			if(perteneceAsubcadena(i,posEnPadre)==-1) x.getGenes().set(i,padre2.getGenes().get(i));
			else {
				x.getGenes().set(i,selected[num]);
				num++;
			}
		}
	
				
		return x;
	}
	
	
	
	Individuo OxReproduccion(Individuo padre1, Individuo padre2,int punto1, int punto2){

		 // empezamos a reccorer desde punto2
		Individuo x= new Individuo();
		ArrayList<Integer> subcad2 = subcadena(padre2,punto1,punto2);
		int lon=padre1.getLong_indv();
		
		for(int j=punto1; j < punto2; ++j) {
			x.getGenes().set(j,subcad2.get(j-punto1));
		}
		
			int i=punto2;
			int pos=i;
			while(i< lon+punto1) {
				while(perteneceAsubcadena(padre1.getGenes().get(pos%lon),subcad2)!=-1) {
					++pos;
				}
				x.getGenes().set(i%lon,padre1.getGenes().get(pos%lon));
				pos++;
				++i;
			}
			
			
		return x;
		
	}
	
	Individuo PmxReproduccion(Individuo padre1, Individuo padre2,int punto1,int punto2) {
		
	
			
			Individuo x= new Individuo();
			int pos=0;
			int n=0;
			ArrayList<Integer> subcad1=subcadena(padre1,punto1,punto2);
			ArrayList<Integer> subcad2 = subcadena(padre2,punto1,punto2);
		
				for(int i=0; i < padre1.getLong_indv();++i) {
					if(i <punto1 || i >=punto2) {
						 pos=perteneceAsubcadena(padre1.getGenes().get(i),subcad2);
						if(pos==-1)  // miramos si pertenece a la subcadena que le va a intercambiar
							x.getGenes().set(i,padre1.getGenes().get(i));
						else // en caso de que se encuentre en dicha subcadena lo cambiamos por su "pareja" del otro padre
							x.getGenes().set(i,subcad1.get(pos));
					}
					
					else {
						x.getGenes().set(i,subcad2.get(n));
						n++;
						
					}
				}	
		
				return x;	
			}

	
	Individuo ErxReproduccion(Individuo padre1, Individuo padre2) {
		Individuo x= new Individuo();
		ArrayList<ArrayList<Integer>> tabla= construyeTabla(padre1, padre2);
		int elem=padre2.getGenes().get(0);
		int shortest;
		int pos_shortest=0;
		for(int i=0;i < padre1.getLong_indv();i++) {
			x.getGenes().set(i, elem);
			shortest=tabla.get(tabla.get(elem-1).get(0)-1).size();
			for(int j=0; j < tabla.get(elem-1).size();j++) {
				if(tabla.get(tabla.get(elem-1).get(j)-1).size()<= shortest && tabla.get(elem-1).get(j)!=elem) {
					pos_shortest=j;
					shortest=tabla.get(tabla.get(elem-1).get(j)-1).size();
				}
			}
			elem=tabla.get(elem-1).get(pos_shortest);
			
		}
		return x;
	}
	
	
	private ArrayList<ArrayList<Integer>> construyeTabla(Individuo padre1, Individuo padre2){
		
		ArrayList<ArrayList<Integer>> tabla= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> conectados= new ArrayList<Integer>();
		int pos;
		for(int i=1; i <= padre1.getLong_indv();i++) {
			pos=perteneceAsubcadena(i,padre1.getGenes());
			if(pos==0) pos=padre1.getLong_indv();
			conectados.add(padre1.getGenes().get((pos-1)%padre1.getLong_indv()));
			conectados.add(padre1.getGenes().get((pos+1)%padre1.getLong_indv()));
			pos=perteneceAsubcadena(i,padre2.getGenes());
			if(pos==0) pos=padre1.getLong_indv();

			if(perteneceAsubcadena(padre2.getGenes().get((pos+1)%padre1.getLong_indv()),conectados)==-1) {
				conectados.add(padre2.getGenes().get((pos+1)%padre1.getLong_indv()));
			}
			if(perteneceAsubcadena(padre2.getGenes().get((pos-1)%padre1.getLong_indv()),conectados)==-1) {
				conectados.add(padre2.getGenes().get((pos-1)%padre1.getLong_indv()));
			}
			
			tabla.add(conectados);
			
		}
		return tabla;
		
	}
	
	Individuo reproduccionProbabilistica(Individuo padre1, Individuo padre2) { // le asigna la mayor probabilidad al mas apto y se genera un rand para ver cual coger
		Individuo x= new Individuo();
		double prob=Math.random();
		double rand;
		int mejor=2;
		if(1-prob>prob) prob=1-prob;
		if(padre1.getAdaptacion()<padre2.getAdaptacion()) {
			mejor=1;
		}		
		for(int i=0; i < padre1.getLong_indv();i++) {
			rand=Math.random();
			if(rand < prob) {
				if(mejor==1)
				x.getGenes().set(i,padre1.getGenes().get(i));
				else x.getGenes().set(i,padre2.getGenes().get(i));
			}
			else {
				if(mejor==1)
				x.getGenes().set(i,padre2.getGenes().get(i));
				else x.getGenes().set(i,padre1.getGenes().get(i));
			}
		
		}
		return x;
	}

	public void burbuja(int[] A,int [] B){

        int i, j;
        int aux;
        int posaux;
        for(i=0;i<A.length-1;i++)

             for(j=0;j<A.length-1;j++)
             if (A[j] > A[j+1]) {
            	 posaux=B[j];
            	 aux=A[j];
            	 B[j]=B[j+1];
            	 A[j]=A[j+1];
            	 A[j+1]=aux;
            	 B[j+1]=posaux;            
             }
            		                             		 

	}
	
	private int perteneceAsubcadena(int n,ArrayList<Integer> sub) {
		int b=-1;
		for(int i =0; i < sub.size();++i) {
			if(sub.get(i)==n) b=i;
		}
		return b;
	}
		
	private ArrayList<Integer> subcadena(Individuo padre, int p1, int p2){
		ArrayList<Integer> sub= new ArrayList<Integer>();
		for(int i=p1; i < p2;++i) sub.add(padre.getGenes().get(i));
		
		return sub;
	}
	
	protected int randomOffset(int n) {
		return  (int) (Math.random() * n) + 1;
	}
	Individuo CordReproduccion(Individuo padre1, Individuo padre2)
    {
        ArrayList<Integer>  listaDinamica = new ArrayList<>();
        for(int i =0; i< padre1.getGenes().size();i++) listaDinamica.add(i+1);
        
        ArrayList<Integer> newElemento= new ArrayList<>();
        
        for(int i =0; i<padre1.getGenes().size();i++)
        {
            int j=0;
            while( j < listaDinamica.size() && padre1.getGenes().get(i) != listaDinamica.get(j))
            {
                j++;
            }
            if(padre1.getGenes().get(i) == listaDinamica.get(j)){
                newElemento.add(j);
                listaDinamica.remove(j);
            }
        }
        
        listaDinamica = new ArrayList<>();
        for(int i =0; i< padre1.getGenes().size();i++)listaDinamica.add(i+1);
        ArrayList<Integer> newElemento2 = new ArrayList<>();
        
       for(int i =0; i<padre1.getGenes().size();i++)
       {
            int j=0;
            while( j < listaDinamica.size() && padre2.getGenes().get(i) != listaDinamica.get(j))
            {
                j++;
            }
            if(padre2.getGenes().get(i) == listaDinamica.get(j)){
                newElemento2.add(j);
                listaDinamica.remove(j);
            }
       }
        int rand= (int) (Math.random() * (padre1.getGenes().size()-1));
 
        Individuo ind = new Individuo(padre1.getCiudadInicial());
        ArrayList<Integer> cadena = (unirCadena(newElemento,newElemento2,rand,padre1.getGenes().size()));
       
        
        listaDinamica = new ArrayList<>();
        for(int i =0; i< padre1.getGenes().size();i++)listaDinamica.add(i+1);
        ind.setGenes(decodificaCadena(cadena, listaDinamica));
        
        return ind;
    }
    


    private ArrayList<Integer> unirCadena(ArrayList<Integer> cadena1, ArrayList<Integer> cadena2 , int pos, int tam)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= 0;i <= pos;i++)
        {
            list.add(cadena1.get(i));
        }
        for(int i=pos+1; i<tam; i++)
        {
            list.add(cadena2.get(i));
        }
        return list;
    }
    
    private ArrayList<Integer> decodificaCadena(ArrayList<Integer> cadena,ArrayList<Integer> lista)
    {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for(int i = 0; i<cadena.size(); i++)
        {
           resultado.add(lista.get(cadena.get(i)));
           lista.remove(lista.get(cadena.get(i)));
        }
        return resultado;
    }

}
