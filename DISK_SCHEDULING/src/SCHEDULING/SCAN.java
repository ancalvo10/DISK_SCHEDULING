/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class SCAN {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.scanTracks.add(Control.originalTracks.get(copy));
        }
        Control.scanTracks.sort(Comparator.naturalOrder());
        int contScan = 0;
        while(Control.scanTracks.get(contScan) < Control.getCabezalActual()){
            contScan++;
        }
        recorrido.add(Control.getCabezalActual());
        while(Control.scanTracks.size() > contScan){
            Control.scanDistancias.add(Math.abs(Control.getCabezalActual() - Control.scanTracks.get(contScan)));
            Control.setCabezalActual(Control.scanTracks.get(contScan));
            recorrido.add(Control.scanTracks.remove(contScan));
        }
        Control.scanTracks.sort(Comparator.reverseOrder());
        while(!Control.scanTracks.isEmpty()){
            Control.scanDistancias.add(Math.abs(Control.getCabezalActual() - Control.scanTracks.getFirst()));
            Control.setCabezalActual(Control.scanTracks.getFirst());
            recorrido.add(Control.scanTracks.removeFirst());
        }
        int contDis = 0;
        while(contDis < Control.scanDistancias.size()){
            Control.scanDistancia += Control.scanDistancias.get(contDis);
            contDis++;
        }
        if(Control.scanDistancia != 0)
            Control.scanPromedio = Control.scanDistancia/Control.originalTracks.size();
        Control.scanTracks = recorrido;
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
        
        SCAN scan = new SCAN();
        scan.start();
        
        System.out.println(Control.scanTracks.toString());
        System.out.println(Control.scanDistancias.toString());
        System.out.println(Control.scanDistancia);
        System.out.println(Control.scanPromedio);
    }
    
}
