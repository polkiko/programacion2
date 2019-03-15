/**
 * Test de Cancion_2. Aprenderemos a instanciar objetos, y a realizar
 * una primera aproximación con el manejo de los mismos.
 *
 * ¡IMPORTANTE! Consulta el fichero Cancion_2.java, será donde esté la clase
 *
 * @author Jesus Jerez
 */

public class Sesion03_2 {
	public static void main(String[] args) {

		/** En esta segunda parte introduciremos el concepto de "Creación de objeto"
		 * (instanciar una clase), por lo que te recomiendo leer el archivo Cancion_2.java
		 * detenidamente para ver los cambios
		**/

		Cancion_2[] canciones = new Cancion_2[5]; // Defino y asigno array tipo Cancion_2

		// A continuación vamos a crear un par de canciones
		// Ahora lo haremos mediante un 'comportamiento'

		canciones[0] = new Cancion_2("Wish you were here", "Pink Floyd", 334);

		// Tras esto ya tendríamos instanciado nuestra canción, y asignada a
		// la posición 0 de nuestro array canciones. De la misma manera puedo instanciar
		// y asignar nuevas caciones:
		canciones[1] = new Cancion_2("The logical song", "Supertramp", 255);
		canciones[2] = new Cancion_2("Despacito", "Luis Fonsi", 666);

		// De la misma manera podemos utilizar más 'comportamientos'

		System.out.println(canciones[2].minutos());
		// Primero ejecuta el comportamiento duracion() de cancion[2], devuelve un
		// string (Consultar Cancion_2.java para conocer qué hace el comportamiento duracion())
		// y luego ejecuta los paréntesis de prinln()

		// ¡Prueba a ejecutar el código!
	}
}
