/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class RANDOM {
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.randomTracks.add(Control.originalTracks.get(copy));
        }
        Random rand = new Random();
        int randomElement = rand.nextInt(Control.randomTracks.size());
        
        Control.randomDistancias.add(Math.abs(Control.getCabezalActual() - Control.randomTracks.get(randomElement)));
        recorrido.add(Control.getCabezalActual());
        while(Control.randomTracks.size() != 1){
            Control.setCabezalActual(Control.randomTracks.remove(randomElement));
            recorrido.add(Control.getCabezalActual());
            randomElement = rand.nextInt(Control.randomTracks.size());
            Control.randomDistancias.add(Math.abs(Control.getCabezalActual() - Control.randomTracks.get(randomElement)));
        }
        
        int contDis = 0;
        while(contDis < Control.randomDistancias.size()){
            Control.randomDistancia += Control.randomDistancias.get(contDis);
            contDis++;
        }
        if(Control.randomDistancia != 0)
            Control.randomPromedio = Control.randomDistancia/Control.originalTracks.size();
        recorrido.add(Control.randomTracks.removeFirst());
        Control.randomTracks = recorrido;
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
        
        RANDOM random = new RANDOM();
        random.start();
        
        System.out.println(Control.randomTracks.toString());
        System.out.println(Control.randomDistancias.toString());
        System.out.println(Control.randomDistancia);
        System.out.println(Control.randomPromedio);
    }
}
