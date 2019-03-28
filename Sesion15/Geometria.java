public class Geometria {
  public static void main(String[] args) {

    System.out.println("Creamos un circulo y un cuadrado y utilizamos métodos.");

    Circulo c = new Circulo(new Punto2D(0,0), 1.0);
    Hexagono h = new Hexagono(new Punto2D(0,0), 2.0);

    System.out.println("¿Como se utilizan estos metodos?:");
    System.out.println("El punto del centro del circulo es: " + c.centro());
    System.out.println("El area del circulo es: " + c.area());
    System.out.println("El area del hexagono es: " + h.area());
    c.print();

    // Al intentar hacer print() del héxagono, da un error en tiempo de ejecucion,
    // puesto que la clase Hexagono no tiene dicho método (pero sí figura)
    h.print();
  }
}
