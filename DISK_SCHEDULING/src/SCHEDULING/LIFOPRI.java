/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import UTIL.Prioridad;
import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author andre
 */
public class LIFOPRI {
    
    public void start(){
        LinkedList<Prioridad> recorridoPrio = new LinkedList<>();
        LinkedList<Integer> recorrido = new LinkedList<>();
        Control.lifoPriTracks = new LinkedList<>();
        Control.lifoPriDistancias = new LinkedList<>();
        Control.lifoPriDistancia = 0;
        
        
        for(int copy = 0; copy < Control.originalPrioTracks.size(); copy++){
            Control.lifoPriTracks.add(Control.originalPrioTracks.get(copy));
        }
        
        int pri = 5;
        while(pri >= 1){
            for (Prioridad prioridadTrack : Control.lifoPriTracks) {
                if(prioridadTrack.getPrioridad() == pri){
                    recorridoPrio.add(prioridadTrack);
                }
            }
            pri--;
        }
        Collections.reverse(recorridoPrio); 
        Control.lifoPriTracks = recorridoPrio;
        
        Control.lifoPriDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        recorrido.add(Control.getCabezalActual());
        while(Control.lifoPriTracks.size() != 1){
            Control.setCabezalActual(Control.lifoPriTracks.pop().getPista());
            recorrido.add(Control.getCabezalActual());
            Control.lifoPriDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        }
        
        int contDis = 0;
        while(contDis < Control.lifoPriDistancias.size()){
            Control.lifoPriDistancia += Control.lifoPriDistancias.get(contDis);
            contDis++;
        }
        if(Control.lifoPriDistancia != 0)
            Control.lifoPriPromedio = Control.lifoPriDistancia/Control.originalPrioTracks.size();
        Control.setCabezalActual(recorridoPrio.getFirst().getPista());
        recorrido.add(recorridoPrio.removeFirst().getPista());
        Control.lifoPriTracksEstadisticas = recorrido;
        
    }
    
    
    public static void main(String[] args){
        LinkedList<Prioridad> pet = new LinkedList<Prioridad>();
        pet = Control.originalPrioTracks;
        
        Control.setCabezalInicial(90);
        // 1 es la prioridad mayor, 5 la menor
        pet.add(new Prioridad(1,183));
        pet.add(new Prioridad(2,37));
        pet.add(new Prioridad(3,122));
        pet.add(new Prioridad(1,14));
        pet.add(new Prioridad(1,65));
        pet.add(new Prioridad(2,67));
        pet.add(new Prioridad(2,140));
        pet.add(new Prioridad(1,90));
        pet.add(new Prioridad(3,15));
        
        LIFOPRI lifoPri = new LIFOPRI();
        lifoPri.start();
        
        System.out.println(Control.lifoPriTracksEstadisticas.toString());
        System.out.println(Control.lifoPriDistancias.toString());
        System.out.println(Control.lifoPriDistancia);
        System.out.println(Control.lifoPriPromedio);
    } 
    
}
