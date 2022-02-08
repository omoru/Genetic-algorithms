package funcionalidadGenetica;

import java.util.ArrayList;

import java.util.Collections;

public class Individuo {
	
	private ArrayList<Integer> genes;
	private int adaptacion;
	private double prob_sel;;
	private double punt_acum;
	private int long_indv=27;
	private int ciudad_inicio;
	private final static int[][] DIST = {

            {},

            {171},

            {369,  294},

            {366,  537,   633},

            {525,  696,   604,   318},

            {540,  515,   809,   717,   1022},

            {646,  817,   958,   401,   694,   620},

            {488,  659,   800,   243,   536,   583,   158},

            {504,  675,   651,   229,   89,918,   605,   447},

            {617,  688,   484,   618,   342,   1284,  1058,  900,   369},

            {256,  231,   525,   532,   805,   284,   607,   524,   701,   873},

            {207,  378,   407,   256,   318,   811,   585,   427,   324,   464,   463},

            {354,  525,   332,   457,   272,   908,   795,   637,   319,   263,   610,   201},

            {860,  1031,  1172,  538,   772,   1118,  644,   535,   683,   1072,  1026,  799,       995},

            {142,  313,   511,   282,   555,   562,   562,   404,   451,   708,   305,   244,       445,   776},

            {640,  615,   909,   817,   1122,  100,   720,   683,   1018,  1384,  384,   911,       1008,  1218,  662},

            {363,  353,   166,   534,   438,   868,   829,   671,   485,   335,   584,   278,       166,   1043,  479,   968},

            {309,  480,   621,   173,   459,   563,   396,   238,   355,   721,   396,   248,       458,   667,   486,   663,   492},

            {506,  703,   516,   552,   251,   1140,  939,   781,   323,   219,   856,   433,       232,   1006,  677,   1240,  350,   690},

            {495,  570,   830,   490,   798,   274,   322,   359,   694,   1060,  355,   587,       797,   905,   406,   374,   831,   339,   1029},

            {264,  415,   228,   435,   376,   804,   730,   572,   423,   367,   520,   179,       104,   944,   380,   904,   99,          393,   336,   732},

            {584,  855,   896,   255,   496,   784,   359,   201,   407,   796,   725,   511,       733,   334,   500,   884,   761,   391,   730,   560,   668},

            {515,  490,   802,   558,   866,   156,   464,   427,   762,   1128,  259,   655,       865,   973,   472,   256,   861,   407,   1097,  118,   779,   628},

            {578,  653,   899,   358,   676,   468,   152,   115,   595,   999,   455,   526,       736,   650,   464,   568,   770,   278,   968,   244,   671,   316,   312},

            {762,  933,   1074,  440,   674,   1020,  546,   437,   585,   974,   928,   696,       897,   98,          678,   1120,  945,   569,   908,   807,   846,   236,   875,   352},

            {251,  422,   563,   115,   401,   621,   395,   237,   297,   663,   417,   190,       400,   609,   167,   721,   434,   58,          632,   397,   335,   333,   465,   336,   551},

            {473,  482,   219,   644,   436,   997,   939,   781,   506,   265,   713,   388,       187,   1153,  615,   1097,  129,   602,   313,   941,   209,   877,   1009,  880,   1055,  544},

            {150,  75,          219,   516,   675,   590,   796,   638,   654,   613,   306,       357,   444,   1010,  292,   690,   278,   459,   628,   611,   340,   734,   583,   694,   912,       401,   407}

            };


	
	public Individuo(int ciudad_inicio) {
		this.genes=new ArrayList<Integer>(long_indv);
		this.inicializarIndividuoVacio();
                this.ciudad_inicio=ciudad_inicio;
	}
	

	

	
		public Individuo() {
		this.genes=new ArrayList<Integer>(long_indv);
		this.inicializarIndividuoVacio();
	}
	




	public ArrayList<Integer> getGenes() {
		return genes;
	}
	public void setGenes(ArrayList<Integer> genes) {
		this.genes = genes;
	}


	public double getProb_sel() {
		return prob_sel;
	}

	public void setProb_sel(double prob_sel) {
		this.prob_sel = prob_sel;
	}
	
	public int getAdaptacion() {
            if(adaptacion==0)evalua();
            return adaptacion;
	}
	public void setAdaptacion(int adaptacion) {
		this.adaptacion = adaptacion;
	}
	
	public double getPunt_acum() {
		return punt_acum;
	}
	public void setPunt_acum(double punt_acum) {
		this.punt_acum = punt_acum;
	}
	public int getLong_indv() {
		return long_indv;
	}
	
	public int getCiudadInicial(){
            return this.ciudad_inicio;
        }
	
	public void inicializarIndividuo()
	{
		for(int i=0; i < long_indv;++i) genes.set(i,i+1);
		Collections.shuffle(genes);
		
	
	}
	
	public void inicializarIndividuoVacio(){
		for(int i=0; i< long_indv;++i)genes.add(i,0);
	}
	
	public int posCiudadInicio(ArrayList<Integer> a) {
	int i=0; 
	boolean encontrado=false;
		while( i < a.size() && !encontrado) {
			if(this.ciudad_inicio==a.get(i)) encontrado=true;
			++i;
		}
	return i-1;
	}
	
	public void evalua() {
	
		int fn=0;
		//filas 1-27 columnas 0-26
		int k=0;
		for(int i=0; i <k ;i++) {
		
			
		}
		int pos=posCiudadInicio(genes);
		for(int i=pos; i < (pos+long_indv);++i) {
			if(genes.get(i%long_indv)>genes.get((i+1)%long_indv)) {
				fn+=DIST[genes.get(i%long_indv)][genes.get((i+1)%long_indv)-1];
				
			}
			else {
				fn+=DIST[genes.get((i+1)%long_indv)][genes.get(i%long_indv)-1];	
			}
		}
	
		
		this.adaptacion=fn;
		
		}
	
	
	public void modifica (int pos1, int pos2){
            int valorAux = genes.get(pos1);
            int valorAux2 = genes.get(pos2);
            genes.set(pos2, valorAux);
            genes.set(pos1, valorAux2);
        }		
        
        public void copiaIndividuo(Individuo ind)
        {
            for(int i = 0 ; i < ind.getLong_indv(); i++)
            {
                genes.set(i, ind.getGenes().get(i));
            }
        }
	
	
	public String toString() {
		return this.genes.toString();
	}




	

}
