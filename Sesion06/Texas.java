/**
 * En revisión
 * ¡IMPORTANTE!
 *
 * @author Jesus Jerez
 */

class Texas{
	public static void main(String[] args){
		Naipe[] cartas;
		cartas = new Naipe[5];

		cartas[0] = new Naipe("picas", "as");
		cartas[1] = new Naipe("picas", "rey");
		cartas[2] = new Naipe("picas", "dama");
		cartas[3] = new Naipe("picas", "valet");
		cartas[4] = new Naipe("picas", "diez");


		System.out.println("Palo: " + cartas[0].palo());

	}
}
