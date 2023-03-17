/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import java.util.ArrayList;

public class Siguiente implements Comparable<Siguiente>{
    
    Integer numero;
    String lexema;
    ArrayList<Integer> siguientes;
    
    public Siguiente(Integer numero,String lexema){
        this.numero = numero;
        this.lexema = lexema;
        this.siguientes =  new ArrayList<Integer>();        
    }
    
    
    
    public void AddSiguiente(int numero){
        this.siguientes.add(numero);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
 
    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Integer> siguientes) {
        this.siguientes = siguientes;
    }

    @Override
    public String toString() {
        return "Siguiente{" + "numero=" + numero + ", lexema=" + lexema + ", siguientes=" + siguientes + '}' + "\n";
    }



    @Override
    public int compareTo(Siguiente o) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return numero.compareTo(o.getNumero());
    }
    
    
    
}
