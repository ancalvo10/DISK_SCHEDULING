/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class NSCAN {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.nscanTracks.add(Control.originalTracks.get(copy));
        }
        
        Control.nscanTracks.sort(Comparator.naturalOrder());
        int contScan = 0;
        while(Control.nscanTracks.get(contScan) < Control.getCabezalActual()){
            contScan++;
        }
        recorrido.add(Control.getCabezalActual());
        while(Control.nscanTracks.size() > contScan){
            Control.nscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.nscanTracks.get(contScan)));
            Control.setCabezalActual(Control.nscanTracks.get(contScan));
            recorrido.add(Control.nscanTracks.remove(contScan));
        }
        Control.nscanTracks.sort(Comparator.reverseOrder());
        while(!Control.nscanTracks.isEmpty()){
            Control.nscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.nscanTracks.getFirst()));
            Control.setCabezalActual(Control.nscanTracks.getFirst());
            recorrido.add(Control.nscanTracks.removeFirst());
        }
        int contDis = 0;
        while(contDis < Control.nscanDistancias.size()){
            Control.nscanDistancia += Control.nscanDistancias.get(contDis);
            contDis++;
        }
        if(Control.nscanDistancia != 0)
            Control.nscanPromedio = Control.nscanDistancia/Control.originalTracks.size();
        Control.nscanTracks = recorrido;
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
        
        NSCAN nscan = new NSCAN();
        nscan.start();
        
        System.out.println(Control.nscanTracks.toString());
        System.out.println(Control.nscanDistancias.toString());
        System.out.println(Control.nscanDistancia);
        System.out.println(Control.nscanPromedio);
    }
    
}
