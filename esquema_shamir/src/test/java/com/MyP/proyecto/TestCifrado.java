package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Cifrado;
import java.util.ArrayList;

/**
 * Pruebas unitarias para la clase Cifrado.
 */
public class TestCifrado {

  private String llave = "e3b0c44298fc1c149afbf4c8996fb924"
                       + "27ae41e4649b934ca495991b7852b855";
  private String texto = "Este bloque será cifrado, hasta pronto. :)";
  private String textoC = "FK9vGMtv/3Jx62/VsP/JG/Ue7wgy93L+HZG3Rfbrdw0n8pJ1P1FJ/8RdRcDlxzbY";

  /**
   * Prueba unitaria para el método cifra.
   */
  @Test public void TestCifra() {
    String cifrado = "";
    Cifrado prueba = new Cifrado();
    try {
      cifrado = prueba.cifra(llave, texto);
      Assert.assertTrue(cifrado != null);
      Assert.assertTrue(cifrado.length() > 0);
      Assert.assertTrue(cifrado.equals(textoC));
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}
