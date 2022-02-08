package operadores;

import java.util.ArrayList;

import funcionalidadGenetica.Individuo;

public class OperadorGenetico{

	private ArrayList<Individuo> pob; 
	private double prob_mut;
	private double prob_cruce;
	
		

	public OperadorGenetico(ArrayList<Individuo> pob,double prob_mut,double prob_cruce) 
        {
		this.pob = pob;
		this.prob_cruce=prob_cruce;
		this.prob_mut=prob_mut;
	}

	public ArrayList<Individuo> seleccion(String s,int participantes,double media) {
		ArrayList<Individuo> pobAux=new ArrayList<Individuo>(pob.size());
		Seleccion sel= new Seleccion(this.pob);
		double probTrunc=0.1;//-----------------------Suele ser o 0.1 o 0.5
		switch(s) {
		case "Ruleta":
		{
			pobAux=sel.seleccionRuleta(this.pob);break;
		}
		case"Estocastica": {
			pobAux=sel.seleccionEstocastica(this.pob);break;	
		}
		case "Truncamiento":{

			pobAux=sel.seleccionTruncamiento(this.pob,probTrunc);break;
		}
		
		case "TorneoDeterministico": {
			pobAux=sel.torneoDeterministico(this.pob,participantes);break;
		}
			
		case "TorneoProbabilistico":{
			pobAux=sel.torneoProbabilistico(this.pob, participantes);break;
		}
		
		case "Ranking":{
			pobAux=sel.seleccionRanking(this.pob);break;
		}
		
		case "BajoMedia":{
			pobAux= sel.seleccionBajoMedia(pob,media);break;
		}
		default:{
			pobAux=sel.seleccionRuleta(this.pob);break;
		}
					
		
		}
		
	this.pob=pobAux;
	return pobAux;
	}
	
public ArrayList<Individuo> reproduccion(String s,int numelems){
		
		ArrayList<Individuo> descendientes= new ArrayList<Individuo>(pob.size());
		Reproduccion rep= new Reproduccion(this.pob);
		for(int i=0; i < pob.size();i+=2) {
			Individuo x= null;
			Individuo y= null;
			Individuo p1=null;
			Individuo p2=null;
			int rand= (int) (Math.random() * (pob.size()-1));
			p1=pob.get(rand);
			int rand2= (int) (Math.random() * pob.size()-1);
			p2=pob.get(rand2);
			double prob= Math.random() * 1;
			if(prob<this.prob_cruce) {
			
				
				int a= rep.randomOffset(pob.get(0).getLong_indv());
				int b=rep.randomOffset(pob.get(0).getLong_indv());
				int punto1,punto2;
				if(a>b) {
					punto1=b; punto2=a;
				}
				else {
					punto1=a; punto2=b;
				}
				
				switch(s) {
					case "PMX":{
						x=rep.PmxReproduccion(p1,p2,punto1,punto2); 
						y=rep.PmxReproduccion(p2,p1,punto1,punto2); break;
					}
					case "OX": {
						x=rep.OxReproduccion(p1,p2,punto1,punto2);
						y=rep.OxReproduccion(p2,p1,punto1,punto2);break;
					}
					case "VOX": {//con orden prioritario
						x=rep.VoxReproduccion(p1,p2,numelems);
						y=rep.VoxReproduccion(p2,p1,numelems);break;
					
					}
					case "VOXP":{//con posiciones prioritarias,
						x=rep.VoxReproduccionPos(p1,p2,numelems);
						y=rep.VoxReproduccionPos(p2,p1,numelems);break;
					}
					
					case "ERX":{ 
						x=rep.ErxReproduccion(p1,p2);
						y=rep.ErxReproduccion(p2,p1);break;
					}
					
					case "ORDINAL":{
						 x=rep.CordReproduccion(p1,p2);
                         y=rep.CordReproduccion(p2,p1);break;
					}
					
					case "CX":{//ciclos
						x=rep.CXReproduccion(p1,p2);
						y=rep.CXReproduccion(p2,p1);break;
					}
					
					case "RPB":{
						x=rep.reproduccionProbabilistica(p1,p2);
						y=rep.reproduccionProbabilistica(p1,p2);break;
						
					}
					
					default:{
						x=rep.OxReproduccion(p1,p2,punto1,punto2);
						y=rep.OxReproduccion(p2,p1,punto1,punto2);break;
					}
				}
				
			descendientes.add(x);
			descendientes.add(y);
			}
			
			else { 
				descendientes.add(p1);
				descendientes.add(p2);	
			}
			
		//System.out.println(descendientes.toString());
		}
		this.pob=descendientes;
		return descendientes;
		
	}
					
			
	
	 

	public ArrayList<Individuo> mutacion(String s,int numciudades) {
		
		Mutacion mut=new Mutacion(pob);
		for(int i=0; i < pob.size();++i) {
			double prob= Math.random() * 1;
			if(prob< this.prob_mut) {
				int a= (int) (Math.random() * pob.get(0).getLong_indv()) + 1;
				int b=(int) (Math.random() * pob.get(0).getLong_indv()) + 1;
				int punto1,punto2;
				if(a>b) {
					punto1=b; punto2=a;
				}
				else {
					punto1=a; punto2=b;
				}
				
				switch(s) {
				case "Inversion": mut.mutacionInversion(this.pob.get(i),punto1,punto2);break;
				case "Intercambio":mut.mutacionIntercambio(this.pob.get(i),punto1,punto2);break;
				case "Inserccion":  mut.mutacionInsercion(this.pob.get(i),numciudades);break; //numciudades
				case "Heuristica":System.out.println(this.pob.get(i)+ " preMutacion "+ this.pob.get(i).getAdaptacion());mut.mutacionHeuristica(this.pob.get(i));break;
				case "SumaUnitaria": mut.mutacionUnitaria(this.pob.get(i), numciudades);break;
				default:mut.mutacionIntercambio(this.pob.get(i),punto1,punto2);break;
				}
			}
			
		}
		this.pob=mut.pob;
		return mut.pob;
	}

	
	public ArrayList<Individuo> getPob(){
		return this.getPob();
	}
}

