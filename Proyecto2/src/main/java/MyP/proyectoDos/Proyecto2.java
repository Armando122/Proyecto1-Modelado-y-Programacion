package MyP.proyectoDos;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Proyecto2 que recibe una imagen en formato .jpeg y devuvelve el indice
 * de cobertura nubosa en la salida estándar. Regresa también la imagen
 * segmentada con las nubes en blanco y el cielo negro, si se recibe
 * la etiqueta s.
 *
 */
public class Proyecto2 {

    /* Imprime el uso del programa y lo termina. */
    private static void uso() {
      System.err.println("El archivo de entrada debe especificarse como:\n"
                      + " java -cp target/Proyecto-2.jar MyP.proyectoDos.Proyecto2"
                      + " imagen.jpeg\n");
      System.exit(1);
    }

    /* Imprime el uso del programa y lo termina. */
    private static void usoSeg() {
      System.err.println("Etiqueta 's' no encontrada.\n");
      System.exit(1);
    }

    public static void main(String[] args) {

      /* Objeto imagen para calcular el CCI. */
      Imagen nubes = null;
      /* Imagen leída. */
      BufferedImage imagen = null;
      /* Nombre de la imagen sin ruta ni extensión. */
      String nombreIm = "";

      /* En caso de que no se reciba un archivo válido. */
      if (args.length <= 0 || args.length > 1) {
        uso();
      }

      /* Segundo parametro invalido. */
      if (args.length == 2) {
        if (!args[1].equals("S") || !args[1].equals("s")) {
          usoSeg();
        }
      }

      /* Quitamos la ruta a la imagen recibida. */
      for (int i = 0; i<args[0].length(); i++) {
        char m = args[0].charAt(i);
        String diagonal = "/";
        if (m == diagonal.charAt(0)) {
          nombreIm = args[0].substring(i+1);
        }
      }
      /* Quitamos la extensión de la imagen. */
      for (int j = 0; j<args[0].length(); j++) {
        char m = args[0].charAt(j);
        String punto = ".";
        if (m == punto.charAt(0)) {
          nombreIm = args[0].substring(0,j);
        }
      }

      /* Se recibe un archivo válido y se lee. */
      try {
        // Leer imagen
        imagen = ImageIO.read(new File(args[0]));

        //Construir objeto imagen
        nubes = new Imagen(imagen, nombreIm);
        nubes.clasificaPixeles();

        //Imprmimir cci
        float indiceF = nubes.calculaIndice();
        String indice = String.valueOf(indiceF);
        System.out.println(indice);

        if (args.length == 2) {
          // Se colorea la imagen. FALTA
          //Guardar imagen segmentada.
          BufferedImage imagenSeg = nubes.obtenerImagenBN();
          String nombreCompleto = nubes.obtenerNombre() + "-seg.png";
          File imgSalida = new File(nombreCompleto);
          ImageIO.write(imagenSeg, "png", imgSalida);
        }
      } catch(IOException e) {
        System.err.println("La imagen: " + e.getMessage()
                          + " no se encontró en la dirección especificada");
      }

    }
}
