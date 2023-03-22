/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;
import java.util.Collections;



public class ExpresionRG {
    
    String nombre;
    ArrayList<String> ListaExpresiones;
    ArrayList<String> ExpresionConAceptacion;
    String expresionTexto;
    Arbol arbol;
    ArrayList<Siguiente> siguientes;
    ArrayList<Estado> estados;
    Graficas graficas;


    
    public ExpresionRG(String nombre, ArrayList<String> ListaExpresiones, String expresionTexto){
        this.nombre = nombre;
        this.ListaExpresiones = ListaExpresiones;
        this.expresionTexto = expresionTexto;
        this.ExpresionConAceptacion = new ArrayList<String>();
        this.ExpresionConAceptacion.add(".");
        
        for (String simbolo:this.ListaExpresiones){
            this.ExpresionConAceptacion.add(simbolo);
        }
        this.ExpresionConAceptacion.add("#");
        
        Collections.reverse(this.ExpresionConAceptacion);
        
        this.siguientes = new ArrayList<Siguiente>();
        this.estados = new ArrayList<Estado>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getListaExpresiones() {
        return ListaExpresiones;
    }
    
    public ArrayList<String> getExpresionConAceptacion() {
        return ExpresionConAceptacion;
    }
    

    public String getExpresionTexto() {
        return expresionTexto;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public ArrayList<Siguiente> getSiguientes() {
        return siguientes;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }
    
    
    public Graficas getGraficas() {
        return graficas;
    }

    
    public void graficar(){
        this.graficas.graficar();
    }
    /// seters

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaExpresiones(ArrayList<String> ListaExpresiones) {
        this.ListaExpresiones = ListaExpresiones;
    }

    public void setExpresionConAceptacion(ArrayList<String> ExpresionConAceptacion) {
        this.ExpresionConAceptacion = ExpresionConAceptacion;
    }

    public void setExpresionTexto(String expresionTexto) {
        this.expresionTexto = expresionTexto;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    
    public void setSiguientes(ArrayList<Siguiente> siguientes) {
        this.siguientes = siguientes;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

     public void setGraficas(Graficas graficas) {
        this.graficas = graficas;
    }
    
    
    
}
