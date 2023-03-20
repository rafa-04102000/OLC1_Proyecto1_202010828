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


// %init{ 
//     yyline = 1; 
//     yycolumn = 1; 
// %init} 


//simbolos

EXCLAMACION = "!" //33
COMILLA_DOBLE = "\"" //34
NUMERAL = "#" //35
DOLAR = "$" //36
PORCENTAJE = "%" //37
AMPERSAND = "&" //38
COMILLA = "\'" //39
PAR_IZQ = "(" //40
PAR_DER = ")" //41
POR = "*" //42
MAS = "+" //43
COMA = "," //44 ESTE
MENOS_GUION = "-" //45
PUNTO = "." //46
DIV_BARRA = "/" //47

DOBLE_PUNTO = ":" //58
PTCOMA =";" //59
MENORQ = "<" //60
IGUAL = "=" //61
MAYORQ = ">" //62
INTERROGACION = "?" //63
ARROBA = "@" //64


COR_IZQ = "[" //91
BARRA_INV = "\\" //92
COR_DER = "]" //93
ELVACION = "\^" //94
GUION_BAJO = "_" //95
ACENTO = "\`" //96


LLAVE_IZQ = "{" //123
OR = "|" //124
LLAVE_DER = "}" //125
VERGULILLA = "~" //126




//palabras reservadas
RCONJUNTO = "CONJ"

//expresiones - expresiones regulares

// TEXTO=([A-Za-zÑñ]*[0-9]*)+
// TEXTO=[a-zA-Z_][a-zA-Z0-9_Ññ]+
TEXTO=([a-zA-Z0-9_Ññ]+[ ]*)+
// ENTERO = [0-9]+ // del 48 a 57
// LETRAS = [A-Za-zÑñ]+ // del 65 a 90 y del 97 al 122
// TEXTO = [\w\s]*
SPACE = [\ \s\r\t\f] // 32
ENTER = [\ \n] //
SALTO = "\\n"
SEPARADOR = %%


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

// caracter_etc = .|[^.]
comentariosimple    = "//" {InputCharacter}* {LineTerminator}?
// comentarioMultiple = \<\!(\n*.*)*\!\>
comentarioMultiple = "<!" [^/]~ "!>"

// TEXTO2= \"[a-zA-Z]*[0-9]*\"

%%

{comentarioMultiple} {System.out.println("Comentario multilinea: "+ yytext());}
{comentariosimple} {System.out.println("Comentario: "+yytext()); }
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}

// <YYINITIAL> {REVALUAR}  {   return new Symbol(sym.REVALUAR, yyline, yycolumn,yytext());  }
<YYINITIAL> {EXCLAMACION}   {   return new Symbol(sym.EXCLAMACION, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA_DOBLE}   {   return new Symbol(sym.COMILLA_DOBLE, yyline, yycolumn,yytext());  }
<YYINITIAL> {NUMERAL}   {   return new Symbol(sym.NUMERAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {DOLAR}   {   return new Symbol(sym.DOLAR, yyline, yycolumn,yytext());  }

<YYINITIAL> {SEPARADOR}   {   return new Symbol(sym.SEPARADOR, yyline, yycolumn,yytext());  }

<YYINITIAL> {PORCENTAJE}   {   return new Symbol(sym.PORCENTAJE, yyline, yycolumn,yytext());  }
<YYINITIAL> {AMPERSAND}   {   return new Symbol(sym.AMPERSAND, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMILLA}   {   return new Symbol(sym.COMILLA, yyline, yycolumn,yytext());  }
<YYINITIAL> {PAR_IZQ}   {   return new Symbol(sym.PAR_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {PAR_DER}   {   return new Symbol(sym.PAR_DER, yyline, yycolumn,yytext());  }
<YYINITIAL> {POR}   {   return new Symbol(sym.POR, yyline, yycolumn,yytext());  }
<YYINITIAL> {MAS}   {   return new Symbol(sym.MAS, yyline, yycolumn,yytext());  }
<YYINITIAL> {COMA}    {  return new Symbol(sym.COMA, yyline, yycolumn,yytext());   }
<YYINITIAL> {MENOS_GUION}       {  return new Symbol(sym.MENOS_GUION, yyline, yycolumn,yytext());  }
<YYINITIAL> {PUNTO}     {   return new Symbol(sym.PUNTO, yyline, yycolumn,yytext());    }
<YYINITIAL> {SALTO}     {   return new Symbol(sym.SALTO, yyline, yycolumn,yytext());    }
<YYINITIAL> {DIV_BARRA}       {   return new Symbol(sym.DIV_BARRA, yyline, yycolumn,yytext());   }



<YYINITIAL> {DOBLE_PUNTO}       {  return new Symbol(sym.DOBLE_PUNTO, yyline, yycolumn,yytext());   }
<YYINITIAL> {PTCOMA}    {  return new Symbol(sym.PTCOMA, yyline, yycolumn,yytext());   }
<YYINITIAL> {MENORQ}   {   return new Symbol(sym.MENORQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {IGUAL}   {   return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());  }
<YYINITIAL> {MAYORQ}   { return new Symbol(sym.MAYORQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {INTERROGACION}   {   return new Symbol(sym.INTERROGACION, yyline, yycolumn,yytext());  }
<YYINITIAL> {ARROBA}   {   return new Symbol(sym.ARROBA, yyline, yycolumn,yytext());  }


<YYINITIAL> {COR_IZQ}   {   return new Symbol(sym.COR_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {BARRA_INV}   {   return new Symbol(sym.BARRA_INV, yyline, yycolumn,yytext());  }
<YYINITIAL> {COR_DER}   {   return new Symbol(sym.COR_DER, yyline, yycolumn,yytext());  }
<YYINITIAL> {ELVACION}   {   return new Symbol(sym.ELVACION, yyline, yycolumn,yytext());  }
<YYINITIAL> {GUION_BAJO}   {   return new Symbol(sym.GUION_BAJO, yyline, yycolumn,yytext());  }
<YYINITIAL> {ACENTO}   {   return new Symbol(sym.ACENTO, yyline, yycolumn,yytext());  }   


<YYINITIAL> {LLAVE_IZQ}   { return new Symbol(sym.LLAVE_IZQ, yyline, yycolumn,yytext());  }
<YYINITIAL> {OR}   {   return new Symbol(sym.OR, yyline, yycolumn,yytext());  }
<YYINITIAL> {LLAVE_DER}   { return new Symbol(sym.LLAVE_DER, yyline, yycolumn,yytext());  }
<YYINITIAL> {VERGULILLA}   { return new Symbol(sym.VERGULILLA, yyline, yycolumn,yytext());  }


<YYINITIAL> {RCONJUNTO}   {  return new Symbol(sym.RCONJUNTO, yyline, yycolumn,yytext());  }

<YYINITIAL> {TEXTO}   { return new Symbol(sym.TEXTO, yyline, yycolumn,yytext());  }
// <YYINITIAL> {ENTERO}   { return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());  }
// <YYINITIAL> {LETRAS}   { return new Symbol(sym.LETRAS, yyline, yycolumn,yytext());  }





<YYINITIAL> . {
        // String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        // System.out.println(errLex);
        // agregar errores lexicos 
        erroresLexicos.add(new Excepcion("Léxico","El caracter : '"+yytext()+"' no pertenece al lenguaje ", "Fila: " + Integer.toString(yyline+1), "Columna: " + Integer.toString(yycolumn+1)));
}

