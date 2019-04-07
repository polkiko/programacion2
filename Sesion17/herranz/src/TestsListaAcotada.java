import acotados.Lista;
import acotados.ListaAcotada;

public class TestsListaAcotada {
  public static void main(String[] args) {
    final int N = 10;
    Lista<String> l = new ListaAcotada<String>(N);
    assert l.size() == 0 : "La lista debería estar vacía al crearla";
    assert !l.isFull() : "La lista no debería estar llena  al crearla";

    // Prueba sencilla añadiendo un elemento y luego borrándolo por el
    // camino comprobamos propiedades básicas
    boolean borrado;
    l.add(0,"Hola");
    assert l.size() == 1;
    assert !l.isFull();
    assert "Hola".equals(l.get(0));
    borrado = l.remove("Adios");
    assert !borrado;
    borrado = l.remove("Hola");
    assert borrado;

    // Prueba de llenado de la lista
    assert l.size() == 0;
    for (int i = 0; i < N; i++) {
      String datoi = "Dato-" + i;
      l.add(0, datoi);
    }
    assert l.isFull();

    // Prueba de que la lista se ha llenado correctamente
    assert l.size() == N;
    for (int i = 0; i < N; i++) {
      String datoi = "Dato-" + i;
      assert datoi.equals(l.get(i));
    }
    assert l.size() == N : "get() no debe cambiar size()";

  }
}
