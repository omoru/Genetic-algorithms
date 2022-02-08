package funcionalidadGenetica;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		GuiPrincipal gui = new GuiPrincipal();
                gui.setVisible(true);
	}
        
        public static ResultadosGraficos run (int tam_pob, int num_max_generations, double prob_cruce, double prob_mut,double elitismo,String tipoSeleccion,String tipoCruce, String tipoMutacion, int ciudadInicio)
        {
            AlgoritmoGenetico ag= new AlgoritmoGenetico( tam_pob, num_max_generations,  prob_cruce,  prob_mut,ciudadInicio);
            return ag.AlgortimoGenetico(elitismo,tipoSeleccion,tipoCruce,tipoMutacion);
        }
}