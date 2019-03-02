import java.util.Scanner;

public class Playlist {

  private Cancion[] canciones; // Declaro un array de canciones como atributo
  private int i = 0; // Declaro un atributo que cuenta canciones

  Scanner stdin = new Scanner(System.in);

  public Playlist(){
    canciones = new Cancion[10];
  }

  public void add(String titulo, String a, int v){
    int i = 0;
    while (i < canciones.length && canciones[i] != null) {
       i++;
    }
    if (i < canciones.length) {
     canciones[i] = new Cancion(titulo, a, v);
    }
  }

  public void remove(String titulo){
    int i = 0;
    while (i < canciones.length && !titulo.equals(canciones[i].titulo())) {
      i++;
    }
    canciones[i] = null;

    while(canciones[i+1] != null){
      canciones[i] = canciones[i+1];
      canciones[i+1] = null;
      i++;
    }
  }

  public void imprimir(){
    int i = 0;
    for (i = 0; i < canciones.length; i++) {
        System.out.println("Posicion " + i + ": " + canciones[i]);
    }
  }


}
