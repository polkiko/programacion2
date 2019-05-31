package progii.juegotablero.model.ajedrez;

import java.util.function.BiFunction;

import anotacion.Programacion2;
import list.ArrayList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Pieza;

@Programacion2(
		nombreAutor1 = "Jesus",
		apellidoAutor1 = "Jerez Ballesteros",
		emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
		nombreAutor2 = "",
		apellidoAutor2 = "",
		emailUPMAutor2 = ""
)

/**
 * Clase que modela una pieza de ajedrez
 * @author groman
 *
 */
public abstract class PiezaAjedrez extends Pieza {

	private TipoPiezaAjedrez tipoPieza;
	/**
	 * Se define un atributo de tipo función que permite consultar que pieza hay en la posición dada
	 * La función debe cumplir con los siguientes requisitos:
	 * 1º Recibe la fila y la columna siguiendo el criterio del ajedrez
	 * 2º Debe retornar la pieza que hay en la posición indicada o null si no hay ninguna pieza
	 */
	private static BiFunction<Integer,Character,PiezaAjedrez> queHay = null;


	/**
	 * Las piezas de ajedrez se colocan en un tablero que cuya esquina superior izquierda es (8,'a') y la inferior derecha (1,'h')
	 * @param jugador referencia al jugador al que pertenece esta pieza. Se guardará una referencia a el
	 * @param tipoPieza tipo de la pieza que se está creando
	 * @param fila de 1 a 8 fila inicial en la que estará la pieza
	 * @param columna de 'a' a 'h' columna inicial en la que estará la pieza
	 */
	public PiezaAjedrez (Jugador jugador, TipoPiezaAjedrez tipoPieza, int fila, char columna) {
		super(jugador, 8-fila, ((int)columna) - ((int)'a'));
		this.tipoPieza = tipoPieza;
	}

	public TipoPiezaAjedrez getTipoPieza() {
		return tipoPieza;
	}

	/**
	 * Devuelve si la pieza puede mover a la posición (toFila,toColumna) habiendo o no contrario en dicha posición. 
	 * Como esta clase no conoce el movimiento concreto de cada pieza, únicamente devolera true si la pieza
	 * no se sale del tablero o false si la pieza se sale del tablero.   
	 * @param toFila Fila destino del movimiento 
	 * @param toColumna Columna destino del movimiento
	 * @return true si el movimiento está dentro del tablero y false e.o.c.
	 */
	@Override
	public boolean movimientoDentroLimites (int toFila, int toColumna) {
		return toFila <= 7 && toFila >= 0 && toColumna <= 7 && toColumna >= 0 && (getFila() != toFila || getColumna() != toColumna);
	}


	/**
	 * Devuelve si la pieza puede mover a la posición (toFila, toColumna) habiendo o no contrario en dicha posición. 
	 * Como esta clase no conoce el movimiento concreto de cada pieza, únicamente devolera true si la pieza
	 * no se sale del tablero o false si la pieza se sale del tablero.   
	 * @param toFila Fila destino del movimiento 
	 * @param toColumna Columna destino del movimiento
	 * @return true si el movimiento está dentro del tablero y 
	 * la posición de destino es distinta de la de origen.
	 * Se retorma false e.o.c.
	 */
	public boolean puedeMover (int toFila, char toColumna){
		// Si la fila a=0 y el resto se  corresponde, entonces podemos restarle el caracter 'a' a 'a' para que de 0,
		// y así con el resto
		int columnaMatriz = (int)toColumna - (int)'a';
		return movimientoDentroLimites(8 - toFila, columnaMatriz);
	}


	/**
	 * El método devuelve un String con formato: TIPOPIEZA_NOMBREJUGADOR. 
	 * Por ejemplo, ALFIL_NEGRO. Para ello se usará <br> 
	 * tipo de pieza y el nombre del jugador que se encuentra en la clase Pieza.    
	 */
	@Override
	public String toString() {
		return getTipoPieza() + "_" + this.getJugador().getNombre();
	}

	/**
	 * En el ajedrez la fila superior es la 8 y la inferior el 1
	 * @return Este método retorna la fila en la que se encuentra la pieza según un tablero de ajedrez
	 */
	public int getFilaAjedrez(){
		return 8-super.getFila();
	}

	/**
	 * Las columnas en un tablero de ajedrez van de 'a' a 'h' siendo 'a' la columna que esstá más a la izquierda
	 * @return retiorna la columna en la que se encuentra la pieza en un tablero de ajedrez
	 */
	public char getColumnaAjedrez(){
		return (char)(super.getColumna() + 'a');
	}

	public static void setQueHay(BiFunction<Integer,Character,PiezaAjedrez> func){
		PiezaAjedrez.queHay = func;
	}

	/**
	 * Preugunta que hay en la posición dada siguiendo el criterio de posiciones del ajedrez
	 * @param fila fila que se quiere consultar de 8 (superior) a 1 (inferior)
	 * @param columna columna que se quiere consultar de 'a' (izquierda) a 'h' (derecha)
	 * @return retorna la pieza que hubiera o null
	 */
	protected static PiezaAjedrez queHay (Integer fila, Character columna){
		boolean bFilaOK = (fila >= 1 && fila <= 8);
		boolean bColumnaOK = (columna >= 'a' && columna <= 'h');
		if (queHay!=null && bFilaOK && bColumnaOK){
			return queHay.apply(fila, columna);
		}
		return null;
	}

	/**
	 * Preugunta que hay en la posición dada siguiendo el criterio de posiciones de una matriz (modelo interno aplicado para la implementación del juego)
	 * @param fila fila que se quiere consultar de 0 (superior) a 7 (inferior)
	 * @param columna columna que se quiere consultar de '0' (izquierda) a '7' (derecha)
	 * @return retorna la pieza que hubiera o null
	 */
	protected static PiezaAjedrez queHay (int fila, int columna){
		return queHay (Integer.valueOf(8-fila), Character.valueOf((char)('a'+columna)));
	}

	/**
	 *
	 * @return Retorna todas las casillas permitidos para esta pieza en la situación actual del tablero. El valor retornado debe ser distinto de nulo 
	 * aunque no existan casillas permitidas (ArrayList con cero elementos) 
	 */
	@Override
	public abstract ArrayList<Casilla> movimientosValidos();

//	métodos auxiliares
	/**
	 * Este método recorre el tablero desde la posición incial de la pieza hasta llegar a un extremo del 
	 * tablero o encontrar una pieza. La forma en que se desplaza viene determinada por incFila e incColumna.
	 * Inserta en resultado todas las casillas visitables. Una casilla es visitable si desde la posición de la pieza
	 * hasta ella no hay obstaculos, y la casilla está vacía o si está ocupada lo está por una pieza contraria
	 * @param resultado Colección en la que se añaden las casillas visitables
	 * @param incFila incremento de la fila en cada iteración
	 * @param incColumna incremento de la columna en cada interación
	 */
	protected void casillasVisitables (ArrayList<Casilla> resultado,int incFila, int incColumna) {

		int proxFila = getFila() + incFila;
		int proxCol = getColumna() + incColumna;

		boolean piezaEncontrada = false;

			while (movimientoDentroLimites(proxFila, proxCol) && !piezaEncontrada) {
				PiezaAjedrez proxPieza = queHay(proxFila, proxCol);
				piezaEncontrada = proxPieza != null;

				casillaVisitable(resultado, proxFila, proxCol);
				
				proxFila += incFila;
				proxCol += incColumna;
			}
	}

	/**
	 * Método portegiod que comprueba si la casilla indicada es visitable
	 * Una casilla es visitable si y sólo si está vacía u ocuoada por una pieza contraria.
	 * En el caso de que la casilla sea visitable se inserta en resultado
	 * @param resultado colección en la que se añade el movimiento si este es válido
	 * @param filaEst fila de la casilla que se desea estudiar
	 * @param columnaEst columna de la casilla que se desea estduiar
	 */
	protected void casillaVisitable(ArrayList<Casilla> resultado, int filaEst, int columnaEst) {

		PiezaAjedrez pieza = queHay(filaEst, columnaEst);
		if (movimientoDentroLimites(filaEst, columnaEst)
			&& (pieza == null || pieza.getJugador().getId() != this.getJugador().getId())) {
			resultado.add(resultado.size(), new Casilla(filaEst, columnaEst));
		}
	}
}
