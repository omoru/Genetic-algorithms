package Funcion4;

import java.util.ArrayList;
import java.util.Random;

import funcionalidadGenetica.Elemento;

public class ElementoFuncion4Extra extends Elemento<Double> {

	
	public ElementoFuncion4Extra(ArrayList<Double> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		super(gen, tamanos, minimos, maximos);
	}
		
	public  double obtenerValor() 
	{
		double valor=0;
		for(int i=0; i<this.gen.size();i++)
		{
			double x = this.gen.get(i);
			valor += Math.sin(x)*(Math.pow(Math.sin((i+1*x*x)/Math.PI), 20));
		}
		return valor;
	}	
	
	@Override
	public String toString()
	{
		String c= "";
		for (int i =0; i<this.gen.size();i++)
			c += "Variable"+i+" ="+ this.gen.get(i)+ '\n';
		return c +" Valor: "+  (this.obtenerValor());
	}


	@Override
	public void modifica(int i) {
	
		double valor;
		do {
			valor = new Random().nextDouble();
		} while (valor < this.minimos.get(i)|| valor> this.maximos.get(i));
		this.gen.set(i, valor);
	}
}
