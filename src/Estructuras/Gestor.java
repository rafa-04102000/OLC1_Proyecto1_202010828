/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
/**
 *
 * @author Usuario
 */
public class Gestor {
    
    Stack<Nodo> pila;
    //Boolean vinoRegla;
    int posicion;
    ArrayList<Siguiente> siguientes;
    
    
    // variables para la creacino de transicion de estados
    int numreoEstado;
    ArrayList<Estado> listaEstados;
    ArrayList<Estado> verificar;
    int numeroAceptacion;
    
    public Gestor(){
        this.pila = new Stack<Nodo>(); //aca junto todo lo que este junto 
        //this.vinoRegla = false;
        this.posicion = 0;
        this.siguientes = new ArrayList<Siguiente>();
        
        
        //varibales para la creacion de transicion de estados
        this.numreoEstado = 0;
        this.listaEstados = new ArrayList<Estado>();        
        this.verificar = new ArrayList<Estado>();
        this.numeroAceptacion = 0;
    }
    
    
public Nodo regresarRaiz(ArrayList<String> expresion){
    //contar los no anulables
    int cont = 0;
    for (String sim:expresion){
        System.out.println("este es el simobo " + sim);
        if (!sim.equals("|") && !sim.equals("*") && !sim.equals("+") && !sim.equals("?") && !sim.equals(".")){
            cont ++;
           // System.out.println("esto sumo " + cont);
        }
    }
    //System.out.println("Numero " + cont);
    
    ArrayList<String> copia = (ArrayList<String>) expresion.clone();
    Nodo hijo = null;

    hijo = new Nodo(copia.get(0),copia.get(0),0,0);
    hijo.setAnulable(false);
    hijo.AddPrimeraPos(cont);    
    hijo.AddUltimaPos(cont);
    hijo.setTipo("simbolo");  
    this.numeroAceptacion = cont;
    this.siguientes.add(new Siguiente(cont,copia.get(0)));
    copia.remove(0);

    this.pila.add(hijo);
    this.posicion = cont;
    Nodo raiz = recursivo(copia);
    this.pila.pop();
    this.posicion = 0;
    // empiezo la tabla de siguientes
   Collections.sort(this.siguientes);
   if (this.siguientes.isEmpty()){
       System.out.println("Esta vacio");
   }else{
       System.out.println("No esta vacio que pex");
   }
   
    for (Siguiente proximo: this.siguientes){
        System.out.println(proximo.toString());
    }
    
    
    this.estados(raiz);
    //this.siguientes.clear();

    return raiz;
}
    

public Nodo recursivo(ArrayList<String> expresion){
    Nodo hijo = null;

    
    for (int i = 0; i < expresion.size();i++){       
      
        if (expresion.get(i).equals("*")){            
            hijo = new Nodo(expresion.get(i),expresion.get(i),0,0);
            hijo.setTipo("operador");
            //veo si es anulable y su primera y ultima posicion
            hijo.setAnulable(true);
            
            ArrayList<Integer> primeraPos = this.pila.peek().getPrimeraPos();            
            ArrayList<Integer> ultimaPos = this.pila.peek().getUltimaPos();

            hijo.setPrimeraPos(primeraPos);            
            hijo.setUltimaPos(ultimaPos);

                    
            ///-----------
            
            hijo.AddHijo(this.pila.peek());            
            expresion.remove(i);
            this.pila.pop();            
            
            // agrego a la tabla de siguientes          
            for (int ul:ultimaPos){
                for (Siguiente sig: this.siguientes){
                    if (sig.numero == ul ){
                        
                        for (int sig2: primeraPos){
                            if(!sig.siguientes.contains(sig2)){
                                sig.AddSiguiente(sig2);
                            }
                        }
                        
                        Collections.sort(sig.siguientes);
                       
                        break;                        
                    }
                }                
            }
            this.pila.add(hijo);
            break;
          
        }else if(expresion.get(i).equals("+")){
            hijo = new Nodo(expresion.get(i),expresion.get(i),0,0);
            hijo.setTipo("operador");
            //veo si es anulable y su primera y ultima posicion
            if (this.pila.peek().getAnulable()){
                hijo.setAnulable(true); 
            }else{
                hijo.setAnulable(false);
            }
                   
            ArrayList<Integer> primeraPos = this.pila.peek().getPrimeraPos();            
            ArrayList<Integer> ultimaPos = this.pila.peek().getUltimaPos();

            hijo.setPrimeraPos(primeraPos);            
            hijo.setUltimaPos(ultimaPos);

        
            ///-----------
            
            hijo.AddHijo(this.pila.peek());            
            expresion.remove(i);
            this.pila.pop();
            
            
            // agrego a la tabla de siguientes          
            for (int ul:ultimaPos){
                for (Siguiente sig: this.siguientes){
                    if (sig.numero == ul ){
                        
                        for (int sig2: primeraPos){
                            if(!sig.siguientes.contains(sig2)){
                                sig.AddSiguiente(sig2);
                            }
                        }
                        
                        Collections.sort(sig.siguientes);
                       
                        break;                        
                    }
                }                
            }
            
            this.pila.add(hijo);
            break;
            
        }else if(expresion.get(i).equals("?")){
            hijo = new Nodo(expresion.get(i),expresion.get(i),0,0);
            hijo.setTipo("operador");
            //veo si es anulable y su primera y ultima posicion
            hijo.setAnulable(true);
                   
            ArrayList<Integer> primeraPos = this.pila.peek().getPrimeraPos();            
            ArrayList<Integer> ultimaPos = this.pila.peek().getUltimaPos();

            hijo.setPrimeraPos(primeraPos);            
            hijo.setUltimaPos(ultimaPos);

        
            ///-----------
            
            hijo.AddHijo(this.pila.peek());            
            expresion.remove(i);
            this.pila.pop();
            this.pila.add(hijo);
            break;
            
        }else if(expresion.get(i).equals(".")){
            hijo = new Nodo(expresion.get(i),expresion.get(i),0,0);
            hijo.setTipo("operador");
            boolean anulable1;
            ArrayList<Integer> copiaSiguientes1;
            ArrayList<Integer> copiaUltimos1;
                    
                    
            boolean anulable2;
            ArrayList<Integer> copiaSiguientes2;
            ArrayList<Integer> copiaUltimos2;
                    
            boolean anulable3;
            ArrayList<Integer> siguientePos3 = new ArrayList<Integer>();
            ArrayList<Integer> ultimaPos3 = new ArrayList<Integer>();
                    
            //veo si es anulable y su primera y ultima posicion            
            // veo al primer hijo            
 
            Nodo hijo1 = this.pila.peek();
            
            anulable1 = hijo1.getAnulable();            
            copiaSiguientes1 = (ArrayList<Integer>) hijo1.getPrimeraPos().clone();            
            copiaUltimos1 = (ArrayList<Integer>) hijo1.getUltimaPos().clone();
            
            hijo.AddHijo(hijo1);
            this.pila.pop();
            
            //-------------------
            // veo al segundo hijo
            Nodo hijo2 = this.pila.peek();
            
            
            anulable2 = hijo2.getAnulable();            
            copiaSiguientes2 = (ArrayList<Integer>) hijo2.getPrimeraPos().clone();            
            copiaUltimos2 = (ArrayList<Integer>) hijo2.getUltimaPos().clone();
            
            
            hijo.AddHijo(hijo2); 
            this.pila.pop();
             
            
            //---------------
            expresion.remove(i);
            
            // veo si mi . nodo es anulable
            if (anulable1 && anulable2){
                anulable3 = true;
            }else{
                anulable3 = false;
            }
            hijo.setAnulable(anulable3);
            
            // veo mis primeras pos 
            if (anulable1){
                for (int n:copiaSiguientes1){
                    siguientePos3.add(n);
                }
                
                for (int n2:copiaSiguientes2){
                    if (!siguientePos3.contains(n2)){
                        siguientePos3.add(n2);
                    }                    
                }
                
                Collections.sort(siguientePos3);
                
                hijo.setPrimeraPos(siguientePos3);
                
            }else{
                hijo.setPrimeraPos(copiaSiguientes1);
            }
            
            // veo mis ultimas pos
            
            if (anulable2){
                for (int n:copiaUltimos1){
                    ultimaPos3.add(n);
                }
                
                for (int n2:copiaUltimos2){
                    if (!ultimaPos3.contains(n2)){
                        ultimaPos3.add(n2);
                    }                    
                }
                
                Collections.sort(ultimaPos3);
                
                hijo.setUltimaPos(ultimaPos3);
                
            }else{
                hijo.setUltimaPos(copiaUltimos2);
            }
            
            // agrego a la tabla de siguientes
            for (int ul:copiaUltimos1){
                for (Siguiente sig: this.siguientes){
                    if (sig.numero == ul ){
                        
                        for (int sig2: copiaSiguientes2){
                            if(!sig.siguientes.contains(sig2)){
                                sig.AddSiguiente(sig2);
                            }
                        }
                        
                        Collections.sort(sig.siguientes);
                       
                        break;                        
                    }
                }                
            }
            
            
            this.pila.add(hijo);
            break;       
            
        }else if(expresion.get(i).equals("|")){
            hijo = new Nodo(expresion.get(i),expresion.get(i),0,0);
            hijo.setTipo("operador");
            boolean anulable1;
            ArrayList<Integer> copiaSiguientes1;
            ArrayList<Integer> copiaUltimos1;
                    
                    
            boolean anulable2;
            ArrayList<Integer> copiaSiguientes2;
            ArrayList<Integer> copiaUltimos2;
                    
            boolean anulable3;
            ArrayList<Integer> siguientePos3 = new ArrayList<Integer>();
            ArrayList<Integer> ultimaPos3 = new ArrayList<Integer>();
                    
            //veo si es anulable y su primera y ultima posicion            
            // veo al primer hijo
            

            Nodo hijo1 = this.pila.peek();

                        
            anulable1 = hijo1.getAnulable();            
            copiaSiguientes1 = (ArrayList<Integer>) hijo1.getPrimeraPos().clone();            
            copiaUltimos1 = (ArrayList<Integer>) hijo1.getUltimaPos().clone();
            
            hijo.AddHijo(hijo1);
            this.pila.pop();
            
            //-------------------
            // veo al segundo hijo


            Nodo hijo2 = this.pila.peek();

            anulable2 = hijo2.getAnulable();            
            copiaSiguientes2 = (ArrayList<Integer>) hijo2.getPrimeraPos().clone();            
            copiaUltimos2 = (ArrayList<Integer>) hijo2.getUltimaPos().clone();
            
            

            hijo.AddHijo(hijo2);
            this.pila.pop();       

            //----------------------------


            expresion.remove(i);

            // veo si mi . nodo es anulable
            if (anulable1 || anulable2){
                anulable3 = true;
            }else{
                anulable3 = false;
            }
            hijo.setAnulable(anulable3);

            // veo mis primeras pos 
     
            for (int n:copiaSiguientes1){
                siguientePos3.add(n);
            }
            
            for (int n2:copiaSiguientes2){
                if (!siguientePos3.contains(n2)){
                    siguientePos3.add(n2);
                }                    
            }
            
            Collections.sort(siguientePos3);            
            hijo.setPrimeraPos(siguientePos3);
            
            // veo mis ultimas pos            

            for (int n:copiaUltimos1){
                ultimaPos3.add(n);
            }
            
            for (int n2:copiaUltimos2){
                if (!ultimaPos3.contains(n2)){
                    ultimaPos3.add(n2);
                }                    
            }
            
            Collections.sort(ultimaPos3);            
            hijo.setUltimaPos(ultimaPos3);



            this.pila.add(hijo);
            break;
            
        }else{
            //expresion.get(i).replace("§", "")
            Nodo nuevoHijo = new Nodo(expresion.get(i).replace("§", ""),expresion.get(i),0,0);
            nuevoHijo.setTipo("simbolo");
            nuevoHijo.setAnulable(false);
            //this.posicion ++;
            this.posicion --;

            
            nuevoHijo.AddPrimeraPos(this.posicion);            
            nuevoHijo.AddUltimaPos(this.posicion);
            
            this.siguientes.add(new Siguiente(this.posicion,expresion.get(i).replace("§", "")));
            
            this.pila.add(nuevoHijo); 
            expresion.remove(i);
            break;
        }                
            
    }
    
    if (expresion.isEmpty()==false){
        recursivo(expresion);
    }
    
    return this.pila.get(0);
    
}
 
public ArrayList<Siguiente> regresarListaSiguientes() {
    ArrayList<Siguiente> copiaSiguientes = (ArrayList<Siguiente>) this.siguientes.clone();
    this.siguientes.clear();
    return copiaSiguientes;
}




public void estados(Nodo incio){
    ArrayList<Integer> conjutnoS0 = (ArrayList<Integer>) incio.getPrimeraPos().clone();
    Estado trabajando = new Estado("s"+this.numreoEstado);
    trabajando.setConjunto(conjutnoS0);
    
    if(trabajando.conjunto.contains(this.numeroAceptacion)){
        trabajando.setAceptacion(true);
    }else{
        trabajando.setAceptacion(false);
    }
    
    ArrayList<Integer> copiaConjunto = (ArrayList<Integer>) trabajando.getConjunto().clone();
    ArrayList<String> valoresLexemas = new ArrayList<String>();
    
    for (int valor:copiaConjunto){
        String lexema = "";
        ArrayList<Integer> nuevoConjunto = new ArrayList<Integer>();
        for(Siguiente valorDelSiguiente:this.siguientes){
            if (valor == valorDelSiguiente.numero){
                lexema = valorDelSiguiente.lexema;
                break;
            }
        }
        System.out.println("El nodo i = " + valor + ": , su lexema es " + lexema + "\n");
        
        for (int valor2:copiaConjunto ){
            for (Siguiente sig: this.siguientes){
                if (valor2 == sig.numero && valor!= this.numeroAceptacion){               
                    if(lexema.equals(sig.lexema) && !valoresLexemas.contains(lexema)){
                        for (int valoreSiguiente:sig.siguientes){                             
                            if(!nuevoConjunto.contains(valoreSiguiente)){
                                nuevoConjunto.add(valoreSiguiente);
                            }                                                  
                        }                       
                    }                
                }
            }
        }
        valoresLexemas.add(lexema);
        
        if (!nuevoConjunto.isEmpty()){
            Collections.sort(nuevoConjunto);
            System.out.println("El nuevo conjunto armado para el siguente de el nodo con el lexema " + lexema + " es");
            System.out.println(nuevoConjunto);
            System.out.println("\n");
            
            // veo si el conjunto nuevo es igual al del estado que estoy evaluando
            if (copiaConjunto.equals(nuevoConjunto)){
                Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),trabajando.getNombre(),lexema);
                trabajando.AddTransicion(nuevaTransicion);
            }else{
                // veo si mi conjunto ya existe en los estados ya listados o si esta en uno que aun tengo que verificar
                boolean yaExiste = false;  
                String nombreEstado = "";    
                
                // veo en los que estan por verificar
                for (Estado ver:this.verificar){
                    if(ver.conjunto.equals(nuevoConjunto)){
                        nombreEstado = ver.getNombre();
                        yaExiste = true;
                        break;
                    }
                }
                //veo en los estados ya listados
                for (Estado listE:this.listaEstados){
                    if(listE.conjunto.equals(nuevoConjunto)){
                        nombreEstado = listE.getNombre();
                        yaExiste = true;
                        break;
                    }
                } 
                if (yaExiste){
                   Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),nombreEstado,lexema);
                   trabajando.AddTransicion(nuevaTransicion);
                }else{
                    this.numreoEstado++;
                    Estado nuevoEstado = new Estado("s"+this.numreoEstado);
                    nuevoEstado.setConjunto(nuevoConjunto); 
                    if(nuevoEstado.conjunto.contains(this.numeroAceptacion)){
                        nuevoEstado.setAceptacion(true);
                    }else{
                        nuevoEstado.setAceptacion(false);
                    }                    
                    this.verificar.add(nuevoEstado);
                    Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),nuevoEstado.getNombre(),lexema);
                    trabajando.AddTransicion(nuevaTransicion);
                }               
                
            }
            
            
        }
        
        
        
    }
    
    this.listaEstados.add(trabajando);
    System.out.println("estado mas sus transiciones -----");
    System.out.println(trabajando.toString());
    System.out.println("los demas estados para verificar");
    for(Estado l:this.verificar){
       System.out.println(l.toString());
    }
    System.out.println("\n");
    this.hacerEstados();

    
    System.out.println("\nDESPUES DEL ANALISIS ESTOS SON LOS ESTADOS");
    System.out.println("En la lista de verificar tengo ");    
    System.out.println(this.verificar.size() + " estados por analizar ");
    System.out.println("Mis estados en la lista de los que ya analize son \n");
    for (Estado analizado:this.listaEstados){
            System.out.println(analizado.toString()+"\n");
    }


    

    
    /*if (this.verificar.isEmpty() == false){
        this.vaciarListaVerificar();    
    }*/
}


public boolean hacerEstados(){
    System.out.println("Esto es lo que hay en la lista Verificar " );
    System.out.println(this.verificar);
    System.out.println("\n");
    
    Estado trabajando = this.verificar.get(0);
    this.verificar.remove(0);    
    System.out.println("Esto es lo que hay en la lista Verificar despues de borrar la posicion 0 " );
    System.out.println(this.verificar);
    System.out.println("\n");
    
    
    
    System.out.println("Esto es lo que hay en el estado que estoy trabajando " );
    System.out.println(trabajando);
    System.out.println("Esto es el conjunto del estado que trabajo" );
    System.out.println(trabajando.getConjunto());
    System.out.println("Este es el conjutno copiado de mi estado actual" );
    ArrayList<Integer> copiaConjunto = (ArrayList<Integer>) trabajando.getConjunto().clone();
    System.out.println(copiaConjunto);
    System.out.println("\n");

    ArrayList<String> valoresLexemas = new ArrayList<String>();
    
    for (int valor:copiaConjunto){
        String lexema = "";
        ArrayList<Integer> nuevoConjunto = new ArrayList<Integer>();
        for(Siguiente valorDelSiguiente:this.siguientes){
            if (valor == valorDelSiguiente.numero){
                lexema = valorDelSiguiente.lexema;
                break;
            }
        }
        System.out.println("El nodo i = " + valor + ": , su lexema es " + lexema + "\n");
        
        for (int valor2:copiaConjunto ){
            for (Siguiente sig: this.siguientes){
                if (valor2 == sig.numero && valor!= this.numeroAceptacion){               
                    if(lexema.equals(sig.lexema) && !valoresLexemas.contains(lexema)){
                        for (int valoreSiguiente:sig.siguientes){                             
                            if(!nuevoConjunto.contains(valoreSiguiente)){
                                nuevoConjunto.add(valoreSiguiente);
                            }                                                  
                        }                       
                    }                
                }
            }
        }
        valoresLexemas.add(lexema);
        
        if (!nuevoConjunto.isEmpty()){
            Collections.sort(nuevoConjunto);
            System.out.println("El nuevo conjunto armado para el siguente de el nodo con el lexema " + lexema + " es");
            System.out.println(nuevoConjunto);
            System.out.println("\n");
            
            // veo si el conjunto nuevo es igual al del estado que estoy evaluando
            if (copiaConjunto.equals(nuevoConjunto)){
                Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),trabajando.getNombre(),lexema);
                trabajando.AddTransicion(nuevaTransicion);
            }else{
                // veo si mi conjunto ya existe en los estados ya listados o si esta en uno que aun tengo que verificar
                boolean yaExiste = false;  
                String nombreEstado = "";    
                
                // veo en los que estan por verificar
                for (Estado ver:this.verificar){
                    if(ver.conjunto.equals(nuevoConjunto)){
                        nombreEstado = ver.getNombre();
                        yaExiste = true;
                        break;
                    }
                }
                //veo en los estados ya listados
                for (Estado listE:this.listaEstados){
                    if(listE.conjunto.equals(nuevoConjunto)){
                        nombreEstado = listE.getNombre();
                        yaExiste = true;
                        break;
                    }
                } 
                if (yaExiste){
                   Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),nombreEstado,lexema);
                   trabajando.AddTransicion(nuevaTransicion);
                }else{
                    this.numreoEstado++;
                    Estado nuevoEstado = new Estado("s"+this.numreoEstado);
                    nuevoEstado.setConjunto(nuevoConjunto); 
                    if(nuevoEstado.conjunto.contains(this.numeroAceptacion)){
                        nuevoEstado.setAceptacion(true);
                    }else{
                        nuevoEstado.setAceptacion(false);
                    }                    
                    this.verificar.add(nuevoEstado);
                    Transicion nuevaTransicion = new Transicion(trabajando.getNombre(),nuevoEstado.getNombre(),lexema);
                    trabajando.AddTransicion(nuevaTransicion);
                }               
                
            }
            
            
        }
        
        
        
    }
    
    this.listaEstados.add(trabajando);
    
    
    if (!this.verificar.isEmpty()){
        System.out.println("sigo con otra vuelta");
        this.hacerEstados();
    }else{
        System.out.println("no tengo nada mas que verificar");
    }
    

    return true;
}


public ArrayList<Estado> regresarListaEstados() {
    ArrayList<Estado> copiaEstados = (ArrayList<Estado>) this.listaEstados.clone();
    this.numreoEstado = 0;
    this.listaEstados.clear();
    this.verificar.clear();
    this.numeroAceptacion = 0;

    return copiaEstados;
}
    
}
