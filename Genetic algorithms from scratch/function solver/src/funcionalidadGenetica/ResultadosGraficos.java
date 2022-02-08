package funcionalidadGenetica;

import java.util.ArrayList;


public class ResultadosGraficos {

	private ArrayList<Double> bestAbsolut;
	private ArrayList<Double> bestGeneration;
	private ArrayList<Double> mediaGeneracion;
	private int generacionActual;
	
	public ResultadosGraficos()
	{
		this.bestAbsolut = new ArrayList<Double>();
		this.bestGeneration = new ArrayList<Double>();
		this.mediaGeneracion = new ArrayList<Double>();
		this.generacionActual=0;
	}
	
	public void addValor(double bestAbsolut, double bestGeneration, double mediaGeneracion)
	{
		this.bestAbsolut.add(this.generacionActual, bestAbsolut);
		this.bestGeneration.add(this.generacionActual, bestGeneration);
		this.mediaGeneracion.add(this.generacionActual, mediaGeneracion);
		generacionActual++;
	}
	public ArrayList<Double> getBestAbsolut(){return bestAbsolut;}
	public ArrayList<Double> getBestGeneration(){return bestGeneration;}
	public ArrayList<Double> getMediaGeneracion(){return mediaGeneracion;}
	
	public void modifica (int valorSumar, boolean negar)
	{
		for (int i =0; i <this.bestAbsolut.size(); i++)
		{
			this.bestAbsolut.set(i, this.bestAbsolut.get(i)+valorSumar);
			this.bestGeneration.set(i, this.bestGeneration.get(i)+valorSumar);
			this.mediaGeneracion.set(i, this.mediaGeneracion.get(i)+valorSumar);
		}
		if(negar)
		{	for (int i =0; i <this.bestAbsolut.size(); i++)
			{
				this.bestAbsolut.set(i, this.bestAbsolut.get(i)*-1);
				this.bestGeneration.set(i, this.bestGeneration.get(i)*-1);
				this.mediaGeneracion.set(i, this.mediaGeneracion.get(i)*-1);
			}
		}
	}
}
