package gestionpedidos.pedido;

public class PlatoComida {
	private String codigo;
	private double precio;
	private double peso;

	public PlatoComida(String codigo, double precio, double peso) {		
		this.codigo = codigo;
		this.precio = precio;
		this.peso = peso;
	}

	public double getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public double getPeso() {
		return peso;
	}
	
	

}
