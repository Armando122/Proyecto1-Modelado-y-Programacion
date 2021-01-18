package com.MyP.proyecto;

import org.junit.Assert;
import java.util.ArrayList;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Interpolacion;

/**
 * Pruebas unitarias para la clase Interpolacion.
 */
public class TestInterpolacion {

  /**/
  private ArrayList<BigInteger> parejas = new ArrayList<BigInteger>();

  /**
   * Prueba unitaria para el método reconstruye.
   */
  @Test public void testReconstruye() {
    parejas.add(new BigInteger("1"));
    parejas.add(new BigInteger("976545"));
    String llave = Interpolacion.reconstruye(parejas);
    Assert.assertTrue(llave != null);
  }

}
