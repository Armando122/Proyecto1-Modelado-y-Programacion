package com.MyP.proyecto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;

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
  public static ArrayList<String> leerArchivo(String ruta) throws IOException {
    ArrayList<String> archivo = new ArrayList<>();
    Path rutaA = Paths.get(ruta);
    for (String linea : Files.readAllLines(rutaA)) {
      archivo.add(linea);
    }
    return archivo;
  }

  /**
   * Método guardaArchivo que guarda el archivo recibido.
   * @param archivo Las líneas del archivo a guardar.
   * @param ruta - La ruta donde se guardaŕa el archivo
   */
  public static void guardaArchivo(String ruta, ArrayList<String> archivo)
   throws IOException {
       String archivoAGuardar = "";
       Path rutaGuardado = Paths.get(ruta);
       for (String linea : archivo) {
         archivoAGuardar += linea;
       }
       Files.write(rutaGuardado, archivoAGuardar.getBytes());
  }

}
