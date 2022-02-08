package operadores;

import java.util.ArrayList;
import java.util.Arrays;

import funcionalidadGenetica.Individuo;

public class Mutacion {
	
	ArrayList<Individuo> pob;
	
	public Mutacion(ArrayList<Individuo> pob) {
		this.pob=pob;
	}

	
	public void mutacionInversion(Individuo ind,int punto1,int punto2) {
		int i= punto1+1;
		int j=punto2-1;
		while( j>i) {
			int aux=ind.getGenes().get(i);
			ind.getGenes().set(i,ind.getGenes().get(j));
			ind.getGenes().set(j,aux);
			j--;
			i++;
		}
		
	}
	
	public void mutacionIntercambio(Individuo ind,int punto1,int punto2) {

		int aux=ind.getGenes().get(punto1-1);
		ind.getGenes().set(punto1-1,ind.getGenes().get(punto2-1));
		ind.getGenes().set(punto2-1,aux);
		
	}
	
	public void mutacionInsercion(Individuo ind, int numcities){
		 int pos_insertar,pos_ciudad,a,b;
		for(int j=0; j < numcities;j++) {
		
			a=(int) (Math.random() * ind.getLong_indv()-1)+1;
			b=(int) (Math.random() * ind.getLong_indv()-1)+1;
			if(a<b) {
				pos_insertar=a;
				pos_ciudad=b;
			}
			else {
				pos_insertar=b;
				pos_ciudad=a;
			}
			int aux=ind.getGenes().get(pos_ciudad);
			for(int i=pos_ciudad; i > pos_insertar;i--) {
				ind.getGenes().set(i,ind.getGenes().get(i-1));
			}			
			ind.getGenes().set(pos_insertar, aux);	
		}
		
	}
	
	public void mutacionHeuristica(Individuo ind) {
             
              int  numero = 3; //(int) (Math.random() * (ind.getLong_indv()-1)) + 1;
              ArrayList<Integer> posiciones = new ArrayList();
              
              int k = (int) (Math.random() * (ind.getLong_indv()-1)) + 1;
              for (int i= 0 ; i< numero; i++)
              {
                while(posiciones.contains(k))
                {
                  k =  (int) (Math.random() * (ind.getLong_indv()-1)) + 1;
                }
                posiciones.add(k);    
              }
              
              System.out.println(ind.getAdaptacion());
              this.permutaciones(posiciones,ind);
              System.out.println(ind.getAdaptacion());
	}
	
	private void swap(int[] arr, int i, int j)
	{
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}

	private void permute(int[] arr, int i)
	{
	    if (i == arr.length)
	    {
	        System.out.println(Arrays.toString(arr));
	        return;
	    }
	    for (int j = i; j < arr.length; j++)
	    {
	        swap(arr, i, j); 
	        permute(arr, i + 1);  // recurse call
	        swap(arr, i, j);      // backtracking
	    }
	}
        
        
        private Individuo permutaciones(ArrayList<Integer> posiciones, Individuo ind ){
            
            Individuo mejor = new Individuo(ind.getCiudadInicial());mejor.copiaIndividuo(ind);
            System.out.println(mejor.getAdaptacion());
            if(posiciones.size()<=1) return ind;
            else {
                for (int i= 0; i< posiciones.size();i++)
                {
                    ind.modifica(posiciones.get(0),posiciones.get(i));
                    int auxPosiciones = posiciones.get(0);
                    posiciones.remove(0); 
                    Individuo resultado = permutaciones(posiciones,ind);
                    posiciones.add(0, auxPosiciones);
                    if(resultado.getAdaptacion() < ind.getAdaptacion())
                    {
                        mejor = resultado;
                    }
                }
            }
            return mejor;
        }
        
        public void mutacionUnitaria(Individuo ind,int num_cities) {
    		int pos_rand;
    		for(int i=0; i < num_cities;i++) {
    			pos_rand=(int)(Math.random() * (ind.getLong_indv()-2));
    			if(ind.getGenes().get(pos_rand)>ind.getGenes().get(pos_rand+1)) {
    				int aux= ind.getGenes().get(pos_rand);
    				ind.getGenes().set(pos_rand,ind.getGenes().get(pos_rand+1));
    				ind.getGenes().set(pos_rand+1,aux);				
    			}
    			else {
    				int aux= ind.getGenes().get(pos_rand);
    				ind.getGenes().set(pos_rand,aux+1);
    				int j=0;
    				while(j < ind.getLong_indv() && ind.getGenes().get(j)!=aux+1)j++;
    				ind.getGenes().set(j,aux);
    				
    			}
    		}
    	}
}
     
