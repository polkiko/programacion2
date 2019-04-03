/**
 * Crea instancias de una carte de tipo Naipe con enumerados, definida por sus dos principales
 * atributos 'palo' y 'valor'. En esta clase controlaremos qué palos y valores
 * son válidos mediante el uso de enum (enumerados).
 *
 * @author Jesus Jerez
 */

public class Naipe_enum{

  // Vamos a definir dos enumerados, para el palo y el valor
  public enum Palo {
    TREBOLES, DIAMANTES, CORAZONES, PICAS;
  }

  public enum Valor {
    AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, VALET, DAMA, REY;
  }

	// Y ponemos como atributos los nuevos enumerados
	private Palo palo;
	private Valor valor;

	private Naipe_enum(){
	}

  // Ahora nuestro método constructor deberá recibir dos parámetros de tipo
  // palo y valor, que deberemos asignar a nuestros atributos
	public Naipe_enum(Palo palo, Valor valor) {
    this.palo = palo;
    this.valor = valor;
  }

  // Método observador que devuelve el valor del palo de un Naipe
	public void imprimirPalo(){
		System.out.println(palo);
	}



}
