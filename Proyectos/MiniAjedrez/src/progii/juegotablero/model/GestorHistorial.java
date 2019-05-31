package progii.juegotablero.model;

import anotacion.Programacion2;
import progii.juegotablero.exceptions.MovimientoException;
import stacks.exceptions.EmptyStackException;
import stacks.Stack;

@Programacion2(
		nombreAutor1 = "Jesus",
		apellidoAutor1 = "Jerez Ballesteros",
		emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
		nombreAutor2 = "",
		apellidoAutor2 = "",
		emailUPMAutor2 = ""
)


/**
 * Clase que gestiona el historial de movimientos de la partida
 */
public class GestorHistorial {

	private Stack<Movimiento> pilaDeshacer;
	private Stack<Movimiento> pilaRehacer;
	
	/**
	 * Crea e inicializa las pilas del gestor del historial
	 */
	public GestorHistorial() {
		pilaDeshacer = new Stack<>();
		pilaRehacer = new Stack<>();
	}
	
	/**
	 * Guarda un nuevo movimientos en el historial
	 * @param movimiento Movimiento a guardar
	 */
	public void guardarMovimiento (Movimiento movimiento) {
		if(!pilaRehacer.isEmpty()){
			pilaRehacer = new Stack<>();
		}
		pilaDeshacer.push(movimiento);
	}
	
	/**
	 * Devuelve el último movimiento realizado y lo elimina de la pila de deshacer
	 * @return El movimiento a deshacer
	 * @throws MovimientoException En caso de que no haya movimientos que deshacer
	 */
	public Movimiento deshacer () throws MovimientoException {
		try {
			Movimiento ultMov = pilaDeshacer.pop();
			pilaRehacer.push(ultMov);
			return ultMov;
		}catch (EmptyStackException e){
			throw new MovimientoException("No se puede deshacer porque no hay movimientos para deshacer");
		}
	}
	
	/**
	 * Devuelve el último movimiento deshecho y lo elimina de la pila de rehacer
	 * @return El movimiento a rehacer
	 * @throws MovimientoException En caso de que no haya movimientos que rehacer
	 */
	public Movimiento rehacer () throws MovimientoException {
		try {
			Movimiento ultMov = pilaRehacer.pop();
			pilaDeshacer.push(ultMov);
			return ultMov;
		}catch (EmptyStackException e){
			throw new MovimientoException("No se puede rehacer porque no hay movimientos para rehacer");
		}
	}
	
}
