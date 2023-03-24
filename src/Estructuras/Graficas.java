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
import javax.swing.JOptionPane;
import Errores.Excepcion;

public class Graficas {
    
    ArrayList<Siguiente> siguientes;
    ArrayList<Estado> estados;
    String nombre;
    public Graficas(ArrayList<Siguiente> siguientes, ArrayList<Estado> estados,String nombre) {
        this.siguientes = siguientes;
        this.estados = estados;
        this.nombre = nombre;
    }
    
    public Graficas(){
        
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
            
            fichero = new FileWriter("src\\SIGUIENTES_202010828\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\SIGUIENTES_202010828\\"+this.nombre+".jpg", "src\\SIGUIENTES_202010828\\"+this.nombre+".dot");
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
            
            fichero = new FileWriter("src\\TRANSICIONES_202010828\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\TRANSICIONES_202010828\\"+this.nombre+".jpg", "src\\TRANSICIONES_202010828\\"+this.nombre+".dot");
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
            
            fichero = new FileWriter("src\\AFD_202010828\\"+this.nombre+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            System.out.println(grafica);
            pw.println(grafica);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src\\AFD_202010828\\"+this.nombre+".jpg", "src\\AFD_202010828\\"+this.nombre+".dot");
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
    
    
    
    
    
    public void reporteErrores(ArrayList<Excepcion> errores){
        try{
            //File archivoHtml = new File("Reportes/"+"Usuarios"+".html");
            File archivoHtml = new File("src\\ERRORES_202010828\\"+"Errores.html");
            /*if(archivoHtml.createNewFile()){
               JOptionPane.showMessageDialog(null, "Se creo el reporte de Usuarios, puede revisar la carpeta de Reportes");
            }else{                        
                JOptionPane.showMessageDialog(null, "Reporte de Usuarios Actualizado, puede revisar la carpeta de Reportes");
            }*/

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el reporte de los Usuarios");
        }

        try{
            FileWriter escribirContenido = new FileWriter("src\\ERRORES_202010828\\"+"Errores.html");

            escribirContenido.write(
                    "<!DOCTYPE html>\n"+
                    "<html lang=\"en\" >\n"+
                    "<head>\n"+
                    "<meta charset=\"UTF-8\">\n"+
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"+
                    "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n"+
                    "<title>"+ "Reporte de Errores" + "</title>\n"+        
                    "</head>\n"+ 
                    "<body>\n"+ 
                    "<div class=\"section lime darken-2\">\n"+ 
                    "<div class=\"container\">\n"+ 
                    "<div class=\"row\">\n"+ 
                    "<div class=\"col s12 center\">\n"+ 
                    "<h3><i class=\"mdi-content-send brown-text\"></i></h3>\n"+ 
                    "<h1><b>"+"Universidad de San Carlos"+"</b></h1>\n"+ 
                    "<img class=\"responsive-img\" style=\"height:200px;\" src=\"https://www.usac.edu.gt/g/escudo10.png\" />\n"+ 
                    "<h4>"+"Reporte de Errores"+"</h4>\n"+ 
                    "</div>\n"+ 
                    "</div>\n"+ 
                    "</div>\n"+ 
                    "</div>\n");


             escribirContenido.write(
                    "<div class=\"container\">\n"+ 
                    "<div  class=\"section \">\n"+ 
                    "<div  class=\"row\">\n"+
                    "<div  class=\"col s12 center\">\n"+
                    "<h3><i class=\"mdi-content-send brown-text\"></i></h3>\n"+
                    "<h3><b>Tabla de Errores</b></h3>\n"+
                    "</div>\n"
             );


            ///Tabla Usuarios admins
            escribirContenido.write(
                    "<div class=\"col s12 m12 l12\">\n"+ 
                    "<div class=\"col s12 center\">\n"+ 
                    "<h3><i class=\"mdi-content-send brown-text\"></i></h3>\n"+ 
                    "<h4>Errores</h4>\n"+
                    "</div>\n" );

            escribirContenido.write(
            "<table>\n"
            );
            escribirContenido.write("<thead>\n");
            escribirContenido.write("<tr>\n");

                escribirContenido.write("<th>"+"#"+"</th>\n");    
                escribirContenido.write("<th>"+"Tipo de Error"+"</th>\n");    
                escribirContenido.write("<th>"+"Descripción"+"</th>\n");
                escribirContenido.write("<th>"+"Línea"+"</th>\n");                
                escribirContenido.write("<th>"+"Columna"+"</th>\n");



            escribirContenido.write("</tr>\n");
            escribirContenido.write("</thead>\n");

            escribirContenido.write("<tbody>\n");
            
            
            int numeros = 1;
            
            for (Excepcion error:errores){
                escribirContenido.write("<tr>\n");
                    escribirContenido.write("<td>"+numeros+"</td>\n");
                    numeros++;
                    escribirContenido.write("<td>"+error.getTipo()+"</td>\n");                                
                    escribirContenido.write("<td>"+error.getDescripcion()+"</td>\n");
                    escribirContenido.write("<td>"+error.getLinea()+"</td>\n");                          
                    escribirContenido.write("<td>"+error.getColumna()+"</td>\n");                            

                escribirContenido.write("</tr>\n");
            }
            
            escribirContenido.write("</tbody>\n");

            escribirContenido.write(
            "</table>\n"
            );
            escribirContenido.write(
                    "</div>\n"                 
            );
            //Fin de la tabla de usuarios admins         




             escribirContenido.write(
                    "</div>\n"+   
                    "</div>\n"+ 
                    "</div>\n"
             );
            //Fin del Paso 1


          

            //Informacion XD

                    escribirContenido.write( 
                    "<div class=\"section lime darken-2\">\n"+ 
                    "<div class=\"container\">\n"+ 
                    "<div class=\"row\">\n"+ 
                    "<div class=\"col s12 center\">\n"+ 
                    "<h3><i class=\"mdi-content-send brown-text\"></i></h3>\n"+ 
                    "<h3><b>"+"ORGANIZACION DE LENGUAJES Y COMPILADORES 1 "+"</b></h3>\n"+                     
                    "<h3><b>"+"Sección C"+"</b></h3>\n"+ 
                    "<img class=\"responsive-img\" style=\"height:200px;\" src=\"https://www.usac.edu.gt/g/escudo10.png\" />\n"+ 
                    "<h4>"+"Tobias Rafael Zamora Santos"+"</h4>\n"+ 
                    "<h4>"+"202010828"+"</h4>\n"+ 
                    "</div>\n"+ 
                    "</div>\n"+ 
                    "</div>\n"+ 
                    "</div>\n");
            //Fin de la Informacion



            escribirContenido.write(
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n"+ 
                    "</body>\n"+ 
                    "</html>"

            );

            escribirContenido.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error escribiendo en el reporte de: "+"Usuarios");
        }
    }
   
    
    
    
}
