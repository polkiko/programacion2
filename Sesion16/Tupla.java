// Esta clase se llama "Clase genérica", y se definien poniendo el nombre
// de la clase y sus argumentos entre <,>, siendo cualquier tipo.
//
// Una vez tengo la clase creada, puedo crear clases de cualquier tipo
// pasado por los argumentos. Son clases completamente nuevas.

public class Tupla<T1, T2> {

  private T1 x;
  private T2 y;

  public Tupla(T1 fst, T2 snd) {
    x = fst;
    y = snd;
  }

  public T1 fst() {
    return x;
  }

  public T2 snd() {
    return y;
  }

}
