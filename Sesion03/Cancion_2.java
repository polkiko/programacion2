/**
 * Archivo de la clase Cancion, que instanciará objetos de la clase Cancion
 *
 * NOTA: por razones de simplificación esta clase tiene menos atributos que
 * las de las diapositivas.
 *
 * @author Jesus Jerez
 */

class Cancion_2 {

  String titulo;  // Atributos de mi clase Canción. Su ámbito de uso queda
	String interprete; // restringido a esta clase. Lo que realmente estoy creando
	int duracion; // son "variables" donde almacenar datos del objeto Canción.

  // Ahora vamos a definir un 'comportamiento' (método) específico para mi clase
  // que nos permitirá instanciar los objetos

  // [COMPORTAMIENTO 1] Sirve para 'crear' nuestros objetos (instanciar)
  Cancion_2 (                   // Debe tener el mismo nombre que la clase
             String titulo,     // Parámetros formales que recibiremos
             String interprete, // cuando invoquemos el new(parametro1,param2...)
             int duracion       // ¡RECUERDA! Indica el tipo de vairable
            ) {
    this.titulo = titulo;            // Y finalmente asignamos los parámetros recibidos
    this.interprete = interprete;    // (derecha) a los atributos del propio
    this.duracion = duracion;        // objeto (izquierda)
  }

  // ¡IMPORTANTE! El 'this. sirve para trabajar en el ámbito correcto. Como vemos,
  // tenemos dos nombres de vairbales iguales, y de alguna manera deberemos distinguirlos
  //
  // Para conseguirlo, deberemos indicarle a java que las vairbales a las que
  // queremos asignarle los nuevos valores (es decir, las que están a la izquierda)
  // hacen referencia a las del objeto, y no a las recibidas en la llamada.
  // Esto se consigue añadiendo 'this.'


  // A continuación podemos seguir definiendo nuevos 'comportamientos' (métodos)

  // [COMPORTAMIENTO 2] Sirve para devolver los minutos de una cancion
  String minutos() {
    return duracion / 60 + " minutos";
  }
  // ¡RECUERDA! Como en cualquier funcion, deberemos indicar a java el tipo del valor devuelto
  // que en nuestro caso es String y a continuación el nombre de nuestro comportamiento

 // [COMPORTAMIENTO 3] Sirve para devolver la info de una canción
	public String toString(){
		return titulo + ":" + interprete + ":" + duracion;
	}

  /** Más adelante veremos qué nombre reciben estos 'comportamientos', qué tipos
   *  hay, cómo utilizarlos y para qué sirven
  **/

}
