import quepasa.Contacto;

public class TestsContacto {
  public static void main(String[] args) {
    Contacto c = new Contacto();

    // Prueba para ver que un contacto vacío no tiene nada
    assert c.nombre() == null;
    assert c.avatar() == null;
    assert c.nMensajes() == 0;

  }
}
