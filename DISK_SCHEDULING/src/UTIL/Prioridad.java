/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

/**
 *
 * @author andre
 */
public class Prioridad {
    
    private int prioridad;
    private int pista;

    public Prioridad(int prioridad, int pista) {
        this.prioridad = prioridad;
        this.pista = pista;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPista() {
        return pista;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }
    
    
    
}
