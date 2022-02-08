package Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Funcion1.FitnessFunctionFuncion1;
import Funcion2.ElementoFuncion2;
import Funcion2.FitnessFunctionFuncion2;
import Funcion3.ElementoFuncion3;
import Funcion3.FitnessFunctionFuncion3;
import Funcion4.ElementoFuncion4;
import Funcion4.ElementoFuncion4Extra;
import Funcion4.FitnessFunctionFuncion4;
import Funcion4.FitnessFunctionFuncion4Extra;
import funcionalidadGenetica.Elemento;
import funcionalidadGenetica.FitnessFunction;
import funcionalidadGenetica.ResultadosGraficos;
import funcionalidadGenetica.algoritmoGenetico;
import gui.Gui;
import Funcion1.ElementoFuncion1;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) 
	{
		
		Gui window = new Gui();
		window.open();

		//Funcion1GeneticAlgorithmSearch(Double.parseDouble(args[0]),Double.parseDouble(args[1]), Double.parseDouble(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]) );
	}
	
	public static ResultadosGraficos FuncionGeneticAlgorithm(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,int numElementos,int problema, Double elitismo,String  seleccion,String reproduccion) 
	{	
		ResultadosGraficos result = null;
		
			ArrayList<Double> minimos = new ArrayList<Double>();ArrayList<Double> maximos = new ArrayList<Double>();
			
			switch (problema) {
				case 1:
					result = problema1(tolerancia, probMutacion, probReproduccion, tamañoPoblacion, maxGeneraciones, minimos, maximos, elitismo,seleccion,reproduccion);
					break;
		
				case 2:
					result = problema2(tolerancia, probMutacion, probReproduccion, tamañoPoblacion, maxGeneraciones, minimos, maximos, elitismo,seleccion,reproduccion);
					break;
			
				case 3:
					result = problema3(tolerancia, probMutacion, probReproduccion, tamañoPoblacion, maxGeneraciones, minimos, maximos, elitismo,seleccion,reproduccion);
				break;
			
				case 4:				
					result = problema4(tolerancia,probMutacion,probReproduccion,tamañoPoblacion,maxGeneraciones,minimos,maximos,numElementos, elitismo, seleccion,reproduccion);
				break;
				case 5:
					result = problema5(tolerancia,probMutacion,probReproduccion,tamañoPoblacion,maxGeneraciones,minimos,maximos,numElementos, elitismo, seleccion,reproduccion);
				break;
			} 
		return result;
	}
	
	private static ResultadosGraficos problema1(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,ArrayList<Double> minimos,ArrayList<Double> maximos, Double  elitismo,String seleccion,String reproduccion)
	{
		minimos.add((double) -3.0);
		minimos.add((double) 4.1);	
		maximos.add((double) 12.1);
		maximos.add((double) 5.8);
		FitnessFunctionFuncion1 fitnessFunction1 = new FitnessFunctionFuncion1(38.839, minimos, maximos, tolerancia);
		Set<ElementoFuncion1> population1 = new HashSet<ElementoFuncion1>();
		for (int i = 0; i < tamañoPoblacion; i++) {
			population1.add(fitnessFunction1.generateRandomIndividual());
		}
		algoritmoGenetico<ElementoFuncion1> ga1 = new algoritmoGenetico<ElementoFuncion1>(fitnessFunction1.calculaTamanoTotal(),fitnessFunction1,probMutacion,probReproduccion);
		ResultadosGraficos resultadosGraficos = ga1.geneticAlgorithm(population1, fitnessFunction1,0L, maxGeneraciones,elitismo,seleccion,reproduccion);
		return resultadosGraficos;
	}
	
	private static ResultadosGraficos problema2(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,ArrayList<Double> minimos,ArrayList<Double> maximos, Double  elitismo,String seleccion,String reproduccion)
	{
		minimos.add((double) -512);
		minimos.add((double) -512);
		maximos.add((double) 512);
		maximos.add((double) 512);
		FitnessFunctionFuncion2 fitnessFunction2 = new FitnessFunctionFuncion2(-959.6407, minimos, maximos, tolerancia);
		Set<ElementoFuncion2> population2 = new HashSet<ElementoFuncion2>();
		for (int i = 0; i < tamañoPoblacion; i++) {
			population2.add(fitnessFunction2.generateRandomIndividual());
		}
		algoritmoGenetico<ElementoFuncion2> ga2 = new algoritmoGenetico<ElementoFuncion2>(fitnessFunction2.calculaTamanoTotal(),fitnessFunction2,probMutacion,probReproduccion);
		ResultadosGraficos resultadosGraficos = ga2.geneticAlgorithm(population2, fitnessFunction2,0L, maxGeneraciones,elitismo,seleccion,reproduccion);
		
		resultadosGraficos.modifica(-900, true);
		return resultadosGraficos;
	}
	
	private static ResultadosGraficos problema3(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,ArrayList<Double> minimos,ArrayList<Double> maximos, Double  elitismo,String seleccion,String reproduccion)
	{
		minimos.add((double) -10);
		minimos.add((double) -10);
		maximos.add((double) 10);
		maximos.add((double) 10);
		FitnessFunctionFuncion3 fitnessFunction3 = new FitnessFunctionFuncion3( -186.7309, minimos, maximos, tolerancia);
		Set<ElementoFuncion3> population3 = new HashSet<ElementoFuncion3>();
		for (int i = 0; i < tamañoPoblacion; i++) {
			population3.add(fitnessFunction3.generateRandomIndividual());
		}
		algoritmoGenetico<ElementoFuncion3> ga3 = new algoritmoGenetico<ElementoFuncion3>(fitnessFunction3.calculaTamanoTotal(),fitnessFunction3,probMutacion,probReproduccion);
		ResultadosGraficos resultadosGraficos = ga3.geneticAlgorithm(population3, fitnessFunction3,0L, maxGeneraciones,elitismo,seleccion,reproduccion);
		resultadosGraficos.modifica(-100, true);
		return resultadosGraficos;
	}
	
	private static ResultadosGraficos problema4(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,ArrayList<Double> minimos,ArrayList<Double> maximos, int numElementos, Double  elitismo,String seleccion,String reproduccion)
	{

		for(int i= 0; i<numElementos; i++)
		{
			 minimos.add((double) 0);
			 maximos.add(Math.PI);
		}
		FitnessFunctionFuncion4 fitnessFunction4 = new FitnessFunctionFuncion4(-3.89, minimos, maximos, tolerancia);
		Set<ElementoFuncion4> population4 = new HashSet<ElementoFuncion4>();
		for (int i = 0; i < tamañoPoblacion; i++) {
			population4.add(fitnessFunction4.generateRandomIndividual());
		}
		algoritmoGenetico<ElementoFuncion4> ga4 = new algoritmoGenetico<ElementoFuncion4>(fitnessFunction4.calculaTamanoTotal(),fitnessFunction4,probMutacion,probReproduccion);
		ResultadosGraficos resultadosGraficos = ga4.geneticAlgorithm(population4, fitnessFunction4,0L, maxGeneraciones,elitismo,seleccion,reproduccion);
		resultadosGraficos.modifica(0, true);
		return resultadosGraficos;
	}
	
	private static ResultadosGraficos problema5(double tolerancia, double probMutacion , double probReproduccion, int tamañoPoblacion, int maxGeneraciones,ArrayList<Double> minimos,ArrayList<Double> maximos, int numElementos, Double  elitismo,String seleccion,String reproduccion)
	{
		for(int i= 0; i<numElementos; i++)
		{
			 minimos.add((double) 0);
			 maximos.add(Math.PI);
		}
		FitnessFunctionFuncion4Extra fitnessFunction4 = new FitnessFunctionFuncion4Extra(-3.89, minimos, maximos, tolerancia);
		Set<ElementoFuncion4Extra> population4 = new HashSet<ElementoFuncion4Extra>();
		for (int i = 0; i < tamañoPoblacion; i++) {
			population4.add(fitnessFunction4.generateRandomIndividual());
		}
		algoritmoGenetico<ElementoFuncion4Extra> ga4 = new algoritmoGenetico<ElementoFuncion4Extra>(fitnessFunction4.calculaTamanoTotal(),fitnessFunction4,probMutacion,probReproduccion);
		ResultadosGraficos resultadosGraficos = ga4.geneticAlgorithm(population4, fitnessFunction4,0L, maxGeneraciones,elitismo,seleccion,reproduccion);
		resultadosGraficos.modifica(0, true);
		return resultadosGraficos;
	}
}

