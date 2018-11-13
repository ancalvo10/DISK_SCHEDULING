/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import UTIL.Prioridad;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class FIFOPRI {
    
    public void start(){
        LinkedList<Prioridad> recorridoPrio = new LinkedList<>();
        LinkedList<Integer> recorrido = new LinkedList<>();
        Control.fifoPriTracks = new LinkedList<>();
        Control.fifoPriDistancias = new LinkedList<>();
        Control.fifoPriDistancia = 0;
        
        
        for(int copy = 0; copy < Control.originalPrioTracks.size(); copy++){
            Control.fifoPriTracks.add(Control.originalPrioTracks.get(copy));
        }
        
        int pri = 1;
        while(pri <= 5){
            for (Prioridad prioridadTrack : Control.fifoPriTracks) {
                if(prioridadTrack.getPrioridad() == pri){
                    recorridoPrio.add(prioridadTrack);
                }
            }
            pri++;
        }
        //Collections.reverse(recorridoPrio); 
        Control.fifoPriTracks = recorridoPrio;
        
        Control.fifoPriDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        recorrido.add(Control.getCabezalActual());
        while(Control.fifoPriTracks.size() != 1){
            Control.setCabezalActual(Control.fifoPriTracks.pop().getPista());
            recorrido.add(Control.getCabezalActual());
            Control.fifoPriDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        }
        
        int contDis = 0;
        while(contDis < Control.fifoPriDistancias.size()){
            Control.fifoPriDistancia += Control.fifoPriDistancias.get(contDis);
            contDis++;
        }
        if(Control.fifoPriDistancia != 0)
            Control.fifoPriPromedio = Control.fifoPriDistancia/Control.originalPrioTracks.size();
        Control.setCabezalActual(recorridoPrio.getFirst().getPista());
        recorrido.add(recorridoPrio.removeFirst().getPista());
        Control.fifoPriTracksEstadisticas = recorrido;
        
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
        
        FIFOPRI fifoPri = new FIFOPRI();
        fifoPri.start();
        
        System.out.println(Control.fifoPriTracksEstadisticas.toString());
        System.out.println(Control.fifoPriDistancias.toString());
        System.out.println(Control.fifoPriDistancia);
        System.out.println(Control.fifoPriPromedio);
    } 
    
}
