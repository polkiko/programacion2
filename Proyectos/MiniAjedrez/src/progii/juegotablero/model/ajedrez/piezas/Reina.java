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

public class Reina extends PiezaAjedrez  {

    /**
     * Crea una reina pertenenciente a jugador en la posición (x,y) del tablero
     * @param jugador El jugador al que pertenece la pieza
     * @param fila Fila que ocupa
     * @param columna Columna que ocupa
     */
    public Reina(Jugador jugador, int fila, char columna) {
        super(jugador, TipoPiezaAjedrez.REINA, fila, columna);


    }


    @Override
    public ArrayList<Casilla> movimientosValidos() {
        ArrayList<Casilla> resultado = new ArrayList<>();

        casillasVisitables (resultado, 1, 0); // Verticlal abajo
        casillasVisitables (resultado, -1, 0); // Vertical arriba

        casillasVisitables (resultado, 0, -1); // Horizontal izquierda
        casillasVisitables (resultado, 0, 1); // Horizontal derecha

        casillasVisitables (resultado, 1, -1); // Diagonal abajo izquierda
        casillasVisitables (resultado, 1, 1); // Diagonal abajo derecha

        casillasVisitables (resultado, -1, -1); // Diagonal Arriba izquierda
        casillasVisitables (resultado, -1, 1); // Diagonal Arriba derecha

        return resultado;
    }

}