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
public class Nodo {
    
    public String lexema;
    public String token;

    /*public int id;
    public Nodo hijoIzq;
    public Nodo hijoDer;*/
    public int fila, column;
    public ArrayList<Nodo> hijos ;
    
    
    public boolean anulable;
    public ArrayList<Integer> primeraPos;
    public ArrayList<Integer> ultimaPos;
    public String tipo;

    
    
    public Nodo(){
        
    }
    
    public Nodo(String token, String lexema, int fila, int column){
        this.token = token;        
        this.lexema = lexema;
        this.fila = fila;
        this.column = column;
        this.hijos  = new ArrayList<Nodo>();   
        this.primeraPos = new ArrayList<Integer>();        
        this.ultimaPos = new ArrayList<Integer>();
        this.tipo = null;
    }
    
    
    public String getToken(){
        return token;
    }
    
    public void AddHijo(Nodo n){
        this.hijos.add(n);
    }


    
    
    public boolean getAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }


    
    
    public void AddPrimeraPos(int numero){
        this.primeraPos.add(numero);
    }
    
    public void AddUltimaPos(int numero){
        this.ultimaPos.add(numero);
    }


    public ArrayList<Integer> getPrimeraPos() {
        return primeraPos;
    }

    public ArrayList<Integer> getUltimaPos() {
        return ultimaPos;
    }
    
    public String getTipo() {
        return tipo;
    }


    public void setPrimeraPos(ArrayList<Integer> primeraPos) {
        this.primeraPos = primeraPos;
    }

    public void setUltimaPos(ArrayList<Integer> ultimaPos) {
        this.ultimaPos = ultimaPos;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    

}
