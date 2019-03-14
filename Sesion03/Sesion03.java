import java.util.Scanner;

public class Sesion03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bienvenido. Cuantas canciones quieres crear?: ");
		int ncanciones = sc.nextInt();
		
		Cancion[] canciones = new Cancion[ncanciones]; /* Defino la variable canciones del tipo array
		de canciones, y le asigno el array de 5 elementos de tipo Cancion */
		
		System.out.println("Genial! Vamos a crear " + ncanciones + " canciones");
		
		
		for(int i = 0; i < ncanciones; i++){
			System.out.print("Titulo de la cancion " + (i+1) + ": ");
			String titulo = sc.nextLine();
			
			System.out.print("Interprete de la cancion " + (i+1) + ": ");
			String interprete = sc.nextLine();
			
			System.out.print("Duracion (s) de la cancion " + (i+1) + ": ");
			int duracion = sc.nextInt();
			
			canciones[i] = new Cancion(titulo, interprete, duracion);
			
		}
		
		/*Scanner sc = new Scanner(System.in);
		String titulo = sc.nextLine();*/
		
		
		// canciones[0] = new Cancion("Titulo 1", "Interpete 1", 999);

		// canciones[0].getCancion();
		// canciones[1].getCancion();

		
		
		
	}
}