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
public class FurgonetaSubcontratada extends Furgoneta {

    private double eurosPKm = 1; //Tarifa para esta furgoneta (en euros/Km). Su valor por defecto es 1

    public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara){
        super(codigo, mapa, tara);
    }

    public double coste(String codPosOrigen, String codPosDestino){
        if(this.getTara() < 1000) {
            return getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm;
        }else{
            return getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm*1.10;
        }
    }

    public void setEurosPKm(double eurosPKm) {
        this.eurosPKm = eurosPKm;
    }

}
