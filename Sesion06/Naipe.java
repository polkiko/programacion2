class Naipe{

	private String palo;
	private String valor;
	
	private Naipe(){
		// Poniendo el metodo Naipe() en private, ahora nadie puede usarlo
	}
	
	public Naipe(String palo, String valor) {
	
		String[] palosValidos = {"corazones", "picas", "treboles", "diamantes"};
		String[] valoresValidos = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "valet", "dama", "rey"};
		
		int i = 0;
		
		while (i < palosValidos.length && !palosValidos[i].equals(palo)) {
			i++;
		}
		
		if (i == palosValidos.length) {
			System.err.println("Palo no válido: " + palo);
			System.exit(-1);
		}
		
		i = 0;
		while (i < valoresValidos.length && !valoresValidos[i].equals(valor)) {
			i++;
		}
		
		if (i == valoresValidos.length) {
			System.err.println("Valor no válido: " + valor);
			System.exit(-1);
		}
		
		this.palo = palo;
		this.valor = valor;
		
	}
	
	
	String palo(){
		return palo;
	}
	
	
	
}