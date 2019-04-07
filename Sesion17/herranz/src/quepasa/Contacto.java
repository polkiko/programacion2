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
  }

  /**
   * Devuelve todos los mensajes enviados a un usuario.
   */
  public Lista<String> mensajes() {
    return null;
  }

  /**
   * Devuelve el último mensaje enviado (null si no hay mensajes).
   */
  public String ultimoMensaje() {
    return null;
  }

  /**
   * Devuelve el número de mensajes enviados al contacto.
   */
  public int nMensajes() {
    return 0;
  }
}
