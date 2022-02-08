package operadores;

import java.util.ArrayList;


import funcionalidadGenetica.Individuo;

public class Seleccion 
{
	ArrayList<Individuo> pob;
	
	public Seleccion(ArrayList<Individuo> pob) {
		this.pob=pob;
	}
	
	
	
	
	 ArrayList<Individuo> torneoDeterministico(ArrayList<Individuo> pob,int participantes){
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		
		int pos_rand=(int)(Math.random() * pob.size());
		int pos_min;
		double min;
		int[] fValues = new int[participantes];
		
		for(int j=0; j < pob.size();j++) {
			pos_min=pos_rand;
			min=pob.get(pos_min).getAdaptacion();
			for(int i=0; i < participantes;++i) {
				fValues[i]=pob.get(pos_rand).getAdaptacion();
				if(fValues[i]<min) {
					pos_min=pos_rand;
					min=pob.get(pos_min).getAdaptacion();
				}
				pos_rand=(int)(Math.random() * pob.size());
			}
		
		pobAux.add(pob.get(pos_min));
		
		}
		
		return pobAux;
	}
	
	 ArrayList<Individuo> torneoProbabilistico(ArrayList<Individuo> pob,int participantes){
		
			ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
			
			int pos_rand=(int)(Math.random() * pob.size());
			int pos_min,pos_max;
			double min,max,prob,rand;
			
			int[] fValues = new int[participantes];			
			for(int j=0; j < pob.size();j++) {
				pos_min=pos_rand;
				pos_max=pos_rand;
				min=pob.get(pos_min).getAdaptacion();
				max=min;
				rand=Math.random();
				prob = 0.1 + (0.4) * Math.random();
				for(int i=0; i < participantes;++i) {
					fValues[i]=pob.get(pos_rand).getAdaptacion();
					if(fValues[i]<min) {
						pos_min=pos_rand;
						min=pob.get(pos_min).getAdaptacion();
					}
					if(fValues[i]>max) {
						pos_max=pos_rand;
						max=pob.get(pos_max).getAdaptacion();
					}
					pos_rand=(int)(Math.random() * pob.size());
				}
			
				if(rand>prob) {
					pobAux.add(pob.get(pos_max));
				}
				else pobAux.add(pob.get(pos_min));
				
				
			}
			
			return pobAux;
	}
	
	
	ArrayList<Individuo> seleccionRuleta(ArrayList<Individuo> pob){
		
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		ordenarPuntAcum();
		double prob;
		for(int i=0; i < pob.size();++i) {
			prob= Math.random() * 1;
			int j=0;
			while(j<pob.size() && prob > pob.get(j).getPunt_acum())j++;
			if(j==pob.size())j--;
			pobAux.add(pob.get(j));
		}
		
		return pobAux;
	}
	
	ArrayList<Individuo> seleccionEstocastica(ArrayList<Individuo> pob){
		double pop = 1.0/pob.size();
		double probEstocast= Math.random() * pop;
		ordenarPuntAcum();
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		for(int i=0; i < pob.size();++i) {
			int j=0;
			while(j<pob.size() && probEstocast > pob.get(j).getPunt_acum())j++;
			pobAux.add(pob.get(j));
			probEstocast+=pop;
		}
		
		return pobAux;
		
		
	}
	
	ArrayList<Individuo> seleccionTruncamiento(ArrayList<Individuo> pob,double probTrunc){
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>();
		int numMejores=(int) (probTrunc*pob.size());
		ordenaFitness();
		for(int i=0; i < pob.size();++i) {
			pobAux.add(pob.get(i%numMejores));		
		}
		
		return pobAux;
	}
	
	ArrayList<Individuo> seleccionRanking(ArrayList<Individuo> pob	){
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		ordenaFitness();
		for(int i=0; i < pob.size();i++) pob.get(i).setPunt_acum((double)(1/(i+1)));
		pobAux=this.seleccionRuleta(pob);
		return pobAux;
	}
	
	
	
	ArrayList<Individuo> seleccionBajoMedia(ArrayList<Individuo> pob,double media){
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		int pos_rand;
		int margen=pob.get(pob.size()-1).getAdaptacion()-pob.get(0).getAdaptacion();
		ordenaFitness();
		int j=0;
		while(j < pob.size() && pob.get(j).getAdaptacion()< media+(margen/media))j++;
		for(int i=0; i < pob.size();i++) {
			pos_rand=(int)(Math.random() * j);
			pobAux.add(pob.get(pos_rand));
		}
		
		
		return pobAux;
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
		
		private void ordenarPuntAcum() {
			
	        int i, j;
	        Individuo aux=null;
	        for(i=0;i<pob.size();i++)

	             for(j=0;j<pob.size()-1;j++)
	             if (pob.get(j).getPunt_acum() > pob.get(j+1).getPunt_acum()) {
	            	 aux=pob.get(j);
	            	 pob.set(j,pob.get(j+1));
	            	 pob.set(j+1,aux);
	            	           
	             }
	            		                             		 
	}
	
	

}
