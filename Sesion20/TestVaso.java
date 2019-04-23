public class TestVaso {

  public static void main(String[] args) throws CapacidadSuperada{

    Vaso v = new Vaso(250);
    v.llenar(100);
    v.llenar(100);
    v.vaciar(50);

    v = new Vaso(200);

    // v.llenar(250); // Aquí mi programa lanza una excepción, porque así lo hemos
    // definido en Vaso.java

    // Lo correcto para manejar excepciones es utilizar la sintaxis
    // de: try{}catch(){}

    try { // Intentamos hacer algo
      v.llenar(250);
    }catch (CapacidadSuperada ex) { // Capturamos la excepcion
      // Si la capturamos, ya no necesitaríamos elevar la excepcion, de manera
      // que ya no haría falta elevarla en el main (quitar el throws)
      System.err.println("La he cagado"); // Y avisamos
      System.err.println("Contacta con Herranz!");
      System.exit(1);
    }

    v = new Vaso(200);
  }

}
