public class Geometria {
  public static void main(String[] args) {

    Circulo c = new Circulo(new Punto2D(0,0), 1.0);
    Hexagono h = new Hexagono(new Punto2D(0,0), 2.0);

    System.out.println(c.centro());
    System.out.println(c.area());
    System.out.println(h.area());
  }
}
