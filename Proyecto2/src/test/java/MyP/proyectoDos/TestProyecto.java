package MyP.proyectoDos;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import MyP.proyectoDos.Imagen;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Pruebas unitarias del proyecto.
 */
public class TestProyecto {

    /* Plantilla base para las pruebas. */
    private BufferedImage plantilla = null;
    private String nombre = "CloudCoverageImgs/prueba.jpg";
    private Imagen imgP = null;

    /**
     * Crea una imagen para las pruebas.
     */
    public TestProyecto() throws IOException {
        plantilla = ImageIO.read(getClass().getResourceAsStream("/prueba.jpg"));
        imgP = new Imagen(plantilla, nombre);
    }

    /**
     * Prueba unitaria para el cosntructor de Imagen.
     */
    @Test public void testConstructor() {
      Assert.assertTrue(imgP != null);
    }

    /**
     * Prueba unitaria para el método calculaIndice de Imagen.
     */
    @Test public void testCalculaIndice() {
      imgP.clasificaPixeles();
      float indice = imgP.calculaIndice();
      Assert.assertTrue(indice == 1.0);
    }

    /**
     * Prueba unitaria para el método obtenerNombre de Imagen.
     */
    @Test public void testObtenerNombre() {
      String nomPrueba = imgP.obtenerNombre();
      Assert.assertTrue(nomPrueba.equals(nombre));
    }

}
