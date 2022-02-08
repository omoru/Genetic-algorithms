package Funcion2;

import java.util.ArrayList;

import funcionalidadGenetica.FitnessFunction;

public class FitnessFunctionFuncion2 extends FitnessFunction<ElementoFuncion2>  {

	public FitnessFunctionFuncion2(double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
	{
		super(valorObjetivo,  minimos,  maximos,  tolerancia);
	}
	
	public ElementoFuncion2 generateRandomIndividual()
	{
		Boolean valido = false;
		ElementoFuncion2 elemento = null;
		int tamanoTotal = this.calculaTamanoTotal();
	    while(!valido)
	    {
	    	int contador = 0;
			ArrayList<Boolean> individual = generarCadenaBooleana(tamanoTotal);
			elemento = new ElementoFuncion2 (individual,this.tamanos,this.minimos,this.maximos);
			for(int i =0; i<this.maximos.size();i++)
			{
				if(elemento.getFenotipo(i) < this.maximos.get(i))
					contador++;
			}
			if (contador == this.maximos.size())
				valido = true;
	    }
	    return elemento;
	 }
	
	@Override
	public ElementoFuncion2 creaElementoVacio() {
		return new ElementoFuncion2(new ArrayList<Boolean>(),this.tamanos,this.minimos,this.maximos);
	}
}
