public class Nodo<T> {

  public T dato;
  public Nodo<T> siguiente;

  public Nodo(T dato) {
    this.dato = dato; siguiente = null;
  }

  // Insertar
  public void insertar(Nodo<T> lista, T elemento){
    Nodo<T> ultimoNodo = new Nodo<T>(elemento);
    while(lista.siguiente != null){
      lista = lista.siguiente;
    }
    lista.siguiente = (Nodo<T>) ultimoNodo;
  }

  // Calcular número de datos en l, = longitud
  public int longitud(Nodo<T> lista){
    int longitud = 0;
    while(lista != null){
      lista = lista.siguiente;
      longitud++;
    }
    return longitud;
  }

}
