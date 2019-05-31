package progii.juegotablero.model.ajedrez.piezas;

import anotacion.Programacion2;
import list.ArrayList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
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

public class Peon extends PiezaAjedrez {
    /**
     * Crea un peon pertenenciente a jugador en la posición (x,y) del tablero
     * @param jugador El jugador al que pertenece la pieza
     * @param fila Fila que ocupa
     * @param columna Columna que ocupa
     */
    public Peon(Jugador jugador, int fila, char columna) {
        super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
    }

    @Override
    public ArrayList<Casilla> movimientosValidos() {
        ArrayList<Casilla> resultado = new ArrayList<>();

        int rowActual = getFila();
        int colActual = getColumna();
        int avanza;
        int filaComienzo;

        if (this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO) {
            avanza = 1; // Si el jugador va con negras, el avance (en fila y en base a la matriz) se produce en positivo
            filaComienzo = 1; // Comienza en la fila 1
        } else {
            avanza = -1; // Si el jugador va con negras, el avance (en fila y en base a la matriz) se produce en negativo
            filaComienzo = 6; // Comienza en la fila 6
        }

        if(queHay(rowActual + avanza, colActual) == null) {
            casillaVisitable(resultado, getFila() + avanza, colActual); // Casilla delante
        }

        if(this.getFila() == filaComienzo && (queHay(rowActual + avanza, colActual) == null)
                && (queHay(rowActual + 2*avanza, colActual) == null)) {
            casillaVisitable(resultado, rowActual + 2*avanza, colActual); // Casilla dos delante
        }

        PiezaAjedrez pieza1 = queHay(rowActual + avanza, colActual - 1);
        PiezaAjedrez pieza2 = queHay(rowActual + avanza, colActual + 1);

        if(pieza1 != null && pieza1.getJugador().getId() != this.getJugador().getId()){
            casillaVisitable (resultado, rowActual + avanza, colActual - 1); // Diagonal izquierda
        }
        if(pieza2 != null && pieza2.getJugador().getId() != this.getJugador().getId()){
            casillaVisitable (resultado, rowActual + avanza, colActual + 1); // Diagonal derecha
        }

        return resultado;
    }

}