package com.MyP.proyecto;

import java.math.BigInteger;
import java.lang.IllegalArgumentException;

/**
 * Clase Polinomio.
 * Clase encargada de construir un polinomio módulo un número p de 256 bits.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Polinomio {

  /* Primo grande para trabajar modulo. */
  private BigInteger primoGrande = new BigInteger("");

  /* Llave. */
  private BigInteger llave;

  /* Puntos que tendrá el polinomio. */
  private int puntos;

  /* Coeficientes del polinomio. */
  private BigInteger[] coeficientes;

  /**
   * Constructor de Polinomio.
   * @param llave La clave segura de 256 bits.
   * @param puntosMin Los puntos mínimos que pasarán por ese polinomio.
   */
  public Polinomio(String llave, int puntosMin) {
    this.llave = new BigInteger(llave);
    this.puntos = puntosMin - 1;
    this.coeficientes = coeficientes(this.puntos);
  }

  /**
   * Método coeficientes.
   * Genera aleatoriamente los coeficientes del polinomio.
   * Recibe los coeficientes que tendrá el polinomio,
   * regresa un arreglo con los coeficientes del polinomio.
   */
  private BigInteger[] coeficientes(int coeficientes) {}

  /**
   * Método modulo, que se encarga de transformar los números.
   */
  private BigInteger modulo() {}

  /**
   * Método evaluaHorner.
   * @return BigInteger[] Las n parejas ordenadas.
   */
  public BigInteger[] evaluaHorner() {}

  /**
   * Método reconstruye.
   * Recupera la clave segura.
   * @param parejas Al menos t parejas ordenadas.
   * @return BigInteger La llave para desencriptar.
   * @throws IllegalArgumentException Si se reciben menos de los puntos mínimos.
   */
  public BigInteger reconstruye() throws IllegalArgumentException {}

}
