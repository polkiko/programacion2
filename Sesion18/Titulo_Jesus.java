// Autores: Jerez Ballesteros, Jesús + Fernández Verdugo, Sergio

/**
 * Clase que modeliza los títulos (propiedades o cartas) del juego Monopoly.
 *
 * @author Jesús Jerez y Sergio Fernández
 */

package monopoly.dominio;

public class Titulo {

  // Atributos requeridos en el enunciado
  private String nombre;
  private Color color;
  private int precioCasa;
  private int precioHotel;
  private int[] alquilerAPagar = new int[6];

  // Atributos que guardan el número de propiedades
  private int nCasas;
  private int nHotel;

  // Atributo que indica si tiene todas las propiedades del mismo color
  private int tieneTodosMismoColor = 1; // 1=no los tiene, 2=tiene todos

  /**
  * Constructor de la clase que crea el titulo
  *
  * @param color Indica el color del titulo
  * @param nombre Indica el nombre que lleva el titulo
  * @param precioCasa Coste por construir una casa
  * @param precioHotel Coste por construir un hotel
  * @param alquilerAPagar Array cuyas posiciones indican el precio que cuesta
  * el alquiler dependiendo del número de propiedades (siendo la posición 0 el
  * alquiler sin ninguna construcción, del 1 al 4 el precio por el número de
  * casas, y la posición 5 el precio por tener un hotel)
  */
  public Titulo(Color color, String nombre, int precioCasa,
                int precioHotel, int[] alquilerAPagar){
    this.color = color;
    this.nombre = nombre;
    this.precioCasa = precioCasa;
    this.precioHotel = precioHotel;
    this.alquilerAPagar = alquilerAPagar;
  }

  /**
  * Método observador que devuelve el color del título
  *
  * @return Devuelve el color del título
  */
  public Color color(){
    return color;
  }

  /**
  * Método observador que devuelve el nombre del título
  *
  * @return Devuelve el nombre del título
  */
  public String nombre(){
    return nombre;
  }

  /**
  * Método observador que devuelve el precio de una casa
  *
  * @return Devuelve el precio de una casa
  */
  public int precioCasa(){
    return precioCasa;
  }

  /**
  * Método observador que devuelve el precio de un hotel
  *
  * @return Devuelve el precio de un hotel
  */
  public int precioHotel(){
    return precioHotel;
  }

  /**
  * Método observador que devuelve el número de casas
  *
  * @return Devuelve el número de casas
  */
  public int casas(){
    return nCasas;
  }

  /**
  * Método observador que devuelve si existe un hotel o no
  *
  * @return Devuelve true si existe un hotel, y false en el caso contrario
  */
  public boolean hotel(){
    return nHotel == 1;
  }

  /**
  * Método modificador que incrementa en uno el número de casas si es posible
  */
  public void construirCasa(){
    if(nCasas < 4 && nHotel < 1){
      nCasas++;
    }
  }

  /**
  * Método modificador que incrementa en uno el número de hoteles si es posible
  */
  public void construirHotel(){
    if(nCasas == 4){
      nHotel++;
      nCasas = 0;
    }
  }

  /**
  * Método modificador que asigna si el jugador tiene todos los titulos del
  * mismo color
  */
  public void marcarGrupoCompleto(){
    tieneTodosMismoColor = 2;
  }

  /**
  * Método observador que devuelve el precio (alquiler) que deberá pagar
  * el jugador
  *
  * @return Devuelve el precio del alquiler
  */
  public int alquiler(){

    int precio = 0;

    if(nHotel == 1){
      precio = alquilerAPagar[5];
    }else if(nCasas == 4){
      precio = alquilerAPagar[4];
    }else if(nCasas == 3){
      precio = alquilerAPagar[3];
    }else if(nCasas == 2){
      precio = alquilerAPagar[2];
    }else if(nCasas == 1){
      precio = alquilerAPagar[1];
    }else{
      precio = tieneTodosMismoColor * alquilerAPagar[0];
    }

    return precio;
  }


}
