package MyP.proyectoDos;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Imagen.
 * @author Cecilia Villatoro Ramos.
 * @author Armando ramírez González.
 */
public class Imagen {

  /* Atributos de Imagen. */
  /* Colores para colorear los píxeles. */
  private final Color negro = new Color(1, 1, 1);
  private int rgbNegro = negro.getRGB();

  /* El conjunto de coordenadas de los pixeles que son cielo*/
  private ArrayList<int[]> cielo = new ArrayList();

  /* El área útil de la imagen recibida, donde el radio
  /* es 1324 pixeles de acuerdo con las especificaciones dadas*/
  private final float áreaÚtil = (float) Math.PI * (float) Math.pow(1324,2);

  /* BufferedImage, copia de la imagen. */
  private BufferedImage imagen;
  /* String, nombre de la imagen sin la extensión. */
  private String nombre;
  /* Umbral para determinar si el píxel es de una nube o cielo. */
  private final double umbral = 0.95;


  /**
   * Constructor para imagen.
   * @param BufferedImage imagen: imagen a analizar.
   * @param String nombre nombe de la imagen.
   */
  public Imagen(BufferedImage imagen, String nombre) {
    this.nombre = nombre;
    this.imagen = imagen;
  }

  /**
   * Método obtenerNombre. Devuelve el nombre de la imagen.
   * @return String nombre de imagen.
   */
  public String obtenerNombre() {
    return this.nombre;
  }

  /**
   * Método que clasifica los pixeles de la imagen y guarda
   * los que correspondan a cielo de acuerdo con el humbral.
   */
  public void clasificaPixeles(){
    for(int x = 834; x < 3534; x++){

      int nuevaX = x - 834;

      for(int y = 106; y < 2806; y++){
        int srgb = this.imagen.getRGB(x, y);

        Color colorPixel = new Color(srgb);

        float rojo = (float) colorPixel.getRed();
        float azul = (float) colorPixel.getBlue();

        int nuevaY = y - 106;

        int[] coordPixel = {nuevaX, nuevaY};

        float razónRA = rojo / azul;

        if(razónRA < umbral){
          cielo.add(coordPixel);
        }
      }
    }
  }

  /**
   * Método calculaIndice.
   * Que se encarga de calcular el índice de cobertura nubosa
   * de la imagen.
   * @return float El índice de cobertura nubosa.
   */
  public float calculaIndice() {
    //Calcula el indice y colorea la imagen.
    return (áreaÚtil - (float) cielo.size()) / áreaÚtil;
  }

  /**
   * Método dibujaCielo.
   * Se encarga de sobreescribir una copia de la plantilla con los pixeles que
   * corresponden al cielo de la Imagen.
   * @return BufferImage imagen en blanco y negro del cielo.
   */

  public BufferedImage dibujaCielo() throws IOException{
    //Necesarios para acceder a la plantilla
    File plantilla = new File("src/main/resources/plantilla.png");
    BufferedImage bufferPlantilla = ImageIO.read(plantilla);

    //Colorea los pixeles de negro
    for(int i = 0; i < cielo.size(); i++){
      int[] pixel = cielo.get(i);
      /*Se escriben los pixeles negros sobre la plantilla, pero sin
       cambiar la imagen original.*/
      bufferPlantilla.setRGB(pixel[0], pixel[1], rgbNegro);
    }
    return bufferPlantilla;
  }
}
