package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Cifrado;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Pruebas unitarias para la clase Cifrado.
 */
public class TestCifrado {

  /**
   * Prueba unitaria para el método cifra.
   */
  @Test public void TestCifra() {
    String constrasenaDebil = "ark123h23";
    String contrasenaFuerte = null;

    try {
      MessageDigest digestion = MessageDigest.getInstance("SHA-256");
      digestion.reset();
      digestion.update(constrasenaDebil.getBytes("utf8"));
      byte[] bytesContrasena = digestion.digest();
      contrasenaFuerte = String.format("%064x", new BigInteger(1, digestion.digest()) );
    } catch(Exception e) {
      e.printStackTrace();
    }

    BigInteger bonito = new BigInteger(contrasenaFuerte, 16);
    String numDecimal = bonito.toString();
    byte[] bytes = decodeHex(bonita.toCharArray());
    String mejor = new String(bytes, "UTF-8");


    String mierd = "https://medium.com/el-acordeon-del-programador/encriptaci%C3%B3n-aes-en-java-ebb81ddf82b";
    String limpio = "";
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      SecretKeySpec secret = new SecretKeySpec(mejor.getBytes(), "AES");
      cipher.init(Cipher.ENCRYPT_MODE, secret);
      byte[] encipt = cipher.doFinal(mierd.getBytes());
      limpio = new String(Base64.getEncoder().encode(encipt));
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println(limpio);
    Assert.assertTrue();
  }
}
