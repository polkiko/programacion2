public class Circulo extends Figura {

  private double radio;

  public Circulo(Punto2D centro, double radio){
    this.centro = centro;
    this.radio = radio;
  }

  public double area() {
    return Math.PI * radio * radio;
  }

  public void print(){
    System.out.println("Radio: " + radio + ". Centro: " + centro);
  }

}
