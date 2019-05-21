public class PilaRedimensionable<T> implements Pila<T> {

  private T[] datos;

  // Pragma de programación, que sirve para 'hablarle' al compilador
  @SuppressWarnings("unchecked")
  public PilaRedimensionable(){
    datos = (T[]) new Object[0];
  }

  @SuppressWarnings("unchecked")
  public void apilar(T dato){

    T[] aux = (T[]) new Object[datos.length+1];

    for(int i = 0; i < datos.length; i++){
        aux[i] = datos[i];
    }
    datos = aux;
    datos[datos.length-1] = dato;
  }

  public T cima() throws PilaVaciaException{
    //Al mirar la cima, deberíamos comprobar que no esté vacía
    // Las excepciones también pueden ser colocadas en los métodos, o bien con
    // un if() o un try/catch

    try {
      return datos[datos.length-1];
    }catch(IndexOutOfBoundsException e){
      throw new PilaVaciaException();
    }
  }

  @SuppressWarnings("unchecked")
  public void desapilar() throws PilaVaciaException{
    if(this.vacia()){
      throw new PilaVaciaException();
    }
    T[] aux = (T[]) new Object[datos.length-1];

    for(int i = 0; i < datos.length-1; i++){
        aux[i] = datos[i];
    }
    datos = aux;
  }

  public boolean vacia(){
    return datos.length == 0;
  }

}
