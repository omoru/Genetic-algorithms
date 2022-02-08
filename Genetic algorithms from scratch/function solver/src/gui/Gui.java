package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;

import Main.Main;
import funcionalidadGenetica.ResultadosGraficos;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Gui {

	protected Shell shlPePractica;
	private Text PopulationSizeText;
	private Text GenerationNumberText;
	private Text CrossoverPcText;
	private Text MutationPcText;
	private Text ElitismoPcText;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text ToleranciaText;
	/**
	 * @wbp.nonvisual location=855,129
	 */
	private final Plot2DPanel plot2DPanel = new Plot2DPanel();
	private Text text;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPePractica.open();
		shlPePractica.layout();
		while (!shlPePractica.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPePractica = new Shell();
		shlPePractica.setSize(1018, 633);
		shlPePractica.setText("PE Practica1");
		shlPePractica.setLayout(new FormLayout());
		
		Label PopulationSizeLabel = new Label(shlPePractica, SWT.NONE);
		PopulationSizeLabel.setAlignment(SWT.RIGHT);
		FormData fd_PopulationSizeLabel = new FormData();
		fd_PopulationSizeLabel.left = new FormAttachment(0, 235);
		PopulationSizeLabel.setLayoutData(fd_PopulationSizeLabel);
		PopulationSizeLabel.setText("Population Size");
		
		PopulationSizeText = new Text(shlPePractica, SWT.BORDER);
		fd_PopulationSizeLabel.top = new FormAttachment(PopulationSizeText, 3, SWT.TOP);
		fd_PopulationSizeLabel.right = new FormAttachment(100, -601);
		PopulationSizeText.setText("100");
		FormData fd_PopulationSizeText = new FormData();
		fd_PopulationSizeText.top = new FormAttachment(0, 144);
		PopulationSizeText.setLayoutData(fd_PopulationSizeText);
		
		Label GenerationNumberLabel = new Label(shlPePractica, SWT.NONE);
		GenerationNumberLabel.setAlignment(SWT.RIGHT);
		FormData fd_GenerationNumberLabel = new FormData();
		fd_GenerationNumberLabel.right = new FormAttachment(100, -587);
		GenerationNumberLabel.setLayoutData(fd_GenerationNumberLabel);
		GenerationNumberLabel.setText("Generation Number");
		
		GenerationNumberText = new Text(shlPePractica, SWT.BORDER);
		fd_PopulationSizeText.right = new FormAttachment(GenerationNumberText, 0, SWT.RIGHT);
		fd_PopulationSizeText.bottom = new FormAttachment(GenerationNumberText, -6);
		fd_PopulationSizeText.left = new FormAttachment(0, 473);
		fd_GenerationNumberLabel.top = new FormAttachment(GenerationNumberText, 3, SWT.TOP);
		GenerationNumberText.setText("100");
		FormData fd_GenerationNumberText = new FormData();
		fd_GenerationNumberText.right = new FormAttachment(100, -256);
		fd_GenerationNumberText.left = new FormAttachment(0, 473);
		GenerationNumberText.setLayoutData(fd_GenerationNumberText);
		
		Label SelectionLabel = new Label(shlPePractica, SWT.NONE);
		fd_GenerationNumberLabel.left = new FormAttachment(0, 249);
		SelectionLabel.setAlignment(SWT.CENTER);
		FormData fd_SelectionLabel = new FormData();
		fd_SelectionLabel.left = new FormAttachment(0, 249);
		SelectionLabel.setLayoutData(fd_SelectionLabel);
		SelectionLabel.setText(" Selection");
		
		Composite CrossoverComposite = new Composite(shlPePractica, SWT.NONE);
		fd_SelectionLabel.bottom = new FormAttachment(CrossoverComposite, -3);
		FormData fd_CrossoverComposite = new FormData();
		fd_CrossoverComposite.top = new FormAttachment(0, 227);
		fd_CrossoverComposite.left = new FormAttachment(0, 249);
		CrossoverComposite.setLayoutData(fd_CrossoverComposite);
		
		Label CrossoverLabel = new Label(CrossoverComposite, SWT.NONE);
		CrossoverLabel.setBounds(10, 0, 55, 15);
		CrossoverLabel.setText("Crossover");
		
		Label CrossoverBaseLabel = new Label(CrossoverComposite, SWT.NONE);
		CrossoverBaseLabel.setAlignment(SWT.CENTER);
		CrossoverBaseLabel.setBounds(10, 29, 210, 15);
		CrossoverBaseLabel.setText("CrossoverB");
		
		Combo CrossoverBCombo = new Combo(CrossoverComposite, SWT.READ_ONLY);
		CrossoverBCombo.setItems(new String[] {"Un punto", "Uniforme", "Multipunto"});
		CrossoverBCombo.setBounds(226, 26, 272, 23);
		CrossoverBCombo.select(0);
		
		Label CrossoverPcLabel = new Label(CrossoverComposite, SWT.NONE);
		CrossoverPcLabel.setAlignment(SWT.CENTER);
		CrossoverPcLabel.setBounds(10, 50, 210, 15);
		CrossoverPcLabel.setText(" Crossover %");
		
		CrossoverPcText = new Text(CrossoverComposite, SWT.BORDER);
		CrossoverPcText.setText("60.0");
		CrossoverPcText.setBounds(226, 47, 272, 21);
		
		Composite MutationComposite = new Composite(shlPePractica, SWT.NONE);
		fd_CrossoverComposite.bottom = new FormAttachment(MutationComposite, -6);
		fd_CrossoverComposite.right = new FormAttachment(MutationComposite, 0, SWT.RIGHT);
		FormData fd_MutationComposite = new FormData();
		fd_MutationComposite.left = new FormAttachment(0, 249);
		fd_MutationComposite.right = new FormAttachment(100, -245);
		fd_MutationComposite.top = new FormAttachment(0, 308);
		fd_MutationComposite.bottom = new FormAttachment(100, -217);
		MutationComposite.setLayoutData(fd_MutationComposite);
		
		Label MutationLabel = new Label(MutationComposite, SWT.NONE);
		MutationLabel.setBounds(10, 0, 55, 15);
		MutationLabel.setText("Mutation");
		
		Label MutationBLabel = new Label(MutationComposite, SWT.NONE);
		MutationBLabel.setAlignment(SWT.CENTER);
		MutationBLabel.setBounds(10, 25, 209, 15);
		MutationBLabel.setText("MutacionB");
		
		Combo MutationBCombo = new Combo(MutationComposite, SWT.READ_ONLY);
		MutationBCombo.setItems(new String[] {"Un Bit"});
		MutationBCombo.setBounds(225, 18, 273, 23);
		MutationBCombo.select(0);
		
		MutationPcText = new Text(MutationComposite, SWT.BORDER);
		MutationPcText.setText("5.0");
		MutationPcText.setBounds(225, 43, 273, 21);
		
		Label MutationPcLabel = new Label(MutationComposite, SWT.NONE);
		MutationPcLabel.setAlignment(SWT.CENTER);
		MutationPcLabel.setBounds(10, 46, 209, 15);
		MutationPcLabel.setText(" Mutation %");
		
		Composite ElitismoComposite = new Composite(shlPePractica, SWT.NONE);
		FormData fd_ElitismoComposite = new FormData();
		fd_ElitismoComposite.top = new FormAttachment(MutationComposite, 6);
		fd_ElitismoComposite.left = new FormAttachment(CrossoverComposite, 0, SWT.LEFT);
		fd_ElitismoComposite.bottom = new FormAttachment(100, -167);
		fd_ElitismoComposite.right = new FormAttachment(100, -245);
		ElitismoComposite.setLayoutData(fd_ElitismoComposite);
		
		Label ElitismoLabel = new Label(ElitismoComposite, SWT.NONE);
		ElitismoLabel.setBounds(10, 0, 65, 15);
		ElitismoLabel.setText("Elitismo");
		
		Label ElitismoPcLabel = new Label(ElitismoComposite, SWT.NONE);
		ElitismoPcLabel.setAlignment(SWT.CENTER);
		ElitismoPcLabel.setBounds(10, 21, 208, 21);
		ElitismoPcLabel.setText("Elitismo %");
		
		ElitismoPcText = new Text(ElitismoComposite, SWT.BORDER);
		ElitismoPcText.setText("0.0");
		ElitismoPcText.setBounds(224, 21, 274, 21);
		
		Label ProblemLabel = new Label(shlPePractica, SWT.NONE);
		FormData fd_ProblemLabel = new FormData();
		fd_ProblemLabel.left = new FormAttachment(0, 307);
		fd_ProblemLabel.top = new FormAttachment(0, 10);
		ProblemLabel.setLayoutData(fd_ProblemLabel);
		ProblemLabel.setText("Problem");
		
		Combo ProblemCombo = new Combo(shlPePractica, SWT.READ_ONLY);
		fd_ProblemLabel.right = new FormAttachment(100, -601);
		ProblemCombo.setItems(new String[] {"1", "2", "3", "4", "5"});
		FormData fd_ProblemCombo = new FormData();
		fd_ProblemCombo.right = new FormAttachment(ProblemLabel, 78, SWT.RIGHT);
		fd_ProblemCombo.left = new FormAttachment(ProblemLabel, 6);
		fd_ProblemCombo.top = new FormAttachment(0, 7);
		ProblemCombo.setLayoutData(fd_ProblemCombo);
		ProblemCombo.select(0);
		
		Combo SeleccionComboBox = new Combo(shlPePractica, SWT.READ_ONLY);
		fd_SelectionLabel.right = new FormAttachment(100, -540);
		fd_GenerationNumberText.bottom = new FormAttachment(SeleccionComboBox, -6);
		fd_SelectionLabel.top = new FormAttachment(0, 201);
		FormData fd_SeleccionComboBox = new FormData();
		fd_SeleccionComboBox.right = new FormAttachment(100, -256);
		fd_SeleccionComboBox.left = new FormAttachment(SelectionLabel, 11);
		fd_SeleccionComboBox.bottom = new FormAttachment(CrossoverComposite, -6);
		SeleccionComboBox.setLayoutData(fd_SeleccionComboBox);
		SeleccionComboBox.setItems(new String[] {"Ruleta", "TorneoDeterministico", "TorneoProbabilistico", "Estocastico", "Truncamiento"});
		SeleccionComboBox.select(0);
		
		Button btnCheckButton = new Button(shlPePractica, SWT.CHECK);
		btnCheckButton.setSelection(true);
		FormData fd_btnCheckButton = new FormData();
		fd_btnCheckButton.left = new FormAttachment(ProblemCombo, 20);
		fd_btnCheckButton.top = new FormAttachment(ProblemLabel, -1, SWT.TOP);
		btnCheckButton.setLayoutData(fd_btnCheckButton);
		formToolkit.adapt(btnCheckButton, true, true);
		btnCheckButton.setText("Enable popups");
		
		Button btnCheckButtonImprimir = new Button(shlPePractica, SWT.CHECK);
		fd_btnCheckButton.right = new FormAttachment(btnCheckButtonImprimir, -15);
		FormData fd_btnCheckButtonImprimir = new FormData();
		fd_btnCheckButtonImprimir.top = new FormAttachment(0, 10);
		fd_btnCheckButtonImprimir.right = new FormAttachment(PopulationSizeText, 0, SWT.RIGHT);
		fd_btnCheckButtonImprimir.left = new FormAttachment(0, 613);
		btnCheckButtonImprimir.setLayoutData(fd_btnCheckButtonImprimir);
		formToolkit.adapt(btnCheckButtonImprimir, true, true);
		btnCheckButtonImprimir.setText("Print in project folder");
		
		
		text = new Text(shlPePractica, SWT.BORDER);
		text.setText("1");
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(PopulationSizeText, 0, SWT.RIGHT);
		fd_text.left = new FormAttachment(PopulationSizeText, 0, SWT.LEFT);
		text.setLayoutData(fd_text);
		formToolkit.adapt(text, true, true);
		
		
		Button ResetFieldsButton = new Button(shlPePractica, SWT.NONE);
		ResetFieldsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			 PopulationSizeText.setText("100");
			 GenerationNumberText.setText("100");
			 CrossoverPcText.setText("60.0");
			 MutationPcText.setText("5.0");
			 ElitismoPcText.setText("0.0");
			 SeleccionComboBox.select(0);
			 CrossoverBCombo.select(0);
			 ProblemCombo.select(0);
			 MutationBCombo.select(0);
			 ToleranciaText.setText("0.001");
			 btnCheckButton.setSelection(true);
			 text.setText("1");
			}
		});
		FormData fd_ResetFieldsButton = new FormData();
		fd_ResetFieldsButton.right = new FormAttachment(SelectionLabel, 0, SWT.RIGHT);
		fd_ResetFieldsButton.top = new FormAttachment(ElitismoComposite, 26);
		fd_ResetFieldsButton.left = new FormAttachment(GenerationNumberLabel, 0, SWT.LEFT);
		ResetFieldsButton.setLayoutData(fd_ResetFieldsButton);
		ResetFieldsButton.setText("Reset fields");
		
		Button RunButton = new Button(shlPePractica, SWT.NONE);
		RunButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int problema = Integer.parseInt(ProblemCombo.getItem(ProblemCombo.getSelectionIndex()));
				ResultadosGraficos result = Main.FuncionGeneticAlgorithm(getTolerancia(),getMutationPc(),getCrossoverPc(),getPopulationSize(),getGenerationNumber(),getNumElements(),problema,getElitismoPc(),SeleccionComboBox.getText(),CrossoverBCombo.getText());
				if(btnCheckButton.getSelection())
				{
					plot2DPanel.removeAllPlots();
					plot2DPanel.addLinePlot("Mejor Absoluto", Color.BLUE,ArrayListtoArray(result.getBestAbsolut()));
					plot2DPanel.addLinePlot("Mejor de la Generacion", Color.RED,ArrayListtoArray(result.getBestGeneration()));
					plot2DPanel.addLinePlot("Media Generacional", Color.GREEN,ArrayListtoArray(result.getMediaGeneracion()));
					plot2DPanel.addLegend("SOUTH");
					JFrame jFrame = new JFrame();
					jFrame.setSize(800, 800);
					jFrame.setContentPane(plot2DPanel);
					jFrame.setVisible(true);
				
				}
				if(btnCheckButtonImprimir.getSelection())
				{
					Grafica(result);
				}

			}
		});
		
	
		
		FormData fd_RunButton = new FormData();
		fd_RunButton.right = new FormAttachment(PopulationSizeText, 0, SWT.RIGHT);
		fd_RunButton.top = new FormAttachment(ResetFieldsButton, 0, SWT.TOP);
		fd_RunButton.left = new FormAttachment(PopulationSizeText, 0, SWT.LEFT);
		RunButton.setLayoutData(fd_RunButton);
		RunButton.setText("Run");
		
		FormData fd_ComponenteGraficoComposite1 = new FormData();
		fd_ComponenteGraficoComposite1.bottom = new FormAttachment(RunButton, 0, SWT.BOTTOM);
		fd_ComponenteGraficoComposite1.left = new FormAttachment(PopulationSizeLabel, 24);
		
		Label lblTolerancia = new Label(shlPePractica, SWT.NONE);
		lblTolerancia.setAlignment(SWT.CENTER);
		lblTolerancia.setBackground(SWTResourceManager.getColor(192, 192, 192));
		FormData fd_lblTolerancia = new FormData();
		fd_lblTolerancia.left = new FormAttachment(0, 309);
		lblTolerancia.setLayoutData(fd_lblTolerancia);
		formToolkit.adapt(lblTolerancia, true, true);
		lblTolerancia.setText(" Tolerancia");
		
		ToleranciaText = new Text(shlPePractica, SWT.BORDER);
		fd_text.bottom = new FormAttachment(ToleranciaText, -6);
		fd_lblTolerancia.top = new FormAttachment(ToleranciaText, 3, SWT.TOP);
		fd_lblTolerancia.right = new FormAttachment(ToleranciaText, -70);
		FormData fd_ToleranciaText = new FormData();
		fd_ToleranciaText.right = new FormAttachment(PopulationSizeText, 0, SWT.RIGHT);
		fd_ToleranciaText.bottom = new FormAttachment(PopulationSizeText, -6);
		fd_ToleranciaText.left = new FormAttachment(PopulationSizeText, 0, SWT.LEFT);
		ToleranciaText.setLayoutData(fd_ToleranciaText);
		ToleranciaText.setText("0.001");
		formToolkit.adapt(ToleranciaText, true, true);
		
		Label numElementsLabel = new Label(shlPePractica, SWT.NONE);
		numElementsLabel.setText("Num elements(Problem4 only)");
		numElementsLabel.setAlignment(SWT.CENTER);
		FormData fd_numElementsLabel = new FormData();
		fd_numElementsLabel.right = new FormAttachment(SelectionLabel, 0, SWT.RIGHT);
		fd_numElementsLabel.bottom = new FormAttachment(lblTolerancia, -9);
		fd_numElementsLabel.left = new FormAttachment(0, 249);
		numElementsLabel.setLayoutData(fd_numElementsLabel);
		formToolkit.adapt(numElementsLabel, true, true);
		
	}
	
	public int getPopulationSize()
	{
		return Integer.parseInt(this.PopulationSizeText.getText());
	}
	
	public int getNumElements()
	{
		return Integer.parseInt(this.text.getText());
	}
	
	public int getGenerationNumber()
	{
		return Integer.parseInt(this.GenerationNumberText.getText());
	}
	
	public double getCrossoverPc()
	{
		return Double.parseDouble(this.CrossoverPcText.getText());
	}
	
	public double getTolerancia()
	{
		return Double.parseDouble(this.ToleranciaText.getText());
	}
	
	public double getMutationPc()
	{
		return Double.parseDouble(this.MutationPcText.getText());
	}
	
	public double getElitismoPc()
	{
		return Double.parseDouble(this.ElitismoPcText.getText());
	}
	
	public void Grafica(ResultadosGraficos result)
	{
		DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Mejor Absoluto", generaSeries(result.getBestAbsolut()));
        dataset.addSeries("Mejor Generacion", generaSeries(result.getBestGeneration()));
        dataset.addSeries("Media Generacion", generaSeries(result.getMediaGeneracion()));
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));
        
        JFreeChart Grafica = ChartFactory.createXYLineChart("Grafico","Evaluacion", "Generacion", dataset,PlotOrientation.HORIZONTAL, false, false, false);
        
        Grafica.getXYPlot().getRangeAxis().setRange(0, 100);
        ((NumberAxis) Grafica.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
        Grafica.getXYPlot().setRenderer(renderer);

        BufferedImage image = Grafica.createBufferedImage(800, 600);
        try {
			ImageIO.write(image, "png", new File("resultado.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	private double[][] generaSeries(ArrayList<Double> a)
	{
		double resultado[][] = new double [2][a.size()];
		for(int i=0; i< a.size(); i++)
		{
			resultado[0][i] = a.get(i);
			resultado[1][i] = i;
		}
		return resultado;
			
	}
	
	public double[] ArrayListtoArray(ArrayList<Double> a)
	{
		double array[] = new double[a.size()];
		for(int i=0;i<a.size();i++)
		{
			array[i]=a.get(i);
		}
		return array;
	}
}
