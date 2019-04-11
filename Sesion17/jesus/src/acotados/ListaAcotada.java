package acotados;

public class ListaAcotada<E> implements Lista<E> {

  private Object[] lista;

  public ListaAcotada(int capacidad){
    lista = new Object[capacidad];
  }

  public void add(int insertIndex, E element){
    if(lista[insertIndex] == null){
      lista[insertIndex] == element;
    }else{
      for(int i=0; ;i++){
        lista[insertIndex + 1] = lista[insertIndex];
      }
    }
  }

  public E get(int getIndex){
    return (E)lista[getIndex];
  }

  public int indexOf(E search){

    int indice = 0;
    for(int i=0; i < lista.length && indice == 0; i++) {
      if(search.equals(lista[i])){
        indice = i;
      }
    }

    return indice;
  }

  public boolean remove(E element){
    boolean borrar = false;
    for(int i=0; i < lista.length && !borrar; i++) {
      if(element.equals(lista[i])){
        borrar = true;
        lista[i] = null;
      }
    }
    return borrar;
  }

  public void removeElementAt(int removalIndex){
    lista[removalIndex] = null;
  }

  public void set(int insertIndex, E element){
    lista[insertIndex] = element;
  }

  public int size(){
    int tamano = 0;
    for(int i=0; i < lista.length && (lista[i] != null); i++) {
        tamano++;
    }
    return tamano;
  }

  public boolean isFull(){
    int tamano = 0;
    for(int i=0; i < lista.length && (lista[i] != null); i++) {
        tamano++;
    }
    return (tamano == lista.length);
  }

}
