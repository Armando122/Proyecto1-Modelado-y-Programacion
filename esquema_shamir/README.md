# Esquema de Secreto Compartido de Shamir

Programa que implementa el esquema de Shamir para compartir la clave necesaria para descifrar un archivo que suponemos contiene información confidencial. Está información puede ser accedida siempre que estén presentes al menos u, de los n miembros de un grupo de personas con autorización para acceder a ella.

A partir de un archivo, se genera una versión confidencial de él. Mediante el mecanismo AES (Advenced Encryption Standar). El documento original es cifrado por una contraseña que porporciona el usuario. A partir de esa contraseña se genera la clave de cifrado K, con la que se cifra el documento. Además el programa devuelve el documento cifrado y las n evaluaciones del polinomio. Si se logran reunir al menos t <= n de esas personas, el programa puede descifrar el documento cifrado.

### Autores

Proyecto realizado por:

* Armando Ramírez González - 317158225.

* Cecilia Villatoro Ramos - 419002938.

### Entrada

El programa tiene dos modalidades de entrada, una para cifrar y otra para descifrar

### Cifrar

En la línea de comandos se debe proporcionar:
* La opción c.

* El nombre de archivo donde se guardarán las n evaluaciones del polinomio.

* El número total de evaluaciones requeridas(n > 2).

* El número mínimo de puntos necesarios para descifrar(1 < t <= n).

* El nombre del archivo del documento original.

Ejemplo:

```
java -jar target/EsquemaShamir.jar c archivo.txt 15 10 archivo.pdf
```

Durante la ejecución de esta opción se le solicitará al usuario una contraseña.

### Descifrar

En la línea de comando debe proporcionarse:

* La opción d.

* EL nombre de archivo con, al menos, t de las n evaluaciones del polinomio.

* El nombre del archivo cifrado.

Ejemplo:

```
java -jar target/EsquemaShamir.jar d evaluaciones.txt archivoCifrado.txt
```

### Salida

En caso de que la entrada haya sido con la opción c, el programa devuelve:

* Un archivo con el documento cifrado.

* El archivo con n parejas.

En caso de que la entrada haya sido con la opción d, el programa devuelve:

* El archivo con el documento claro y con el nombre original.

## Bibliotecas utilizadas

Se usaron las bibliotecas de Java:

* [BigInteger](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html).

* [MessageDigest](https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html).

* [SecureRandom](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html).

* [Base64](https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html).

* [SecretKeySpec](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/javax/crypto/spec/SecretKeySpec.html).

* [Cipher](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/javax/crypto/Cipher.html).

* [Console](https://docs.oracle.com/javase/7/docs/api/java/io/Console.html).

## Para compilar y correr el código

Para compilar el código debe escribirse:

```
mvn compile
```

Una vez compilado y que haya pasado las pruebas debe escribirse:

```
mvn install
```

Una vez instalado para ejecutar el código debe escribirse:

```
java -jar target/EsquemaShamir.jar {INSTRUCCIONES}
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

## Enlace del repositorio

https://github.com/Armando122/Proyectos-Modelado-y-Programacion/tree/master/esquema_shamir

## Documentación

Para generar la documentación debe escribirse:

```
mvn site
```





