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
public class FSCAN {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.fscanTracks.add(Control.originalTracks.get(copy));
        }
        Control.fscanTracks.sort(Comparator.naturalOrder());
        int contScan = 0;
        while(Control.fscanTracks.get(contScan) < Control.getCabezalActual()){
            contScan++;
        }
        recorrido.add(Control.getCabezalActual());
        while(Control.fscanTracks.size() > contScan){
            Control.fscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.fscanTracks.get(contScan)));
            Control.setCabezalActual(Control.fscanTracks.get(contScan));
            recorrido.add(Control.fscanTracks.remove(contScan));
        }
        Control.fscanTracks.sort(Comparator.reverseOrder());
        while(!Control.fscanTracks.isEmpty()){
            Control.fscanDistancias.add(Math.abs(Control.getCabezalActual() - Control.fscanTracks.getFirst()));
            Control.setCabezalActual(Control.fscanTracks.getFirst());
            recorrido.add(Control.fscanTracks.removeFirst());
        }
        int contDis = 0;
        while(contDis < Control.fscanDistancias.size()){
            Control.fscanDistancia += Control.fscanDistancias.get(contDis);
            contDis++;
        }
        if(Control.fscanDistancia != 0)
            Control.fscanPromedio = Control.fscanDistancia/Control.originalTracks.size();
        Control.fscanTracks = recorrido;
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
        
        FSCAN fscan = new FSCAN();
        fscan.start();
        
        System.out.println(Control.fscanTracks.toString());
        System.out.println(Control.fscanDistancias.toString());
        System.out.println(Control.fscanDistancia);
        System.out.println(Control.fscanPromedio);
    }
    
}
