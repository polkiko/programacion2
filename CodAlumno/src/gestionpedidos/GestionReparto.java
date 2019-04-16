package gestionpedidos;

import anotacion.Programacion2;
import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.*;

@Programacion2 (
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

    //PRE: el transporte no ha sido asignado a ninguna zona
    public void addTransporteLocalidad(Transporte transporte) {

        PosicionXY posicionTransporte = mapa.getPosicion(transporte.getCodigo());

        if(posicionTransporte.getX() >= 0 && posicionTransporte.getX() <= mapa.getMaxCoordX()/2 &&
           posicionTransporte.getY() >= 0 && posicionTransporte.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 0
            gestoresLocales[0].add(transporte);

        }else if(posicionTransporte.getX() >= 0 && posicionTransporte.getX() <= mapa.getMaxCoordX()/2 &&
                posicionTransporte.getY() >= mapa.getMaxCoordY()/2+1 && posicionTransporte.getY() <= mapa.getMaxCoordY()) {
            // Está en la localidad 1
            gestoresLocales[1].add(transporte);

        }else if(posicionTransporte.getX() >= mapa.getMaxCoordX()/2+1 && posicionTransporte.getX() <= mapa.getMaxCoordX() &&
                posicionTransporte.getY() >= 0 && posicionTransporte.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 2
            gestoresLocales[2].add(transporte);

        }else{
            // Está en la localidad 3
            gestoresLocales[3].add(transporte);

        }
    }

    //PRE: el pedido no tiene asignado ningún transporte
    public void asignarPedido(Pedido pedido) {
        PosicionXY posicionPedido = mapa.getPosicion(pedido.getCliente().getCodigo());

        if(posicionPedido.getX() >= 0 && posicionPedido.getX() <= mapa.getMaxCoordX()/2 &&
                posicionPedido.getY() >= 0 && posicionPedido.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 0
            gestoresLocales[0].asignarPedido(pedido);

        }else if(posicionPedido.getX() >= 0 && posicionPedido.getX() <= mapa.getMaxCoordX()/2 &&
                posicionPedido.getY() >= mapa.getMaxCoordY()/2+1 && posicionPedido.getY() <= mapa.getMaxCoordY()) {
            // Está en la localidad 1
            gestoresLocales[1].asignarPedido(pedido);

        }else if(posicionPedido.getX() >= mapa.getMaxCoordX()/2+1 && posicionPedido.getX() <= mapa.getMaxCoordX() &&
                posicionPedido.getY() >= 0 && posicionPedido.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 2
            gestoresLocales[2].asignarPedido(pedido);

        }else{
            // Está en la localidad 3
            gestoresLocales[3].asignarPedido(pedido);

        }
    }

    //PRE: el pedido tiene asignado un transporte
    public void notificarEntregaPedido(Pedido pedido) {
        PosicionXY posicionPedido = mapa.getPosicion(pedido.getCliente().getCodigo());

        if(posicionPedido.getX() >= 0 && posicionPedido.getX() <= mapa.getMaxCoordX()/2 &&
                posicionPedido.getY() >= 0 && posicionPedido.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 0
            gestoresLocales[0].notificarEntregaPedido(pedido);

        }else if(posicionPedido.getX() >= 0 && posicionPedido.getX() <= mapa.getMaxCoordX()/2 &&
                posicionPedido.getY() >= mapa.getMaxCoordY()/2+1 && posicionPedido.getY() <= mapa.getMaxCoordY()) {
            // Está en la localidad 1
            gestoresLocales[1].notificarEntregaPedido(pedido);

        }else if(posicionPedido.getX() >= mapa.getMaxCoordX()/2+1 && posicionPedido.getX() <= mapa.getMaxCoordX() &&
                posicionPedido.getY() >= 0 && posicionPedido.getY() <= mapa.getMaxCoordY()/2) {
            // Está en la localidad 2
            gestoresLocales[2].notificarEntregaPedido(pedido);

        }else{
            // Está en la localidad 3
            gestoresLocales[3].notificarEntregaPedido(pedido);

        }
    }

}
