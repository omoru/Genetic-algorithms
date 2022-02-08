package Funcion1;

import java.util.ArrayList;

import funcionalidadGenetica.FitnessFunction;

public class FitnessFunctionFuncion1 extends FitnessFunction<ElementoFuncion1>  {

	public FitnessFunctionFuncion1(double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
	{
		super(valorObjetivo,  minimos,  maximos,  tolerancia);
	}

	public ElementoFuncion1 generateRandomIndividual()
	{
		Boolean valido = false;
		ElementoFuncion1 elemento = null;
		int tamanoTotal = this.calculaTamanoTotal();
	    while(!valido)
	    {
	    	int contador = 0;
			ArrayList<Boolean> individual = generarCadenaBooleana(tamanoTotal);
			elemento = new ElementoFuncion1 (individual,this.tamanos,this.minimos,this.maximos);
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
	public ElementoFuncion1 creaElementoVacio() {
		return new ElementoFuncion1(new ArrayList<Boolean>(),this.tamanos,this.minimos,this.maximos);
	}
}
