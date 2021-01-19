package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Cifrado;

/**
 * Pruebas unitarias para la clase Cifrado.
 */
public class TestCifrado {

  private String llave = "e3b0c44298fc1c149afbf4c8996fb924
                          27ae41e4649b934ca495991b7852b855";
  private String texto = "Este bloque será cifrado, hasta pronto. :)";
  private String textoC = "Qh2vt8uVWpDVJ0FvF9I4SyaBhwDqLPQ6UyT4Pi2urDtFoKCaoUA2uqXhL9I4TFYM";

  /**
   * Prueba unitaria para el método cifra.
   */
  @Test public void TestCifra() {
    String cifrado = Cifrar.cifra(llave, texto);

    Assert.assertTrue(cifrado != null);
    Assert.assertTrue(cifrado.length() > 0);
    Assert.assertTrue(cifrado.equals(textoC));
  }
}
