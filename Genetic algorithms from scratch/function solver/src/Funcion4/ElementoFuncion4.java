package Funcion4;

import java.util.ArrayList;

import funcionalidadGenetica.Elemento;


public class ElementoFuncion4  extends Elemento<Boolean>{
	
	public ElementoFuncion4 (ArrayList<Boolean> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		super(gen, tamanos, minimos, maximos);
	}
	
	public double obtenerValor()
	{
		double valor=0;
		for(int i=1; i<this.tamanos.size()+1;i++)
		{
			double x = this.getFenotipo(i-1);
			valor += Math.sin(x)*Math.pow(Math.sin((i+1*x*x)/Math.PI), 20);
		}
		return valor;
	}

	@Override
	public void modifica (int i)
	{
		if(this.gen.get(i)) this.gen.set(i, false);
		else this.gen.set(i, true);
	}
}
