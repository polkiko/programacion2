package acotados;

public interface Lista<E> {
  /**
   * Coloca un nuevo elemento "element" en la posición "insertIndex"
   * de la lista.
   */
  void add(int insertIndex, E element);

  /**
   * Devuelve el elemento de la lista en la posición "getIndex".
   */
  E get(int getIndex);

  /**
   * Devuelve la posición ocupada por el primer elemento de lista
   * igual a "search" (se usa "equals" para hacer la comparación).
   */
  int indexOf(E search);

  /**
   * Elimina de la lista el primer elemento que sea igual a
   * "element" (se usa "equals" para hacer la comparación).
   */
  boolean remove(E element);

  /**
   * Elimina de la lista el elemento que ocupa la posición
   * "removalIndex".
   */
  void removeElementAt(int removalIndex);

  /**
   *  Coloca el elemento "element" en la posición "insertIndex"
   *  (sobreescribiendo el elemento que ocupara dicha posición).
   */
  void set(int insertIndex, E element);

  /**
   * Devuelve el número de elementos en la lista.
   */
  int size();

  /**
   * Indica si la lista está llena.
   */
  boolean isFull();
}
