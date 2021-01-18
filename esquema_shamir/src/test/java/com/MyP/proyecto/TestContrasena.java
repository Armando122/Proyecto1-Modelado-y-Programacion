package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Constrasena;

/**
 * Pruebas unitarias para la clase Contrasena.
 */
public class TestContrasena {

  /**
   * Prueba unitaria para el método genera contraseña.
   */
  @Test public void TestGeneraContrasena() {
    String prueba = Contrasena.generaContrasena("1243r242");
    byte total[] = prueba.getBytes();
    Assert.assertTrue(256 == total.length);
  }
}
