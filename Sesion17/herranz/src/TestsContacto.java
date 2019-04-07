import quepasa.Contacto;
import acotados.Lista;

public class TestsContacto {
  public static void main(String[] args) {
    Contacto c = new Contacto();

    // Prueba para ver que un contacto vacío no tiene nada
    assert c.nombre() == null;
    assert c.avatar() == null;
    assert c.nMensajes() == 0;

    // Comprobar cambios de nombres y avatar
    String nombre = "John Dow";
    String avatar = "https://pbs.twimg.com/profile_images/682327338755854336/gl1v_Qf6_400x400.jpg";
    c.cambiarNombre(nombre);
    c.cambiarAvatar(avatar);
    assert nombre.equals(c.nombre());
    assert avatar.equals(c.avatar());

    // Comprobar borrado de nombres y avatar
    c.cambiarNombre(null);
    c.cambiarAvatar(null);
    assert c.nombre() == null;
    assert c.avatar() == null;

    // Prueba de envío de un mensaje
    String primer = "Hola guapo, quedamos para cenar?";
    c.enviar(primer);
    assert c.nMensajes() == 1;
    assert primer.equals(c.ultimoMensaje());

    // Prueba de envío de varios mensajes
    String repetido = "No me contestas?";
    for (int i = 0; i < 10; i++)
      c.enviar(repetido);
    assert c.nMensajes() == 11;
    assert repetido.equals(c.ultimoMensaje());

    // Prueba de un último mensaje
    String ultimo = "Ya he quedado a cenar con mi madre";
    c.enviar(ultimo);
    assert c.nMensajes() == 12;
    assert ultimo.equals(c.ultimoMensaje());

    // Prueba de mensajes
    Lista mensajes = c.mensajes();
    assert primer.equals(mensajes.get(0));
    assert ultimo.equals(mensajes.get(mensajes.size() - 1));
    for (int i = 1; i < mensajes.size() - 2; i++) {
      assert repetido.equals(mensajes.get(i));
    }
  }
}
