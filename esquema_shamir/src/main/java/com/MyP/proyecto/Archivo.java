package com.MyP.proyecto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.lang.NullPointerException;

/**
 * Clase Archivo.
 * Clase encargada de leer el archivo recibido y guardar el archivo recibido.
 * @version 1.0
 * @author Armando ramírez González.
 * @author Cecilia Villatoro Ramos.
 */
public class Archivo {

  /* Constructor privado para evitar instanciación. */
  private Archivo() {}

  /**
   * Método leerArchivo que lee un archivo recibido.
   * @param ruta La ruta del archivo.
   * @return ArrayList<String> Las lineas del archivo en un arreglo.
   * @throws IOException Si no se encuentra el archivo.
   */
  public ArrayList<String> leerArchivo(String ruta) throws IOException {}

  /**
   * Método guardaArchivo que guarda el archivo recibido.
   * @param archivo Las líneas del archivo.
   */
  public void guardaArchivo(ArrayList<String> archivo) {
    //Codigo
  }

}
