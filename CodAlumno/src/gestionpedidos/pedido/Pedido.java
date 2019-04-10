package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;

public class Pedido {
	// CÓDIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;	
	private Transporte transporte;
	private double peso;
	
	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {		
		//TO-DO
	}

	
	public double getPeso(){
		//TO-DO
		return 0;
	}
	
	
	public double coste(Transporte transporte){
		//TO-DO
		return 0;
	}
	
	// CÓDIGO DE APOYO
	public double getImporte(){
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
	public Cliente getCliente(){
		return cliente;
	}
	
	// CÓDIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
