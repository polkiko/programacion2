/**
 * Test de Cancion_1. Aprenderemos a instanciar objetos, y a realizar
 * una primera aproximación con el manejo de los mismos.
 *
 * ¡IMPORTANTE! Consulta el fichero Cancion_1.java, será donde esté la clase
 *
 * @author Jesus Jerez
 */

public class Sesion03_1 {
	public static void main(String[] args) {

		Cancion_1[] canciones; // Defino la variable 'canciones' de tipo array de Cancion_1
		canciones = new Cancion_1[5]; // y asigno un array de 5 elementos de tipo Cancion_1

		// A continuación vamos a crear un par de canciones

		canciones[0] = new Cancion_1(); // Instanciamos un nuevo objeto de la clase Cancion
		canciones[0].titulo = "Wish you were here"; // Y voy asignando un valor
		canciones[0].interprete = "Pink Floyd";     // a cada atributo de la misma
		canciones[0].duracion = 334;

		canciones[1] = new Cancion_1();						 // ¡RECUERDA! el punto significa
		canciones[1].titulo = "The logical song";  // "sigue la felcha", hacia dónde
		canciones[1].interprete = "Supertramp";    //apunta una dirección de memoria
		canciones[1].duracion = 255;

		// Tras esto ya tendríamos instanciados (creados) dos objetos de la clase
		// Cancion_1 con los valores asociados a cada uno de ellos. De esta manera,
		// podríamos por ejemplo imprimir por pantalla las canciones:

		System.out.println(
		"| " + canciones[0].titulo
		+ " | " + canciones[0].interprete
		+ " | " + canciones[0].duracion / 60 + "mins |"
		);

		System.out.println(
		"| " + canciones[1].titulo
		+ " | " + canciones[1].interprete
		+ " | " + canciones[1].duracion / 60 + "mins |"
		);

		// ¡Prueba a ejecutar el código!

		/** Pero, ¿te imaginas poder hacer todo esto sin tener que conocer la clase canción?
		 * Por ejemplo haciendo algo como:
		 * canciones[0] = new Cancion("Wish you were here", "Pink Floyd", 334);
		 * canciones[1] = new Cancion("The logical song", "Pink Supertramp", 255);
		 *
		 * ¿O la posibilidad de imprimir datos?:
		 * System.out.println(cancion[0].minutos());
		 * Y que la salida por pantalla  fuera:
		 * >> 2 minutos y 34 segundos
		 *
		 * [DIAPOSITIVAS] Repasar "roles" de programador
		 * [PARTE 2] Continua en Sesion03_2.java
		 *
		**/
	}
}
