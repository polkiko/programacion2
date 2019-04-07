package quepasa;

import acotados.Lista;

public class Contacto {
  private String nombre;
  private String avatar;
  private Lista<String> mensajes;

  /**
   * Constructor de contacto vacío.
   */
  public Contacto() {
    mensajes = new acotados.ListaAcotada<String>(1000);
  }

  /**
   * Devuelve el nombre del contacto o null si no tiene nombre.
   */
  public String nombre() {
    return nombre;
  }

  /**
   * Modifica el nombre del contacto (lo elimina si se le pasa null).
   */
  public void cambiarNombre(String nuevoNombre) {
    nombre = nuevoNombre;
  }

  /**
   * Devuelve el avatar del contacto o null si no tiene avatar.
   */
  public String avatar() {
    return avatar;
  }

  /**
   * Modifica el avatar del contacto (lo elimina si se le pasa null).
   */
  public void cambiarAvatar(String nuevoAvatar) {
    avatar = nuevoAvatar;
  }

  /**
   * Se envía el mensaje al contacto.
   */
  public void enviar(String mensaje) {
    mensajes.add(0, mensaje);
  }

  /**
   * Devuelve todos los mensajes enviados a un usuario. El primer
   * mensaje ocupa la posición 0.
   */
  public Lista<String> mensajes() {
    // Se crea una lista de capacidad máxima el tamaño actual de
    // mensajes
    int n = mensajes.size();
    Lista<String> ordenados = new acotados.ListaAcotada<String>(n);
    // Se llena ordenados en el orden adecuado (hay que invertir mensajes)
    for (int i = 0; i < n; i++) {
      ordenados.add(0, mensajes.get(i));
    }
    return ordenados;
  }

  /**
   * Devuelve el último mensaje enviado (null si no hay mensajes).
   */
  public String ultimoMensaje() {
    return mensajes.get(0);
  }

  /**
   * Devuelve el número de mensajes enviados al contacto.
   */
  public int nMensajes() {
    return mensajes.size();
  }
}
