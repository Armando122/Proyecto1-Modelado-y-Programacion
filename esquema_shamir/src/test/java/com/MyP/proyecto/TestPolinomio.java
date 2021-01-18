package com.MyP.proyecto;

import org.junit.Assert;
import java.util.ArrayList;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Polinomio;

/**
 * Pruebas unitarias para la clase Polinomio.
 */
public class TestPolinomio {

  /* Polinomio. */
  private Polinomio prueba = null;
  private String llaveStr = "e3b0c44298fc1c149afb
                             92427ae41e4649b934ca495991b7852b855";
  private int evaluaciones = 6;
  private int puntosMin = 4;
  private ArrayList<BigInteger> parejas = new ArrayList<BigInteger>();

  /**
   * Crea un Polinomio para las pruebas.
   */
  public TestPolinomio() {
      prueba = new Polinomio(llaveStr, 4, 6);
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
    parejas = prueba.evaluaHorner();
    Assert.assertTrue(parejas != null);
    Assert.assertTrue(parejas.size() == 12);
  }
  
}
