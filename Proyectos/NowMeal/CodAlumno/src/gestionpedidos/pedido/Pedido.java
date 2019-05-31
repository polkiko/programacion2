package gestionpedidos.pedido;

import anotacion.Programacion2;
import gestionpedidos.transportes.Transporte;

@Programacion2(
        nombreAutor1 = "Jesus",
        apellidoAutor1 = "Jerez Ballesteros",
        emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
        nombreAutor2 = "",
        apellidoAutor2 = "",
        emailUPMAutor2 = ""
)

public class Pedido {

    private Cliente cliente;
    private PlatoComida[] comidas; // Atributo no necesario
    private Restaurante restaurante;
    private double importe;
    private Transporte transporte = null;
    private double peso;

    public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {
        this.cliente = cliente;
        this.comidas = comidas;
        this.restaurante = restaurante;
        for (int i = 0; i < comidas.length; i++) {
            peso += comidas[i].getPeso(); // Asignación y suma
            importe += comidas[i].getPrecio();
        }
    }


    public double getPeso() {
        return peso;
    }


    public double coste(Transporte transporte) {
        double costeTotal = 0;

        costeTotal += importe;
        costeTotal += transporte.coste(restaurante.getCodigo());
        costeTotal += transporte.coste(restaurante.getCodigo(), cliente.getCodigo());

        return costeTotal;
    }

    // CÓDIGO DE APOYO
    public double getImporte() {
        return importe;
    }

    // CÓDIGO DE APOYO
    public Transporte getTransporte() {
        return transporte;
    }

    // CÓDIGO DE APOYO
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    // CÓDIGO DE APOYO
    public Cliente getCliente() {
        return cliente;
    }

    // CÓDIGO DE APOYO
    public Restaurante getRestaurante() {
        return restaurante;
    }
}
