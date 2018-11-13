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
public class PRIORIDAD {
    
    public void start(){
        LinkedList<Prioridad> recorridoPrio = new LinkedList<>();
        LinkedList<Integer> recorrido = new LinkedList<>();
        Control.prioridadTracks = new LinkedList<>();
        Control.prioridadDistancias = new LinkedList<>();
        Control.prioridadDistancia = 0;
        
        
        for(int copy = 0; copy < Control.originalPrioTracks.size(); copy++){
            Control.prioridadTracks.add(Control.originalPrioTracks.get(copy));
        }
        
        int pri = 1;
        while(pri <= 5){
            for (Prioridad prioridadTrack : Control.prioridadTracks) {
                if(prioridadTrack.getPrioridad() == pri){
                    recorridoPrio.add(prioridadTrack);
                }
            }
            pri++;
        }
        //Collections.reverse(recorridoPrio); 
        Control.prioridadTracks = recorridoPrio;
        
        Control.prioridadDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        recorrido.add(Control.getCabezalActual());
        while(Control.prioridadTracks.size() != 1){
            Control.setCabezalActual(Control.prioridadTracks.pop().getPista());
            recorrido.add(Control.getCabezalActual());
            Control.prioridadDistancias.add(Math.abs(Control.getCabezalActual() - recorridoPrio.getFirst().getPista()));
        }
        Control.setCabezalActual(recorridoPrio.getFirst().getPista());
        
        int contDis = 0;
        while(contDis < Control.prioridadDistancias.size()){
            Control.prioridadDistancia += Control.prioridadDistancias.get(contDis);
            contDis++;
        }
        if(Control.prioridadDistancia != 0)
            Control.prioridadPromedio = Control.prioridadDistancia/Control.originalPrioTracks.size();
        recorrido.add(recorridoPrio.removeFirst().getPista());
        Control.prioridadTracksEstadisticas = recorrido;
        
    }
    
    
    public static void main(String[] args){
        LinkedList<Prioridad> pet;// = new LinkedList<>();
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
        
        PRIORIDAD prioridad = new PRIORIDAD();
        prioridad.start();
        
        System.out.println(Control.prioridadTracksEstadisticas.toString());
        System.out.println(Control.prioridadDistancias.toString());
        System.out.println(Control.prioridadDistancia);
        System.out.println(Control.prioridadPromedio);
    } 
}
