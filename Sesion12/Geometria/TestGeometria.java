import geometria.Cuadrado;
import geometria.Circulo;

class TestGeometria{
  public static void main(String[] args){

    Cuadrado c1 = new Cuadrado(5,2);
    Circulo circ = new Circulo(3);

    System.out.println(c1.areaCuadrado());
    System.out.println(c1.perimetroCuadrado());

    System.out.println(circ.areaCirculo());
    System.out.println(circ.perimetroCirculo());

    c1.printCuadrado();
  }
}
