package Funcion3;

import java.util.ArrayList;

import funcionalidadGenetica.FitnessFunction;

public class FitnessFunctionFuncion3 extends FitnessFunction<ElementoFuncion3>  {

	public FitnessFunctionFuncion3(double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
	{
		super(valorObjetivo,  minimos,  maximos,  tolerancia);
	}
			
	public ElementoFuncion3 generateRandomIndividual()
	{
		Boolean valido = false;
		ElementoFuncion3 elemento = null;
		int tamanoTotal = this.calculaTamanoTotal();
	    while(!valido)
	    {
	    	int contador = 0;
			ArrayList<Boolean> individual = generarCadenaBooleana(tamanoTotal);
			elemento = new ElementoFuncion3 (individual,this.tamanos,this.minimos,this.maximos);
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
	public ElementoFuncion3 creaElementoVacio() {
		return new ElementoFuncion3(new ArrayList<Boolean>(),this.tamanos,this.minimos,this.maximos);
	}
}
