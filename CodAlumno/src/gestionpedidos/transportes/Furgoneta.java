package gestionpedidos.transportes;

import anotacion.Programacion2;
import gestionpedidos.mapa.Mapa;

@Programacion2 (
        nombreAutor1 = "Jesus",
        apellidoAutor1 = "Jerez Ballesteros",
        emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
        nombreAutor2 = "",
        apellidoAutor2 = "",
        emailUPMAutor2 = ""
)

public abstract class Furgoneta extends Transporte {

    private double tara;

    public Furgoneta(String codigo, Mapa mapa, double tara){
        super(codigo, mapa);
        this.tara = tara;
    }


    public double getTara() { return tara; }
}
