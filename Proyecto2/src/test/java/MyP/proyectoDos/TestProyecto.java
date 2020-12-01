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
 * Pruebas unitarias de Imagen y Proyecto2
 */
public class TestProyecto {

    /**/
    private BufferedImage plantilla;
    private String nombre = "11833"

    /**
     * Crea una imagen para las pruebas.
     */
    public TestProyecto() {
        plantilla = imageIO.read(new File("CloudCoverageImgs/11833.JPG"));
    }

    /**
     * Prueba unitaria para el cosntructor de Imagen.
     */
    @Test public void testConstructor() {
    }

    /**
     * Prueba unitaria para el método calculaIndice de Imagen.
     */
    @Test public void testCalculaIndice() {
    }

    /**
     * Prueba unitaria para el método obtenerNombre de Imagen.
     */
    @Test public void testObtenerNombre() {
      
      Assert.assertTrue();
    }

    /**
     * Prueba unitaria para el método obtenerImagenBN de Imagen.
     */
    @Test public void testObtenerImagenBN() {
    }

}
