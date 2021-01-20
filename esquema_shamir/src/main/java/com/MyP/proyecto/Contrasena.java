package com.MyP.proyecto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

/**
 * Clase Contraseña.
 * Se encarga de generar una contraseña segura de 256 bits a través
 * de una contraseña entregada por el usuario.
 *
 * @version 1.0
 * @author Cecilia Villatoro Ramos.
 * @author Armando ramírez González.
 */
public class Contrasena {

  /* Constructor privado para evitar instanciación.*/
  private Contrasena() {}

  /**
   * Método generaContrasena, que genera una contraseña segura de 256 bits
   * a partir de la contraseña que ingresó el usuario.
   * @param contrasenaU Contraseña que ingresó el usuario.
   * @return String Contraseña segura de 256 bits.
   */
  public String generaContrasena(String contrasenaU) throws Exception {
    String contSegura = null;

    MessageDigest digestion = MessageDigest.getInstance("SHA-256");
    digestion.reset();
    digestion.update(contrasenaU.getBytes("utf8"));
    byte[] dispersion = digestion.digest();
    contSegura = String.format("%064x", new BigInteger(1, digestion.digest()) );

    return contSegura;
  }

}
