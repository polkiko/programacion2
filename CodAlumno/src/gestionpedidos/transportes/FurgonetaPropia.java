package gestionpedidos.transportes;

import anotacion.Programacion2;
import gestionpedidos.mapa.Mapa;

@Programacion2(
        nombreAutor1 = "Jesus",
        apellidoAutor1 = "Jerez Ballesteros",
        emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
        nombreAutor2 = "",
        apellidoAutor2 = "",
        emailUPMAutor2 = ""
)

public class FurgonetaPropia extends Furgoneta {

    private double velocidadMedia = 30; // Velocidad media registrada hasta la fecha (en Km/h)
    private static final double EUROS_P_HORA = 40; // Constante de precio por hora que cobra una furgoneta

    public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
        super(codigo, mapa, tara);
    }

    public double coste(String codPosOrigen, String codPosDestino) {
        if (this.getTara() < 500) {
            return getMapa().distancia(codPosOrigen, codPosDestino) * EUROS_P_HORA / velocidadMedia;
        } else {
            return getMapa().distancia(codPosOrigen, codPosDestino) * EUROS_P_HORA / velocidadMedia * 1.10;
        }
    }

    public void setVelocidadMedia(double velocidadMedia) {
        this.velocidadMedia = velocidadMedia;
    }
}
