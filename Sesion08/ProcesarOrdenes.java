import java.util.Scanner;

public class ProcesarOrdenes {
  public static void main(String[] args) {

    // Se crea un objeto Scanner para poder leer de la entrada estándar
    Scanner stdin = new Scanner(System.in);

    // Se declara un array de canciones con el maximo
    final int N = 10; // final indica que es una variable constante
    Cancion[] playlist = new Cancion[N];

    // Variable auxiliar para iteraciones
    int i = 0;

    // Leer órdenes hasta que no haya más datos en la entrada estándar
    while (stdin.hasNext()) {
      String o = stdin.nextLine(); // Leemos la primera orden
      switch (o) {
      case "a": // Añadir canción
        while (i < playlist.length && playlist[i] != null) {
          i++;
        }
        assert i >= playlist.length || playlist[i] == null;
        if (i < playlist.length) {
          assert playlist[i] == null;
          playlist[i] = new Cancion(stdin.nextLine(),
                                    stdin.nextLine(),
                                    stdin.nextInt());
          stdin.nextLine();
        }
        break;
      case "r": // Borrar canción
        i = 0;
        String titulo = stdin.nextLine();
        while (i < playlist.length
               && (playlist[i] == null
                   || !titulo.equals(playlist[i].titulo()))) {
          i++;
        }
        assert
          i >= playlist.length
          || (playlist[i] != null
              && titulo.equals(playlist[i].titulo()));
        if (i < playlist.length) {
          playlist[i] = null;
        }
        break;

      }
    }
    // Imprimir la playlist
    for (i = 0; i < playlist.length; i++) {
      if (playlist[i] != null) {
        System.out.println(playlist[i]);
      }
    }
  }
}
