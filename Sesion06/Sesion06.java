/**
 * En la sesión 6 volvimos a repasar algunos términos importantes para la programación,
 * así como buenas prácticas que deben llevarse a cabo siempre que programemos,
 * como la ocultación, que sirve para evitar que una modificación interna default:
 * nuestra clase afecte a quien la usa (y siempre pueda ser utilizada igual).
 *
 * En esta clase introducimos el concepto de API (Application Programming Interface),
 * que es un conjunto de acciones o procedimientos (recordamos, 'métodos' en la programación
 * orienta a objetos) que ofrece una biblioteca (como una clase) para ser utilizado
 * por otro programador que le permita abstraerse. Es decir, mediante la API
 * nosotros le mostramos al resto de programadores qué y cómo deben usar nuestros métodos
 * (cómo puedo construir objetos, qué métodos hay, qué parámetros necesitan...).
 *
 * Además, en esta sesión empezamos a modelizar algo un tanto más tangible.
 * Para ello, comenzamos a ver cómo podíamos representar el juego "Texas Hold'em".
 *
 * En esta primera aproximación, trataremos de representar lo que sería una carta (Naipe),
 * utilizando los conceptos vistos hasta la fecha. Para ello, comenzaríamos creando
 * una clase Naipe que representará dichas cartas, con su 'Valor' y 'Palo'.
 *
 * Consulta el fichero 'Naipe.java' para concer más sobre cómo lo implementamos.
 *
 * ¡IMPORTANTE! Revisa las transpas de Herranz correspondientes a la Sesión 06.
 *
 * ¡IMPORTANTE! Consulta el fichero 'Naipe.java' para conocer más sobre esta implementación.
 *
 *
 * @author Jesus Jerez
 */

class Sesion06 {

	public static void main(String[] args) {

		Naipe[] cartas;
		cartas = new Naipe[5];

		cartas[0] = new Naipe("picas", "as");
		cartas[1] = new Naipe("picas", "rey");
		cartas[2] = new Naipe("picas", "dama");
		cartas[3] = new Naipe("picas", "valet");
		cartas[4] = new Naipe("picas", "diez");

		System.out.println("Palo: " + cartas[0].palo());

	}

}
