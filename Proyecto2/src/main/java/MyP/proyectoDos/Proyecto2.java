package MyP.proyectoDos;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Proyecto2 que recibe una imagen en formato .jpg y devuvelve el indice
 * de cobertura nubosa en la salida estándar. Regresa también la imagen
 * segmentada con las nubes en blanco y el cielo negro, si se recibe
 * la etiqueta s.
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Proyecto2 {

    /* Imprime el uso del programa y lo termina. */
    private static void uso() {
      System.err.println("\nEl archivo de entrada debe especificarse como:\n\n"
                      + "  java -jar target/Proyecto2.jar imagen.jpeg\n\n"
                      + "   - Para guardar la imagen segementada debe agregarse"
                      + " la bandera s.");
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
      if (args.length <= 0 || args.length > 2) {
        uso();
      }

      /* Segundo parametro invalido. */
      if (args.length == 2) {
        String param = args[1].toLowerCase();
        if (!param.equals("s")) {
          usoSeg();
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
      String parteMedia = nombreIm;
      /* Quitamos la ruta a la imagen recibida. */
      for (int i = 0; i<parteMedia.length(); i++) {
        char m = parteMedia.charAt(i);
        String diagonal = "/";
        if (m == diagonal.charAt(0)) {
          nombreIm = parteMedia.substring(i+1);
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
          //Guardar imagen segmentada.
          BufferedImage imagenSeg = nubes.dibujaCielo();
          String nombreCompleto = nubes.obtenerNombre() + "-seg.png";
          File imgSalida = new File(nombreCompleto);
          ImageIO.write(imagenSeg, "png", imgSalida);
        }
      } catch(IOException e) {
        System.err.println(e.getMessage());
      }

    }
}
