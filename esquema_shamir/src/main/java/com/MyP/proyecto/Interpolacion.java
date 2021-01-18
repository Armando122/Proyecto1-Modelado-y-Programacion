package com.MyP.proyecto;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Clase Interpolacion.
 * Clase encargada de obtener una clave segura a partir de t puntos.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Interpolacion {

  /* Primo grande para trabajar modulo. */
  private BigInteger modulo = new BigInteger(
          "2083516173160912412343267463121244482512355622
          26470491514186331217050270460481");

  /**
   * Constructor privado para evitar instanciación.
   */
  private Interpolacion() {}

  /**
   * Método reconstruye.
   * Recupera la clave segura a partir de t puntos.
   *
   * NO SE GARANTIZA SU FUNCIONAMIENTO SI SE RECIBEN MENOS
   * DE LOS t PUNTOS INICIALES ESTABLECIDOS POR EL USUARIO.
   *
   * @param parejas Al menos t parejas ordenadas.
   * @return String - La llave para desencriptar.
   */
  public String reconstruye(ArrayList<BigInteger> parejas) {

    ArrayList<BigInteger> valoresX = new ArrayList<BigInteger>();
    ArrayList<BigInteger> valoresY = new ArrayList<BigInteger>();
    int contador = 1;

    for (BigInteger cordenada : parejas) {
      if (contador % 2 == 1) {
        valoresX.add(cordenada);
      } else {
        valoresY.add(cordenada);
      }
      contador += 1;
    }

    ArrayList<BigInteger> bases = base(valoresX);
    BigInteger resultado = BigInteger.ZERO;

    for (int i = 0; i<valoresY.size(); i++) {
      BigInteger valorY = valoresY.get(i);
      BigInteger valorB = bases.get(i);
      BigInteger productoxY = valorY.multiply(valorB);
      BigInteger prodMod = productoxY.mod(modulo);

      resultado = resultado.add(prodMod);
    }

    resultado = resultado.mod(modulo);
    String llavecita = resultado.toString(16);
    return llavecita;

  }

  /*
   * Método auxiliar base, que evalua la base del polinomio
   * para ese valor.
   * Recibe la lista de valores de x.
   * Devuelve las bases del polinomio.
   */
  private ArrayList<BigInteger> base(ArrayList<BigInteger> valoresDeX) {
    ArrayList<BigInteger> bases = new ArrayList<BigInteger>();

    for (int i = 0; i<valoresDeX.size(); i++) {
      BigInteger numerador = BigInteger.ONE;
      BigInteger denominador = BigInteger.ONE;
      BigInteger xElegida = valoresDeX.get(i);

      for (BigInteger equis : valoresDeX) {

        if (valoresDeX.indexOf(equis) == i) {
          continue;
        }

        BigInteger cero = BigInteger.ZERO;
        BigInteger resta = cero.subtract(equis);
        numerador = numerador.multiply(equis);

        BigInteger restaDen = xElegida.subtract(equis);
        denominador = denominador.multiply();
      }

      BigInteger numeradorMod = numerador.mod(modulo);
      BigInteger denominadorMod = denominador.mod(modulo);
      BigInteger enModulo = denominador.modInverse(modulo);
      BigInteger baseComp = numeradorMod.multiply(enModulo);
      bases.add(baseComp);

    }

  }

}
