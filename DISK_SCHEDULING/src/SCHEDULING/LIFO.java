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
public class LIFO {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.lifoTracks.add(Control.originalTracks.get(copy));
        }
        Control.lifoDistancias.add(Math.abs(Control.getCabezalActual() - Control.lifoTracks.getLast()));
        recorrido.add(Control.getCabezalActual());
        while(Control.lifoTracks.size() != 1){
            Control.setCabezalActual(Control.lifoTracks.removeLast());
            recorrido.add(Control.getCabezalActual());
            Control.lifoDistancias.add(Math.abs(Control.getCabezalActual() - Control.lifoTracks.getLast()));
        }
        
        int contDis = 0;
        while(contDis < Control.lifoDistancias.size()){
            Control.lifoDistancia += Control.lifoDistancias.get(contDis);
            contDis++;
        }
        if(Control.lifoDistancia != 0)
            Control.lifoPromedio = Control.lifoDistancia/Control.originalTracks.size();
        recorrido.add(Control.lifoTracks.removeLast());
        Control.lifoTracks = recorrido;
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
        
        LIFO lifo = new LIFO();
        lifo.start();
        
        System.out.println(Control.lifoTracks.toString());
        System.out.println(Control.lifoDistancias.toString());
        System.out.println(Control.lifoDistancia);
        System.out.println(Control.lifoPromedio);
    }
    
}
