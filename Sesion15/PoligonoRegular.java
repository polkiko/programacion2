public class PoligonoRegular extends Poligono {

  protected double longLado;

  public PoligonoRegular(Punto2D centro, int nLados, double longLado) {
    this.centro = centro;
    this.nLados = nLados;
    this.longLado = longLado;
  }

  public double perimetro() {
    return longLado * nLados;
  }

  //
  public double getLado() {
    return longLado;
  }

  public double area() {
    // Tengo: centro + nLados + longLados
    double a = longLado / (2 * Math.tan(Math.PI/nLados));
    return nLados * a * longLado / 2;
  }
}
