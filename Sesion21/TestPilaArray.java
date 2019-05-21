public class TestPilaArray {

  public static void main(String[] args) {
    final int N = 10;
    PilaAcotada<String> p = new PilaArray<String>(N);
    String dato;
    assert p.vacia();
    assert !p.llena();
    try{
      for (int i = 1; i < N; i++) {
        dato = "Dato-"+i; p.apilar(dato);
        assert !p.vacia();
        assert !p.llena();
        assert p.cima().equals(dato);
      }
      dato = "Dato-"+N;
      p.apilar(dato);
      assert p.llena();
      for (int i = N; i > 1; i--) {
        dato = "Dato-"+i;
        assert !p.vacia();
        assert p.cima().equals(dato);
        p.desapilar();
        assert !p.llena();
      }
      dato = "Dato-"+1;
      assert !p.vacia();
      assert !p.llena();
      assert p.cima().equals(dato);
      p.desapilar();
      assert p.vacia();
      assert !p.llena();
  }catch(PilaAcotadaLlena e){
    System.err.println("Error, ta llena");
    System.exit(1);
  }catch(PilaAcotadaVacia e){
    System.err.println("Error, ta vacia");
    System.exit(1);
  }finally(PilaAcotadaVacia excepVacia){ // El bloque finally se ejecuta siempre!
    System.err.println("Revisa bien tu codigo!");
    System.exit(1);
  }
  }

}
