/**
 * Crea instancias de un punto representado en 2D. Para ello emplearemos
 * la coordenada 'x' y la 'y', que serán los atributos de la misma.
 *
 * @author Jesus Jerez
 */
import java.lang.Math;

class Punto2D{

	// En este ejemplo, hemos añadido el modificador 'private' para que no pueda
	// ser utilizado desde fuera, y sólo sea en esta clase
	// Consultar fichero Sesion05.java para ver qué no está permitido.
	private double x;
	private double y;

 /**
	 * Constructor no permitido. Para ello hemos añadido 'private', de manera que
	 * no podrá utilizarse el constructor vacío
	 */
	private Punto2D(){
	}

	/**
	 * MÉTODO CONSTRUCTOR: Crea el punto de la forma (x,y)
	 *
	 * @param x Variable x del punto
	 * @param y Variable y del punto
	 */
	public Punto2D(double x, double y){
		this.x = x;
		this.y = y;
	}

	/**
	 * MÉTODO OBSERVADOR: Devuelve la distancia entre dos puntos dados
	 *
	 * @param p El otro punto del que calcular la distancia
	 * @return Distancia entre los dos puntos
	 */
	double distancia(Punto2D p){
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * MÉTODO OBSERVADOR: Devuelve la coordenada del eje de abscisas (x)
	 *
	 * @return coordenada x
	 */
	public double get_X(){
		return x;
	}

	/**
	 * MÉTODO OBSERVADOR: Devuelve la coordenada del eje de ordenadas (y)
	 *
	 * @return coordenada y
	 */
	public double get_Y(){
		return y;
	}

}
