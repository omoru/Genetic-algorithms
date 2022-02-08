package Funcion1;

import java.util.ArrayList;

import funcionalidadGenetica.Elemento;

public class ElementoFuncion1 extends Elemento<Boolean> {
	
	public ElementoFuncion1 (ArrayList<Boolean> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		super(gen, tamanos,minimos, maximos);
	}
	
	public double obtenerValor()
	{
		double x = this.getFenotipo(0);
		double y = this.getFenotipo(1);
		return (21.5 + x * Math.sin(4*Math.PI*x) + y * Math.sin(20*Math.PI*y));
	}

	@Override
	public void modifica (int i)
	{
		if(this.gen.get(i)) this.gen.set(i, false);
		else this.gen.set(i, true);
	}

	
}
