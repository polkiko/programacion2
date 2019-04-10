package gestionpedidos;

import gestionpedidos.mapa.Mapa;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;

public class GestionReparto {
	// CÓDIGO DE APOYO
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;
	
	public GestionReparto(Mapa mapa){
		//TO-DO
	}
	
	//CÓDIGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}
	
	// CÓDIGO DE APOYO
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}
	
	// CÓDIGO DE APOYO
	public String getEstadoGestorLocalNum(int i){
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}
	
	//PRE: el transporte no ha sido asignado a ninguna zona
	public void addTransporteLocalidad(Transporte transporte) {
		//TO-DO
	}
		
	//PRE: el pedido no tiene asignado ningún transporte
	public void asignarPedido(Pedido pedido){
		//TO-DO
	}
	
	//PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido){
		//TO-DO
	}
	
}
