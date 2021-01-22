package com.MyP.proyecto;

import com.MyP.proyecto.Archivo;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Pruebas unitarias de la clase Archivo.
 */
public class TestArchivo {

  /**
   * Prueba unitaria para el método leerArchivo.
   */
  @Test public void testLeerArchivo() {
    ArrayList<String> exito = new ArrayList<String>();
    try {
      exito = Archivo.leerArchivo("archivo.txt");
    } catch(Exception e) {
    }
  }

  /**
   * Prueba unitaria para el método guardaArchivo.
   */
  @Test public void testGuardaArchivo() {
    ArrayList<String> auxiliar = new ArrayList<String>();
    try {
      Archivo.guardaArchivo("", auxiliar);
    } catch(Exception e) {
    }
  }

}
