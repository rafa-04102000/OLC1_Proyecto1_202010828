package Analizador;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

// importar la clase Error
import Errores.Excepcion;

%%

%{
    //Código de usuario
    // crear un arraylist para los errores lexicos
    public  ArrayList<Excepcion> erroresLexicos = new ArrayList<Excepcion>() ;

%}

%class scanner // definir como trabajara el scanner
%cup // trabajar con cup
%public // tipo publico
%line // conteo de lineas - linea por linea
// %char // caracter por caracter
%column // caracter por caracter
%unicode // tipo de codificacion para que acepte la ñ u otro caracter
%ignorecase // hola o HOLA



/*  ============================ Expresiones Regulares ============================  */
ENTERO  = [0-9]
// DECIMAL = [0-9]+("."[  |0-9]+)?
LETRA   = [a-zA-ZÑñ]
ID      = {LETRA}({LETRA}|{ENTERO}|"_")*

SPACE   = [\ \r\t\f\t]
ENTER   = \r|\n|\r\n
CARACTER = [^\r\n]
COMENTARIOLINEA = "//" {CARACTER}* {ENTER}?
COMENTARIOMULTI = "<!" [^/]~ "!>"

SALTO_LINEA = \\n
COMILLA_SIMPLE_ESPECIAL = \\'
COMILLA_DOBLE_ESPECIAL = \\\"

// ASCII =[!-+] 

flecha = "-"{SPACE}*">"

//simbolos

EXCLAMACION = "!" //33
COMILLA_DOBLE = "\"" //34
NUMERAL = "#" //35
DOLAR = "$" //36

SEPARADOR = %%
PORCENTAJE = "%" //37
AMPERSAND = "&" //38
COMILLA = "\'" //39
PAR_IZQ = "(" //40
PAR_DER = ")" //41
KLEENE  = "*" //42
POSITIVA = "+" //43
COMA = "," //44 ESTE
GUION = "-" //45

DIV_BARRA = "/" //47
CONCATENACION = "." //46
DOBLE_PUNTO = ":" //58
PTCOMA =";" //59
MENOR_QUE = "<" //60
IGUAL = "=" //61
MAYOR_QUE = ">" //62
OPCIONAL = "?" //63
ARROBA = "@" //64


COR_IZQ = "[" //91
BARRA_INV = "\\" //92
COR_DER = "]" //93
ELVACION = "\^" //94
GUION_BAJO = "_" //95
ACENTO = "\`" //96


LLAVE_IZQ = "{" //123
OR = "|"//124
LLAVE_DER  = "}" //125
VERGULILLA = "~" //126


// CONCATENACION = "."
// OR          = "|"
// KLEENE      = "*"
// POSITIVA    = "+"
// OPCIONAL    = "?"

CADENA  = [\"]({EXCLAMACION}|{NUMERAL}|{DOLAR}|{PORCENTAJE}|{AMPERSAND}|{COMILLA}|{PAR_IZQ}|{PAR_DER}|{KLEENE}|{POSITIVA}|{COMA}|{GUION}|{DIV_BARRA}|{CONCATENACION}|{DOBLE_PUNTO}|{PTCOMA}|{MENOR_QUE}|{IGUAL}|{MAYOR_QUE}|{OPCIONAL}|{ARROBA}|{COR_IZQ}|{BARRA_INV}|{COR_DER}|{ELVACION}|{GUION_BAJO}|{ACENTO}|{LLAVE_IZQ}|{OR}|{LLAVE_DER}|{VERGULILLA}|{LETRA}|{ENTERO}|\ )+[\"]
// CADENA  = [\"]({EXCLAMACION}|{NUMERAL})+[\"]
// CADENA  = [\"][^\"\n]+[\"]
//palabras reservadas
RCONJUNTO = "CONJ"


%%



<YYINITIAL> {RCONJUNTO}       {/*System.out.println("Reconocio PALABRA RESERVADA: "+yytext());*/    return new Symbol(sym.RCONJUNTO, yyline, yycolumn,yytext());  }

<YYINITIAL> {SALTO_LINEA}       {/*System.out.println("Reconocio SALTO DE LINEA: "+yytext());*/    return new Symbol(sym.SALTO_LINEA, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA_SIMPLE_ESPECIAL}       {/*System.out.println("Reconocio COMILLA ESPECIAL: "+yytext()); */   return new Symbol(sym.COMILLA_SIMPLE_ESPECIAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA_DOBLE_ESPECIAL}       {/*System.out.println("Reconocio COMILLA DOBLE ESPECIAL: "+yytext()); */   return new Symbol(sym.COMILLA_DOBLE_ESPECIAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {flecha}       {/*System.out.println("Reconocio  FLECHA: "+yytext());*/    return new Symbol(sym.flecha, yyline, yycolumn,yytext());  }
<YYINITIAL> {SEPARADOR}       {/*System.out.println("Reconocio  SEPARADOR: "+yytext()); */   return new Symbol(sym.SEPARADOR, yyline, yycolumn,yytext());  }

<YYINITIAL> {EXCLAMACION}       {/* System.out.println("Reconocio EXCLAMACION: "+yytext()); */  return new Symbol(sym.EXCLAMACION, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA_DOBLE}       { /*System.out.println("Reconocio COMILA DOBLE: "+yytext()); */  return new Symbol(sym.COMILLA_DOBLE, yyline, yycolumn,yytext());  }
<YYINITIAL> {NUMERAL}      { /*System.out.println("Reconocio NUMERAL: "+yytext()); */  return new Symbol(sym.NUMERAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {DOLAR}      { /*System.out.println("Reconocio DOLAR: "+yytext());*/   return new Symbol(sym.DOLAR, yyline, yycolumn,yytext());  }
<YYINITIAL> {PORCENTAJE}         {/*System.out.println("Reconocio PORCENTAJE: "+yytext());*/    return new Symbol(sym.PORCENTAJE, yyline, yycolumn,yytext());  }
<YYINITIAL> {AMPERSAND}     {/* System.out.println("Reconocio AMPERSAND: "+yytext()); */  return new Symbol(sym.AMPERSAND, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA}        {/*System.out.println("Reconocio COMILLA: "+yytext()); */   return new Symbol(sym.COMILLA, yyline, yycolumn,yytext());   }
<YYINITIAL> {PAR_IZQ}          {  /*System.out.println("Reconocio PAR IZQ: "+yytext());*/  return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());   }
<YYINITIAL> {PAR_DER}     { /*System.out.println("Reconocio PAR DER: "+yytext());*/   return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());   }
<YYINITIAL> {KLEENE}   {/*System.out.println("Reconocio KLEEN: "+yytext());*/    return new Symbol(sym.KLEENE, yyline, yycolumn,yytext());}
<YYINITIAL> {POSITIVA}    {  /* System.out.println("Reconocio POSITIVO: "+yytext());*/ return new Symbol(sym.POSITIVA, yyline, yycolumn,yytext());   }
<YYINITIAL> {COMA}         { /*System.out.println("Reconocio COMA: "+yytext()); */  return new Symbol(sym.COMA, yyline, yycolumn,yytext());  }
<YYINITIAL> {GUION} {/*System.out.println("Reconocio GUION: "+yytext()); */  return new Symbol(sym.GUION, yyline, yycolumn,yytext());}
<YYINITIAL> {DIV_BARRA}            { /*System.out.println("Reconocio BARRA/DIV: "+yytext());*/   return new Symbol(sym.DIV_BARRA, yyline, yycolumn,yytext());   }
<YYINITIAL> {CONCATENACION}        { /*System.out.println("Reconocio CONCATENACION: "+yytext());*/   return new Symbol(sym.CONCATENACION, yyline, yycolumn,yytext());   }
<YYINITIAL> {DOBLE_PUNTO}      {/*System.out.println("Reconocio DOBLE PUNTO: "+yytext());*/    return new Symbol(sym.DOBLE_PUNTO, yyline, yycolumn,yytext());   }
<YYINITIAL> {PTCOMA}  { /*System.out.println("Reconocio PUNTO Y COMA: "+yytext());*/   return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());   }
<YYINITIAL> {MENOR_QUE}   { /*System.out.println("Reconocio MENOR QUE: "+yytext());*/   return new Symbol(sym.MENOR_QUE, yyline, yycolumn,yytext());   }
<YYINITIAL> {IGUAL} {/*System.out.println("Reconocio IGUAL: "+yytext()); */   return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());   }
<YYINITIAL> {MAYOR_QUE} { /*System.out.println("Reconocio MAYOR QUE: "+yytext());*/   return new Symbol(sym.MAYOR_QUE, yyline, yycolumn,yytext());   }
<YYINITIAL> {OPCIONAL}         {/*System.out.println("Reconocio OPCIONAL: "+yytext());*/    return new Symbol(sym.OPCIONAL, yyline, yycolumn,yytext());   }
<YYINITIAL> {ARROBA}        { /*System.out.println("Reconocio ARROBA: "+yytext()); */  return new Symbol(sym.ARROBA, yyline, yycolumn,yytext());   }
<YYINITIAL> {COR_IZQ}       {  /*System.out.println("Reconocio COR IZQ: "+yytext());*/  return new Symbol(sym.COR_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {BARRA_INV}         { /*System.out.println("Reconocio BARR INV: "+yytext());*/   return new Symbol(sym.BARRA_INV, yyline, yycolumn,yytext());   }
<YYINITIAL> {COR_DER}            { /*System.out.println("Reconocio COR DER: "+yytext());*/   return new Symbol(sym.COR_DER, yyline, yycolumn,yytext());   }
<YYINITIAL> {ELVACION}        {/*System.out.println("Reconocio ELEVACION: "+yytext());*/    return new Symbol(sym.ELVACION, yyline, yycolumn,yytext());   }
<YYINITIAL> {GUION_BAJO}        { /*System.out.println("Reconocio GUION BAJO: "+yytext()); */  return new Symbol(sym.GUION_BAJO, yyline, yycolumn,yytext());   }
<YYINITIAL> {ACENTO}        {/*System.out.println("Reconocio ACENTO: "+yytext()); */   return new Symbol(sym.ACENTO, yyline, yycolumn,yytext());   }
<YYINITIAL> {LLAVE_IZQ}        {/*System.out.println("Reconocio LLAVE IZQ: "+yytext());*/    return new Symbol(sym.LLAVE_IZQ, yyline, yycolumn,yytext());   }
<YYINITIAL> {OR}        {  /*System.out.println("Reconocio OR: "+yytext());*/  return new Symbol(sym.OR, yyline, yycolumn,yytext());   }
<YYINITIAL> {LLAVE_DER}        { /*System.out.println("Reconocio LLAVE DER: "+yytext());*/   return new Symbol(sym.LLAVE_DER, yyline, yycolumn,yytext());   }
<YYINITIAL> {VERGULILLA}        {/*System.out.println("Reconocio VERGUILILLA: "+yytext()); */   return new Symbol(sym.VERGULILLA, yyline, yycolumn,yytext());   }


<YYINITIAL> {ENTERO}        { /* System.out.println("Reconocio ENTERO: "+yytext());*/  return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());   }
<YYINITIAL> {LETRA}        {  /*System.out.println("Reconocio LETRA: "+yytext());*/  return new Symbol(sym.LETRA, yyline, yycolumn,yytext());   }

<YYINITIAL> {ID}        { /*System.out.println("Reconocio ID: "+yytext()); */  return new Symbol(sym.ID, yyline, yycolumn,yytext());   }
<YYINITIAL> {CADENA}        {/*System.out.println("Reconocio CADENA: "+yytext()); */   return new Symbol(sym.CADENA, yyline, yycolumn,yytext());   }

<YYINITIAL> {SPACE}             {  /*return new Symbol(sym.SPACE, yyline, yycolumn,yytext()); */ }
<YYINITIAL> {ENTER}             { /*Saltos de linea, ignorados*/}

<YYINITIAL> {COMENTARIOLINEA}   {System.out.println("Comentario: "+yytext()); }
<YYINITIAL> {COMENTARIOMULTI}   { System.out.println("Comentario: multilinea"+yytext()); }



<YYINITIAL> . {
        // String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        // System.out.println(errLex);
        // agregar errores lexicos 
        erroresLexicos.add(new Excepcion("Léxico","El caracter : '"+yytext()+"' no pertenece al lenguaje ", "Fila: " + Integer.toString(yyline+1), "Columna: " + Integer.toString(yycolumn+1)));
}

