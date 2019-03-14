import java.util.Scanner;

public class Sesion08{
	
	public static void main(String[] args){
		
		// Se crea un objeto Scanner para poder leer la entrada estándar
		Scanner sc = new Scanner(System.in);
		
		// Se lee la primera orden
		char orden = sc.next().charAt(0);
		sc.nextLine();
		
		// Declaro un array de canciones
		Cancion[] playlist = new Cancion[10];
		
		// Leemos las canciones
		for(int i = 0; i < playlist.length; i++){
			
			System.out.println("Orden numero " + i + " >>> " + orden);
			
			if(orden == 'a'){
				String t = sc.nextLine();
				String a = sc.nextLine();
				int v = sc.nextInt();
				
				playlist[i] = new Cancion(t, a, v);
				System.out.println("Se ha puesto la cancion '" +  t + "'");
				
			}else if(orden == 'r'){
				
				String tb = sc.nextLine();
				System.out.println("Vamos a borrar: " + tb);
				
				for(int j = 0; j < playlist.length; j++){
					
					if (tb.equals(playlist[j].titulo)){
						System.out.println("Cambiamos titulo");
					}
				}
				
			}else{
				System.out.println("Orden no es igual ni a ni a r");
			}
			
			sc.nextLine();
			orden = sc.next().charAt(0);
			sc.nextLine();
		}
	}

}