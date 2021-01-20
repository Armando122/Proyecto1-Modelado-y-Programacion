package com.MyP.proyecto;

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
  }

}
