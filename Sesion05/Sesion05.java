/**
 * En esta sesión repasamos algunos conceptos vistos hasta la fecha. En concreto,
 * fuimos definiendo los conceptos de:
 * - Clases: son 'plantillas' que nos permiten crear (instanciar) objetos
 * [EJEMPLO] public class Circulo { ... }
 *
 * - Objetos: son 'elementos' generdos a partir de una clase
 * [EJEMPLO] Circulo c = new C();
 *
 * - Referencias: dirección de memoria que apunta hacia un objeto
 *
 * - Variables: datos que pueden ser primitivos o no
 * [EJEMPLO] int x = 32;
 *
 * Recordamos que una clase está formada por:
 * - Atributos: son los 'datos' de nuestra clase. Suelen declararse como privados
 * - Métodos: son 'comportamientos' de nuestros objetos. A su vez, encontramos:
 * --- Constructor: tienen el mismo nombre que la clase. Sirven para crear
 *     (instanciar) nuevos objetos de la clase. Éste puede definirse como
 *     público o privado, en función de lo que queramos crear.
 * --- Observador: devuelve un dato, sin modificar nada del objeto.
 *     public int devolverValor{
 *        return x;
 *     }
 * --- Modificador: nos permite modificar algún dato de un objeto. Como no
 *     devuelve nada, debe estar precedido por 'void'
 * NOTA: No se recomienda en ningún caso hacer métodos 'observamodificadores'
 *
 * A partir de estas definiciones, en java emplearemos los siguientes términos
 * para referirnos a ellos:
 * Objeto = Instancia
 * Puntero = Referencia
 * Método = Mensaje
 * Invocar = Enviar mensaje
 * Clase = (contiene un)'Tipo'
 *
 * Además, en esta sesión vimos en qué consistía la ocultación y para qué
 * es bueno utilizarla en cualquier lenguaje de programación.
 *
 * También hicimos alusión a los dos 'roles' que existen a la hora de implementar
 * nuevo código.
 *
 * ¡IMPORTANTE! Revisa las transpas de Herranz correspondientes a la Sesion 05
 *
 * ¡IMPORTANTE! Consulta el fichero Punto2D.java para conocer más de la implementación
 *
 * A continuación haremos algunos ejemplos de buenas prácticas.
 *
 * @author Jesus Jerez
 */
import java.lang.Math;

class Sesion05 {

	public static void main(String[] args){

		Punto2D a;
		Punto2D b;

		// Quiero que new Punto2D(x,y) cree una instancia que represente el (x,y)
		a = new Punto2D(0,0);
		b = new Punto2D(1,-1);

		// El constructor vacío daría error en tiempo de ejecución, porque
		// hemos definido en private dicho constrcutor (en Punto2D.java)
		//   b = new Punto2D(); <-- ¡No compila!

		// Al estar los atributos x e y en privado, NO podriamos hacer algo como:
		//   a.x = 2; <-- ¡No compila!

		// Calculo la distancia entre dos puntos y la asigno a 'd'
		double d = a.distancia(b);

		// Imprimo el valor devuelto por el método observador get_X()
		System.out.println(a.get_X()); // Devuelve 0,0 (double)

		// Compruebo que está bien calculado con un assert
		System.out.println(Math.sqrt(2) == d);
		// Devuelve 'true', puesto que la distancia 'd' es igual a la raíz de 2.
	}

}
