/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidadGenetica;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author Bryan De Renovales
 */
public class GuiPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GuiPrincipal
     */
    public GuiPrincipal() {
        initComponents();
        panelGrafica.setSize(561, 518);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PopulationSizeText = new javax.swing.JTextField();
        GenerationNumberText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RunButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        SelectionCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        CrossoverCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CrossoverText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        MutationCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        MutationText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        EliteText = new javax.swing.JTextField();
        ParteOpcionalButton = new javax.swing.JButton();
        CiudadInicalCombo = new javax.swing.JComboBox<>();
        panelGrafica = new javax.swing.JInternalFrame();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoText = new javax.swing.JTextArea();
        CosteText = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Population Size");

        PopulationSizeText.setText("100");
        PopulationSizeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopulationSizeTextActionPerformed(evt);
            }
        });

        GenerationNumberText.setText("100");
        GenerationNumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerationNumberTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Generation number");

        jLabel3.setText("Ciudad Inicial");

        jLabel4.setText("Selection");

        RunButton.setText("Run");
        RunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Reset");
        ResetButton.setToolTipText("");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        SelectionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruleta", "Estocastica", "Truncamiento", "TorneoDeterministico", "TorneoProbabilistico", "Ranking", "BajoMedia" }));
        SelectionCombo.setSelectedIndex(3);
        SelectionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionComboActionPerformed(evt);
            }
        });

        jLabel6.setText("CrossoverB");

        CrossoverCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PMX", "OX", "VOX", "VOXP", "ERX", "CX", "CORD", "RPB" }));
        CrossoverCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrossoverComboActionPerformed(evt);
            }
        });

        jLabel7.setText("Crossover ");

        CrossoverText.setText("0.60");
        CrossoverText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrossoverTextActionPerformed(evt);
            }
        });

        jLabel8.setText("MutationB");

        MutationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inversion", "Intercambio", "Inserccion", "Heuristica", "SumaUnitaria" }));
        MutationCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MutationComboActionPerformed(evt);
            }
        });

        jLabel9.setText("Mutation ");

        MutationText.setText("0.20");
        MutationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MutationTextActionPerformed(evt);
            }
        });

        jLabel10.setText("Elite ");

        EliteText.setText("0.10");
        EliteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliteTextActionPerformed(evt);
            }
        });

        ParteOpcionalButton.setText("Parte Opcional");
        ParteOpcionalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParteOpcionalButtonActionPerformed(evt);
            }
        });

        CiudadInicalCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 -Alicante", "02- Almer??a", "03-Avila", "04-Badajoz", "05-Barcelona", "06-Bilbao", "07- Burgos", "08-C??ceres", "09-C??diz", "10-Castell??n", "11-Ciudad Real", "12-C??rdoba", "13-A Coru??a", "14-Cuenca", "15-Gerona", "16-Granada", "17-Guadalajara", "18-Huelva", "19-Huesca", "20-Ja??n", "21-Le??n", "22-L??rida", "23-Logro??o", "24-Lugo", "25-Madrid", "26-M??laga", "27-Murcia" }));
        CiudadInicalCombo.setSelectedIndex(24);
        CiudadInicalCombo.setToolTipText("");
        CiudadInicalCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadInicalComboActionPerformed(evt);
            }
        });

        panelGrafica.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        panelGrafica.setAutoscrolls(true);
        panelGrafica.setMaximumSize(new java.awt.Dimension(567, 34));
        panelGrafica.setMinimumSize(new java.awt.Dimension(567, 34));
        panelGrafica.setVisible(true);

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica.getContentPane());
        panelGrafica.getContentPane().setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel11.setText("Mejor Ruta");

        resultadoText.setEditable(false);
        resultadoText.setColumns(20);
        resultadoText.setRows(5);
        jScrollPane1.setViewportView(resultadoText);

        CosteText.setEditable(false);
        CosteText.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(47, 47, 47))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(EliteText)
                                            .addComponent(MutationText, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(MutationCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CrossoverText)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(CrossoverCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(GenerationNumberText)
                                            .addComponent(PopulationSizeText)
                                            .addComponent(CiudadInicalCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(SelectionCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)))))
                            .addComponent(ParteOpcionalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CosteText, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RunButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(PopulationSizeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(GenerationNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(CiudadInicalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(SelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(CrossoverCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(CrossoverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(MutationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(MutationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(EliteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ParteOpcionalButton)
                                .addGap(136, 136, 136)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CosteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliteTextActionPerformed

    private void PopulationSizeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopulationSizeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PopulationSizeTextActionPerformed

    private void CrossoverTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrossoverTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrossoverTextActionPerformed

    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunButtonActionPerformed
    
       String s = (String) CiudadInicalCombo.getSelectedItem();
       ResultadosGraficos result = Main.run(Integer.parseInt(PopulationSizeText.getText()), Integer.parseInt(GenerationNumberText.getText()),
                                            Double.parseDouble(CrossoverText.getText()), Double.parseDouble(MutationText.getText()),Double.parseDouble(EliteText.getText()), 
                                            SelectionCombo.getItemAt(SelectionCombo.getSelectedIndex()),CrossoverCombo.getItemAt(CrossoverCombo.getSelectedIndex()), 
                                            MutationCombo.getItemAt(MutationCombo.getSelectedIndex()),Integer.parseInt(s.substring(0, 2)));
       
       Plot2DPanel plot2DPanel = new Plot2DPanel();
       plot2DPanel.removeAllPlots();
       plot2DPanel.addLinePlot("Mejor Absoluto", Color.BLUE,ArrayListtoArray(result.getBestAbsolut()));
       plot2DPanel.addLinePlot("Mejor de la Generacion", Color.RED,ArrayListtoArray(result.getBestGeneration()));
       plot2DPanel.addLinePlot("Media Generacional", Color.GREEN,ArrayListtoArray(result.getMediaGeneracion()));
       plot2DPanel.addLegend("SOUTH");
       panelGrafica.setContentPane(plot2DPanel);
       panelGrafica.setVisible(true);
       panelGrafica.setSize(561, 518);
       String resultado = generaCadena(result.getBestIndividuo());
       resultadoText.setText(resultado);
       CosteText.setText(result.getBestAbsolut().get(result.getBestAbsolut().size()-1).toString());
    }//GEN-LAST:event_RunButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
      PopulationSizeText.setText("100");
      GenerationNumberText.setText("100");
      CiudadInicalCombo.setSelectedIndex(24);
      SelectionCombo.setSelectedIndex(3);
      CrossoverCombo.setSelectedIndex(0);
      CrossoverText.setText("0.60");
      MutationCombo.setSelectedIndex(0);
      MutationText.setText("0.20");
      EliteText.setText("0.10");
      
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void MutationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MutationComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MutationComboActionPerformed

    private void ParteOpcionalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParteOpcionalButtonActionPerformed
        GuiParteOpcional guiOpcional = new GuiParteOpcional();
        guiOpcional.setVisible(true);
    }//GEN-LAST:event_ParteOpcionalButtonActionPerformed

    private void SelectionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectionComboActionPerformed

    private void CrossoverComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrossoverComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrossoverComboActionPerformed

    private void GenerationNumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerationNumberTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenerationNumberTextActionPerformed

    private void MutationTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MutationTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MutationTextActionPerformed

    private void CiudadInicalComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadInicalComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadInicalComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CiudadInicalCombo;
    private javax.swing.JTextField CosteText;
    private javax.swing.JComboBox<String> CrossoverCombo;
    private javax.swing.JTextField CrossoverText;
    private javax.swing.JTextField EliteText;
    private javax.swing.JTextField GenerationNumberText;
    private javax.swing.JComboBox<String> MutationCombo;
    private javax.swing.JTextField MutationText;
    private javax.swing.JButton ParteOpcionalButton;
    private javax.swing.JTextField PopulationSizeText;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton RunButton;
    private javax.swing.JComboBox<String> SelectionCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JInternalFrame panelGrafica;
    private javax.swing.JTextArea resultadoText;
    // End of variables declaration//GEN-END:variables

    public double[] ArrayListtoArray(ArrayList<Double> a)
    {
		double array[] = new double[a.size()];
		for(int i=0;i<a.size();i++)
		{
			array[i]=a.get(i);
		}
		return array;
    }
    
    private String generaCadena (Individuo ind)
    {
        String cadena = "";
        for(int i = 0; i<ind.getGenes().size();i++)
        {
            switch(ind.getGenes().get(i))
            {
                case 1:
                    cadena +="Alicante -> "; break;
                case 2:
                    cadena +="Almer??a -> "; break;     
                case 3:
                    cadena +="Avila -> "; break; 
                case 4:
                    cadena +="Badajoz -> "; break; 
                case 5:
                    cadena +="Barcelona -> "; break; 
                case 6:
                    cadena +="Bilbao -> "; break;
                case 7:
                    cadena +="Burgos -> "; break;
                case 8:
                    cadena +="C??ceres -> "; break;
                case 9:
                    cadena +="C??diz -> "; break;
                case 10:
                    cadena +="Castell??n -> "; break;
                case 11:
                    cadena +="Ciudad Real -> "; break;
                case 12:
                    cadena +="C??rdoba -> "; break;
                case 13:
                    cadena +="A Coru??a -> "; break;
                case 14:
                    cadena +="Cuenca -> "; break;
                case 15:
                    cadena +="Gerona -> "; break;
                case 16:
                    cadena +="Granada -> "; break;
                case 17:
                    cadena +="Guadalajara -> "; break;
                case 18:
                    cadena +="Huelva -> "; break;
                case 19:
                    cadena +="Huesca -> "; break;
                case 20:
                    cadena +="Ja??n -> "; break;
                case 21:
                    cadena +="Le??n -> "; break;
                case 22:
                    cadena +="L??rida -> "; break;
                case 23:
                    cadena +="Logro??o -> "; break;
                case 24:
                    cadena +="Lugo -> "; break;
                case 25:
                    cadena +="Madrid -> "; break;
                case 26:
                    cadena +="M??laga -> "; break; 
                case 27:
                    cadena +="Murcia -> "; break; 
            }
        }
        return cadena;
    }
}
