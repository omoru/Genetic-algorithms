package Funcion4;

import java.util.ArrayList;
import java.util.Random;

import funcionalidadGenetica.FitnessFunction;

public class FitnessFunctionFuncion4Extra extends FitnessFunction<ElementoFuncion4Extra> {
 
	public FitnessFunctionFuncion4Extra (double valorObjetivo, ArrayList<Double> minimos, ArrayList<Double> maximos, double tolerancia) 
	{
		super(valorObjetivo,  minimos,  maximos,  tolerancia);
	}
	
	public ElementoFuncion4Extra generateRandomIndividual()
	{
		ElementoFuncion4Extra elemento = null;
		int tamanoTotal = this.calculaTamanoTotal();
		ArrayList<Double> individual = this.generarCadenaDouble(tamanoTotal);
		elemento = new ElementoFuncion4Extra(individual,this.tamanos,this.minimos,this.maximos);
	    return elemento;
	 }
	
	@Override
	public ElementoFuncion4Extra creaElementoVacio() {
		return new ElementoFuncion4Extra(new ArrayList<Double>(),this.tamanos,this.minimos,this.maximos);
	}
	
	private ArrayList<Double> generarCadenaDouble(int tamanoTotal)
	{
		ArrayList<Double> valores=new ArrayList<Double>();
		int parteEntera,parteDecimal;Double valor; 
		
		for (int i=0; i<this.maximos.size();i++)
		{
			parteEntera = new Random().nextInt(this.maximos.get(i).intValue()); parteEntera -= this.minimos.get(i); 
			parteDecimal = new Random().nextInt((int) (1/tolerancia));
			valor = parteEntera + (parteDecimal / (1/tolerancia));
			valores.add(valor);
		}
		return valores;
	}
}
