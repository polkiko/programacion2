/**
 * Crea instancias de un punto representado en 2D
 *
 * @author Jesus Jerez
 */

public class Punto2D{

	private double x;
	private double y;

	Punto2D(double x, double y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return "(" + x + "," + y + ")";
	}

}
