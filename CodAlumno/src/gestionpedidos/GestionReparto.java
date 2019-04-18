package gestionpedidos;

import anotacion.Programacion2;
import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;

@Programacion2(
        nombreAutor1 = "Jesus",
        apellidoAutor1 = "Jerez Ballesteros",
        emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
        nombreAutor2 = "",
        apellidoAutor2 = "",
        emailUPMAutor2 = ""
)

public class GestionReparto {

    private GestionRepartoLocal[] gestoresLocales;
    private Mapa mapa;

    public GestionReparto(Mapa mapa) {
        this.mapa = mapa;
        gestoresLocales = new GestionRepartoLocal[4];
        for (int i = 0; i < 4; i++) {
            gestoresLocales[i] = new GestionRepartoLocal();
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    public String getEstadoGestorLocal(int i) {
        return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
    }

    public String getEstadoGestorLocalNum(int i) {
        return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
                this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
                this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
                this.gestoresLocales[i].getCodEsperandoFurgo().size();
    }

    /*
     * Con el fin de simplificar los métodos siguientes, decido crear un método privado que me devuelve
     * el número (int) de la localidad o zona a la que pertenece. Para ello utilizamos los rangos propuestos
     * en el enunciado del proyecto:
     *
     * Zona 0: X [0, maxCoordX/2] Y [0, maxCoordY/2]
     * Zona 1: X [0, maxCoordX/2] Y [maxCoordY/2 + 1, maxCoordY]
     * Zona 2: X [maxCoordX/2 + 1, maxCoordX] Y [0, maxCoordY/2]
     * Zona 3: X [maxCoordX/2 + 1, maxCoordX] Y [maxCoordY/2 + 1, maxCoordY]
     *
     */

    //PRE: se da una posición válida
    private int getLocalidad(PosicionXY posicion) {

        int coordenadaX = posicion.getX();
        int coordenadaY = posicion.getY();

        if (coordenadaX >= 0 && coordenadaX <= mapa.getMaxCoordX() / 2) {

            return (coordenadaY >= 0 && coordenadaY <= mapa.getMaxCoordY() / 2) ? 0 : 1;
            // Si Y es mayor que 0 y menor que maximoY/2, entonces estará en la zona 0, sino en la 1

        } else {

            return (coordenadaY >= 0 && coordenadaY <= mapa.getMaxCoordY() / 2) ? 2 : 3;
            // Si Y es mayor que 0 y menor que maximoY/2, entonces estará en la zona 2, sino en la 3

        }
    }

    //PRE: el transporte no ha sido asignado a ninguna zona
    public void addTransporteLocalidad(Transporte transporte) {
        int zona = getLocalidad(mapa.getPosicion(transporte.getCodigo()));
        gestoresLocales[zona].add(transporte);
    }

    //PRE: el pedido no tiene asignado ningún transporte
    public void asignarPedido(Pedido pedido) {
        int zona = getLocalidad(mapa.getPosicion(pedido.getCliente().getCodigo()));
        gestoresLocales[zona].asignarPedido(pedido);
    }

    //PRE: el pedido tiene asignado un transporte
    public void notificarEntregaPedido(Pedido pedido) {
        int zona = getLocalidad(mapa.getPosicion(pedido.getCliente().getCodigo()));
        gestoresLocales[zona].notificarEntregaPedido(pedido);
    }

}
