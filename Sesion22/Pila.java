/**
 * Interfaz genérico para Pila
 */
public interface Pila<T> {
  void apilar(T dato);
  T cima() throws PilaVaciaException;
  void desapilar() throws PilaVaciaException;
  boolean vacia();
}
