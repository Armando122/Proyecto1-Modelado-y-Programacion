package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Polinomio;

/**
 * Pruebas unitarias para la clase Polinomio.
 */
public class TestPolinomio {

  /* Polinomio. */
  private Polinomio prueba = null;
  private BigInteger llave = new BigInteger("1342");
  private int puntosTot = 6;
  private int puntosMin = 4;
  private BigInteger puntos[];

  /**
   * Crea un Polinomio para las pruebas.
   */
  public TestPolinomio() {
      prueba = new Polinomio("1342", 4, 6);
      puntos = prueba.evaluaHorner();
  }

  /**
   * Prueba unitaria para el constructor de Polinomio.
   */
  @Test public void testConstructor() {
    Assert.assertTrue(prueba != null);
  }

  /**
   * Prueba unitaria para el método evaluaHorner.
   */
  @Test public void testEvaluaHorner() {
    BigInteger resultados[] = prueba.evaluaHorner();
    Assert.assertTrue(resultados != null);
    Assert.assertTrue(puntos.length == 6);
  }

  /**
   * Prueba unitaria para el método reconstruye.
   */
  @Test public void testReconstruye() {
    BigInteger llaveSegura = prueba.reconstruye(pruebas);
    Assert.assertTrue(llaveSegura.equals(llave));
  }
}
