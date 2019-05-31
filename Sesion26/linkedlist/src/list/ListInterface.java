package list;

/**
 * Definición de un TAD Lista
 * 
 * @author jramirez
 *
 */
public interface ListInterface<E> {
	
  /**
   * Coloca un nuevo elemento en la posición insertIndex
   *
   * <br><B>PRE:</B> insertIndex EN {0..size()}
   * <br><B>POST:</B> devuelve la lista this con element en la pos insertIndex
   * y los elementos que antes estaban en pos &gt;=insertIndex, ahora en pos+1.
   * 
   * @throws IndexOutOfBoundsException 
   */
  public void add(int insertIndex, E element) throws IndexOutOfBoundsException;
	
  /**
   * Lectura indexada de una posición de la lista
   * 
   * <br><B>PRE:</B> insertIndex EN {0..size()-1}
   * <br><B>POST:</B> devuelve una ref al elemento que está en la pos index.
   * 
   * @throws IndexOutOfBoundsException 
   */ 
  public E get(int getIndex) throws IndexOutOfBoundsException;
	
  /**
   * No. de elementos en la lista
   * 
   * <br><B>PRE:</B> cierto
   * <br><B>POST:</B> devuelve el no. de elems que hay en la lista.
   */
  public int size();
	
  /**
   * Escritura indexada en una posición de la lista
   * 
   * <br><B>PRE:</B> insertIndex EN {0..size()-1}
   * <br><B>POST:</B> coloca element en la posición insertIndex de la lista destruyendo 
   * el elemento que había en esa posición.
   * 
   * @throws IndexOutOfBoundsException 
   */
  public void set(int insertIndex, E element) throws IndexOutOfBoundsException;
	
  /**
   * Posición de un elemento dentro de la lista
   * 
   * <br><B>PRE:</B> Cierto
   * <br><B>POST:</B> devuelve una ref al primer elemento de la lista
   * que es igual a search (equals), o -1 si no existe ningún elemento igual a search.
   * 
   */
  public int indexOf(E search);
	
  /**
   * Extracción de un elemento de la lista dada su posición
   * 
   * <br><B>PRE:</B> removalIndex EN {0..size()-1}
   * <br><B>POST:</B> extrae el elemento que está en la pos removalIndex.
   * 
   * @throws IndexOutOfBoundsException 
   */
  public void removeElementAt(int removalIndex) throws IndexOutOfBoundsException;
	
  /**
   * Extracción de un elemento de la lista dado un elemento igual (equals)
   * 
   * <br><B>PRE:</B> cierto
   * <br><B>POST:</B> extrae el primer elemento que sea igual a element (equals) y devuelve cierto, 
   * si existe. Y si no existe, devuelve falso.
   * 
   */ 
  public boolean remove(E element);

}
