public class Cancion {
  private String titulo;
  private String artista;
  private int valoracion;

  public Cancion(String t,
                 String a,
                 int v) {
    titulo = t;
    artista = a;
    valoracion = v;
  }
  
  public String titulo() {
    return titulo;
  }
  
  public String toString() {
    return titulo + ":"
      + artista + ":"
      + valoracion;
  }
}

