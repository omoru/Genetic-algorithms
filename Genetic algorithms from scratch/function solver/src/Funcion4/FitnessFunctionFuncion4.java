package Funcion4;

import java.util.ArrayList;
import funcionalidadGenetica.FitnessFunction;

public class FitnessFunctionFuncion4 extends FitnessFunction<ElementoFuncion4> {
 
	public FitnessFunctionFuncion4 (double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
	{
		super(valorObjetivo,  minimos,  maximos,  tolerancia);
	}
	
	public ElementoFuncion4 generateRandomIndividual()
	{
		Boolean valido = false;
		ElementoFuncion4 elemento = null;
		int tamanoTotal = this.calculaTamanoTotal();
	    while(!valido)
	    {
	    	int contador = 0;
			ArrayList<Boolean> individual = generarCadenaBooleana(tamanoTotal);
			elemento = new ElementoFuncion4 (individual,this.tamanos,this.minimos,this.maximos);
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
	public ElementoFuncion4 creaElementoVacio() {
		return new ElementoFuncion4(new ArrayList<Boolean>(),this.tamanos,this.minimos,this.maximos);
	}
}
