/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Controller.accessFrame.createInicio;
import static Controller.accessFrame.createTablaComparativa;
import SCHEDULING.CSCAN;
import SCHEDULING.FIFO;
import SCHEDULING.FIFOPRI;
import SCHEDULING.FSCAN;
import SCHEDULING.LIFO;
import SCHEDULING.LIFOPRI;
import SCHEDULING.NSCAN;
import SCHEDULING.PRIORIDAD;
import SCHEDULING.RANDOM;
import SCHEDULING.SCAN;
import SCHEDULING.SSTF;
import UTIL.Control;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erin
 */
public class Ejecución extends javax.swing.JFrame {

    /**
     * Creates new form Ejecución
     */
    DefaultTableModel model;
    public Ejecución() {
        //model = (DefaultTableModel) jTable1.getModel();
        initComponents();
    }
        
    public void populateTable(LinkedList<Integer> Tracks, LinkedList<Integer> Distancias){
    
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);    
        model.addRow(new Object[] { Tracks.get(0) , 0});
        for (int i=0 ; i < Tracks.size()-1 ; i++) {
              
                model.addRow(new Object[] { Tracks.get(i+1) , Distancias.get(i)});
            }
         
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboxAlgorithm = new javax.swing.JComboBox<>();
        btnCorrer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtAverage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menFile = new javax.swing.JMenu();
        menAyuda = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menCompa = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione un algoritmo:");

        cboxAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C-SCAN", "FIFO", "FIFOPRI", "FSCAN", "LIFOPRI", "N-SCAN", "PRIORIDAD", "RANDOM", "SCAN", "SSTF" }));
        cboxAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlgorithmActionPerformed(evt);
            }
        });

        btnCorrer.setText("Correr");
        btnCorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrerActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Next track accessed", "Number of tracks traversed"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtAverage.setEditable(false);
        txtAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAverageActionPerformed(evt);
            }
        });

        jLabel2.setText("Average seek length");

        jLabel3.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel3.setText("Ejecución de algoritmos");

        jLabel4.setText("Total seek length");

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        menFile.setText("File");
        menFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menFileActionPerformed(evt);
            }
        });

        menAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menAyuda.setText("Ayuda");
        menAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAyudaActionPerformed(evt);
            }
        });
        menFile.add(menAyuda);

        jMenuBar1.add(menFile);

        jMenu2.setText("Ir");

        menCompa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menCompa.setText("Inicio");
        menCompa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCompaActionPerformed(evt);
            }
        });
        jMenu2.add(menCompa);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Comparar algoritmos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboxAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(btnCorrer))
                                    .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCorrer)
                    .addComponent(jLabel1)
                    .addComponent(cboxAlgorithm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillAverageSSTF(){
        String average = Integer.toString(Control.sstfPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.sstfDistancia));
    }
    
    private void fillAverageSCAN(){
        String average = Integer.toString(Control.scanPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.scanDistancia));
        
    }
    
    private void fillAverageRANDOM(){
        String average = Integer.toString(Control.randomPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.randomDistancia));
    }
    
    private void fillAverageLIFOPRI(){
        String average = Integer.toString(Control.lifoPriPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.lifoPriDistancia));
    }
    
    private void fillAverageFIFOPRI(){
        String average = Integer.toString(Control.fifoPriPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.fifoPriDistancia));
    }
    
    private void fillAverageFIFO(){
        String average = Integer.toString(Control.fifoPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.fifoDistancia));
    }
    
    private void fillAverageCSCAN(){
        String average = Integer.toString(Control.cscanPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.cscanDistancia));               
    }
    
    private void fillAverageFSCAN(){
        String average = Integer.toString(Control.fscanPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.fscanDistancia));
    }
    
    private void fillAverageNSCAN(){
        String average = Integer.toString(Control.nscanPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.nscanDistancia));
    }
    private void fillAveragePRIORIDAD(){
        String average = Integer.toString(Control.prioridadPromedio);
        txtAverage.setText(average);
        txtTotal.setText(Integer.toString(Control.prioridadDistancia));        
    }
    
    
    

    
    private void btnCorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrerActionPerformed

        String algoritmo = (String) cboxAlgorithm.getSelectedItem(); 
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int a = model.getRowCount()-1;
        System.out.println(a);
        for(int i=a; i>=0; i--){
        model.removeRow(i );
        }
        //Control.leerArchivo();
        
        if (null == algoritmo) {
        } else {
            
            switch (algoritmo) {
                
                case "C-SCAN":
                    
                    Control.setCabezalActual(Control.getCabezalActual());
                    CSCAN cscan = new CSCAN();
                    cscan.start();
                    populateTable(Control.cscanTracks,Control.cscanDistancias);
                    fillAverageCSCAN();
             
                    break;
                    
                case "FSCAN":
                    Control.setCabezalActual(Control.getCabezalActual());
                    FSCAN fscan = new FSCAN();
                    fscan.start();
                    populateTable(Control.fscanTracks,Control.fscanDistancias);
                    fillAverageFSCAN();
                    break;
                case "N-SCAN":
                    Control.setCabezalActual(Control.getCabezalActual());
                    NSCAN nscan = new NSCAN();
                    nscan.start();
                    populateTable(Control.nscanTracks,Control.nscanDistancias);
                    fillAverageNSCAN();
                    break;
                case "PRIORIDAD":
                    System.out.println("Prioridad");
                    Control.setCabezalActual(Control.getCabezalActual());
                    PRIORIDAD prioridad = new PRIORIDAD();
                    prioridad.start();
                    System.out.println("Prioridad");
                    populateTable(Control.prioridadTracksEstadisticas, Control.prioridadDistancias);
                    fillAveragePRIORIDAD();
                    break;
                case "SSTF":
                    Control.setCabezalActual(Control.getCabezalActual());
                    SSTF sstf = new SSTF();
                    sstf.start();
                    populateTable(Control.sstfTracks,Control.sstfDistancias);
                    fillAverageSSTF();
                    break;
                case "SCAN":
                    Control.setCabezalActual(Control.getCabezalActual());
                    SCAN scan = new SCAN();
                    scan.start();
                    populateTable(Control.scanTracks, Control.scanDistancias);
                    fillAverageSCAN();
                    break;
                case "RANDOM":
                    Control.setCabezalActual(Control.getCabezalActual());
                    RANDOM random = new RANDOM();
                    random.start();
                    populateTable(Control.randomTracks, Control.randomDistancias);
                    fillAverageRANDOM();
                    break;
                case "LIFOPRI":
                    Control.setCabezalActual(Control.getCabezalActual());
                    LIFOPRI lifoPri = new LIFOPRI();
                    lifoPri.start();
                    populateTable(Control.lifoPriTracksEstadisticas, Control.lifoPriDistancias);
                    fillAverageLIFOPRI();
                    break;
                case "FIFOPRI":
                    Control.setCabezalActual(Control.getCabezalActual());
                    FIFOPRI fifoPri = new FIFOPRI();
                    fifoPri.start();
                    populateTable(Control.fifoPriTracksEstadisticas, Control.fifoPriDistancias);
                    fillAverageFIFOPRI();
                    break;
                case "FIFO":
                    Control.setCabezalActual(Control.getCabezalActual());
                    FIFO fifo = new FIFO();
                    fifo.start();
                    populateTable(Control.fifoTracks, Control.fifoDistancias);
                    fillAverageFIFO();
                    break;  
                case "LIFO":
                    Control.setCabezalActual(Control.getCabezalActual());
                    LIFO lifo = new LIFO();
                    lifo.start();
                    populateTable(Control.lifoTracks, Control.lifoDistancias);
                    fillAverageFIFO();
                    break; 
                default:
                    break;
            }
        }
        
        
    }//GEN-LAST:event_btnCorrerActionPerformed

    private void txtAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAverageActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
        createTablaComparativa();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menCompaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCompaActionPerformed
        dispose();
        createInicio();
    }//GEN-LAST:event_menCompaActionPerformed

    private void cboxAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlgorithmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlgorithmActionPerformed

    private void menFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menFileActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_menFileActionPerformed

    private void menAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAyudaActionPerformed
        // TODO add your handling code here:
          
        String ms = "En esta sección podrá ejecutar alguno de los algoritmos de scheduling del disco.\n"
                + "Para poder ejecutar el algoritmo, primero debe seleccionar una opción y posterior \n"
                + "a esto deberá dar click en el botón Correr, esto procesará el algoritmo seleccionado\n"
                + " y mostrará la gráfica correspondiente, de igual forma desplegará en la tabla el \n"
                + "orden en que se accesaron las pistas del disco y el número de pistas atravesadas, \n"
                + "además se mostrará el promedio de búsqueda.";
            JOptionPane.showMessageDialog(null, ms);
    }//GEN-LAST:event_menAyudaActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed


    
            
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
            java.util.logging.Logger.getLogger(Ejecución.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejecución.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejecución.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejecución.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     
         

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejecución().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorrer;
    public static javax.swing.JComboBox<String> cboxAlgorithm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menAyuda;
    private javax.swing.JMenuItem menCompa;
    private javax.swing.JMenu menFile;
    private static javax.swing.JTextField txtAverage;
    private static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
