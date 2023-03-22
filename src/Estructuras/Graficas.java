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
    
    
    public void graficar(){
        graficarTablaSiguientes();      
        graficarTablaTransiciones();
        graficarAFD();
    }
    
    public void graficarTablaSiguientes(){
        String grafica = "digraph tabla_siguientes {\n\n";
        grafica += "graph [\n" +
        "newrank = true,\n" +
        "nodesep = 0.3,\n" +
        "ranksep = 0.2,\n" +
        "overlap = true,\n" +
        "splines = false,\n" +
        "] \n\n";
        grafica += "node  [shape=plain]\n\n";

  
        grafica +=  "nodo1 [label=<\n\n";
        grafica +=  "<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n\n";
        grafica +=  "  <tr><td><b>Token</b></td><td><b>Nodo</b></td><td><b>Siguientes</b></td></tr>\n\n";
        
        for (Siguiente siguiente:this.siguientes){
             grafica +=  " <tr>  <td >"+siguiente.lexema+"</td><td>"+siguiente.numero+"</td><td>"+siguiente.siguientes+"</td></tr>\n\n";
        }
        
        
        grafica +=  "</table>>];\n\n";        
        grafica +=  "	LKD [\n" +
                "fontsize = 20,\n" +
                "label = \"Tabla de siguientes: "+this.nombre+"\",\n" +
                "shape = plain,\n" +
                "style = \"\"]\n" +
                "\n" +
                "LKD -> nodo1 [style = invis]\n\n";

        grafica +=  "} \n\n";


        FileWriter fichero = null;
        try {
            
            fichero = new FileWriter("src\\Img_TablaSiguientes\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\Img_TablaSiguientes\\"+this.nombre+".jpg", "src\\Img_TablaSiguientes\\"+this.nombre+".dot");
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

    public void graficarTablaTransiciones(){
        String grafica = "digraph tabla_siguientes {\n\n";
        grafica += "graph [\n" +
        "newrank = true,\n" +
        "nodesep = 0.3,\n" +
        "ranksep = 0.2,\n" +
        "overlap = true,\n" +
        "splines = false,\n" +
        "] \n\n";
        grafica += "node  [shape=none fontname=Helvetica]\n\n";
  
        grafica +=  "nodo1 [ label = <\n\n";
        grafica +=  "<table>\n\n";
        
        
        int cont = 0;
        for (Siguiente sig1:this.siguientes){
             if(!sig1.lexema.equals("#")){
                 cont++;
             }
        }
        
        grafica +=  "<tr>\n\n";     
        grafica +=  "<td rowspan=\"2\" bgcolor=\"#F20101\" >Estados</td>\n\n";        
        grafica +=  "<td colspan=\""+cont+"\" bgcolor=\"#F26001\" >Terminales</td>\n\n";
        grafica +=  "</tr>\n\n";
        

        grafica +=  "<tr>\n\n";
        for (Siguiente siguiente:this.siguientes){
            if(!siguiente.lexema.equals("#")){
                 grafica +=  "<td bgcolor=\"#F2DC01\">"+siguiente.lexema+"</td>\n\n";
            }
        }
        grafica +=  "</tr>\n\n";
        
        for (Estado estado:this.estados){
             grafica +=  "<tr>\n";           
             grafica +=  "<td>"+estado.nombre+estado.conjunto+"</td>\n";    
             
             for(Siguiente sig2:this.siguientes){                 
                if(!sig2.lexema.equals("#")){
                    boolean existeEstado = false;
                     for(Transicion transicion:estado.transiciones){
                         if(transicion.entrada.equals(sig2.lexema)){
                            existeEstado = true;
                            grafica +=  "<td>"+transicion.destino+"</td>\n";
                         }
                     }
                     if(existeEstado == false){
                        grafica +=  "<td>---</td>\n";
                     }
                }
             }

             grafica +=  "</tr>\n";
        }
        

        
   
        grafica +=  "</table>>];\n\n";        
        grafica +=  "	LKD [\n" +
                "fontsize = 20,\n" +
                "label = \"Tabla de transiciones: "+this.nombre+"\",\n" +
                "shape = plain,\n" +
                "style = \"\"]\n" +
                "\n" +
                "LKD -> nodo1 [style = invis]\n\n";

        grafica +=  "} \n\n";


        FileWriter fichero = null;
        try {
            
            fichero = new FileWriter("src\\Img_TablaEstados\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\Img_TablaEstados\\"+this.nombre+".jpg", "src\\Img_TablaEstados\\"+this.nombre+".dot");
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
                String modificacion = "";
                if(transicion.entrada.equals("\\n") || transicion.entrada.equals("\\\"") || transicion.entrada.equals("\\\'") || transicion.entrada.equals("\\")){
                    if (transicion.entrada.equals("\\\"")){
                        modificacion = "\\\\"+transicion.entrada;
                    }else{
                        modificacion = "\\"+transicion.entrada;
                    }
                      grafica += transicion.origen + "->" + transicion.destino + "[label = \""+ modificacion+"\"];" +  "\n\n";
                }else{                
                   grafica += transicion.origen + "->" + transicion.destino + "[label = \""+ transicion.entrada +"\"];" +  "\n\n";
                }


                
               // grafica += transicion.origen + "->" + transicion.destino + "[label = \""+ transicion.entrada +"\"];" +  "\n\n";
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
