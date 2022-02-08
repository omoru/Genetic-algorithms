package Funcion2;

import java.util.ArrayList;

import funcionalidadGenetica.Elemento;

public class ElementoFuncion2 extends Elemento<Boolean> {

	public ElementoFuncion2 (ArrayList<Boolean> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		super(gen, tamanos, minimos, maximos);
	}
	
	public double obtenerValor()
	{
		double x = this.getFenotipo(0);
		double y = this.getFenotipo(1);
		double valor = (-(y +47)*Math.sin(Math.sqrt(Math.abs((y+(x/2)+47)))) - x*Math.sin((Math.sqrt(Math.abs(x-(y+47))))));
		return (valor-900)*-1;
	}
		
	@Override
	public String toString()
	{
		String c= "";
		for (int i =0; i<this.tamanos.size();i++)
			c += "Variable "+i+" = "+ this.getFenotipo(i)+ '\n';
		return c +"Valor: "+  (this.obtenerValor()*-1 + 900);
	}
	@Override
	public void modifica (int i)
	{
		if(this.gen.get(i)) this.gen.set(i, false);
		else this.gen.set(i, true);
	}
}

