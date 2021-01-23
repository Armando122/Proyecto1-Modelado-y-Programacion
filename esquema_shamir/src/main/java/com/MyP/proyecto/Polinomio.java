package com.MyP.proyecto;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Clase Polinomio.
 * Clase encargada de construir un polinomio módulo un número p de 256 bits.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Polinomio {

  /* Primo grande para trabajar modulo. */
  String numS = "208351617316091241234326746"
                 + "312124448251235562226470"
                 + "491514186331217050270460481";
  private BigInteger modulo = new BigInteger(numS);

  /* Llave. */
  private BigInteger llave = new BigInteger("0");

  /* Puntos que tendrá el polinomio. */
  private int puntos;

  /* Coeficientes del polinomio. */
  private BigInteger[] coeficientes;

  /* n puntos de los que se quiere su evaluación. */
  private int numEvaluaciones;

  /**
   * Constructor de Polinomio.
   * @param llave - La llave secreta del polinomio.
   * @param puntosMin Los puntos mínimos que pasarán por ese polinomio.
   * @param evaluaciones - Número de puntos a evaluar.
   */
  public Polinomio(String llave, int puntosMin, int evaluaciones) {
    this.llave = new BigInteger(llave, 16);
    this.puntos = puntosMin - 1;
    this.numEvaluaciones = evaluaciones;
    this.coeficientes = coeficientes();
  }

  /*
   * Método coeficientes.
   * Genera aleatoriamente los coeficientes del polinomio.
   * Regresa un arreglo con los coeficientes del polinomio.
   */
  private BigInteger[] coeficientes() {
    BigInteger[] numeros = new BigInteger[this.puntos+1];
    for (int i = 0; i<numeros.length-1; i++) {
      numeros[i] = new BigInteger(256, new SecureRandom());
    }
    numeros[numeros.length-1] = this.llave;
    return numeros;
  }

  /**
   * Método evaluaHorner.
   * @return ArrayList<BigInteger> Las n parejas ordenadas.
   */
  public ArrayList<BigInteger> evaluaHorner() {
    ArrayList<BigInteger> parejas = new ArrayList<BigInteger>();

    for (int i = 1; i<=numEvaluaciones; i++) {
      BigInteger abcisa = new BigInteger(String.valueOf(i));
      parejas.add(abcisa);
      BigInteger ordenada = auxiliarHorner(i);
      parejas.add(ordenada);
    }

    return parejas;

  }

  /*
   * Método auxiliarHorner que realiza la evaluación en el polinomio
   * del punto recibido.
   */
  private BigInteger auxiliarHorner(int aEvaluar){
    BigInteger numero = new BigInteger(String.valueOf(aEvaluar));
    BigInteger resultado = new BigInteger("0");
    for (int i = 0; i<coeficientes.length; i++) {
      BigInteger mult = resultado.multiply(numero);
      BigInteger multModulo = mult.mod(modulo);
      BigInteger suma = multModulo.add(coeficientes[i]);
      BigInteger sumaMod = suma.mod(modulo);
      resultado = sumaMod;
    }
    return resultado;
  }

}
