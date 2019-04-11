package ee1;

// Es necesario aÒadir al proyecto la librerÌa CorrectorOffline.jar
// que se encuentra en moodle
// Este paquete hay que importarlo para que el compilador
// reconozca la anotaciÛn @Programacion2
import anotacion.Programacion2;

// Rellenar siempre los datos del Autor 1
// Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
	nombreAutor1 = "Jesús",
	apellidoAutor1 = "Jerez Ballesteros",
	emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
	nombreAutor2 = "",
	apellidoAutor2 = "",
	emailUPMAutor2 = ""
)

public class Lector {
  private int nSocio;
  private String nombre;
  private Libro [] historicoLectura;
  private static final int TAMANIO_HISTORICO = 10;
  //Hace referencia a la primera posición vacía
  private int noLibrosHistorico;

  public Lector (int nSocio, String nombre){
	  this.nSocio = nSocio;
	  this.nombre = nombre;
	  //Se reserva memoria para el histórico creando un array de objetos
      this.historicoLectura = new Libro[TAMANIO_HISTORICO];
  }

  /**
   * Indica si dos lectores son iguales. Dos lectores son iguales si:
   * coincide el número de socio y los libros leídos que hay en el histórico
   *  son los mismos y están en el mismo orden
   * @param otro
   * @return
   */
  public boolean esIgual (Lector otro){
	boolean resultado = this.nSocio == otro.nSocio &&
			this.noLibrosHistorico == otro.noLibrosHistorico;
	for (int i=0; i< this.noLibrosHistorico && resultado; i++){
		resultado = this.historicoLectura[i].esIgual(
				otro.historicoLectura[i]);
	}

	return resultado;
  }
  /**
   * El lector ha cogido un libro para leerlo.
   * El libro se inserta en el histórico según se explica
   * en el enunciado
   * @param leer
   */
  public void leerLibro (Libro leer){//leerLibro
	if (this.noLibrosHistorico < this.historicoLectura.length)
	{//Hay sitio, por lo que se mete al final
		this.historicoLectura[this.noLibrosHistorico] = leer;
		this.noLibrosHistorico++;
	}
	else{//Está lleno hay que quitar el más antiguo
		for (int i= 1; i<this.noLibrosHistorico; i++){//for
			this.historicoLectura[i-1] = this.historicoLectura[i];
		}//for
		this.historicoLectura[this.noLibrosHistorico -1] = leer;
	}
	//Se le indica al libro que ha sido prestado
	leer.prestado();
  }//leerLibro



 /**
  * Este método permitir consultar un libro del histórico <br/>
  * @param pos
  * @return si pos<=noLibrosHistorico, se retorna el libro que
  * está en la posición pos del histórico,
  * en caso contrario se retorna null
  */
 public Libro getLibroLeido(int pos){
	if (pos <= noLibrosHistorico){
		return this.historicoLectura[pos-1];
	}
	else
		return null;
 }

 /**
 * @return the nSocio
 */
public int getNSocio() {
	return nSocio;
}

/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}


}
