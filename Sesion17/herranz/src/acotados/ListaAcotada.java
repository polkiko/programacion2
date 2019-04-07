package acotados;

public class ListaAcotada<E> implements Lista<E> {
  /**
   * Array con el que representamos los elementos en la lista. La
   * declaración debería ser E[] elementos pero Java no permite luego
   * crear un array donde el tipo de los elementos sea un parámetro
   * genérico (error: generic array creation). Por eso se declara como
   * array de objetos.
   */
  private Object[] elementos ;

  /**
   * Crea una lista acotada con una capacidad máxima indicada por
   * capacidadMax
   */
  public ListaAcotada(int capacidadMax) {
    elementos = new Object[capacidadMax];
  }

  public void add(int insertIndex, E element) {
    // Desplazamos todos los elementos desde insertIndex a la
    // "derecha" desde el último
    int i;
    for (i = size(); i > insertIndex; i--) {
      elementos[i] = elementos[i-1];
    }
    assert i == insertIndex;
    elementos[i] = element;
  }

  @SuppressWarnings("unchecked")
  public E get(int getIndex) {
    return (E)elementos[getIndex];
  }

  public int indexOf(E search) {
    int index = -1;
    for (int i = 0;
         i < elementos.length
           && elementos[i] != null
           && index == -1;
         i++) {
      if (elementos[i].equals(search)) {
        index = i;
      }
    }
    return index;
  }

  public boolean remove(E element) {
    int index = indexOf(element);
    boolean encontrado = index != -1;
    if (encontrado) {
      // Movemos todos los elementos a izquierda desde el índice del
      // elemento a borrar
      while (elementos[index] != null) {
        elementos[index] = elementos[index + 1];
        index++;
      }
    }
    return encontrado;
  }

  public void removeElementAt(int removalIndex) {
  }

  public void set(int insertIndex, E element) {
  }

  public int size() {
    int i = 0;
    // Buscamos la primera posición con null, ese es el tamaño de la
    // lista
    while (i < elementos.length && elementos[i] != null)
      i++;
    return i;
  }

  public boolean isFull() {
    return size() == elementos.length;
  }
}
