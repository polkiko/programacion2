// Definimos una clase abstracta. Esto quiere decir que esta clase es
// tan abstracta que no voy a poderla representar, por lo que, entre otros
// no hay método constructor.

public abstract class Figura {

  // Al definir un atributo con 'protected', le estamos indicando a java que
  // este atributo podrá ser utilizado por sus subclases, pero no por esta;
  // a diferencia de private, que sólo podría ser utilizado en esta clase, o
  // public, que entonces daría acceso al atributo desde cualquier sitio.
  protected Punto2D centro;

  // Defino el método area, al que le añado 'abstract' puesto que en la
  // actual clase no puedo definir cómo calcular el area.
  public abstract double area();

  public abstract void print();

  public Punto2D centro() {
    return centro;
  }
}
