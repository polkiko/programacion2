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

    // Prueba de cambio de un elemento
    int medio = N/2;
    l.set(medio, "Medio");
    String datoMedio = "Dato-" + medio;
    assert !datoMedio.equals(l.get(medio));
    assert "Medio".equals(l.get(5));
    String datoAnterior = "Dato-" + (medio - 1);
    assert datoAnterior.equals(l.get(medio - 1))
      : "cambiar el dato i no debe cambiar el i - 1";

    // Prueba de borrado de un elemento
    borrado = l.remove(datoMedio);
    assert borrado;
    assert l.size() == N - 1;
    for (int i = 0; i < medio; i++) {
      String datoi = "Dato-" + i;
      assert datoi.equals(l.get(i)) : "hasta el medio nada ha cambiado";
    }
    for (int i = medio; i < N; i++) {
      String datoi = "Dato-" + (i + 1);
      assert datoi.equals(l.get(i)) : "desde el medio los datos cambian";
    }

    // Prueba de borrado de un elemento por posición
    borrado = l.removeElementAt(medio);
    assert borrado;
    assert l.size() == N - 2;
    for (int i = 0; i < medio; i++) {
      String datoi = "Dato-" + i;
      assert datoi.equals(l.get(i)) : "hasta el medio nada ha cambiado";
    }
    for (int i = medio; i < N; i++) {
      String datoi = "Dato-" + (i + 2);
      assert datoi.equals(l.get(i)) : "desde el medio los datos cambian";
    }

    // Prueba de búsqueda
    for (int i = 0; i < medio; i++) {
      String datoi = "Dato-" + i;
      assert i == l.indexOf(datoi);
    }
  }
}
