package Funcion3;

import java.util.ArrayList;
import funcionalidadGenetica.Elemento;

public class ElementoFuncion3 extends Elemento<Boolean> 
{
			
	public ElementoFuncion3(ArrayList<Boolean> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		super(gen, tamanos, minimos, maximos);
	}
			
			
	public double obtenerValor()
	{
		double x = this.getFenotipo(0);
		double y = this.getFenotipo(1);
		double valor1=0;double valor2=0;
		for (int i =1; i<6;i++)
		{
			valor1 += i*Math.cos((i+1)*x+i);
			valor2 += i*Math.cos((i+1)*y+i);
		}
		return (valor1*valor2-100)*-1;
	}


	@Override
	public void modifica (int i)
	{
		if(this.gen.get(i)) this.gen.set(i, false);
		else this.gen.set(i, true);
	}
			
}
