package funcionalidadGenetica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract  class Elemento<A> {
	
	protected ArrayList<A> gen;
	protected ArrayList<Integer> tamanos;
	protected ArrayList<Double> minimos;
	protected ArrayList<Double> maximos;
	
	public Elemento(ArrayList<A> gen, ArrayList<Integer> tamanos,ArrayList<Double> minimos,ArrayList<Double> maximos)
	{
		this.gen = gen;
		this.tamanos = tamanos;
		this.minimos = minimos;
		this.maximos = maximos;
	}
	
	public double getFenotipo(int j) 
	{
		if(this.gen.get(j) instanceof Double)
				if(this.gen.get(j) != null) return (double) this.gen.get(j);
		
		double x = 0;
		int inicio = 0;
		for (int i = 0; i<j;i++)
			inicio += this.tamanos.get(i);
		for(int i = inicio; i< inicio+this.tamanos.get(j);i++)
		{
				if((boolean) this.gen.get(i)) x += Math.pow(2,i-inicio);
		}
		return Math.round((this.minimos.get(j) + (this.maximos.get(j) - this.minimos.get(j)) * x/ (Math.pow(2,this.tamanos.get(j)) - 1)) * 1000.0) / 1000.0;
		//return (x / (1 / this.tolerancia)) + this.minimos.get(j);
	}
	
	public abstract void modifica (int i);
	
	public abstract double obtenerValor();

	public ArrayList<A> getLista() {
		return this.gen;
	}
	
	@SuppressWarnings("unchecked")
	public void insertaParte(int index, List<?>list) {
		this.gen.addAll(index, (Collection<? extends A>) list);
	}
	
	@Override
	public String toString()
	{
		String c= "";
		for (int i =0; i<this.tamanos.size();i++)
			c += "Variable "+i+" = "+ this.getFenotipo(i)+ '\n';
		return c +"Valor: "+  (this.obtenerValor());
	}
}
