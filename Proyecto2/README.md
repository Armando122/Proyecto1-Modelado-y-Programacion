# Cálculo del índice de Cobertura Nubosa (CCI)

Programa en java (Java 14) que recibe una imagen en formato .jpeg y devuelve el índice de cobertura nubosa de la imagen (CCI).

### Autores

Proyecto realizado por:

* Armando Ramírez González.

* Cecilia Villatoro Ramos.

### Entrada

La entrada del programa es el nombre de una imagen en formato `.jpg` de 4,368 píxeles de ancho y 2,912 píxeles de alto. La imagen del cielo se encuentra en un círculo de centro (2184,1456) y de radio aproximado de 1324 píxeles contenida en el rectángulo de cada imagen.

El programa recibe en la entrada estándar los archivos de imagen. Las siguientes entradas son válidas para el programa:

```
java -jar target/Proyecto2.jar Nubes_11773.jpg S
java -jar target/Proyecto2.jar Nubes_11773.jpg s
java -jar target/Proyecto2.jar Nubes_11773.jpg
```

Donde `Nubes_11773.jpg` es la imagen y la etiqueta `s` le indica al programa si debe entregarse el archivo en blanco y negro con las nubes en blanco y el cielo negro.

### Salida

Se debe entregar en la salida estándar el índice de cobertura nubosa.

Si además el programa recibió la etiqueta `s` se generará una imagen en formato jpg o png con las nubes en blanco y el cielo negro el nombre del archivo debe contener el nombre del archivo de entrada además con el sufijo `-seg`. Ejemplo si se recibe el archivo `Nube 11773.jpg` el programa devuelve el archivo `Nube 11773-seg.jpg` o `Nube 11773-seg.png`.

## Bibliotecas utilizadas

Se usaron las bibliotecas de Java:

* [BufferedImage](https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html).
* [File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html).
* [ImageIO](https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html).
* [Color](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html).
* [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

## Para compilar y correr el código

Para compilar el código debe escribirse:

```
mvn compile
```

Una vez compilado debe escribirse:

```
mvn install
```

Una vez instalado para ejecutar el código debe escribirse:

```
java -jar target/Proyecto2.jar imagen.jpg
```

o si se quiere obtener la imagen segmentada debe escribirse:

```
java -jar target/Proyecto2.jar imagen.jpg S
```

o

```
java -jar target/Proyecto2.jar imagen.jpg s
```

Por ejemplo:

```
java -jar target/Proyecto2.jar CloudCoverageImgs/11839.jpg s
```

## Para correr las pruebas

Para ejecutar las pruebas debe compilarse el proyecto haciendo.

```
mvn compile
```

Después escribir.

```
mvn test
```

Lo que ejecutará las pruebas del código.

## Documentación

Para generar la documentación debe escribirse:

```
mvn site
```

## Enlace del repositorio

https://github.com/Armando122/Proyectos-Modelado-y-Programacion/tree/master/Proyecto2.



