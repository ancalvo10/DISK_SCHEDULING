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
    
    
    LinkedList<Integer> recorrido = new LinkedList<>();
    
    private void aux(LinkedList<Integer> nscanTracks){
        nscanTracks.sort(Comparator.naturalOrder());
        int contScan = 0;
        int ex = 0;
        while(ex < nscanTracks.size()){
            //nscanTracks.size() < contScan
           // try{
                if(nscanTracks.get(contScan) < Control.getCabezalActual())
                    contScan++;
                ex++;
           // }
           // catch(Exception e){
             //   ex++;}
        }
        while(nscanTracks.size() > contScan){
            Control.nscanDistancias.add(Math.abs(Control.getCabezalActual() - nscanTracks.get(contScan)));
            Control.setCabezalActual(nscanTracks.get(contScan));
            recorrido.add(nscanTracks.remove(contScan));
        }
        nscanTracks.sort(Comparator.reverseOrder());
        while(!nscanTracks.isEmpty()){
            Control.nscanDistancias.add(Math.abs(Control.getCabezalActual() - nscanTracks.getFirst()));
            Control.setCabezalActual(nscanTracks.getFirst());
            recorrido.add(nscanTracks.removeFirst());
        }
    }
    
    public void start(){
        Control.nscanTracks = new LinkedList<>();
        Control.nscanDistancias = new LinkedList<>();
        Control.nscanDistancia = 0;
        
        LinkedList<Integer> recn = new LinkedList<>();
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.nscanTracks.add(Control.originalTracks.get(copy));
        }
        recorrido.add(Control.getCabezalActual());
        while(!Control.nscanTracks.isEmpty()){
            //System.out.println(Control.nscanTracks.toString());
            for(int i = 0; i < Control.originalTracks.size()/3; i++){
                if(!Control.nscanTracks.isEmpty())
                    recn.add(Control.nscanTracks.removeFirst());
            }
            aux(recn);
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
        //System.out.println(pet.toString());
        
        NSCAN nscan = new NSCAN();
        nscan.start();
        
        System.out.println(Control.nscanTracks.toString());
        System.out.println(Control.nscanDistancias.toString());
        System.out.println(Control.nscanDistancia);
        System.out.println(Control.nscanPromedio);
    }
    
}
