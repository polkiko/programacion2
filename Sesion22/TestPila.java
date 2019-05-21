public class TestPila {

  public static void main(String[] args) throws PilaVaciaException {

    // Test de que está vacia
    final int N = 200000;
    Pila<String> p = new PilaRedimensionable<String>();
    String dato;
    assert p.vacia();

    // Test de llenando
    for (int i = 1; i < N; i++) {
      dato = "Dato-"+i;
      p.apilar(dato);
      assert !p.vacia();
      assert p.cima().equals(dato);
    }
    dato = "Dato-"+N;
    p.apilar(dato);

    // Test de casi vaciando
    for (int i = N; i > 1; i--) {
    dato = "Dato-"+i;
    assert !p.vacia();
    assert p.cima().equals(dato);
    p.desapilar();
    }

    // Test de vaciando
    dato = "Dato-"+1;
    assert !p.vacia();
    assert p.cima().equals(dato);
    p.desapilar();
    assert p.vacia();
  }
}
