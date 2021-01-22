package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Descifrado;
import java.util.ArrayList;

/**
 * Pruebas unitarias para la clase Descifrado.
 */
public class TestDescifrado {

  private String llave = "e3b0c44298fc1c149afbf4c8996fb924"
                       + "27ae41e4649b934ca495991b7852b855";
  private String textoD = "Este bloque será cifrado, hasta pronto. :)";
  private String texto = "Qh2vt8uVWpDVJ0FvF9I4SyaBhwDqLPQ6UyT4Pi2urDtFoKCaoUA2uqXhL9I4TFYM";

  /**
   * Prueba unitaria para el método descifra.
   */
  @Test public void testDescifra() {
    String descifrado = null;
    Descifrado descrip = new Descifrado();
    try {
      descifrado = descrip.descifra(llave, texto);
      Assert.assertTrue(descifrado != null);
      Assert.assertTrue(descifrado.length() > 0);
      Assert.assertTrue(descifrado.equals(textoD));
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

}
