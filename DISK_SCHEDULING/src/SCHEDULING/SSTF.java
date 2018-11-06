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
import java.util.ArrayList;
 
public class SSTF{
    
public static void main(String[] args){
    
    int cabezal = 90;
    ArrayList<Integer> pet = new ArrayList<Integer>();

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

    int distancia = 0,numPistas=pet.size();

    System.out.print(cabezal);
    while (pet.size() > 0){
        int posicion = 0;
        for (int j=1; j<pet.size(); j++)
            //Se van comparando las diferencias entre el cabezal y las pistas, se va guardando la 
            //posición de la pista más cercana, es decir, donde la resta salió menor
            if (Math.abs(cabezal - pet.get(j).intValue()) < Math.abs(cabezal - pet.get(posicion).intValue()))
                posicion = j;
            //Se guarda la resta entre el cabezal y la pista más cercana actual, se va acumulando.
            distancia += Math.abs(cabezal - pet.get(posicion).intValue());
            System.out.print(" ("+Math.abs(cabezal - pet.get(posicion).intValue())+") ");
            cabezal = pet.get(posicion).intValue();
            System.out.print(" -> "+cabezal);
            pet.remove(posicion);//como el ciclo while depende del tamaño de la lista, entonces una vez
            //que se "atendió la petición" se borra de la lista para que pueda finalizar el ciclo
    }

    int promedio=distancia/numPistas;
    System.out.println("\n"+distancia + " pistas recorridas");
    System.out.println("Longitud promedio de busqueda: "+promedio);

    }
}
