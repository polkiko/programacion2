/**
 * Las instancias de SIM (cuando creo un objeto SIM) representan seres
 * humanos en mi simulacion
 *
 * @author Jesus Jerez
 */

public class SIM {

  // Creo una clase de enumerados con las actividades de mi SIM
  public enum Actividad {
    DORMIR, COMER, JUGAR, ESTUDIAR; // Solo podré crear estos objetos

    private int tiempoHoras; // Defino el atributo de cada objeto que corresponde
    // al número de horas que han hecho dicha actividad

    /**
     * METODO CONSTRUCTOR que crea los objetos de mi clase de Enumerados
     *
     * @param horas Horas que se anaden para la estadística
     */
    public void anadirHoras(int horas){
      this.tiempoHoras = horas;
    }

    /**
     * METODO OBSERVADOR que devuelve las horas de una actividad
     *
     * @return Horas que ha estado haciendo una actividad
     */
    public int verHoras(){
      return tiempoHoras;
    }

  };

  // Defino los atributos que utilizaré para esta clase
  private String nombre;
  private int horasVida;
  private Actividad haciendo;
  private SIM[] amigos;

  /**
   * METODO CONSTRUCTOR que crea un SIM
   *
   * @param  nombre Nombre del SIM
   */
  public SIM(String nombre){
    this.nombre = nombre; // Asigno el nombre de mi SIM
    haciendo = Actividad.DORMIR; // Por defecto mi SIM empieza dormido
    amigos = new SIM[10]; // Asigno un array de max 10 huecos para amigos
  }

  /**
   * METODO MODIFICADOR que simula el paso de horas, aumentando su "vida"
   *
   * @param tiempoHoras Tiempo que avanza la vida de este SIM
   */
  public void simular(int tiempoHoras){
    horasVida = horasVida + tiempoHoras;
    haciendo.anadirHoras(tiempoHoras);
  }

  /**
   * METODO MODIFICADOR que asigna un nuevo amigo al SIM
   *
   * @param amigo SIM que ahora es amigo
   */
  public void hacerAmigo(SIM amigo){
    for(int i = 0; i < amigos.length && amigos[i] != null; i++){
      amigos[i] = amigo;
    }
  }

  /**
   * METODO OBSERVADOR que devuelve el nombre de mi SIM
   *
   * @return nombre de mi SIM
   */
  public String nombre(){
    return nombre;
  }

  /**
   * METODO OBSERVADOR que devuelve la actividad que está haciendo mi SIM
   *
   * @return Actividad que está haciendo mi SIM
   */
  public Actividad quease(){
    return haciendo;
  }

  /**
   * METODO OBSERVADOR que informa sobre el tiempo dedicado a una actividad
   *
   * @param  a actividad sobre la que se quiere conocer el tiempo dedicado
   * @return numero de horas dedicas a la actividad indicada
   */
  public int estadistica(Actividad a){
    return a.verHoras();
  }

  /**
   * METODO OBSERVADOR que devuelve el array de amigos de mi SIM
   *
   * @return devuelve el array de los amigos de mi SIM
   */
  public SIM[] amigos(){
    return amigos;
  }
}
