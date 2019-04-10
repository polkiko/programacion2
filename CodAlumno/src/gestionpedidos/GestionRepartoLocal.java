package gestionpedidos;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import queues.NaiveQueue;


public class GestionRepartoLocal {	
	// CÓDIGO DE APOYO
	private ArrayList<Moto> motosDisponibles;
	private ArrayList<Furgoneta> furgonetasDisponibles;

	private NaiveQueue<Pedido> pedidosEsperandoMoto;
	private NaiveQueue<Pedido> pedidosEsperandoFurgoneta;
	
	// CÓDIGO DE APOYO
	private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
		ArrayList<String> salida = new ArrayList<>();
		for(int i=0; i<disponibles.size(); i++)
			salida.add(salida.size(),((Transporte) disponibles.get(i)).getCodigo());
		return salida;
	}
	
	// CÓDIGO DE APOYO
	private static ArrayList<String[]> getClienteRestauranteList(NaiveQueue<Pedido> pendientes){
		 ArrayList<String[]> salida = new ArrayList<>();
		 NaiveQueue<Pedido> aux = new NaiveQueue<>();
		while(!pendientes.isEmpty()) {
			Pedido pedido = pendientes.poll();
			
			salida.add(salida.size(),new String[]{pedido.getCliente().getCodigo(),
					pedido.getRestaurante().getCodigo()});
			aux.add(pedido);
		}
		while (!aux.isEmpty())
			 pendientes.add(aux.poll());
		
		return salida;
	}
	
	// CÓDIGO DE APOYO
	private static String myArrayListToString (ArrayList<?> list){
		String salida = "";
		for(int i=0; i<list.size(); i++){
			salida += " " ;
			if (list.get(i) instanceof String[]){
				String[] item = (String[])list.get(i);
				for(int j=0; j<item.length; j++){
					salida += item[j] ;
				}	
			}else if (list.get(i) instanceof String){
				salida += (String)list.get(i);
			}
		}
			
		return salida;
	}
	
	// CÓDIGO DE APOYO
	public String getDisponibles(){
		return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator() +
			"Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles)) + System.lineSeparator();
			
	}
	
	// CÓDIGO DE APOYO
	public String getEsperando(){
		return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto)) + System.lineSeparator() +
				"Pedidos esperando furgoneta:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
	}
	
	// CÓDIGO DE APOYO
	public ArrayList<String> getCodMotosDisponibles(){
		return getCodList(motosDisponibles);
	}	
	
	// CÓDIGO DE APOYO
	public ArrayList<String> getCodFurgoDisponibles(){
		return getCodList(furgonetasDisponibles);
			
	}
	
	// CÓDIGO DE APOYO
	public ArrayList<String[]> getCodEsperandoMoto(){
		return getClienteRestauranteList(pedidosEsperandoMoto);
	}
	
	public ArrayList<String[]> getCodEsperandoFurgo(){
		return getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}

	private static final double PESOMAXMOTO = 20;

	// CÓDIGO DE APOYO
	public GestionRepartoLocal(){		
		
		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new NaiveQueue<>();
		this.pedidosEsperandoMoto = new NaiveQueue<>();
	}

	//PRE: el transporte no ha sido asignado a ninguna zona
	public void add(Transporte transporte){
		//TO-DO
	}
			
	//PRE: el pedido no tiene asignado ningún transporte
	public void asignarPedido(Pedido pedido){
		//TO-DO		
	}
	
	//PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido) {	
		//TO-DO	
	}
}