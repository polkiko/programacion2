package test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.FurgonetaPropia;

public class FurgonetaPropiaJUnitTest {
	
	@Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test	
	
	
	private FurgonetaPropia furgo;
	private Mapa mapa;
	private static final double DELTA_PRECISSION = 0.001;
	private static final double EUROS_POR_HORA = 40;
	
	/**
	 * Test del constructor de la FurgonetaPropia.
	 * 
	 * <p>Utiliza los métodos getTara y getCodigo.</p>
	 */
	@Test
	public void testFurgonetaPropia() {
		String furgoId0001 = "0001";
		
		for (int i=0;i<10;i++){
			double tara = Math.random()*100;
			Furgoneta t = new FurgonetaPropia(furgoId0001, new Mapa(10, 10),tara);
			furgo =(FurgonetaPropia) t;
		
			assertEquals("El codigo de la furgoneta propia no coincide ("+furgoId0001+")", furgoId0001, furgo.getCodigo());
	
			assertEquals("La tara de la furgoneta no coincide", tara, furgo.getTara(),DELTA_PRECISSION);
		}
	}

	/**
	 * Test del método coste.
	 * 
	 * <p>Utiliza el constructor de FurgonetaPropia y setVelocidadMedia().</p>
	 */
	@Test
	public void testCoste() {
		mapa = new Mapa(100, 100);
		String furgoId0001 = "0001",furgoId0002 = "0002";
		for (int i=0;i<10;i++){
			double tara = (i%2) + 499;
			
			furgo = new FurgonetaPropia(furgoId0001, mapa,tara);
			FurgonetaPropia furgo2 = new FurgonetaPropia(furgoId0002, mapa,tara);
			
			mapa.addObjetoDinamico(furgo.getCodigo(), new PosicionXY((int)(Math.random()*100),(int)(Math.random()*100)));
			mapa.addObjetoDinamico(furgo2.getCodigo(), new PosicionXY((int)(Math.random()*100),(int)(Math.random()*100)));
		
			double dist = mapa.distancia(furgoId0001, furgoId0002);
			
			double velocidadMedia = Math.random()*50;
			furgo2.setVelocidadMedia(velocidadMedia);
			
			assertEquals("El coste calculado para el trayecto de la moto no coincide", (dist*EUROS_POR_HORA)/velocidadMedia*(tara<500?1:1.1), furgo2.coste(furgoId0001),DELTA_PRECISSION);
			
			assertEquals("El coste calculado para el trayecto de la moto no coincide", (dist*EUROS_POR_HORA)/velocidadMedia*(tara<500?1:1.1), furgo2.coste(furgoId0001,furgoId0002),DELTA_PRECISSION);

		}
	}

}
