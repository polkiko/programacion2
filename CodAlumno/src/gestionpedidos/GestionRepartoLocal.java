package gestionpedidos;

import anotacion.Programacion2;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.*;
import list.ArrayList;
import queues.NaiveQueue;

@Programacion2(
        nombreAutor1 = "Jesus",
        apellidoAutor1 = "Jerez Ballesteros",
        emailUPMAutor1 = "jesus.jerez.ballesteros@alumnos.upm.es",
        nombreAutor2 = "",
        apellidoAutor2 = "",
        emailUPMAutor2 = ""
)

public class GestionRepartoLocal {

    private ArrayList<Moto> motosDisponibles;
    private ArrayList<Furgoneta> furgonetasDisponibles;

    private NaiveQueue<Pedido> pedidosEsperandoMoto;
    private NaiveQueue<Pedido> pedidosEsperandoFurgoneta;

    private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
        ArrayList<String> salida = new ArrayList<>();
        for (int i = 0; i < disponibles.size(); i++)
            salida.add(salida.size(), ((Transporte) disponibles.get(i)).getCodigo());
        return salida;
    }

    // CÓDIGO DE APOYO
    private static ArrayList<String[]> getClienteRestauranteList(NaiveQueue<Pedido> pendientes) {
        ArrayList<String[]> salida = new ArrayList<>();
        NaiveQueue<Pedido> aux = new NaiveQueue<>();
        while (!pendientes.isEmpty()) {
            Pedido pedido = pendientes.poll();

            salida.add(salida.size(), new String[]{pedido.getCliente().getCodigo(),
                    pedido.getRestaurante().getCodigo()});
            aux.add(pedido);
        }
        while (!aux.isEmpty())
            pendientes.add(aux.poll());

        return salida;
    }

    // CÓDIGO DE APOYO
    private static String myArrayListToString(ArrayList<?> list) {
        String salida = "";
        for (int i = 0; i < list.size(); i++) {
            salida += " ";
            if (list.get(i) instanceof String[]) {
                String[] item = (String[]) list.get(i);
                for (int j = 0; j < item.length; j++) {
                    salida += item[j];
                }
            } else if (list.get(i) instanceof String) {
                salida += (String) list.get(i);
            }
        }

        return salida;
    }

    // CÓDIGO DE APOYO
    public String getDisponibles() {
        return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator() +
                "Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles)) + System.lineSeparator();

    }

    // CÓDIGO DE APOYO
    public String getEsperando() {
        return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto)) + System.lineSeparator() +
                "Pedidos esperando furgoneta:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
    }

    // CÓDIGO DE APOYO
    public ArrayList<String> getCodMotosDisponibles() {
        return getCodList(motosDisponibles);
    }

    // CÓDIGO DE APOYO
    public ArrayList<String> getCodFurgoDisponibles() {
        return getCodList(furgonetasDisponibles);

    }

    // CÓDIGO DE APOYO
    public ArrayList<String[]> getCodEsperandoMoto() {
        return getClienteRestauranteList(pedidosEsperandoMoto);
    }

    public ArrayList<String[]> getCodEsperandoFurgo() {
        return getClienteRestauranteList(pedidosEsperandoFurgoneta);
    }

    private static final double PESOMAXMOTO = 20;

    // CÓDIGO DE APOYO
    public GestionRepartoLocal() {

        this.motosDisponibles = new ArrayList<>();
        this.furgonetasDisponibles = new ArrayList<>();

        this.pedidosEsperandoFurgoneta = new NaiveQueue<>();
        this.pedidosEsperandoMoto = new NaiveQueue<>();
    }

    //PRE: el transporte no ha sido asignado a ninguna zona
    public void add(Transporte transporte) {
        // Declaro una variable del tipo del Array y le asigno el transporte dado mediante un cast (puesto que Moto y
        // Furgoneta heredan de Transporte)

        if (transporte.getCodigo().charAt(0) == 'M') {
            Moto moto = (Moto) transporte;
            motosDisponibles.add(motosDisponibles.size(), moto);
        } else {
            Furgoneta furgo = (Furgoneta) transporte;
            furgonetasDisponibles.add(furgonetasDisponibles.size(), furgo);
        }
    }

    //PRE: el pedido no tiene asignado ningún transporte
    public void asignarPedido(Pedido pedido) {

        ArrayList<Transporte> trans;
        NaiveQueue<Pedido> cola;

        if(pedido.getPeso() <= PESOMAXMOTO){
            trans = (ArrayList) motosDisponibles;
            cola = pedidosEsperandoMoto;
        } else {
            trans = (ArrayList) furgonetasDisponibles;
            cola = pedidosEsperandoFurgoneta;
        }

        double temp = Integer.MAX_VALUE;
        double costeActual = 0;
        Transporte transporteAsignado = null;

        if (trans.size() != 0) {
            // Hay transporte disponible
            for (int i = 0; i < trans.size(); i++) {

                costeActual = pedido.coste(trans.get(i));

                if (costeActual <= temp) {
                    transporteAsignado = trans.get(i);
                    temp = costeActual;
                }

            }
            trans.remove(transporteAsignado);

        } else {
            // No hay transporte, se pone en cola
            cola.add(pedido);
        }

        pedido.setTransporte(transporteAsignado);
    }

    //PRE: el pedido tiene asignado un transporte
    public void notificarEntregaPedido(Pedido pedido) {
        if (pedido.getTransporte().getCodigo().charAt(0) == 'M') {
            if (!pedidosEsperandoMoto.isEmpty()) {
                pedidosEsperandoMoto.peek().setTransporte(pedido.getTransporte());
                pedidosEsperandoMoto.poll();
            } else {
                motosDisponibles.add(motosDisponibles.size(), (Moto) pedido.getTransporte());
            }
        } else {
            if (!pedidosEsperandoFurgoneta.isEmpty()) {
                pedidosEsperandoFurgoneta.peek().setTransporte(pedido.getTransporte());
                pedidosEsperandoFurgoneta.poll();
            } else {
                furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) pedido.getTransporte());
            }
        }
    }
}