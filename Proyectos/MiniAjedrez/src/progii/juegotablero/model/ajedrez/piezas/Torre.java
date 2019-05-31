package progii.juegotablero.model.ajedrez.piezas;

import anotacion.Programacion2;
import list.ArrayList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

@Programacion2(
		nombreAutor1 = "Jesus",
		apellidoAutor1 = "Jerez Ballesteros",
		emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
		nombreAutor2 = "",
		apellidoAutor2 = "",
		emailUPMAutor2 = ""
)

/**
 * Clase que representa a la Torre
 * @author groman
 *
 */

public class Torre extends PiezaAjedrez  {

	/**
	 * Crea una torre pertenenciente a jugador en la posición (x,y) del tablero
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila Fila que ocupa 
	 * @param columna Columna que ocupa
	 */
	public Torre(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.TORRE, fila, columna);

		
	}


	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		/* La torre se puede mover en horizontal y vertical
		 * Si hay una ficha de color contrario también puede moverse a esa posición comíendose la pieza 
		*/
		//Vertical descendente según el modelo interno (matriz)
		casillasVisitables (resultado, 1, 0);
		//Vertical ascendente según el modelo interno (matriz)
		casillasVisitables (resultado, -1, 0);
		
		//Horiznotal izquierda según el modelo interno (matriz)
		casillasVisitables (resultado, 0, -1);
		//Horizontal derecha según el modelo interno (matriz)
		casillasVisitables (resultado, 0, 1);
		return resultado;
	}

}

