package com.MyP.proyecto;

import java.lang.IllegalArgumentException;
import java.math.BigInteger;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase Descifrado.
 * Se encarga de descifrar un archivo dadas t entradas
 * que ingrese el usuario.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Descifrado {

  /* Constructor privado para evitar instanciación. */
  public Descifrado() {}

  /**
   * Método que calcula cada Pi(x) usando el método de Lagrange.
   * En el caso de este proyecto, x = 0.
   * @param x La variable en la que estamos evaluando.
   * @param ordenadas El arreglo de todas las ordenadas para
   *                  calcular el resultado.
   * @param modsz El módulo del campo en el que estamos.
   * @return BigInteger[] El arreglo que en cada entrada i está
   *                  el resultado obtenido de Pi(x).
   */
  public static BigInteger[] multiplicaciónLagrange(
          BigInteger x, BigInteger[] ordenadas, BigInteger modsz){
    BigInteger resultado = new BigInteger("1");
    BigInteger[] pI = new BigInteger[ordenadas.length];

    for(int i = 0; i<ordenadas.length; i++){
      for (int j = 0; j < ordenadas.length; j++){
        if(i != j){
          BigInteger dividendo = x.add(ordenadas[i].negate()).mod(modsz);
          BigInteger divisor = ordenadas[i].add(ordenadas[j].negate()).modInverse(modsz);

          BigInteger división = dividendo.multiply(divisor).mod(modsz);

          resultado.multiply(división);
        }
      }
      pI[i] = resultado;
      resultado = new BigInteger("1");
    }
    return pI;
  }

  /**
   * Método que calcula el término independiente del polinomio
   * de Lagrange. La longitud de ambos arreglos debe ser la misma.
   * @param abscisas Arreglo con todos las evaluaciones de cada punto.
   * @param pI Arreglo que contiene las Pi(x).
   * @param modsz Módulo del campo en el que se está trabajando.
   * @throws Exception si los arreglos dados no tienen la misma logitud.
   * @return Regresa la suma del producto de cada abscisa con su
   * correspondiente Pi(x). Si x = 0, regresa el valor de la llave
   * de cifrado.
   */
  public static BigInteger polinomioLagrange(BigInteger[] abscisas,
                                             BigInteger[] pI,
                                             BigInteger modsz) throws Exception{
    if(abscisas.length != pI.length){
      throw new Exception("La longitud de los arreglos no coincide");
    }

    BigInteger resultado = new BigInteger("0");

    for (int i = 0; i < pI.length; i++){
      resultado.add(abscisas[i].multiply(pI[i]));
    }
    return resultado.mod(modsz);
  }


  /**
   * Método descrifra que desencripta la línea de texto recibida.
   * @param llave Clave segura para desencriptar.
   * @param linea Texto a desencriptar.
   * @return Texto desencriptado.
   */
  public String descifra(String llave, String linea) throws Exception {
    /* De String hexadecimal a arreglo de tipo byte. */
     /* Código de: https://www.codercrunch.com/question/
     1029223515/how-convert-hex-string-bytes-and-viceversa-java */
     byte[] datos = new byte[llave.length() / 2];
     for (int i = 0; i < datos.length; i++) {
       datos[i] = (byte) Integer.parseInt(llave.substring(2 * i, 2 * i + 2), 16);
     }

     /* Desciframos el texto. */
     Cipher modo = Cipher.getInstance("AES");
     SecretKeySpec secreto = new SecretKeySpec(datos, "AES");
     modo.init(Cipher.DECRYPT_MODE, secreto);
     byte[] prim = Base64.getDecoder().decode(linea.getBytes("UTF-8"));
     byte[] linBytes = modo.doFinal(prim);
     String linDecript = new String(linBytes,"UTF-8");

     return linDecript;
  }

}
