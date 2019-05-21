/**
 * Interfaz genérico para PilasAcotadas
 */

public interface PilaAcotada<T> {

  // Se declaran los métodos junto con las excepciones que pueden provocar
  void apilar(T dato) throws PilaAcotadaLlena;

  T cima() throws PilaAcotadaVacia;

  void desapilar() throws PilaAcotadaVacia;

  boolean llena();

  boolean vacia();
  
}
