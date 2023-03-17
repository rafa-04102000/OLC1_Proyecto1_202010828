/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Graficas {
    
    ArrayList<Siguiente> siguientes;
    ArrayList<Estado> estados;
    String nombre;
    public Graficas(ArrayList<Siguiente> siguientes, ArrayList<Estado> estados,String nombre) {
        this.siguientes = siguientes;
        this.estados = estados;
        this.nombre = nombre;
    }

    public void graficarAFD(){
        String grafica = "digraph grafo_afd {\n\n";
        grafica += " fontname=\"Helvetica,Arial,sans-serif\"\n\n";
        grafica += "edge [fontname=\"Helvetica,Arial,sans-serif\"]\n\n";
        grafica += "rankdir=LR;\n\n";
        
        for (Estado estado:this.estados){
            if (estado.aceptacion){
                grafica +=  estado.nombre+"[shape=doublecircle]\n\n";
            }
        }
        grafica +=  "Inicio [shape=box]\n\n";
        grafica +=  "Inicio -> s0\n\n";
        grafica +=  "node [shape = circle];\n\n";
        
        for (Estado estado:this.estados){
            for(Transicion transicion:estado.transiciones){
                grafica += transicion.origen + "->" + transicion.destino + "[label = \""+ transicion.entrada +"\"];" +  "\n\n";
            }
        }
        
        grafica +=  "afd [ \n\n";
        grafica +=  "fillcolor=\"#ff880022\"\n\n";
        grafica +=  "label=<<table border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"18\"> \n\n";
        grafica +=  "<tr> <td> <b>Nombre AFD: "+ this.nombre +"</b> </td> </tr> \n\n";       
        grafica +=  "</table>> \n\n";
        grafica +=  "shape=plain \n\n";
        grafica +=  " ]\n\n";
        grafica +=  "} \n\n";


        FileWriter fichero = null;
        try {
            
            fichero = new FileWriter("src\\Img_AFDs\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\Img_AFDs\\"+this.nombre+".jpg", "src\\Img_AFDs\\"+this.nombre+".dot");
                proceso.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
    
    
    
}
