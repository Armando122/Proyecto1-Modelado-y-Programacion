package com.MyP.proyecto;

import java.io.Console;
import java.io.IOException;
import java.io.IOError;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Implementación del secreto compartido de Shamir.
 * Que cifra un archivo mediante una contraseña de usuario y
 * lo descifra con t contraseñas independientes.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class EsquemaShamir {

  /* Imprime el uso del programa y lo termina. */
  private static void uso() {
    System.err.println("La entrada debe especificarse como(Cifrar):\n"
                    + " java -jar target/EsquemaShamir.jar c ArchivoEv"
                    + " EvReq EvMinimas ArchivoOr\n"
                    + "     c - Bandera para cifrar un archivo.\n"
                    + "     ArchivoEv - Nombre de archivo donde se guardarán"
                    + " los n puntos.\n"
                    + "     EvReq - Número de n evaluaciones requeridas(n>2).\n"
                    + "     EvMinimas - Número mínimo de puntos necesarios"
                    + " para descifrar.\n"
                    + "     ArchivoOr - Nombre de archivo que se quiere"
                    + " cifrar.\n\n"
                    + "Para cifrar debe especificarse como:\n"
                    + " java -jar target/EsquemaShamir.jar d ArchivoEv Cifrado\n"
                    + "     d - Bandera para descifrar un archivo.\n"
                    + "     ArchivoEv - El nombre de archivo con al menos"
                    + " t (minimas) evaluaciones. [Ingresar menos de t"
                    + " evaluaciones solo dañará el archivo.]\n"
                    + "     Cifrado - Nombre del archivo cifrado.\n\n"
                    + " LA ENTRADA DEBE ESPECIFICARSE EN ESE ORDEN EN TODO"
                    + " MOMENTO.\n");
    System.exit(1);
  }

  public static void main( String[] args ) {

    /* Uso del programa. */
    if (args.length == 0) {
      uso();
    }

    if (args[0].equals("c") && args.length != 5) {
      uso();
    }

    if (args[0].equals("d") && args.length != 3) {
      uso();
    }

    /* Opción de cifrar. */
    if (args[0].equals("c")) {
      /* Asignación de datos. */
      String archivoPuntos = args[1];
      String documentoClaro = args[4];
      int nPuntos = 0;
      int minPuntos = 0;

      try {
        nPuntos = Integer.parseInt(args[2]);
        minPuntos = Integer.parseInt(args[3]);

        if (nPuntos <= 2) {
          System.err.println("Se requieren más de 2 puntos.");
          System.exit(1);
        }
        if (minPuntos <= 1 || minPuntos > nPuntos) {
          System.err.println("Los puntos mínimos no pueden ser menores que 1"
                 + " ni mayores que los puntos totales.");
          System.exit(1);
        }

      } catch(NumberFormatException eNum) {
        System.err.println("El dato ingresado como parámetro no es un número.");
        System.exit(1);
      }

      String nombCompletArch = "";
      String soloNombreArch = "";
      /* Quitamos la ruta del archivo. */
      for (int i = 0; i<documentoClaro.length(); i++) {
        char caracter = documentoClaro.charAt(i);
        String signoMalo = "/";
        if (caracter == signoMalo.charAt(0)) {
          nombCompletArch = documentoClaro.substring(i+1);
        }
      }
      /* Quitamos la extensión del documento. */
      for (int j = 0; j<nombCompletArch.length(); j++) {
        char caracter = nombCompletArch.charAt(j);
        String signoMalo = ".";
        if (caracter == signoMalo.charAt(0)) {
          soloNombreArch = nombCompletArch.substring(0,j);
        }
      }

      /* Obtener contraseña usuario. */
      char[] contrasenaUsr = null;
      Console entrada = null;
      String contrasena = null;
      try {
        entrada = System.console();
        if (entrada != null) {
          contrasenaUsr = entrada.readPassword();
        }
        contrasena = String.valueOf(contrasenaUsr);
      } catch(Exception e) {
      }

      /* Generamos contraseña segura. */
      String contrasenaSegura = "";
      try {
        contrasenaSegura = Contrasena.generaContrasena(contrasena);
      } catch(Exception e) {
      }

      Polinomio puntos = new Polinomio(contrasenaSegura, minPuntos, nPuntos);
      ArrayList<BigInteger> parejas = puntos.evaluaHorner();
      ArrayList<String> parejasOrdena = new ArrayList<String>();
      /* Ordenamos los puntos. */
      String pareja = "(";
      for (BigInteger cordenada : parejas) {
        if (parejas.indexOf(cordenada) % 2 == 0) {
          pareja += cordenada.toString() + ", ";
        } else {
          pareja += cordenada.toString() + ")";
          parejasOrdena.add(pareja);
          pareja = "(";
        }
      }

      /* Leemos el archivo. */
      ArrayList<String> archivoOrig = new ArrayList<String>();
      try {
        archivoOrig = Archivo.leerArchivo(documentoClaro);
      } catch(IOException e) {
        System.err.println("Archivo" + e.getMessage() + "no encontrado o inexistente.");
      }

      /* Se encripta. */
      ArrayList<String> archivoCifrado = new ArrayList<String>();
      try {
        archivoCifrado = Cifrado.cifra(contrasenaSegura, archivoOrig);
      } catch(Exception e) {
      }
      archivoCifrado.add(0, nombCompletArch);

      /* Guardamos el archivo cifrado y las n evaluaciones. */
      try {
        Archivo.guardaArchivo("encriptado.aes", archivoCifrado);
        Archivo.guardaArchivo("encriptado.frg", parejasOrdena);
      } catch(IOException e) {
        e.getMessage();
      }

    }

    /* Opción para descifrar. */
    if (args[0].equals("d")) {

      /* Obtención de datos. */
      String evaluaciones = args[1];
      String archivoCifrado = args[2];
      ArrayList<String> puntos = new ArrayList<String>();
      ArrayList<String> archivo = new ArrayList<String>();

      try {
        puntos = Archivo.leerArchivo(evaluaciones);
        archivo = Archivo.leerArchivo(archivoCifrado);
      } catch(IOException e) {
        System.err.println("Archivo" + e.getMessage() + "no encontrado o inexistente.");
      }

      String nombreArch = archivo.remove(0);

      ArrayList<BigInteger> parejasListas = new ArrayList<BigInteger>();
      for (String pareja : puntos) {
        String inicio = pareja.replace("(", "");
        String fin = pareja.replace(")", "");
        String[] parejas = fin.split(", ");
        BigInteger abcisa = new BigInteger(parejas[0]);
        BigInteger ordenada = new BigInteger(parejas[1]);
        parejasListas.add(abcisa);
        parejasListas.add(ordenada);
      }

      /* Obtenemos la llave. */
      Interpolacion inicioLlave = new Interpolacion();
      String llavecita = inicioLlave.reconstruye(parejasListas);

      /* Desencriptamos el archivo. */
      ArrayList<String> descifrado = new ArrayList<String>();
      try {
        descifrado = Descifrado.descifra(llavecita, archivo);
      } catch(Exception e) {
      }

      /* Guardamos el archivo. */
      try {
        Archivo.guardaArchivo(nombreArch, descifrado);
      } catch(IOException e) {
        e.getMessage();
      }

    }

    /* Si ninguna condición se cumple. */
    uso();

  }

}
