public class Hexagono extends PoligonoRegular {

  public Hexagono(Punto2D centro, double longLado) {
    this.centro = centro;
    this.nLados = 6;
    this.longLado = longLado;

    // Esto lo que hace es llama al método constructor de la super clase con
    // los parametros que le paso
    super(centro, 6, longLado);
  }

  public double area() {
    return 3 * Math.sqrt(3) * longLado * longLado / 2;
  }
}
