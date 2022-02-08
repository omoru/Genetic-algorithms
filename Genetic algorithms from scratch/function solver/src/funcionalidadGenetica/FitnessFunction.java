package funcionalidadGenetica;

import java.util.ArrayList;
import java.util.Random;


import funcionalidadGenetica.FitnessFunction;
import funcionalidadGenetica.GoalTest;

public abstract class FitnessFunction<A extends Elemento<?>> implements GoalTest 
{
		protected ArrayList<Double> minimos ;
		protected ArrayList<Double> maximos ;
		protected double valorObjetivo;
		protected double tolerancia;
		protected ArrayList<Integer> tamanos;
		
		public FitnessFunction(double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
		{
			this.tamanos = new ArrayList<Integer>();
			this.valorObjetivo = valorObjetivo;
			this.maximos=maximos;
			this.minimos=minimos;
			this.tolerancia = tolerancia;
			for(int i = 0; i < this.minimos.size(); i++)
				this.tamanos.add(calculaTamano(this.minimos.get(i), this.maximos.get(i),this.tolerancia));
		}
		
		public double getValue(A individual)
		{
			return individual.obtenerValor();
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean isGoalState(Object state) {
			A elemento = (A) state;
			return elemento.obtenerValor() == valorObjetivo;
		}
		
		public abstract A generateRandomIndividual();
			
		private int calculaTamano (double min, double max, double tolerancia)
		{
			return (int) (Math.log10( ((max-min) / tolerancia)+1) / Math.log10(2));
		}
		
		public int calculaTamanoTotal()
		{
			int tamanoTotal=0;
			for(int i=0; i<this.tamanos.size();i++)
				tamanoTotal += this.tamanos.get(i);
			return tamanoTotal;
		}
		
		protected ArrayList<Boolean> generarCadenaBooleana(int tamano)  
		{
			
			ArrayList<Boolean> cadena = new ArrayList <Boolean>();
			int tamanoTotal = tamano;
			for(int i=0; i<tamanoTotal;i++)
			{
				cadena.add(new Random().nextBoolean());
			}
			return cadena;
		}
		
		public abstract A creaElementoVacio() ;

		public boolean elementoValido(A mutatedChild) 
		{
			int contador = 0;
			for(int i =0; i<this.maximos.size();i++)
			{
				if(mutatedChild.getFenotipo(i) < this.maximos.get(i))
					contador++;
			}
			return contador ==  this.maximos.size();
		}
}
