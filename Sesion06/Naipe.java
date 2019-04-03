/**
 * Crea instancias de una carte de tipo Naipe, definida por sus dos principales
 * atributos 'palo' y 'valor'. En esta clase controlaremos qué palos y valores
 * son válidos mediante la comprobación con un Array.
 *
 * Consulta la implementación de Naipe_enum.java para visualizar la misma
 * implementación pero utilizando enumerados.
 *
 * @author Jesus Jerez
 */

class Naipe{

	// Atributos en privado, ocultación
	private String palo;
	private String valor;

	private Naipe(){
		// Poniendo el metodo sin argumentos 'Naipe()' precedido de private,
		// indica que el constructor vacío no puede ser utilizado, y que por
		// tanto no se pueden crear 'naipes vacíos'
	}

	public Naipe(String palo, String valor) {

		// Para el método constructor vamos a crearnos dos arrays de Strings con
		// los palos validos y los valores válidos.
		String[] palosValidos = {"corazones", "picas", "treboles", "diamantes"};
		String[] valoresValidos = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete",
															 "ocho", "nueve", "diez", "valet", "dama", "rey"};

		// A continuación iteramos para conocer si el valor pasado es válido tanto
		// para el palo como para el valor
		int i = 0;
		while (i < palosValidos.length && !palosValidos[i].equals(palo)) {
			i++;
		}

		if (i == palosValidos.length) {
			System.err.println("Palo no válido: " + palo);
			System.exit(-1); // System.exit(-1) = se rompe el programa
		}


		i = 0;
		while (i < valoresValidos.length && !valoresValidos[i].equals(valor)) {
			i++;
		}

		if (i == valoresValidos.length) {
			System.err.println("Valor no válido: " + valor);
			System.exit(-1);
		}

		this.palo = palo;
		this.valor = valor;

	}

	// Método observador que devuelve el valor del palo de un Naipe
	public String palo(){
		return palo;
	}



}
