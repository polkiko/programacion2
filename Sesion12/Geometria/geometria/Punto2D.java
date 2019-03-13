/**
 * Crea instancias de un punto representado en 2D
 *
 * @author Jesus Jerez
 */

package geometria;

public class Punto2D{

	private double x;
	private double y;

 /**
	 * Constructor vacio. Crea el punto (0,0)
	 */
	Punto2D(){
		x = 0;
		y = 0;
	}

	/**
	 * Crea el punto (x,y)
	 *
	 * @param x Variable x del punto
	 * @param y Variable y del punto
	 */
	Punto2D(double x, double y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Devuelve la distancia entre dos puntos
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
	 * Devuelve la coordenada del eje de abscisas (x)
	 *
	 * @return coordenada x
	 */
	public double get_X(){
		return x;
	}

	/**
	 * Devuelve la coordenada del eje de ordenadas (y)
	 *
	 * @return coordenada y
	 */
	public double get_Y(){
		return y;
	}

}
