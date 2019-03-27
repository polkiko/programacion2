/**
 * Test de Racional.java. Este fichero nos servirá para hacer los test
 * de nuestra clase 'Racional'
 *
 * En esta sesión trabajaremos con las clases, objetos y métodos.
 * Para ello realizaremos los ejercicios propuestos por Herranz.
 *
 * ¡IMPORTANTE! Consulta el fichero Racional.java, será donde esté la clase
 *
 * @author Jesus Jerez
 */

class TestRacional{
	public static void main(String[] args) {

		Racional r1; // Defino la variable 'r1' del tipo 'Racional'
		r1 = new Racional(2,6); // Instancio y asigno un Racional

		Racional r2;
		r2 = new Racional(1,3);

		// Consultar la clase Racional para conocer los métodos
		r1.sum(r2); // Sumo el racional 'r2' a 'r1'

		System.out.println(r1); // Imprimio r1. Esto se produce gracias al
		// método toString() definido en la clase Racional, lo que devuelve
		// el racional de la forma "num/den". Consultar Racional.java
	}
}
