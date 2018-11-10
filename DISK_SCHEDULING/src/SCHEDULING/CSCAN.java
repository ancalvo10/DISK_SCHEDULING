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
public class CSCAN {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.cscanTracks.add(Control.originalTracks.get(copy));
        }
        Control.cscanTracks.sort(Comparator.naturalOrder());
        int contScan = 0;
        while(Control.cscanTracks.get(contScan) < Control.getCabezalActual()){
            contScan++;
        }
        recorrido.add(Control.getCabezalActual());
        while(Control.cscanTracks.size() > contScan){
            Control.cscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.cscanTracks.get(contScan)));
            Control.setCabezalActual(Control.cscanTracks.get(contScan));
            recorrido.add(Control.cscanTracks.remove(contScan));
        }
        while(!Control.cscanTracks.isEmpty()){
            Control.cscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.cscanTracks.getFirst()));
            Control.setCabezalActual(Control.cscanTracks.getFirst());
            recorrido.add(Control.cscanTracks.removeFirst());
        }
        int contDis = 0;
        while(contDis < Control.cscanDistancias.size()){
            Control.cscanDistancia += Control.cscanDistancias.get(contDis);
            contDis++;
        }
        if(Control.cscanDistancia != 0)
            Control.cscanPromedio = Control.cscanDistancia/Control.originalTracks.size();
        Control.cscanTracks = recorrido;
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
        
        CSCAN cscan = new CSCAN();
        cscan.start();
        
        System.out.println(Control.cscanTracks.toString());
        System.out.println(Control.cscanDistancias.toString());
        System.out.println(Control.cscanDistancia);
        System.out.println(Control.cscanPromedio);
    }
    
}
