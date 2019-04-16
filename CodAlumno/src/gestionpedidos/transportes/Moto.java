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
public class Moto extends Transporte {

    private double eurosPKm = 2; //Tarifa para esta moto (en euros/Km). Su valor por defecto es 2.

    public Moto(String codigo, Mapa mapa){
        super(codigo,mapa);
    }

    public double coste(String codPosOrigen, String codPosDestino){
        return getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm;
    }

    public double getEurosPKm(){
        return eurosPKm;
    }

    public void setEurosPKm(double eurosPKm) {
        this.eurosPKm = eurosPKm;
    }


}
