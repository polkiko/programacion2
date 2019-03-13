/**
 * Crea instancias de un cuadrado
 *
 * @author Jesus Jerez
 */

package geometria;

public class Cuadrado{

  private int base;
  private int altura;

  private Cuadrado(){
    // No puede existir un cuadrado sin ninguna medida
  }

  /**
	 * Crea el cuadrado de base x y altura y
	 *
	 * @param x Base del cuadrado
	 * @param y Altura del cuadrado
	 */
  public Cuadrado(int x, int y){
    base = x;
    altura = y;
  }

  /**
	 * Devuelve el área del cuadrado
	 *
	 * @return Area del cuadrado
	 */
  public int areaCuadrado(){
    return base * altura;
  }

  /**
	 * Devuelve el perímetro del cuadrado
	 *
	 * @return Perímetro del cuadrado
	 */
  public int perimetroCuadrado(){
    return base*2 + altura*2;
  }

  /**
	 * Devuelve la base
	 *
	 * @return Base del cuadrado
	 */
  public int get_Base(){
    return base;
  }

  /**
	 * Devuelve la altura
	 *
	 * @return Altura del cuadrado
	 */
  public int get_Altura(){
    return altura;
  }

  /**
	 * Imprime el cuadrado
	 *
	 */
  public void printCuadrado(){
    System.out.println("El cuadrado es de " + base + "x" + altura + ": ");
    for(int i = 0; i < altura; i++){
      for(int j = 0; j < base; j++){
        System.out.print("+ ");
      }
      System.out.println();
    }
  }
}
