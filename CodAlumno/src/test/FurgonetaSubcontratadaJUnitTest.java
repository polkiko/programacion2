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
import gestionpedidos.transportes.FurgonetaSubcontratada;

public class FurgonetaSubcontratadaJUnitTest {

	@Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test	
	
	
	private FurgonetaSubcontratada furgo;
	private Mapa mapa;
	private static final double DELTA_PRECISSION = 0.001;
	
	/**
	 * Test del constructor de la FurgonetaSubcontratada.
	 * 
	 * <p>Utiliza los métodos getTara y getCodigo.</p>
	 */
	@Test
	public void testFurgonetaSubcontratada() {
		String furgoId0001 = "0001";
		
		for (int i=0;i<10;i++){
			double tara = Math.random()*100;
			Furgoneta t = new FurgonetaSubcontratada(furgoId0001, new Mapa(10, 10),tara);
			furgo = (FurgonetaSubcontratada) t;
		
			assertEquals("El codigo de la furgoneta propia no coincide ("+furgoId0001+")", furgoId0001, furgo.getCodigo());
	
			assertEquals("La tara de la furgoneta no coincide", tara, furgo.getTara(),DELTA_PRECISSION);
		}
	}

	/**
	 * Test del método coste.
	 * 
	 * <p>Utiliza el constructor de FurgonetaSubcontratada y setEurosPKm().</p>
	 */
	@Test
	public void testCoste() {
		mapa = new Mapa(100, 100);
		String furgoId0001 = "0001",furgoId0002 = "0002";
		for (int i=0;i<10;i++){
			double tara = Math.random()*100 + (1000*(i%2));
			
			furgo = new FurgonetaSubcontratada(furgoId0001, mapa,tara);
			FurgonetaSubcontratada furgo2 = new FurgonetaSubcontratada(furgoId0002, mapa,tara);
			
			mapa.addObjetoDinamico(furgo.getCodigo(), new PosicionXY((int)(Math.random()*100),(int)(Math.random()*100)));
			mapa.addObjetoDinamico(furgo2.getCodigo(), new PosicionXY((int)(Math.random()*100),(int)(Math.random()*100)));
		
			double dist = mapa.distancia(furgoId0001, furgoId0002);
			
			double eurospkm = Math.random()*100;
			furgo.setEurosPKm(eurospkm);
			
			assertEquals("El coste calculado para trayecto de la moto no coincide", dist*eurospkm*(tara<1000?1:1.1), furgo.coste(furgoId0002),DELTA_PRECISSION);
			
			assertEquals("El coste calculado para trayecto de la moto no coincide", dist*eurospkm*(tara<1000?1:1.1), furgo.coste(furgoId0001,furgoId0002),DELTA_PRECISSION);

		}
	}

}
