import acotados.Lista;
import acotados.ListaAcotada;

public class TestsListaAcotada {
  public static void main(String[] args) {
    final int N = 10;
    Lista<String> l = new ListaAcotada<String>(N);
    assert l.size() == 0 : "La lista debería estar vacía al crearla";
    assert !l.isFull() : "La lista no debería estar llena  al crearla";
  }
}
