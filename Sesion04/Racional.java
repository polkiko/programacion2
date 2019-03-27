/**
 * Clase Racional. Crea objetos del tipo racional, que son fracciones
 * con su numerador y denominador. Además, contiene algunos métodos
 * que nos permiten realizar algunas acciones con los mismos.
 *
 * ¡IMPORTANTE! En el fichero TestRacional.java, será donde esté el test.
 *
 * @author Jesus Jerez
 */

class Racional{

	public int num;
	public int den;

	public Racional(int num, int den){
		this.num = num;
		this.den = den;
	}

	public String toString(){
		return num + "/" + den;
	}

	public void sum(Racional r2){
		num = num * r2.den + r2.num * den;
		den = den * r2.den;
		simplificar();
	}

	void simplificar(){
		int i = 2;
		while(this.num%i == 0 && this.den%i == 0){
			this.num = this.num/2;
			this.den = this.den/2;
			i++;
		}
	}
}
