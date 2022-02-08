package funcionalidadGenetica;

import java.util.ArrayList;


public class ResultadosGraficos {

	private ArrayList<Double> bestAbsolut;
	private ArrayList<Double> bestGeneration;
	private ArrayList<Double> mediaGeneracion;
        private Individuo bestIndividuo;
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
        
        public void addBestIndividuo(Individuo ind){this.bestIndividuo =  ind;}
	public ArrayList<Double> getBestAbsolut(){return bestAbsolut;}
	public ArrayList<Double> getBestGeneration(){return bestGeneration;}
	public ArrayList<Double> getMediaGeneracion(){return mediaGeneracion;}
        public Individuo getBestIndividuo(){return bestIndividuo;}

}
