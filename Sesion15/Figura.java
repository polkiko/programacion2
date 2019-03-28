// Definimos una clase abstracta. Esto quiere decir que esta clase es
// tan abstracta que no voy a poderla representar.

public abstract class Figura {

  // Al definir un atributo con 'protected', le estamos indicando a java que
  // este atributo podrá ser utilizado por sus subclases, pero no en esta
  protected Punto2D centro;

  // Defino el método area, al que le añado 'abstract' puesto que en la
  // actual clase no puedo definir cómo calcular el area
  public abstract double area();

  public Punto2D centro() {
    return centro;
  }
}
