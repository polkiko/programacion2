/**
 * Crea instancias de un circulo
 *
 * @author Jesus Jerez
 */

package geometria;

import java.lang.Math;

class Circulo{

  private int r; // Radio del círculo

  private Circulo(){
    // No puede existir un círculo sin radio
  }

  /**
	 * Crea el circulo de radio r
	 *
	 * @param radio Radio del círculo
	 */
  Circulo(int radio){
    r = radio;
  }

  /**
	 * Devuelve el área del circulo
	 *
	 * @return Area del circulo
	 */
  public double areaCirculo(){
    return Math.PI * Math.pow(r,2);
  }

  /**
   * Devuelve el perímetro del círculo
   *
   * @return Perímetro del círculo
   */
  public double perimetroCirculo(){
    return 2 * Math.PI * r;
  }

  /**
   * Devuelve el radio del círculo
   *
   * @return Radio del círculo
   */
  public int get_radio(){
    return r;
  }
}
