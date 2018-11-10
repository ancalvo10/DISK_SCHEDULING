/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Controller.accessFrame.createInicio;
import static Controller.accessFrame.createTablaComparativa;
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
        
    public void populateTable(){
   
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Integer[] tracks = Control.sstfTracks.toArray(new Integer[Control.sstfTracks.size()]);
        Integer[] distancias = Control.sstfDistancias.toArray(new Integer[Control.sstfDistancias.size()]);
       
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //model.removeTableModelListener(jTable1);       
        for (int i=0; i<tracks[i];i++) {
            //for (Integer di : distancias) {
              
                model.addRow(new Object[] { tracks , distancias});
                System.out.println(tracks[i].toString());
            //}
        }
        
//        try {
//           
//           Object track[][]= Control.sstfTracks.toArray(new Object[0][]);
//           for (int i=0;i<track.length;i++) {
//               for (int j=0;j<track[i].length;j++) {
//                model.addRow(new Object[]{track[i][j]});
//               }
//           }
//        } catch (Exception e){
//              System.err.println("Error: " + e.getMessage());
//        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jMenuBar1 = new javax.swing.JMenuBar();
        menAyuda = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione un algoritmo:");

        cboxAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C-SCAN", "FIFO", "FSCAN", "LIFO", "N-SCAN", "PRIORIDAD", "RAMDOM", "SCAN", "SSTF" }));
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

        menAyuda.setText("Ayuda");
        menAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAyudaActionPerformed(evt);
            }
        });
        jMenuBar1.add(menAyuda);

        jMenu2.setText("Ir");

        jMenuItem1.setText("Inicio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboxAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(btnCorrer)))))
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCorrer)
                    .addComponent(jLabel1)
                    .addComponent(cboxAlgorithm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillAverageSSTF(){
        String average = Integer.toString(Control.sstfPromedio);
        txtAverage.setText(average);
    }
    
    private void fillAverageSCAN(){
        String average = Integer.toString(Control.scanPromedio);
        txtAverage.setText(average);
    }
    
    private void fillAverageRANDOM(){
        String average = Integer.toString(Control.randomPromedio);
        txtAverage.setText(average);
    }
    
    private void fillAverageLIFO(){
        String average = Integer.toString(Control.lifoPromedio);
        txtAverage.setText(average);
    }
    
    private void fillAverageFIFO(){
        String average = Integer.toString(Control.fifoPromedio);
        txtAverage.setText(average);
    }

    
    private void btnCorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrerActionPerformed
 
        String algoritmo = (String) cboxAlgorithm.getSelectedItem(); 
        if (null != algoritmo)switch (algoritmo) {
            case "SSTF":
                fillAverageSSTF();
                break;
            case "SCAN":
                fillAverageSCAN();
                break;
            case "RANDOM":
                fillAverageRANDOM();
                break;
            case "LIFO":
                fillAverageLIFO();
                break;
            case "FIFO":
                fillAverageFIFO();
                break;
            default:
                break;
        }
        
        Grafico ventanaGrafico = new Grafico();
        ventanaGrafico.setVisible(true);
    }//GEN-LAST:event_btnCorrerActionPerformed

    private void txtAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAverageActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        createTablaComparativa();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        createInicio();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cboxAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlgorithmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlgorithmActionPerformed

    private void menAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAyudaActionPerformed
        // TODO add your handling code here:
        
        String ms = "Para empezar cree una impresora y una aplicacion ingresando con los botones Crear impresora y Crear Aplicacion, respectivamente, \n"
                + "puede ver el log de ambas cuando estos hayan realizado alguna acción con los botones de Historial, \n"
                + "con el boton Imprimir puede ir a la ventana de buscar y enviar archivos a imprimir, \n"
                + "por ultimo, Ver estado muestra el estado de la cola de impresion de la impresora que se seleccione en esa pantalla";
            JOptionPane.showMessageDialog(null, ms);
    }//GEN-LAST:event_menAyudaActionPerformed


    
            
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menAyuda;
    private javax.swing.JTextField txtAverage;
    // End of variables declaration//GEN-END:variables
}
