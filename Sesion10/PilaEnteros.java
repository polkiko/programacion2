/**
 * Clase de mi pila, que me permite crear una pila, apilar (push), desapilar (pop),
 * y mostrar el último elemento (top).
 *
 * @author Jesus Jerez
 */
 
public class PilaEnteros {

  private int[] pila;
  private int fin;

  public PilaEnteros(){
    pila = new int[100]; // Longitud de mi array
    fin = -1; // Indice
  }

  public void push(int i){ // apilar
    pila[fin + 1] = i;
    fin++;
  }

  public void pop(){ // desapilar
    fin--;
  }

  public int top(){ // cima
    return pila[fin];
  }

}
