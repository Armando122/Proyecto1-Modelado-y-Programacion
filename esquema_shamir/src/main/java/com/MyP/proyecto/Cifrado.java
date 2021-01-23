package com.MyP.proyecto;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase Cifrado.
 * Se encarga de cifrar un archivo dada una constraseña segura
 * de 256 bits.
 *
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Cifrado {

  /* Constructor privado para evitar instanciación. */
  public Cifrado() {}

  /**
   * Método cifra que encripta el texto recibido.
   * @param llave Clave segura.
   * @param linea Texto a encriptar.
   * @return ArrayList<String> Texto encriptado.
   */
  public String cifra(String llave, String linea) throws Exception {

    /* De String hexadecimal a arreglo de tipo byte. */
    /* Código de: https://www.codercrunch.com/question/
    1029223515/how-convert-hex-string-bytes-and-viceversa-java */
    byte[] datos = new byte[llave.length() / 2];
    for (int i = 0; i < datos.length; i++) {
      datos[i] = (byte) Integer.parseInt(llave.substring(2 * i, 2 * i + 2), 16);
    }

    /* Ciframos el texto. */
    Cipher modo = Cipher.getInstance("AES/ECB/PKCS5Padding");
    SecretKeySpec secreto = new SecretKeySpec(datos, "AES");
    modo.init(Cipher.ENCRYPT_MODE, secreto);
    byte[] linBytes = modo.doFinal(linea.getBytes("UTF-8"));

    return Base64.getEncoder().encodeToString(linBytes);
  }

}
