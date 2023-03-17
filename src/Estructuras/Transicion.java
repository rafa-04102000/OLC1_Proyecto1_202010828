/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

public class Transicion {
    
    String origen;
    String destino;
    String entrada;

    public Transicion(String origen, String destino, String entrada) {
        this.origen = origen;
        this.destino = destino;
        this.entrada = entrada;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "\nTransicion{" + "origen=" + origen + ", destino=" + destino + ", entrada=" + entrada + '}';
    }
    
    
    
}
