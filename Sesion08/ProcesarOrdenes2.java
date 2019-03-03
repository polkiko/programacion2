import java.util.Scanner;

public class ProcesarOrdenes2 {
  public static void main(String[] args) {

    // Se crea un objeto Scanner para poder leer de la entrada estándar
    Scanner stdin = new Scanner(System.in);

    // Se declara un array de canciones con el maximo
    Playlist playlist = new Playlist();

    // Variables auxiliares
    int i = 0; // Contador
    String t;
    String a;
    int v;

    // Leer órdenes hasta que no haya más datos en la entrada estándar
    while (stdin.hasNext()) {
      String o = stdin.nextLine(); // Leemos la primera orden
      switch (o) {
      case "a": // Añadir canción
        t = stdin.nextLine();
        a = stdin.nextLine();
        v = stdin.nextInt();
        stdin.nextLine();
        playlist.add(t, a, v);
      break;

      case "r": // Borrar cancion
        String titulo = stdin.nextLine();
        playlist.remove(titulo);
      break;

      }
    }
    // Imprimir la playlist
    playlist.imprimir();
  }
}
