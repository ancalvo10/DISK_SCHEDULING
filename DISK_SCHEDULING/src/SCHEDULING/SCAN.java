/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

import UTIL.Control;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author andre
 */
public class SCAN {
    
    public void start(){
        
    }
    
    public static void main(String[] args){
        LinkedList<Integer> pet = new LinkedList<Integer>();
        pet = Control.originalTracks;
        Collections.sort(Control.originalTracks);
        
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
