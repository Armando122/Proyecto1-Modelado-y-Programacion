package com.MyP.proyecto;

import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

/**
 * Clase Contraseña.
 * Se encarga de generar una contraseña segura de 256 bits a través
 * de una contraseña entregada por el usuario.
 *
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Contrasena {

  /* Constructor privado para evitar instanciación.*/
  private Contrasena() {}

  /**
   * Método generaContrasena, que genera una contraseña segura de 256 bits
   * a partir de la contraseña que ingresó el usuario.
   * @param contrasenaU Contraseña que ingresó el usuario.
   * @return String Contraseña segura de 256 bits
   * @throws IllegalArgumentException Si la contraseña es vacía.
   * @throws NullPointerException Si la contraseña es nula.
   */
  public String generaContrasena(String contrasenaU) throws Exception {}
}
