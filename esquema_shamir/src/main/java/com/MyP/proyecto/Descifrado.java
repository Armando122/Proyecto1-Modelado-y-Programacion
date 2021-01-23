package com.MyP.proyecto;

import java.nio.charset.StandardCharsets;
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
   * Método descrifra que desencripta la línea de texto recibida.
   * @param llave Clave segura para desencriptar.
   * @param linea Texto a desencriptar.
   * @return ArrayList<String> Texto desencriptado.
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
     byte[] prim = Base64.getDecoder().decode(linea.getBytes(StandardCharsets.UTF_8));
     byte[] linBytes = modo.doFinal(prim);

     return new String(linBytes, StandardCharsets.UTF_8);
  }

}
