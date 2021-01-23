package com.MyP.proyecto;

import java.math.BigInteger;
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
  String modS = "208351617316091241234326"
                + "7463121244482512355622"
                + "26470491514186331217050270460481";
  private BigInteger modulo = new BigInteger(modS);

  /**
   * Constructor privado para evitar instanciación.
   */
  protected Interpolacion() {}

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

    ArrayList<BigInteger> valoresX = new ArrayList<>();
    ArrayList<BigInteger> valoresY = new ArrayList<>();
    int contador = 1;

    /* Separamos las parejas ordenadas. */
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
    return resultado.toString(16);

  }

  /**
   * Método auxiliar base, que evalua la base del polinomio
   * para ese valor.
   * Recibe la lista de valores de x.
   * Devuelve las bases del polinomio.
   */
  private ArrayList<BigInteger> base(ArrayList<BigInteger> valoresDeX) {
    ArrayList<BigInteger> bases = new ArrayList<>();

    for (int i = 0; i<valoresDeX.size(); i++) {
      BigInteger numerador = BigInteger.ONE;
      BigInteger denominador = BigInteger.ONE;
      BigInteger xElegida = valoresDeX.get(i);

      for (BigInteger equis : valoresDeX) {

        if (valoresDeX.indexOf(equis) == i) {
          continue;
        }

        numerador = numerador.multiply(equis);

        BigInteger restaDen = xElegida.subtract(equis);
        denominador = denominador.multiply(restaDen);
      }

      BigInteger numeradorMod = numerador.mod(modulo);
      BigInteger denominadorMod = denominador.mod(modulo);
      BigInteger enModulo = denominadorMod.modInverse(modulo);
      BigInteger baseComp = numeradorMod.multiply(enModulo);
      bases.add(baseComp);

    }

    return bases;

  }

}
