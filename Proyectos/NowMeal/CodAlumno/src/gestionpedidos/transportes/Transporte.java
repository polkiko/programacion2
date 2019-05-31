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

public abstract class Transporte {

    private Mapa mapa;
    private String codigo;

    public Transporte(String codigo, Mapa mapa) {
        this.mapa = mapa;
        this.codigo = codigo;
    }

    public double coste(String posDestino) {
        return this.coste(codigo, posDestino);
        // El coste dado por un parámetro corresponde al coste entre la posición
        // del actual transporte (codigo) hasta la posición de destino (posDestino)
    }

    public abstract double coste(String cod1, String cod2);

    public String getCodigo() {
        return codigo;
    }

    protected Mapa getMapa() {
        return mapa;
    }

}
