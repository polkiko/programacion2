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
public class FurgonetaSubcontratada extends Furgoneta {

    private double eurosPKm = 1; //Tarifa para esta furgoneta (en euros/Km). Su valor por defecto es 1

    public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
        super(codigo, mapa, tara);
    }

    public double coste(String codPosOrigen, String codPosDestino) {
        double sobreCoste = (this.getTara() < 1000)? 1: 1.10; // Si la tara de la furgoneta no es menor que 1000, se aplica un 10% de sobrecoste
        return getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm * sobreCoste;
    }

    public void setEurosPKm(double eurosPKm) {
        this.eurosPKm = eurosPKm;
    }

}
