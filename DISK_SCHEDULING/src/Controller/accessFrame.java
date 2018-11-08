/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Ejecución;
import GUI.Inicio;
import GUI.TablaComparativa;

/**
 *
 * @author Erin
 */
public class accessFrame {
    
     public static void createEjecution(){
        
        Ejecución ventCreateEjecution = new Ejecución();
        ventCreateEjecution.setVisible(true);
        
    }
     
     public static void createInicio(){
        
        Inicio ventCreateInicio = new Inicio();
        ventCreateInicio.setVisible(true);
        
    }
     
     public static void createTablaComparativa(){
        
        TablaComparativa ventCreateTablaComparativa = new TablaComparativa();
        ventCreateTablaComparativa.setVisible(true);
        
    }
    
}
