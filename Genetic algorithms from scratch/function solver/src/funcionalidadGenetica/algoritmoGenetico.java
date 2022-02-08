package funcionalidadGenetica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class algoritmoGenetico<A extends Elemento<?>> {

	protected static final String POPULATION_SIZE = "populationSize";
	protected static final String ITERATIONS = "iterations";
	protected static final String TIME_IN_MILLISECONDS = "timeInMilliseconds";
	//
	protected Metrics metrics = new Metrics();
	//
	protected int individualLength;
	protected double reproduceProbability;
	protected double mutationProbability;
	protected Random random;
	protected FitnessFunction<A> fitnessFn;

	public algoritmoGenetico(int individualLength,FitnessFunction<A> fitnessFunction, double mutationProbability,double reproduceProbability) 
	{
		this(individualLength,  mutationProbability,reproduceProbability,fitnessFunction,new Random());
	}

	public algoritmoGenetico(int individualLength,  double mutationProbability,double reproduceProbability,FitnessFunction<A> fitnessFunction ,Random random)
	{
		this.individualLength = individualLength;
		this.mutationProbability = mutationProbability;
		this.random = random;
		this.fitnessFn=fitnessFunction;
		this.reproduceProbability =reproduceProbability;
	}

	/** 
	 * Returns the best individual in the specified population, according to the
	 * specified FITNESS-FN and goal test.
	 * 
	 * @param population
	 *            a set of individuals
	 * @param fitnessFn
     *            a function that measures the fitness of an individual
	 * @param goalTest
	 *            test determines whether a given individual is fit enough to
	 *            return.
	 * @param maxTimeMilliseconds
	 *            the maximum time in milliseconds that the algorithm is to run
	 *            for (approximate). Only used if > 0L.
	 * @return the best individual in the specified population, according to the
	 *         specified FITNESS-FN and goal test.
	 */
	public ResultadosGraficos geneticAlgorithm(Set<A> population, GoalTest goalTest,long maxTimeMilliseconds, int maxGeneraciones, Double elitismo, String seleccion,String reproduccion)
	{
		A bestIndividual = null;

		// Create a local copy of the population to work with
		population = new LinkedHashSet<A>(population);
			
		// Validate the population and setup the instrumentation
		clearInstrumentation();
		setPopulationSize(population.size());

		long startTime = System.currentTimeMillis();
		A bestAbsolutElement = retrieveBestIndividual(population);
		ResultadosGraficos result = new ResultadosGraficos();
		result.addValor(bestAbsolutElement.obtenerValor(), bestAbsolutElement.obtenerValor(), this.mediaFitness(population));
		int cnt = 0;
		do
		{
			
			bestIndividual = nextGeneration(population,elitismo,seleccion,reproduccion);
			cnt++;
			if(this.fitnessFn.getValue(bestIndividual)> this.fitnessFn.getValue(bestAbsolutElement))
				bestAbsolutElement = bestIndividual;
			result.addValor(bestAbsolutElement.obtenerValor(), bestIndividual.obtenerValor(), this.mediaFitness(population));
		} while (!goalTest.isGoalState(bestIndividual) && cnt < maxGeneraciones);
		setIterations(cnt);
		setTimeInMilliseconds(System.currentTimeMillis()-startTime);
			
		// return the best individual in population, according to FITNESS-FN
		return result;
	}

	

	//
	// PROTECTED METHODS
	//
	// Note: Override these protected methods to create your own desired
	// behavior.
	//
	protected A nextGeneration(Set<A> population,Double elitismo, String seleccion,String reproduccion)
	{
		// new_population <- empty set
				Set<A> newPopulation = new HashSet<A>();
				
				List<A> populationAsList = new ArrayList<A>(population);
				// for i = 1 to SIZE(population) do
			
				
				int numsel=0;
				double[][] fValues = new double[population.size()][2];
				double probTrunc=0.5; //o 0,1
				double pop = 1.0/population.size();
				//System.out.println(pop);
				double probEstocastx= Math.random() * pop;
				double probEstocasty = Math.random() * pop;
				
				if(seleccion== "Truncamiento"){
					
					for (int i = 0; i < population.size(); i++) {
						fValues[i][0] = this.fitnessFn.getValue(populationAsList.get(i));
						fValues[i][1]=i;
					}
					
					
					burbuja(fValues);
					
			
				}
				
				for (int i = 0; i < population.size(); i++)
				{
					
					A x=null;
					A y= null;
					switch(seleccion) {
						case "Ruleta":{// x <- RANDOM-SELECTION(population, FITNESS-FN)
							 x = randomSelection(populationAsList);
						
						// y <- RANDOM-SELECTION(population, FITNESS-FN)<
						 y = randomSelection(populationAsList);
					//A x = fitnessFn.creaElementoVacio(), y=fitnessFn.creaElementoVacio();
				//	this.elitistaSeleccion(populationAsList, x, y);
						break;}
						
						case "Estocastico": {
							 x= SelectionEstocastica(populationAsList, probEstocastx);
							probEstocastx+=pop;
							 y= SelectionEstocastica(populationAsList, probEstocasty);
							probEstocasty +=pop;
							break;							
						}

						case "Truncamiento":{
							
							if(numsel >= probTrunc*100)numsel=0;
							
							 x= SelectionTrunc(populationAsList,numsel,fValues);
							 numsel++;
							 y= SelectionTrunc(populationAsList,numsel,fValues);
							 numsel++;
							 
							break;
							
						}
						case "TorneoDeterministico": {
							int participantes=3; // o 2
							x=TorneoDeterministico(populationAsList,participantes);
							y=TorneoDeterministico(populationAsList,participantes);
							break;
						}
						case "TorneoProbabilistico":{
							int participantes=3; // o 2
							
							  x=TorneoProbabilistico(populationAsList,participantes);
							  y=TorneoProbabilistico(populationAsList,participantes);
							break;
						}
						default:	{// x <- RANDOM-SELECTION(population, FITNESS-FN)
							 x = randomSelection(populationAsList);
						
						// y <- RANDOM-SELECTION(population, FITNESS-FN)
							 y = randomSelection(populationAsList);
					//A x = fitnessFn.creaElementoVacio(), y=fitnessFn.creaElementoVacio();
				//	this.elitistaSeleccion(populationAsList, x, y);
						break;
						}
					}
			
						// child <- REPRODUCE(x, y)
						A child = null;
						if(random.nextDouble() <= this.reproduceProbability)
						{
							switch(reproduccion) {
								case "Un punto":{
									child = reproduce(x, y);
								}
								case "Uniforme":{
									child = reproduceUniforme(x, y);
								}
								case "Multipunto":{
									child =reproduceMultipunto(x, y);
								}
							}
							child = reproduce(x, y);
							if(random.nextDouble() <= elitismo)
							{
								if(child.obtenerValor()<x.obtenerValor()||child.obtenerValor()<y.obtenerValor())
								{
									if(x.obtenerValor()<y.obtenerValor()) child = y;
									else child = x;
								}
							}
						}
						else
						{
							child = this.fitnessFn.creaElementoVacio();
							if(x.obtenerValor() > y.obtenerValor())
							{
								child.insertaParte(0, x.getLista().subList(0, individualLength));
							}
							else
							{
								child.insertaParte(0, y.getLista().subList(0, individualLength));
							}
						}
						
						// if (small random probability) then child <- MUTATE(child)
						if (random.nextDouble() <= this.mutationProbability) {
							child = mutate(child);
						}
						// add child to new_population
						newPopulation.add(child);
		}
		population.clear();
		population.addAll(newPopulation);
		
		return retrieveBestIndividual(population);
	}
		
	// RANDOM-SELECTION(population, FITNESS-FN) ruleta 
 	protected A randomSelection(List<A> population)
	{
		A selected = null;

		// Determine all of the fitness values
		double[] fValues = new double[population.size()];
		for (int i = 0; i < population.size(); i++) {
			fValues[i] = this.fitnessFn.getValue(population.get(i));
		}
			
		// Normalize the fitness values
		fValues = this.normalize(fValues);
		double prob = random.nextDouble();
		double totalSoFar = 0.0;
		for (int i = 0; i < fValues.length; i++) {
			// Are at last element so assign by default
			// in case there are rounding issues with the normalized values
			totalSoFar += fValues[i];
			if (prob <= totalSoFar) {
				selected = population.get(i);
				break;
			}
		}

		// selected may not have been assigned
		// if there was a rounding error in the
		// addition of the normalized values (i.e. did not total to 1.0)
		if (null == selected) {
			// Assign the last value
			selected = population.get(population.size() - 1);
		}

		return selected;
	}
 	
 	protected A SelectionEstocastica(List<A> population,double prob)
	{
		A selected = null;

		// Determine all of the fitness values
		double[] fValues = new double[population.size()];
		for (int i = 0; i < population.size(); i++) {
			fValues[i] = this.fitnessFn.getValue(population.get(i));
		}		
		// Normalize the fitness values
		fValues = this.normalize(fValues);
		double totalSoFar = 0.0;
		for (int i = 0; i < fValues.length; i++) {
			// Are at last element so assign by default
			// in case there are rounding issues with the normalized values
			totalSoFar += fValues[i];
			if (prob <= totalSoFar) {
				selected = population.get(i);
				break;
			}
		}
		// selected may not have been assigned
		// if there was a rounding error in the
		// addition of the normalized values (i.e. did not total to 1.0)
		if (null == selected) {
			// Assign the last value
			selected = population.get(population.size() - 1);
		}
		return selected;
	}
	

protected A SelectionTrunc(List<A> population,int numSel,double[][] fValues) {
		
		A selected = null;
		selected=population.get((int)(fValues[numSel][1]));
		
		return selected;
		
		
	}
	
	protected A TorneoDeterministico(List<A> population,int participantes) {
		
		A elemento=null;
		int pos_rand=(int)(Math.random() * population.size());
		int pos_max=pos_rand;
		double max=this.fitnessFn.getValue(population.get(pos_max));
		double[] fValues = new double[participantes];
		for(int i=0; i < participantes;++i) {
			fValues[i]=this.fitnessFn.getValue(population.get(pos_rand));	
			if(fValues[i]>=max) {
				pos_max=pos_rand;
				max=this.fitnessFn.getValue(population.get(pos_max));
			}
			pos_rand=(int)(Math.random() * population.size());
		}
		elemento=population.get(pos_max);
		return elemento;
	}
	
	protected A TorneoProbabilistico(List<A> population,int participantes) {
		
		A elemento=null;
		int pos_rand=(int)(Math.random() * population.size());
		int pos_max=pos_rand;
		double max=this.fitnessFn.getValue(population.get(pos_max));
		int pos_min=pos_rand;
		double min=this.fitnessFn.getValue(population.get(pos_min));
		double probabilidadTorneo= 0.1 + ( 0.5 - 0.1 ) * random.nextDouble();
		double[] fValues = new double[participantes];
		for(int i=0; i < participantes;++i) 
		{
			fValues[i]=this.fitnessFn.getValue(population.get(pos_rand));	
			if(fValues[i]>=max) {
				pos_max=pos_rand;
				max=this.fitnessFn.getValue(population.get(pos_max));
			}
			else if(fValues[i]<min) {
				pos_min=pos_rand;
				min=this.fitnessFn.getValue(population.get(pos_min));
			}
			pos_rand=(int)(Math.random() * population.size());
		}
		double prob = Math.random() * 1;
		if(prob > probabilidadTorneo)
		elemento=population.get(pos_max);
		else elemento=population.get(pos_min);
		return elemento;
	}
	
	
 	

	public static void burbuja(double [][] A)
	{
        int i, j,posAux;
        double aux;

        for(i=0;i<A.length-1;i++)
        {
             for(j=0;j<A.length-i-1;j++)
             {
                  if(A[j+1][0]>A[j][0])
                  {
                     aux=A[j+1][0];
                     posAux=(int)A[j+1][1];
                     A[j+1][0]=A[j][0];
                     A[j+1][1]=A[j][1];
                     A[j][0]=aux;
                     A[j][1]=posAux;
                     
                  }
             }
        }
	}
 	
	// function REPRODUCE(x, y) returns an individual
	// inputs: x, y, parent individuals
	protected A reproduce(A x, A y) //UN PUNTO
	{
		// n <- LENGTH(x);
		// Note: this is = this.individualLength
		// c <- random number from 1 to n
		int c = randomOffset(individualLength);
		
		// return APPEND(SUBSTRING(x, 1, c), SUBSTRING(y, c+1, n))
		A child = this.fitnessFn.creaElementoVacio() ;
		child.insertaParte(0, x.getLista().subList(0, c));
		child.insertaParte(c, (y.getLista().subList(c,	individualLength)));

		return child;
	}
	
	protected A reproduceMultipunto(A x, A y) 
	{
		// n <- LENGTH(x);
		// Note: this is = this.individualLength
		// c <- random number from 1 to n
		int c = randomOffset(individualLength);
		int d = randomOffset(individualLength);
		
		// return APPEND(SUBSTRING(x, 1, c), SUBSTRING(y, c+1, n))
		A child = this.fitnessFn.creaElementoVacio() ;
		child.insertaParte(0, x.getLista().subList(0, individualLength));
		if(c>d) {
			child.insertaParte(c, y.getLista().subList(d,c));
		}
		else child.insertaParte(c, y.getLista().subList(c, d));
		
		
	
		return child;
	}
	
	protected A reproduceUniforme(A x, A y) {
		A child=this.fitnessFn.creaElementoVacio();
		for(int i=0; i < x.gen.size();++i) {
					double prob= Math.random() * 1;
					if(prob>0.5) {	
						child.insertaParte(i, x.getLista().subList(i, i+1));
					}
					else {
						child.insertaParte(i, y.getLista().subList(i, i+1));
					}
		}
		return child;
	}

	protected A mutate(A child) //modifica un bit en la pos mutateoffset
	{
		boolean valido = false;
		A mutatedChild = null;
		while(!valido)
		{
			int mutateOffset = randomOffset(individualLength);
	
			mutatedChild = child;
			
			mutatedChild.modifica(mutateOffset);
			
			if (this.fitnessFn.elementoValido(mutatedChild)) valido = true;
			else 	mutatedChild.modifica(mutateOffset);
		}
		return mutatedChild;
	}

	protected A retrieveBestIndividual(Set<A> population) 
	{
		A bestIndividual = null;
		double bestSoFarFValue = Double.NEGATIVE_INFINITY;
		for (A individual : population) {
			double fValue = this.fitnessFn.getValue(individual);
			if (fValue > bestSoFarFValue) {
				bestIndividual = individual;
				bestSoFarFValue = fValue;
			}
		}
		return bestIndividual;
	}

	protected int randomOffset(int length) {
		return random.nextInt(length);
	}

	/**
	 * Sets the population size and number of iterations to zero.
	 */
	public void clearInstrumentation() {
		setPopulationSize(0);
		setIterations(0);
		setTimeInMilliseconds(0L);
	}

	/**
	 * Returns all the metrics of the genetic algorithm.
	 * 
	 * @return all the metrics of the genetic algorithm.
	 */
	public Metrics getMetrics() {
		return metrics;
	}

	/**
	 * Returns the population size.
	 * 
	 * @return the population size.
	 */
	public int getPopulationSize() {
		return metrics.getInt(POPULATION_SIZE);
	}

	/**
	 * Sets the population size.
	 * 
	 * @param size
	 *            the population size.
	 */
	public void setPopulationSize(int size)
	{
		metrics.set(POPULATION_SIZE, size);
	}

	/**
	 * Returns the number of iterations of the genetic algorithm.
	 * 
	 * @return the number of iterations of the genetic algorithm.
	 */
	public int getIterations() {
		return metrics.getInt(ITERATIONS);
	}

	/**
	 * Sets the number of iterations of the genetic algorithm.
	 * 
	 * @param cnt
	 *            the number of iterations.
	 */
	public void setIterations(int cnt) {
		metrics.set(ITERATIONS, cnt);
	}

	/**
	 * 
	 * @return the time in milliseconds that the genetic algorithm took.
	*/
	public long getTimeInMilliseconds() 
	{
		return metrics.getLong(TIME_IN_MILLISECONDS);
	}

	/**
	 * Set the time in milliseconds that the genetic algorithm took.
	 * 
	 * @param time
	 *            the time in milliseconds that the genetic algorithm took.
	 */
	public void setTimeInMilliseconds(long time)
	{
		metrics.set(TIME_IN_MILLISECONDS, time);
	}
	
	public  double[] normalize(double[] probDist) {
		int len = probDist.length;
		double total = 0.0;
		for (double d : probDist) {
			total = total + d;
		}

		double[] normalized = new double[len];
		if (total != 0) {
			for (int i = 0; i < len; i++) {
				normalized[i] = probDist[i] / total;
			}
		}

		return normalized;
	}

	protected double mediaFitness(Set<A> population)
	{
		double valorTotal=0;
		for (A individual : population) {
			valorTotal += this.fitnessFn.getValue(individual);
		}
		return valorTotal/ population.size();
	}
	
}

