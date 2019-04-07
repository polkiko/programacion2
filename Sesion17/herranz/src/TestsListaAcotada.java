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

  }
}
