package gestionpedidos.mapa;

public class PosicionXY {

	private int x;
	private int y;	
	
	public PosicionXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distancia(PosicionXY posDestino) {		
		return Math.abs(x - posDestino.x) + Math.abs(y - posDestino.y);		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosicionXY other = (PosicionXY) obj;
		if (x != other.x)
			return false;
		return (y == other.y);			
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

}
