/**
 * En revisión
 *
 * ¡IMPORTANTE!
 *
 * @author Jesus Jerez
 */

class Sesion05{

	public static void main(String[] args){
		Punto2D a;
		Punto2D b;

		// Quiero que new Punto2D() cree una instancia que represente el (0,0)

		a = new Punto2D();

		// Quiero que new Punto2D(x,y) cree una instancia que represente el (x,y)

		b = new Punto2D(1, -1);

		//Voy a calcular la distancia entre los dos puntos

		double d = a.distancia(b);

		// Compruebo que está bien calculada
		System.out.println(Math.sqrt(2) == d);
	}

}
