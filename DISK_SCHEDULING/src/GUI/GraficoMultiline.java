/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SCHEDULING.CSCAN;
import SCHEDULING.FIFO;
import SCHEDULING.FSCAN;
import SCHEDULING.LIFO;
import SCHEDULING.NSCAN;
import SCHEDULING.PRIORIDAD;
import SCHEDULING.RANDOM;
import SCHEDULING.SCAN;
import SCHEDULING.SSTF;
import UTIL.Control;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Erin
 */
public class GraficoMultiline extends javax.swing.JFrame {

    /**
     * Creates new form GraficoMultiline
     */
    public GraficoMultiline() {
   
    
    JPanel chartPanel = createChartPanel();       
    add(chartPanel, BorderLayout.CENTER);
    
    setSize(640, 480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    }
    
    private JPanel createChartPanel() { // this method will create the chart panel containin the graph 
    String chartTitle = "Disk scheduling";
    String xAxisLabel = "Time";
    String yAxisLabel = "Track nnumber";
    
    XYDataset dataset = createDataset();
    
    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
            xAxisLabel, yAxisLabel, dataset);

    customizeChart(chart);
    
    // saves the chart as an image files
    File imageFile = new File("XYLineChart.png");
    int width = 640;
    int height = 480;
    
    try {
        ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
    } catch (IOException ex) {
        System.err.println(ex);
    }
    
    return new ChartPanel(chart);
}

private XYDataset createDataset() {    // this method creates the data as time seris 
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series1 = new XYSeries("C-SCAN");
    XYSeries series2 = new XYSeries("FIFO");
    XYSeries series3 = new XYSeries("LIFO");
    XYSeries series4 = new XYSeries("F-SCAN");
    XYSeries series5 = new XYSeries("N-SCAN");
    XYSeries series6 = new XYSeries("PRIORIDAD");
    XYSeries series7 = new XYSeries("RANDOM");
    XYSeries series8 = new XYSeries("SCAN");
    XYSeries series9 = new XYSeries("SSTF");
    
    int tiempo = 0;
        Integer[] arrayCSCAN = Control.sstfTracks.toArray(new Integer[Control.sstfTracks.size()]);
        Integer[] arrayFIFO = Control.fifoTracks.toArray(new Integer[Control.fifoTracks.size()]);
        Integer[] arrayLIFO = Control.lifoTracks.toArray(new Integer[Control.lifoTracks.size()]);
        Integer[] arrayFSCAN = Control.fscanTracks.toArray(new Integer[Control.fscanTracks.size()]);
        Integer[] arrayNSCAN = Control.nscanTracks.toArray(new Integer[Control.nscanTracks.size()]);
        Integer[] arrayPRI = Control.prioridadTracksEstadisticas.toArray(new Integer[Control.prioridadTracksEstadisticas.size()]);
        Integer[] arrayRAM = Control.randomTracks.toArray(new Integer[Control.randomTracks.size()]);
        Integer[] arraySCAN = Control.scanTracks.toArray(new Integer[Control.scanTracks.size()]);
        Integer[] arraySSTF = Control.sstfTracks.toArray(new Integer[Control.sstfTracks.size()]);

        for (Integer array1 : arrayCSCAN) {
            series1.add(tiempo, array1);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array2 : arrayFIFO) {
            series2.add(tiempo, array2);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array3 : arrayLIFO) {
            series3.add(tiempo, array3);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array4 : arrayFSCAN) {
            series4.add(tiempo, array4);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array5 : arrayNSCAN) {
            series5.add(tiempo, array5);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array6 : arrayPRI) {
            series6.add(tiempo, array6);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array7 : arrayRAM) {
            series7.add(tiempo, array7);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array8 : arraySCAN) {
            series8.add(tiempo, array8);
            tiempo = tiempo + 5;
        }
        tiempo = 0;
        for (Integer array9 : arraySSTF) {
            series9.add(tiempo, array9);
            tiempo = tiempo + 5;
        }
      
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);
        dataset.addSeries(series7);
        dataset.addSeries(series8);
        dataset.addSeries(series9);

        return dataset;
    
}

private void customizeChart(JFreeChart chart) {   // here we make some customization
    XYPlot plot = chart.getXYPlot();
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    // sets paint color for each series
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesPaint(1, Color.GREEN);
    renderer.setSeriesPaint(2, Color.YELLOW);
    renderer.setSeriesPaint(3, Color.ORANGE);
    renderer.setSeriesPaint(4, Color.PINK);
    renderer.setSeriesPaint(5, Color.MAGENTA);
    renderer.setSeriesPaint(6, Color.BLUE);
    renderer.setSeriesPaint(7, Color.CYAN);
    renderer.setSeriesPaint(8, Color.GRAY);

    // sets thickness for series (using strokes)
    renderer.setSeriesStroke(0, new BasicStroke(2.0f));
    renderer.setSeriesStroke(1, new BasicStroke(2.0f));
    renderer.setSeriesStroke(2, new BasicStroke(2.0f));
    renderer.setSeriesStroke(3, new BasicStroke(2.0f));
    renderer.setSeriesStroke(4, new BasicStroke(2.0f));
    renderer.setSeriesStroke(5, new BasicStroke(2.0f));
    renderer.setSeriesStroke(6, new BasicStroke(2.0f));
    renderer.setSeriesStroke(7, new BasicStroke(2.0f));
    renderer.setSeriesStroke(8, new BasicStroke(2.0f));
    
    // sets paint color for plot outlines
    plot.setOutlinePaint(Color.BLACK);
    plot.setOutlineStroke(new BasicStroke(2.0f));
    
    // sets renderer for lines
    plot.setRenderer(renderer);
    
    // sets plot background
    plot.setBackgroundPaint(Color.white);
    
    // sets paint color for the grid lines
    plot.setRangeGridlinesVisible(true);
    plot.setRangeGridlinePaint(Color.BLACK);
    
    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.BLACK);
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficoMultiline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficoMultiline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficoMultiline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficoMultiline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
               
        Control.leerArchivo();
        
        CSCAN cscan = new CSCAN();
        cscan.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        FIFO fifo = new FIFO();
        fifo.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        FSCAN fscan = new FSCAN();
        fscan.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        LIFO lifo = new LIFO();
        lifo.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        NSCAN nscan = new NSCAN();
        nscan.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        PRIORIDAD prioridad = new PRIORIDAD();
        prioridad.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        RANDOM random = new RANDOM();
        random.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        SCAN scan = new SCAN();
        scan.start();
        
        Control.setCabezalActual(Control.getCabezalInicial());
        SSTF sstf = new SSTF();
        sstf.start();
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficoMultiline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
