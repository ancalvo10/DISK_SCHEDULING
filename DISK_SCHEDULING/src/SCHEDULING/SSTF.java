/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHEDULING;

/**
 *
 * @author andre
 */
import GUI.Grafico;
import UTIL.Control;
import java.util.LinkedList;
 
public class SSTF{
    
    public void start(){
        LinkedList<Integer> recorrido = new LinkedList<Integer>();
        Control.sstfTracks = new LinkedList<>();
        Control.sstfDistancias = new LinkedList<>();
        Control.sstfDistancia = 0;
        
        for(int copy = 0; copy < Control.originalTracks.size(); copy++){
            Control.sstfTracks.add(Control.originalTracks.get(copy));
        }
        int distancia = 0,numPistas=Control.sstfTracks.size();
        
        while (Control.sstfTracks.size() > 0){
            int posicion = 0;
            for (int j=1; j<Control.sstfTracks.size(); j++)
                if (Math.abs(Control.getCabezalActual() - Control.sstfTracks.get(j).intValue()) < Math.abs(Control.getCabezalActual() - Control.sstfTracks.get(posicion).intValue()))
                    posicion = j;
                distancia += Math.abs(Control.getCabezalActual() - Control.sstfTracks.get(posicion).intValue());
                Control.sstfDistancias.add(Math.abs(Control.getCabezalActual() - Control.sstfTracks.get(posicion).intValue()));
                recorrido.add(Control.getCabezalActual());
                Control.setCabezalActual(Control.sstfTracks.get(posicion));
                Control.sstfTracks.remove(posicion);
        }
        recorrido.add(Control.getCabezalActual());
        
        Control.sstfTracks = recorrido;
        int promedio=distancia/numPistas;
        Control.sstfDistancia = distancia;
        Control.sstfPromedio = promedio;
        
    }
    
    public static void main(String[] args){
        Control.setCabezalInicial(90);
        LinkedList<Integer> pet = new LinkedList<Integer>();
        pet = Control.originalTracks;

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
        
        
        SSTF sstf = new SSTF();
        sstf.start();
    

        System.out.println(Control.sstfTracks.toString());
        System.out.println(Control.sstfDistancias.toString());
        System.out.println(Control.sstfDistancia);
        System.out.println(Control.sstfPromedio);
    }
}
