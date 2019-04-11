package ee1;

// Es necesario aÒadir al proyecto la librerÌa CorrectorOffline.jar
// que se encuentra en moodle
// Este paquete hay que importarlo para que el compilador
// reconozca la anotaciÛn @Programacion2
import anotacion.Programacion2;
import fecha.Fecha;

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

public class Libro {
	private String titulo;
	private String autor;
	private Fecha fechaPublicacion;
	private int nVecesPrestado;

	public Libro(String titulo, String autor, Fecha fechaPub){//Constructor
		this.titulo = titulo;
		this.autor = autor;
		//Se saca copia de la decha de publicación para
		//evitar que pueda ser modificada desde fuera
		this.fechaPublicacion = new Fecha (fechaPub);
	}//Constructor

//Servicios que ofrecen las instancias
	/**
	 * Este servicio se utiliza apra actualziar
	 * la cuenta de las veces que ha sido prestado
	 * este libro
	 */
	public void prestado (){
		this.nVecesPrestado ++;
	}

	/**
	 * Indica si este libro es igual a otro
	 * PRE: Cierto
	 * Retorna cierto si los libros coincide:
	 * el título, el autor y la fecha de publicación.
	 * En otro caso retorna falso
	 * @param otro libro con el que se compara
	 * @return cierto si son iguales falso en otro caso
	 */
	public boolean esIgual (Libro otro){

		return this.titulo.equals(otro.titulo) &&
				this.autor.equals(otro.autor) &&
				this.fechaPublicacion.equals(otro.fechaPublicacion);
	}

	public String toString(){//toString
		return this.titulo+", "+this.autor+", leído: "+this.nVecesPrestado;
	}

//Gets
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @return una copia de fechaPublicacion
	 */
	public Fecha getFechaPublicacion() {
		return new Fecha(fechaPublicacion);
	}

	/**
	 * @return the nVecesPrestado
	 */
	public int getNVecesPrestado() {
		return nVecesPrestado;
	}

}
