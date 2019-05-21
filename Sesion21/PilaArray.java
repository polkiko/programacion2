public class PilaArray<T> implements PilaAcotada<T> {

  private T[] datos;
  private int cima;

  @SuppressWarnings("unchecked")
  public PilaArray(int capacidad) {
    datos = (T[]) new Object[capacidad];
    cima = -1;
  }

  public void apilar(T dato) throws PilaAcotadaLlena {
    cima++;
    datos[cima] = dato;
  }

  public T cima() throws PilaAcotadaVacia {
    return datos[cima];
  }

  public void desapilar() throws PilaAcotadaVacia {
    cima--;
  }

  public boolean llena() {
    return cima == datos.length - 1;
  }

  public boolean vacia() {
    return cima == -1;
  }

}
