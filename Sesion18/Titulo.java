package monopoly.dominio;

/**
 * Las instancias de la clase Titulo representan títulos de propiedad
 * del Monopoly.
 */
public class Titulo {
  /**
   * El color del título.
   */
  private Color color;

  /**
   * Nombre del solar.
   */
  private String nombre;

  /**
   * Precio para construir una casa.
   */
  private int precioCasa;

  /**
   * Precio para construir un hotel.
   */
  private int precioHotel;

  /**
   * Precios de alquiler. Según posición, 0: sin construcciones, 1:
   * para una casa, 2: para dos casas, 3: para tres casas, 4: para
   * cuatro casas, 5: para un hotel.
   */
  private int[] alquiler;

  /**
   * Número de construcciones: 0: ninguna, 1: una casa, 2: dos casas,
   * 3: tres casas, 4: cuatro casas, 5: un hotel.
   */
  private int construcciones;

  /**
   * Marca de que el grupo está completo.
   */
  private boolean completo;

  /**
   * Crea un nuevo título dado el color, el nombre del solar, los
   * precios de construcción y los precios de alquiler.
   */
  public Titulo(Color color,
                String nombre,
                int precioCasa,
                int precioHotel,
                int[] alquiler) {
    this.color = color;
    this.nombre = nombre;
    this.precioCasa = precioCasa;
    this.precioHotel = precioHotel;
    this.alquiler = alquiler;
    construcciones = 0;
    completo = false;
  }

  /**
   * Devuelve el color del grupo al que pertenece el título.
   */
  public Color color() {
    return color;
  }

  /**
   * Devuelve el nombre del solar al que se refiere el título.
   */
  public String nombre() {
    return nombre;
  }

  /**
   * Devuelve el precio de construcción de una casa.
   */
  public int precioCasa() {
    return precioCasa;
  }

  /**
   * Devuelve el precio de construcción de un hotel.
   */
  public int precioHotel() {
    return precioHotel;
  }

  /**
   * Devuelve el número de casas construidas.
   */
  public int casas() {
    int casas = construcciones == 5 ? 0 : construcciones;
    return casas;
  }

  /**
   * Decide si hay un hotel construido.
   */
  public boolean hotel() {
    return construcciones == 5;
  }

  /**
   * Construye una casa bajo las reglas indicadas.
   */
  public void construirCasa() {
    if (construcciones < 4)
      construcciones++;
  }

  /**
   * Construye una hotel bajo las reglas indicadas.
   */
  public void construirHotel() {
    if (construcciones == 4)
      construcciones++;
  }

  /**
   * Pone una marca en el título para indicar que el grupo está completo.
   */
  public void marcarGrupoCompleto() {
    completo = true;
  }

  /**
   * Devuelve lo que debe pagarse por el alquiler de la propiedad.
   */
  public int alquiler() {
    int aPagar;
    aPagar = alquiler[construcciones];
    if (construcciones == 0 && completo)
      aPagar *= 2;
    return aPagar;
  }
}
