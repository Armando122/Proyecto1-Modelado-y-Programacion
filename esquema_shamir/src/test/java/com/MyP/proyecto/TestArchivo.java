package com.MyP.proyecto;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import com.MyP.proyecto.Archivo;
import java.util.ArrayList;

/**
 * Pruebas unitarias de la clase Archivo.
 */
public class TestArchivo {

  /**
   * Prueba unitaria para el método leerArchivo.
   */
  @Test (expected = IOException.class) public void testLeerArchivo() {
    ArrayList<String> exito = new ArrayList<String>();
    exito = Archivo.leerArchivo("archivo.txt");
  }

  /**
   * Prueba unitaria para el método guardaArchivo.
   */
  @Test (expected = IOException.class) public void testGuardaArchivo() {
    Archivo.guardaArchivo(null);
  }

}
