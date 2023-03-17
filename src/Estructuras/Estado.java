/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Estado {
    
    String nombre;
    ArrayList<Integer> conjunto;
    boolean aceptacion;
    ArrayList<Transicion> transiciones;

    
    public Estado(String nombre){
        this.nombre = nombre;
        this.conjunto = new ArrayList<Integer>();        
        this.transiciones = new ArrayList<Transicion>();

    }
    
    public void AddValor(int numero){
        this.conjunto.add(numero);
    }
    
    public void AddTransicion(Transicion nuevaTransicion){
        this.transiciones.add(nuevaTransicion);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getConjunto() {
        return conjunto;
    }

    public void setConjunto(ArrayList<Integer> conjunto) {
        this.conjunto = conjunto;
    }
    
    
    
    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<Transicion> transiciones) {
        this.transiciones = transiciones;
    }

    @Override
    public String toString() {
        return "Estado{" + "nombre=" + nombre + ", conjunto=" + conjunto + ", aceptacion=" + aceptacion + ", transiciones=" + transiciones + '}';
    }
    
    
    
    
    
}
