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
public class Arbol {
    
    Nodo raiz;
    String nombre;
    
    public Arbol(Nodo raiz,String nombre){
        this.raiz = raiz;
        this.nombre = nombre;
    }
    
    
    public void GraficarSintactico(){
        String grafica = "digraph Arbol_Sintactico{\n\n";
        
           
        grafica += "nombre [ style=filled, label=\""+this.nombre+"\", color=\"#000000\" ,fontcolor=white, fillcolor=\"#D38B0D\" ,shape=square]\n\n";
        grafica += "node [shape = record style = filled fillcolor = \"#E8254C\" fontcolor = white fontname=\"Helvetica,Arial,sans-serif\" ]\n\n";    
                
        grafica += GraficaNodos(this.raiz, "0") + "\n\n}";        
        GenerarDot(grafica);

    }
    
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public String GraficaNodos(Nodo nodo, String i){
        int k=0; 
        String r = "";
        String nodoTerm = nodo.token;
        // nodoTerm = nodoTerm.replace("\"", "");
        if(nodoTerm.equals("|")){
            
            r= "node" + i + "[label = \" "+ nodo.getPrimeraPos()+ "|" +"{"+nodo.getAnulable()+"|"+ " \\" + nodoTerm +"|"+"--"+ "}"+"|"+nodo.getUltimaPos()+ "\"];\n";
 
        }else{
            String modificacion = "";
            if(nodoTerm.equals("\\n") || nodoTerm.equals("\\\"") || nodoTerm.equals("\\\'") || nodoTerm.equals("\\")){
                if (nodoTerm.equals("\\\"")){
                    modificacion = "\\\\"+nodoTerm;
                }else{
                    modificacion = "\\"+nodoTerm;
                }
                r= "node" + i + "[label = \" "+ nodo.getPrimeraPos()+ "|" +"{"+nodo.getAnulable()+"|"+ modificacion +"|"+"--"+ "}"+"|"+nodo.getUltimaPos()+ "\"];\n";
            }else{                
                r= "node" + i + "[label = \" "+ nodo.getPrimeraPos()+ "|" +"{"+nodo.getAnulable()+"|"+ nodoTerm +"|"+"--"+ "}"+"|"+nodo.getUltimaPos()+ "\"];\n";
            }
            
            
        }
        
        for(int j =0 ; j<=nodo.hijos.size()-1; j++){
            r = r + "node" + i + " -> node" + i + k + "[color  = \"#3277CA\"]" +"\n";
            r= r + GraficaNodos(nodo.hijos.get(j), ""+i+k);
            k++;
        }
        
        
        
        
        // if( !(nodo.lexema.equals("")) ){
        //     String nodoToken = nodo.lexema;
        //     nodoToken = nodoToken.replace("\"", "");
        //     r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
        //     r += "node" + i + " -> node" + i + "c\n";
        // }
        
        return r;
    }
    
    public void GenerarDot(String cadena){
        FileWriter fichero = null;
        try {
            
            fichero = new FileWriter("src\\Img_Arboles\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(cadena);
            pw.println(cadena);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\Img_Arboles\\"+this.nombre+".jpg", "src\\Img_Arboles\\"+this.nombre+".dot");
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
