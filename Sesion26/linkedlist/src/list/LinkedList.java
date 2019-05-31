package list;

import node.Node;

/**
 * Implementación de un TAD Lista
 * basada en una cadena simplemente enlazada
 */
public class LinkedList<E> implements ListInterface<E> {

  private Node<E> head;
  private int nElems;

  /**
   * Construye una lista vacía
   *
   * <br><B>PRE:</B> Cierto
   * <br><B>POST:</B> crea una lista vacía.
   *
   */
  public LinkedList(){
    head = null;
    nElems = 0;
  }

  /**
   * Coloca un nuevo elemento en la posición insertIndex
   *
   * <br><B>PRE:</B> insertIndex EN {0..size()}
   * <br><B>POST:</B> devuelve la lista this con element en la pos insertIndex
   * y los elementos que antes estaban en pos &gt;=insertIndex, ahora en pos+1.
   *
   * @throws IndexOutOfBoundsException
   */
  public void add(int insertIndex, E element) throws IndexOutOfBoundsException {
    if (insertIndex < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (head == null) {
      if (insertIndex != 0) {
        throw new IndexOutOfBoundsException();
      }
      head = new Node<E>(element);
    }
    else if (insertIndex == 0) {
      head = new Node<E>(element, head);
    }
    else {
      Node<E> aux = head;
      for (int i = 0; i < insertIndex - 1 && aux != null; i++) {
        aux = aux.next();
      }
      if (aux == null) {
        throw new IndexOutOfBoundsException();
      }
      aux.setNext(new Node<E>(element, aux.next()));
    }
  }

  /**
   * Lectura indexada de una posición de la lista
   *
   * <br><B>PRE:</B> insertIndex EN {0..size()-1}
   * <br><B>POST:</B> devuelve una ref al elemento que está en la pos index.
   *
   * @throws IndexOutOfBoundsException
   */
  public E get(int getIndex) throws IndexOutOfBoundsException {
    if (getIndex < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> aux = head;
    for(int i = 0; i < getIndex && aux != null; i++) {
      aux = aux.next();
    }
    if (aux == null) {
      throw new IndexOutOfBoundsException();
    }
    return aux.element();
  }

  /**
   * No. de elementos en la lista
   *
   * <br><B>PRE:</B> cierto
   * <br><B>POST:</B> devuelve el no. de elems que hay en la lista.
   */
  public int size() {
    int size = 0;
    Node<E> aux = head;
    while (aux != null) {
      size++;
      aux = aux.next();
    }
    return size;
  }

  /**
   * Escritura indexada en una posición de la lista
   *
   * <br><B>PRE:</B> insertIndex EN {0..size()-1}
   * <br><B>POST:</B> coloca element en la posición insertIndex de la lista destruyendo
   * el elemento que había en esa posición.
   *
   * @throws IndexOutOfBoundsException
   */
  public void set(int insertIndex, E element) throws IndexOutOfBoundsException {
    if (insertIndex < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> aux = head;
    for(int i = 0; i < insertIndex && aux != null; i++) {
      aux = aux.next();
    }
    if (aux == null) {
      throw new IndexOutOfBoundsException();
    }
    aux.setElem(element);
  }

  /**
   * Posición de un elemento dentro de la lista
   *
   * <br><B>PRE:</B> Cierto
   * <br><B>POST:</B> devuelve una ref al primer elemento de la lista
   * que es igual a search (equals), o -1 si no existe ningún elemento igual a search.
   *
   */
  public int indexOf(E search) {
    int i = 0;
    Node<E> aux = head;
    while (aux != null && !search.equals(aux.element())) {
      aux = aux.next();
      i++;
    }
    if (aux == null) {
      return -1;
    }
    else {
      return i;
    }
  }

  /**
   * Extracción de un elemento de la lista dada su posición
   *
   * <br><B>PRE:</B> removalIndex EN {0..size()-1}
   * <br><B>POST:</B> extrae el elemento que está en la pos removalIndex.
   *
   * @throws IndexOutOfBoundsException
   */
  public void removeElementAt(int removalIndex) throws IndexOutOfBoundsException {
    if (head == null || removalIndex < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (removalIndex == 0) {
      head = head.next();
    }
    else {
      Node<E> aux = head;
      for(int i = 0; i < removalIndex - 1 && aux.next() != null; i++) {
        aux = aux.next();
      }
      if (aux.next() == null) {
        throw new IndexOutOfBoundsException();
      }
      aux.setNext(aux.next().next());
    }
  }

  /**
   * Extracción de un elemento de la lista dado un elemento igual (equals)
   *
   * <br><B>PRE:</B> cierto
   * <br><B>POST:</B> extrae el primer elemento que sea igual a element (equals) y devuelve cierto,
   * si existe. Y si no existe, devuelve falso.
   *
   */
  public boolean remove(E element) {
    boolean removed = false;
    if (head != null) {
      if (element.equals(head.element())) {
        head = head.next();
        removed = true;
      }
      else {
        Node<E> aux = head;
        while (aux.next() != null && !element.equals(aux.next().element())) {
          aux = aux.next();
        }
        if (aux.next() != null) {
          aux.setNext(aux.next().next());
          removed = true;
        }
      }
    }
    return removed;
  }

  /**
   * Devuelve un string con los elementos de la lista
   *
   * <br><B>PRE:</B> Cierto
   * <br><B>POST:</B> devuelve un string con los elementos de la lista separados
   * por comas.
   */
  public String toString() {
    Node<E> aux = head;
    String resultado = "[ ";
    if (aux != null) {
      resultado += aux.element().toString();
      aux = aux.next();
    }
    while (aux != null) {
      resultado += ", " + aux.element().toString();
      aux = aux.next();
    }
    resultado += " ]";
    return resultado;
  }

  /**
   * Igualdad de listas
   *
   * <br><B>PRE:</B> Cierto
   * <br><B>POST:</B> indica si obj es igual a this. Dos listas son iguales
   * si las secuencias de objetos almacenados en ellas son iguales. Cada par de objetos
   * son comparados con el método equals de la clase a la que pertenecen estos objetos.
   *
   */
  @SuppressWarnings("unchecked")
  public boolean equals(Object obj) {
    try {
      Node<E> head2 = ((LinkedList<E>)obj).head;
      Node<E> head1 = head;
      boolean equals = true;
      while(equals && head1 != null && head2 != null) {
        equals = head1.element().equals(head2.element());
        head1 = head1.next();
        head2 = head2.next();
      }
      return equals;
    }
    catch (Exception e) {
      return false;
    }
  }
}
