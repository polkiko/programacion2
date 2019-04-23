/**
 * Las instancias de Vaso representan vasos de la realdiad, que se pueden
 * llenar y vaciar entre otros
 *
 * @author Jesus Jerez
 */
public class Vaso {

  private double capacidad;
  private double contenido;

  /**
   * METODO CONSTRUCTOR que crea el vaso
   *
   * PRE: capacidad > 0
   * POST: se crea un vaso con la capacidad indicada
   *
   * @param capacidad Mililitros del vaso
   */
  public Vaso(double capacidad){
    this.capacidad = capacidad;
    this.contenido = 0;
  }

  /**
   * METODO MODIFICADOR que añade una cantidad al vaso
   *
   * PRE: el contenido del vaso + cantidad no puede superar la capacidad de vaso
   * POST: el contenido del vaso se habrá incrementado en cantidad
   *
   * @param cantidad Mililitros a añadir del vaso
   */
   // Añadiendo el throws propago la excepción, la elevo, porque no sé qué
   // hacer con ella. Además, le indicas al otro programador que lleve cuidado,
   // porque puede saltarle esa excepcion.
  public void llenar(double cantidad) throws CapacidadSuperada {
    // Aquí
    if(contenido + cantidad > capacidad){
      throw new CapacidadSuperada(); // Lanzo excepciones
    } else {
      contenido += cantidad;
    }

  }

  /**
   * METODO MODIFICADOR que retira una cantidad al vaso
   *
   * PRE: la cantidad no puede ser mayor que el contenido del vaso
   * POST:
   *
   * @param cantidad Mililitros a retirar del vaso
   */
  public void vaciar(double cantidad){
    contenido -= cantidad;
  }

  /**
   * METODO OBSERVADOR que dice qué capacidad tiene el vaso
   *
   * @return capacidad del vaso
   */
  public double capacidad(){
    return contenido;
  }

}
