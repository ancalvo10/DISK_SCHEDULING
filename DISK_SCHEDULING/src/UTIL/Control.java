/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class Control {
    
    private int cabezalInicial;
    private int cabezalActual;
    private int pistasTotales;
    
    private LinkedList<Integer> sstfTracks;
    private LinkedList<Integer> fifoTracks;
    private LinkedList<Integer> lifoTracks;
    private LinkedList<Integer> randomTracks;
    private LinkedList<Prioridad> prioridadTracks;
    private LinkedList<Integer> scanTracks;
    private LinkedList<Integer> cscanTracks;
    private LinkedList<Integer> nscanTracks;
    private LinkedList<Integer> fscanTracks;
    
    public void randomList(LinkedList<Integer> randomTracks){
        Collections.shuffle(randomTracks);
    }

    public int getCabezalInicial() {
        return cabezalInicial;
    }

    public void setCabezalInicial(int cabezalInicial) {
        this.cabezalInicial = cabezalInicial;
        this.cabezalActual = cabezalInicial;
    }
    
    
    
    
    
}
