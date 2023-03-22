/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Analizador.parser;
import Analizador.scanner;

import Estructuras.ExpresionRG;
import Estructuras.Gestor;
import Estructuras.Nodo;
import Estructuras.Arbol;
import Estructuras.Graficas;

import java.util.ArrayList;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    
    ArrayList<ExpresionRG> expresiones;
    Gestor gestor;
    int contadorIMG;
    String tipoGraficas;
    
    //ESTE ES EL CONSTRUCTOR
    
    
    

    public Inicio() {
        initComponents();
        //setTitle("Menu Inicial");
        //setResizable(false);
        this.expresiones = new ArrayList<ExpresionRG>();
        this.gestor = new Gestor();
        this.setLocationRelativeTo(null);
        this.contadorIMG = 0;
        this.tipoGraficas = "";
        
        //aca solo para que se vea bien el abrir archivo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        // aca termina para que tome el diseño del explorador de mi pc

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextoArchivo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        GenerarAutomata = new javax.swing.JButton();
        AnalizarEntrada = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Seleccionar = new javax.swing.JComboBox<>();
        Mostrar = new javax.swing.JButton();
        Imagen = new javax.swing.JLabel();
        bregresar = new javax.swing.JButton();
        bsiguiente = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla Inicial");
        setResizable(false);

        TextoArchivo.setColumns(20);
        TextoArchivo.setRows(5);
        jScrollPane1.setViewportView(TextoArchivo);

        jLabel1.setBackground(new java.awt.Color(204, 255, 153));
        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Archivo");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));

        Consola.setEditable(false);
        Consola.setColumns(20);
        Consola.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        Consola.setRows(5);
        Consola.setText("La expresion : \"lexema ejemplo\" es válida con la expresion Regular ExpRegl");
        jScrollPane2.setViewportView(Consola);

        GenerarAutomata.setText("Generar Automata");
        GenerarAutomata.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        GenerarAutomata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenerarAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarAutomataActionPerformed(evt);
            }
        });

        AnalizarEntrada.setText("Analizar Entrada");
        AnalizarEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));
        AnalizarEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnalizarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarEntradaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consola");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 3, true));

        Seleccionar.setEnabled(false);

        Mostrar.setText("Mostrar");
        Mostrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        Mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Mostrar.setEnabled(false);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));

        bregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/anteriorpeque.png"))); // NOI18N
        bregresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        bregresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bregresar.setEnabled(false);
        bregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregresarActionPerformed(evt);
            }
        });

        bsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/siguientepeque.png"))); // NOI18N
        bsiguiente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        bsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsiguiente.setEnabled(false);
        bsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguienteActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar Como");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(214, 214, 214)
                                        .addComponent(Seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bregresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bsiguiente))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(GenerarAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(AnalizarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(161, 161, 161)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GenerarAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnalizarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

       
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       JFileChooser jf = new JFileChooser();
       jf.showOpenDialog(this);
       File archivo = jf.getSelectedFile();
       
       if(archivo != null){
           System.out.print(archivo.getAbsolutePath());
           
           String texto = "";
           
           try {
//               FileReader fr = new FileReader(archivo.getAbsolutePath());
  //             BufferedReader b = new BufferedReader(fr);
               
               //texto = b.readLine();
               
                File fr = new File(archivo.getAbsolutePath());
                Scanner reader = new Scanner(fr);
                
                while(reader.hasNextLine()){
                texto += reader.nextLine()+"\n";
                

                }
                reader.close();
                TextoArchivo.setText(texto);
                //System.out.println(texto);
               
               
             
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
       }
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AnalizarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarEntradaActionPerformed

        
    }//GEN-LAST:event_AnalizarEntradaActionPerformed

    private void GenerarAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarAutomataActionPerformed
        try {
            scanner scanner = new scanner(new java.io.StringReader(TextoArchivo.getText()));
            parser parser = new parser(scanner);
            parser.parse();
            System.out.println("Analisis finalizado");
            this.expresiones.clear();
            this.contadorIMG = 0;
            this.Seleccionar.removeAllItems();
            this.Seleccionar.setEnabled(false);
            this.Mostrar.setEnabled(false);
            this.bregresar.setEnabled(false);
            this.bsiguiente.setEnabled(false);
            this.Imagen.setIcon(null);

            String texto_errores = "";

             // generar reporte de errores lexicos
            if (scanner.erroresLexicos.isEmpty()) {
                texto_errores += "No se encontraron erorres lexicos";

                Consola.setText(texto_errores);


                 // generar reporte de errores sintacticos
                if (parser.erroresSintacticos.isEmpty()) {
                    texto_errores += "\nNo se encontraron erorres sintacticos";
                    Consola.setText(texto_errores);


                    //System.out.println(parser.expresiones_regulares);
                    //copio las expresiones del cup a mi variable para poder usarlas
                    this.expresiones = (ArrayList<ExpresionRG>) parser.expresiones_regulares.clone();
                    /*
                    for (ExpresionRG ex:parser.expresiones_regulares){
                        this.expresiones.add(ex);
                    }*/

                    for (ExpresionRG ex:this.expresiones){

                        System.out.println("--------------------");
                        System.out.println("Nombre-> "+ ex.getNombre());
                        System.out.println("Simbolos-> "+ex.getListaExpresiones());                        
                        System.out.println("Simbolos con . y #-> "+ex.getExpresionConAceptacion());
                        System.out.println("Simbolos en Texto-> "+ex.getExpresionTexto());
                        System.out.println("--------------------");

                        Nodo raiz = this.gestor.regresarRaiz(ex.getExpresionConAceptacion());

                        Arbol arbol = new Arbol(raiz,ex.getNombre());
                        ex.setArbol(arbol);

                        ex.getArbol().GraficarSintactico();
                        ex.setSiguientes(this.gestor.regresarListaSiguientes());
                        ex.setEstados(this.gestor.regresarListaEstados());
                        Graficas grafica = new Graficas(ex.getSiguientes(),ex.getEstados(),ex.getNombre());
                        ex.setGraficas(grafica);
                        ex.graficar();


                    }

                    parser.expresiones_regulares.clear();
                } else {


                    for (int i = 0; i < parser.erroresSintacticos.size();i++){
                      texto_errores += "\n" + parser.erroresSintacticos.get(i).getTipo() + " | " + parser.erroresSintacticos.get(i).getDescripcion() + " | " + parser.erroresSintacticos.get(i).getLinea() + " | " + parser.erroresSintacticos.get(i).getColumna();
                    }
                    /*parser.erroresSintacticos.forEach((error) -> {
                        System.out.println(error.getTipo() + "| " + error.getDescripcion() + "| " + error.getLinea() + "| " + error.getColumna());   
                    });*/

                    Consola.setText(texto_errores);
                }
                 //----------------------------


            } else {
                scanner.erroresLexicos.forEach((error) -> {
                    Consola.setText("Error: "+error.getTipo() + " | " + error.getDescripcion() + "| " + error.getLinea() + "| " + error.getColumna());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!this.expresiones.isEmpty()){
            Seleccionar.setEnabled(true);
            
            Seleccionar.addItem("Árboles");            
            Seleccionar.addItem("Siguientes");
            Seleccionar.addItem("Transiciones");
            Seleccionar.addItem("Autómatas");


            
            /*for(ExpresionRG nombre:this.expresiones){
                Seleccionar.addItem(nombre.getNombre());                
            }*/
            Mostrar.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_GenerarAutomataActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
       if (Seleccionar.getSelectedItem().equals("Árboles")){   

           ImageIcon im = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(0).getNombre()+".jpg");
           Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
           Imagen.setIcon(i);
           this.tipoGraficas = "Árboles";
          /* ImageIcon nuevaImagen = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(0).getNombre()+".jpg");
           Imagen.setIcon(nuevaImagen);*/
       }else if(Seleccionar.getSelectedItem().equals("Siguientes")){
           ImageIcon im = new ImageIcon("src\\Img_TablaSiguientes\\"+this.expresiones.get(0).getNombre()+".jpg");
           Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
           Imagen.setIcon(i);
           this.tipoGraficas = "Siguientes";
       }else if(Seleccionar.getSelectedItem().equals("Transiciones")){
           ImageIcon im = new ImageIcon("src\\Img_TablaEstados\\"+this.expresiones.get(0).getNombre()+".jpg");
           Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
           Imagen.setIcon(i);
           this.tipoGraficas = "Transiciones";
       }else if(Seleccionar.getSelectedItem().equals("Autómatas")){
           ImageIcon im = new ImageIcon("src\\Img_AFDs\\"+this.expresiones.get(0).getNombre()+".jpg");
           Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
           Imagen.setIcon(i);
           this.tipoGraficas = "Autómatas";
       }
       
       this.contadorIMG = 0;
       bregresar.setEnabled(true);
       bsiguiente.setEnabled(true);
        
    }//GEN-LAST:event_MostrarActionPerformed

    private void bregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregresarActionPerformed
        if (this.tipoGraficas.equals("Árboles")){
            
            if(this.contadorIMG==0){
                this.contadorIMG = this.expresiones.size()-1;
                ImageIcon im = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG--;
                ImageIcon im = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Siguientes")){
            if(this.contadorIMG==0){
                this.contadorIMG = this.expresiones.size()-1;
                ImageIcon im = new ImageIcon("src\\Img_TablaSiguientes\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG--;
                ImageIcon im = new ImageIcon("src\\Img_TablaSiguientes\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Transiciones")){
            if(this.contadorIMG==0){
                this.contadorIMG = this.expresiones.size()-1;
                ImageIcon im = new ImageIcon("src\\Img_TablaEstados\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG--;
                ImageIcon im = new ImageIcon("src\\Img_TablaEstados\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Autómatas")){
            if(this.contadorIMG==0){
                this.contadorIMG = this.expresiones.size()-1;
                ImageIcon im = new ImageIcon("src\\Img_AFDs\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG--;
                ImageIcon im = new ImageIcon("src\\Img_AFDs\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }
    }//GEN-LAST:event_bregresarActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        if (this.tipoGraficas.equals("Árboles")){
            
            if(this.contadorIMG==this.expresiones.size()-1){
                this.contadorIMG = 0;
                ImageIcon im = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG++;
                ImageIcon im = new ImageIcon("src\\Img_Arboles\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Siguientes")){
            if(this.contadorIMG==this.expresiones.size()-1){
                this.contadorIMG = 0;
                ImageIcon im = new ImageIcon("src\\Img_TablaSiguientes\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG++;
                ImageIcon im = new ImageIcon("src\\Img_TablaSiguientes\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Transiciones")){
            if(this.contadorIMG==this.expresiones.size()-1){
                this.contadorIMG = 0;
                ImageIcon im = new ImageIcon("src\\Img_TablaEstados\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG++;
                ImageIcon im = new ImageIcon("src\\Img_TablaEstados\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }else if(this.tipoGraficas.equals("Autómatas")){
            if(this.contadorIMG==this.expresiones.size()-1){
                this.contadorIMG = 0;
                ImageIcon im = new ImageIcon("src\\Img_AFDs\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }else{
                this.contadorIMG++;
                ImageIcon im = new ImageIcon("src\\Img_AFDs\\"+this.expresiones.get(this.contadorIMG).getNombre()+".jpg");
                Icon i = new ImageIcon(im.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
                Imagen.setIcon(i);
            }
            
        }
    }//GEN-LAST:event_bsiguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //aca 
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                // aca termina para que tome el diseño del explorador de mi pc
                
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalizarEntrada;
    private javax.swing.JTextArea Consola;
    private javax.swing.JButton GenerarAutomata;
    public static javax.swing.JLabel Imagen;
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> Seleccionar;
    private javax.swing.JTextArea TextoArchivo;
    private javax.swing.JButton bregresar;
    private javax.swing.JButton bsiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
