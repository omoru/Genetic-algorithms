package funcionalidadGenetica;

import java.util.ArrayList;
import operadores.OperadorGenetico;


public class AlgoritmoGenetico {
	
	private ArrayList<Individuo> pob; 
	private final int tam_pob;
	private final int num_max_generations;
        private final int ciudad_inicio;
	private Individuo best_indv;
	private final double prob_cruce;
	private final double prob_mut;
	private double best_media;
	
	public AlgoritmoGenetico(int tam_pob, int num_max_generations, double prob_cruce, double prob_mut, int ciudadInicio) {
		
		this.tam_pob = tam_pob;
		this.num_max_generations = num_max_generations;
		this.prob_cruce = prob_cruce;
		this.prob_mut = prob_mut;
		this.pob  = new ArrayList<Individuo>(tam_pob);
                this.ciudad_inicio = ciudadInicio;
	}
        
        public ResultadosGraficos AlgortimoGenetico(double elitismo,String tipoSeleccion,String tipoCruce, String tipoMutacion ) 
        {
            inicializarPoblacion(this.ciudad_inicio);
            ResultadosGraficos rg = new ResultadosGraficos();
            evaluaPoblacion();
            double media=calculaMedia();  
            double mejorGeneracion = this.getBestValor();
            double mejorAbsoluto = mejorGeneracion;
            rg.addBestIndividuo(this.getBestIndividuo());
            ArrayList<Individuo> elite= new ArrayList<Individuo>();
            OperadorGenetico op= new OperadorGenetico(this.pob, this.prob_mut, prob_cruce);
            if(elitismo!=0){ 
       		 ordenaFitness();
       		elite=calculaElite(elitismo);
            }
            for(int i=0;i < num_max_generations; i++)
            {	
            
                pob=op.seleccion(tipoSeleccion,3,media);
                pob=op.reproduccion(tipoCruce,3);
                pob=op.mutacion(tipoMutacion,3);
                evaluaPoblacion();
                
                mejorGeneracion = this.getBestValor();
          	  if(mejorGeneracion <  mejorAbsoluto)
                {
                    mejorAbsoluto = mejorGeneracion;
                    rg.addBestIndividuo(this.getBestIndividuo());
                }
            	if(elitismo!=0) {
            		aplicaElitismo(elite, elitismo);
            		elite=calculaElite(elitismo);
            	}
            		
            	  media=calculaMedia();
                  
                
                if(media<best_media) this.best_media=media;   
        	rg.addValor(mejorAbsoluto, mejorGeneracion, media);
            }
	    return rg;
	}
	
        
        private void aplicaElitismo(ArrayList<Individuo> elite,double elitismo){
        	 ordenaFitness();
             for(int j=0; j< elite.size();j++)  //sustituyes por los peores
             {
               pob.set(pob.size()-1-j,elite.get(j));
             }
             
             ordenaFitness();
             evaluaPoblacion();
            
         
        }
	private ArrayList<Individuo> calculaElite(double elitismo){
		ArrayList<Individuo> elite= new ArrayList<Individuo>();
		
		for(int j=0; j < elitismo*tam_pob;j++) elite.add(pob.get(j));
		return elite;
		
	}
	
	private void ordenaFitness() {
		
        int i, j;
        Individuo aux=null;
        for(i=0;i<pob.size();i++)
             for(j=0;j<pob.size()-1;j++)
             if (pob.get(j).getAdaptacion() >pob.get(j+1).getAdaptacion()) {
            	 aux=pob.get(j);
            	 pob.set(j,pob.get(j+1));
            	 pob.set(j+1,aux);
            	           
             }
            		                             		 

	
}
	
	private double calculaMedia()
        {
            double x=0;
            for(int i=0; i < tam_pob;++i) 
            {
                x+=pob.get(i).getAdaptacion();
            }
            if(x/tam_pob < best_media) 
            {
                best_media=x/tam_pob;
            }
            return x/tam_pob;
	}
		
        private double getBestValor()
        {
            double x=Integer.MAX_VALUE;
            for(int i=0; i < tam_pob;++i) 
            {
                if(pob.get(i).getAdaptacion()< x) x = pob.get(i).getAdaptacion();
            }
            return x;
        }
        
        private Individuo getBestIndividuo()
        {
            Individuo ind=null ;  double x=Integer.MAX_VALUE;
            for(int i=0; i < tam_pob;++i) 
            {
                if(pob.get(i).getAdaptacion()< x)
                {
                    x = pob.get(i).getAdaptacion();
                    ind = pob.get(i);
                }
            }
            return ind;
        }
        
	private void inicializarPoblacion(int ciudad_inicio) 
        {
            for(int i=0; i < tam_pob; ++i) 
            {
		Individuo ind=new Individuo(ciudad_inicio);
		ind.inicializarIndividuo();
		pob.add(ind);
            }
            this.best_indv=pob.get(0);	
	}
	
	
		
	
	
	private void evaluaPoblacion() {
		double punt_acu=0;
		double sum_apt=0;
		int posaux=0;
		int max=Integer.MAX_VALUE;
		double best_apt=0;
		
		for(int i=0; i < tam_pob;++i) {
			pob.get(i).evalua();
			sum_apt+=max/pob.get(i).getAdaptacion();
			if( max/pob.get(i).getAdaptacion()> best_apt) {
				posaux=i;
				best_apt=max/pob.get(i).getAdaptacion();
			}
				
		}
		
		if(best_apt >max/this.best_indv.getAdaptacion()) {
			this.best_indv=pob.get(posaux);
		}
		
		for(int i=0; i < tam_pob;i++) {
			this.pob.get(i).setProb_sel(max/pob.get(i).getAdaptacion()/sum_apt);
			this.pob.get(i).setPunt_acum(pob.get(i).getProb_sel()+ punt_acu);
			punt_acu+=pob.get(i).getProb_sel();
			
		}
		
		
	}

	public void pobtostring() {
		for(int i=0; i < this.pob.size();++i) {
			System.out.println(pob.get(i).getAdaptacion()+ "   " +pob.get(i).toString());
		}
		System.out.println("Best: "+ this.best_indv.getAdaptacion()+ "\"\n");
	}

}
