/**
 * Test de Racional.java. Este fichero nos servirá para hacer los test
 * de nuestra clase 'Racional'
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
		System.out.println(r1); // Imprimio r1
	}
}
