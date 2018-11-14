/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class FIFO {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        Control.fifoTracks = new LinkedList<>();
        Control.fifoDistancias = new LinkedList<>();
        Control.fifoDistancia = 0;
        
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.fifoTracks.add(Control.originalTracks.get(copy));
        }
        Control.fifoDistancias.add(Math.abs(Control.getCabezalActual() - Control.fifoTracks.getFirst()));
        recorrido.add(Control.getCabezalActual());
        while(Control.fifoTracks.size() != 1){
            Control.setCabezalActual(Control.fifoTracks.pop());
            recorrido.add(Control.getCabezalActual());
            Control.fifoDistancias.add(Math.abs(Control.getCabezalActual() - Control.fifoTracks.getFirst()));
        }
        
        int contDis = 0;
        while(contDis < Control.fifoDistancias.size()){
            Control.fifoDistancia += Control.fifoDistancias.get(contDis);
            contDis++;
        }
        if(Control.fifoDistancia != 0)
            Control.fifoPromedio = Control.fifoDistancia/Control.originalTracks.size();
        Control.setCabezalActual(Control.fifoTracks.getFirst());
        recorrido.add(Control.fifoTracks.removeFirst());
        Control.fifoTracks = recorrido;
    }
    
    public static void main(String[] args){
        LinkedList<Integer> pet = new LinkedList<Integer>();
        pet = Control.originalTracks;
        
        Control.setCabezalInicial(90);

        pet.add(98);
        pet.add(183);
        pet.add(37);
        pet.add(122);
        pet.add(14);
        pet.add(124);
        pet.add(65);
        pet.add(67);
        pet.add(140);
        pet.add(90);
        pet.add(15);
        
        FIFO fifo = new FIFO();
        fifo.start();
        
        System.out.println(Control.fifoTracks.toString());
        System.out.println(Control.fifoDistancias.toString());
        System.out.println(Control.fifoDistancia);
        System.out.println(Control.fifoPromedio);
    } 
    
}
