/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Control {
    
    private static int cabezalInicial;
    private static int cabezalActual;
    private static int pistasTotales;
    public static LinkedList<Integer> originalTracks = new LinkedList<Integer>();
    public static LinkedList<Prioridad> originalPrioTracks = new LinkedList<Prioridad>();
    
    public static LinkedList<Proceso> procesos = new LinkedList<Proceso>();
    
    public static LinkedList<Integer> sstfTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> sstfDistancias = new LinkedList<Integer>();
    public static int sstfDistancia = 0;
    public static int sstfPromedio = 0;
    public static LinkedList<Integer> fifoTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> fifoDistancias = new LinkedList<Integer>();
    public static int fifoDistancia = 0;
    public static int fifoPromedio = 0;
    public static LinkedList<Integer> lifoTracks = new LinkedList<Integer>();;
    public static LinkedList<Integer> lifoDistancias = new LinkedList<Integer>();;
    public static int lifoDistancia = 0;
    public static int lifoPromedio = 0;
    public static LinkedList<Integer> randomTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> randomDistancias = new LinkedList<Integer>();
    public static int randomDistancia = 0;
    public static int randomPromedio = 0;
    public static LinkedList<Prioridad> prioridadTracks = new LinkedList<Prioridad>();
    public static LinkedList<Integer> prioridadTracksEstadisticas = new LinkedList<Integer>();
    public static LinkedList<Integer> prioridadDistancias = new LinkedList<Integer>();
    public static int prioridadDistancia = 0;
    public static int prioridadPromedio = 0;
    public static LinkedList<Integer> scanTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> scanDistancias = new LinkedList<Integer>();
    public static int scanDistancia = 0;
    public static int scanPromedio = 0;
    public static LinkedList<Integer> cscanTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> cscanDistancias = new LinkedList<Integer>();
    public static int cscanDistancia = 0;
    public static int cscanPromedio = 0;
    public static LinkedList<Integer> nscanTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> nscanDistancias = new LinkedList<Integer>();
    public static int nscanDistancia = 0;
    public static int nscanPromedio = 0;
    public static LinkedList<Integer> fscanTracks = new LinkedList<Integer>();
    public static LinkedList<Integer> fscanDistancias = new LinkedList<Integer>();
    public static int fscanDistancia = 0;
    public static int fscanPromedio = 0;
    
    public void randomList(){
        Collections.shuffle(randomTracks);
    }//No se usó

    public static int getCabezalInicial() {
        return cabezalInicial;
    }

    public static void setCabezalInicial(int cabezalInicial) {
        Control.cabezalInicial = cabezalInicial;
        Control.cabezalActual = cabezalInicial;
    }
    
    public static int getCabezalActual() {
        return cabezalActual;
    }

    public static void setCabezalActual(int cabezalActual) {
        Control.cabezalActual = cabezalActual;
    }

    public static int getPistasTotales() {
        return pistasTotales;
    }

    public static void setPistasTotales(int pistasTotales) {
        Control.pistasTotales = pistasTotales;
    }
    
    public static void addProceso(String nombre, int prioridad){
        Proceso proceso = new Proceso(nombre, prioridad);
        Control.procesos.add(proceso);
    }
    
    public static int findPrioridad(String proceso){
        int cont = 0;
        while(cont < Control.procesos.size()){
            if(Control.procesos.get(cont).getNombre().equals(proceso)){
                break;
            }
            cont++;
        }
        return Control.procesos.get(cont).getPrioridad();
    }
    
    public static void leerArchivo(){
        try { 
            File text = new File("request.txt");
            System.out.println(text.getAbsolutePath());
            Scanner sc = new Scanner(text);
            while (sc.hasNext("#defineprocess")) {
                if(sc.next().equals("#defineprocess")){
                    Control.procesos.add(new Proceso(sc.next(), sc.nextInt()));
                }
                System.out.println(Control.procesos.getLast().getNombre());
                       System.out.println(Control.procesos.getLast().getPrioridad());
                //if(sc.next().equals("#cabezalInicial"))
                
                System.out.println(Control.procesos.toString());
                //String str = sc.next();
                //System.out.println(str);
            }
            while (sc.hasNext("#cabezalInicial")) {
                if(sc.next().equals("#cabezalInicial")){
                    Control.setCabezalInicial(sc.nextInt());
                    System.out.println(Control.getCabezalActual());
                }
            }
            sc.next("#tracks");
            while (sc.hasNext()) {
                String proceso = sc.next();
                int prioridad = findPrioridad(proceso);
                int track = sc.nextInt();
                Control.originalPrioTracks.add(new Prioridad(prioridad, track));
                Control.originalTracks.add(track);
                if(sc.hasNext())
                    sc.next(",");
            }
            System.out.println(Control.originalTracks);
            System.out.println(Control.originalPrioTracks);            
            
        }
        
        catch(Exception e){
            System.err.println("No se pudo leer correctamente el archivo \n"+e);   
        }
    }
    
    public static void main(String[] args){
        leerArchivo();
    }
    
}
