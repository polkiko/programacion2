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

		// Así pues en esta sesión vamos a comenzar por crearnos un string de Naipes
		// al que llamaremos 'cartas', que tendrá espacio para almacenar 5 Naipes
		Naipe[] cartas = new Naipe[5];

		// Y ahora en cada posición del array asignamos un objeto de tipo Naipe
		cartas[0] = new Naipe("picas", "as");
		cartas[1] = new Naipe("corazones", "rey");
		cartas[2] = new Naipe("picas", "dama");
		cartas[3] = new Naipe("picas", "valet");
		cartas[4] = new Naipe("diamantes", "diez");

		System.out.println(cartas[1].palo()); // Devuelve 'corazones'

		/*********************************************************************/
		/************************ PARTE 2: ENUMERADOS ************************/
		/*********************************************************************/

		/** Tras esta primera parte, Herranz propuso una serie de ejercicios tras
		 * explicarnos qué eran los enumerados.
		 *
		 * Los enum (enumeradors) son ni más ni menos que un tipo de clase especial
		 * que nos proporciona Java que nos permiten definir una enumeración de
		 * objetos.
		 *
		 * [IMPORTANTE] Para la siguiente parte utilizaremos la clase 'Naipe_enum',
		 * la cual puedes consultar en el fichero 'Naipe_enum.java' para conocer
		 * cómo funciona.
		 */

		 // Declaro una variable array de naipes que contendrá 5 naipes
    Naipe_enum[] cartas2 = new Naipe_enum[5];

    // Y a continuación creamos 'la mejor mano del poker' utilizando enumerados
		// Como ves, los valores que pasamos van precedidos del tipo que es y un punto,
		// siendo sólo posibles aquellos que tengamos en el enumerado de la clase
		cartas2[0] = new Naipe_enum(Palo.PICAS, Valor.AS);
		cartas2[1] = new Naipe_enum(Palo.PICAS, Valor.REY);
		cartas2[2] = new Naipe_enum(Palo.PICAS, Valor.DAMA);
		cartas2[3] = new Naipe_enum(Palo.PICAS, Valor.VALET);
		cartas2[4] = new Naipe_enum(Palo.PICAS, Valor.DIEZ);

		for (int i = 0; i < cartas2.length; i++) {
      cartas2[i].imprimirPalo(); //Imprime el palo de cada carta
    }

	}

}
