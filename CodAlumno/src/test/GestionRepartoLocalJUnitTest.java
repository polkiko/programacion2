package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import gestionpedidos.GestionRepartoLocal;
import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Cliente;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.pedido.PlatoComida;
import gestionpedidos.pedido.Restaurante;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.FurgonetaPropia;
import gestionpedidos.transportes.FurgonetaSubcontratada;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;

public class GestionRepartoLocalJUnitTest {

	@Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test	
	
	
	private GestionRepartoLocal gestor;

	/**
	 * Test de add (añadir transporte al GestionRepartoLocal).
	 * 
	 * <p>Utiliza el constructor de GestionRepartoLocal, Moto y FurgonetaPropia.</p>
	 */
	@Test
	public void testAdd() {
		Mapa mapa = new Mapa(10, 10);
		int NUM_VEHICULOS = 50;
		gestor = new GestionRepartoLocal();
		Moto[] motos = new Moto[NUM_VEHICULOS];
		Furgoneta[] furgonetas = new Furgoneta[NUM_VEHICULOS];
		
		ArrayList<String> motosEnGR ;
		ArrayList<String> furgosEnGR ;
		
		for (int i = 0; i <NUM_VEHICULOS; i++){
			motos[i] = new Moto("MOTO_"+i, mapa);
			furgonetas[i] = new FurgonetaPropia("FURGO_"+i, mapa, Math.random()*1000);
					
			gestor.add(motos[i]);
			motosEnGR = gestor.getCodMotosDisponibles();
			assertEquals("El número de motos en espera no coincide", i+1, motosEnGR.size());			
			
			gestor.add(furgonetas[i]);
			furgosEnGR = gestor.getCodFurgoDisponibles();			
			assertEquals("El número de furgonetas en espera no coincide", i+1, furgosEnGR.size());
			
			for (int j=0;j<i;j++) {
				assertEquals("El código de las motos en espera no coincide", motos[j].getCodigo(), motosEnGR.get(j));
				assertEquals("El código de las furgonetas en espera no coincide", furgonetas[j].getCodigo(), furgosEnGR.get(j));
			}
		}
		
	}

	/**
	 * Test de asignarPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal y Pedido.</p>
	 * 	 
	 * <p>Se crean pedidos para motos y furgonetas y se encolan todos como pedidos pendientes, 
	 * porque no hay transportes disponibles. Se comprueban los datos y el orden de inserción en las colas.</p>
	 */
	@Test
	public void testAsignarPedido0() {
		Mapa mapa = new Mapa(200, 200);
		final int NUM_IT = 50;
		final double PESOMAXMOTO = 20;
		
		gestor = new GestionRepartoLocal();
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];;
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		for (int i = 0; i <NUM_IT; i++){
			Cliente cliente = new Cliente("C"+i);
			mapa.addObjetoEstatico(cliente.getCodigo(), new PosicionXY(100+i,100+i));		
			Restaurante restaurante = new Restaurante("R"+i);
			mapa.addObjetoDinamico(restaurante.getCodigo(), new PosicionXY(100-i,100-i));		
			
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
			pedidosPequenos[i] = new Pedido(cliente, new PlatoComida[]{comidaPequena}, restaurante);
			
			gestor.asignarPedido(pedidosGrandes[i]);
			
			gestor.asignarPedido(pedidosPequenos[i]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", i+1, pedMoto.size());			
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", i+1, pedFurgo.size());
			
			for (int j=0;j<i;j++) {
				assertEquals("El código del cliente del pedido para moto no coincide",pedidosPequenos[j].getCliente().getCodigo(),pedMoto.get(j)[0]);
				assertEquals("El código del restaurante del pedido para moto no coincide",pedidosPequenos[j].getRestaurante().getCodigo(),pedMoto.get(j)[1]);
				
				assertEquals("El código del cliente del pedido para furgoneta no coincide",pedidosGrandes[j].getCliente().getCodigo(),pedFurgo.get(j)[0]);
				assertEquals("El código del restaurante del pedido para furgoneta no coincide",pedidosGrandes[j].getRestaurante().getCodigo(),pedFurgo.get(j)[1]);
				
			}	
		}
	}

	/**
	 * Test de asignarPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * FurgonetaSubcontratada y Pedido, y el método add de GestionRepartoLocal.</p>
	 * 
	 * <p>Presupone que el método coste de Pedido funciona bien.</p>
	 * 
	 * <p>Se crea un transporte de cada tipo y se crean pedidos para motos y furgonetas.
	 *  Se asignan pedidos a los 3 transportes y se encolan el resto de pedidos, 
	 * porque no quedan transportes disponibles. Se comprueban los datos y el orden de 
	 * inserción en las colas.</p>
	 */
	@Test
	public void testAsignarPedido1() {
		Mapa mapa = new Mapa(200,200);
		final int NUM_IT = 50;
		final double PESOMAXMOTO = 20;
		
		gestor = new GestionRepartoLocal();
		Moto moto = new Moto("MOTO_TEST",mapa);
		mapa.addObjetoDinamico(moto.getCodigo(), new PosicionXY(0,0));
		FurgonetaPropia furgo = new FurgonetaPropia("FURGO_TEST",mapa,1000.0);
		FurgonetaSubcontratada furgoS = new FurgonetaSubcontratada("FURGO_TEST_2",mapa,10.0);
		mapa.addObjetoDinamico(furgo.getCodigo(), new PosicionXY(1,1));	
		mapa.addObjetoDinamico(furgoS.getCodigo(), new PosicionXY(2,1));	
		gestor.add(furgo);
		gestor.add(furgoS);
		gestor.add(moto);
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		for (int i = 0; i <NUM_IT; i++){
			Cliente cliente = new Cliente("C"+i);
			mapa.addObjetoEstatico(cliente.getCodigo(), new PosicionXY(100+i,100+i));		
			Restaurante restaurante = new Restaurante("R"+i);
			mapa.addObjetoDinamico(restaurante.getCodigo(), new PosicionXY(100-i,100-i));		
			
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
			pedidosPequenos[i] = new Pedido(cliente, new PlatoComida[]{comidaPequena}, restaurante);
			
			gestor.asignarPedido(pedidosGrandes[i]);
			
			gestor.asignarPedido(pedidosPequenos[i]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", i, pedMoto.size());			
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", i<1?i=0:i-1, pedFurgo.size());
			
			for (int j=1;j<i;j++) {
				assertEquals("El código del cliente del pedido para moto no coincide",pedidosPequenos[j].getCliente().getCodigo(),pedMoto.get(j-1)[0]);
				assertEquals("El código del restaurante del pedido para moto no coincide",pedidosPequenos[j].getRestaurante().getCodigo(),pedMoto.get(j-1)[1]);
				
				if (j>=2){
					assertEquals("El código del cliente del pedido para furgoneta no coincide",pedidosGrandes[j].getCliente().getCodigo(),pedFurgo.get(j-2)[0]);
					assertEquals("El código del restaurante del pedido para furgoneta no coincide",pedidosGrandes[j].getRestaurante().getCodigo(),pedFurgo.get(j-2)[1]);
				}
			}	
		}
	}

	/**
	 * Test de asignarPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * FurgonetaSubcontratada y Pedido, y el método add de GestionRepartoLocal.</p>
	 * 
	 * <p>Presupone que el método coste de Pedido funciona bien.</p>
	 * 
	 * <p>Se crean transportes de los 3 tipos y se crean pedidos para motos y furgonetas.
	 *  Se asignan pedidos para todos los transportes y se encolan el resto de pedidos, 
	 * porque no quedan transportes disponibles. Se comprueba la correcta asignación de  
	 * transportes a pedidos (por coste min) y se comprueban los 
	 * datos y el orden de inserción en las colas de pedidos pendientes.</p>
	 */
	@Test
	public void testAsignarPedido2() {
		Mapa mapa = new Mapa(200, 200);
		final int NUM_IT = 50;
		final int NUM_TRA = 20;
		final double PESOMAXMOTO = 20;
		
		gestor = new GestionRepartoLocal();
		Hashtable<String, Moto> motos = new Hashtable<String, Moto>();
		Hashtable<String, Transporte> furgonetas = new Hashtable<String, Transporte>();
		
		// se crean transportes y se añaden al gestor local
		for (int i=0;i<NUM_TRA;i++){
			Transporte f = null;
			if (i%2==0){
				f = new FurgonetaPropia("FURGO_TEST_"+i,mapa,1000.0);
			}else{
				f = new FurgonetaSubcontratada("FURGO_TEST_"+i,mapa,10.0);
			}
			furgonetas.put(f.getCodigo(),f);
			mapa.addObjetoDinamico(f.getCodigo(), new PosicionXY(i+1,i+1));	
			gestor.add(f);
			
			Moto m = new Moto("MOTO_TEST_"+i,mapa);
			motos.put(m.getCodigo(),m);
			mapa.addObjetoDinamico(m.getCodigo(), new PosicionXY(i,i));
			gestor.add(m);
		}
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		// se crean pedidos y se van asignando a motos y furgonetas con el min coste hasta que se acaban
		for (int i = 0; i <NUM_IT; i++){
			Cliente cliente = new Cliente("C"+i);
			mapa.addObjetoEstatico(cliente.getCodigo(), new PosicionXY(100+i,100+i));		
			Restaurante restaurante = new Restaurante("R"+i);
			mapa.addObjetoDinamico(restaurante.getCodigo(), new PosicionXY(100-i,100-i));		
			
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
			pedidosPequenos[i] = new Pedido(cliente, new PlatoComida[]{comidaPequena}, restaurante);
			
			ArrayList<String> motosLibres = gestor.getCodMotosDisponibles();
			assertEquals("El número de motos disponibles no coincide", NUM_TRA-i>0?NUM_TRA-i:0, motosLibres.size());	
			ArrayList<String> furgosLibres = gestor.getCodFurgoDisponibles();
			assertEquals("El número de furgonetas disponibles no coincide", NUM_TRA-i>0?NUM_TRA-i:0, furgosLibres.size());	
			
			// si quedan motos libres, se asigna a un pedido pequeño
			// cuando NUM_TRA-(i+1)>0, ya no quedarán motos libres
			if (motosLibres.size()>0){
				String motoAAsignar = motosLibres.get(0);
				double costeMin = pedidosPequenos[i].coste(motos.get(motosLibres.get(0)));
				for (int j=1;j<motosLibres.size();j++) {
					double coste = pedidosPequenos[i].coste(motos.get(motosLibres.get(j)));
					if (coste<costeMin){
						costeMin=coste;
						motoAAsignar = motosLibres.get(j);
					}
				}
				
				gestor.asignarPedido(pedidosPequenos[i]);
				
				motosLibres = gestor.getCodMotosDisponibles();
				assertEquals("El número de motos disponibles no coincide", NUM_TRA-(i+1)>0?NUM_TRA-(i+1):0, motosLibres.size());		
				for (int j=0;j<motosLibres.size();j++) {
					assertNotEquals("Esta moto no debería estar libre", motoAAsignar, motosLibres.get(j));		
					
				}
			}else{ 
				// no queda ninguna moto libre, así que se comprueba que se encola bien el pedido
				gestor.asignarPedido(pedidosPequenos[i]);
				ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();	
				assertEquals("El número de pedidos en espera de moto no coincide", i-NUM_TRA+1, pedMoto.size());
				
			}
			
			// si quedan furgos libres, se asigna a un pedido grande
			// cuando NUM_TRA-(i+1)>0, ya no quedarán furgos libres
			if (furgosLibres.size()>0){
				String furgoAAsignar = furgosLibres.get(0);
				double costeMin = pedidosGrandes[i].coste(furgonetas.get(furgosLibres.get(0)));
				for (int j=1;j<furgosLibres.size();j++) {
					double coste = pedidosGrandes[i].coste(furgonetas.get(furgosLibres.get(j)));
					if (coste<costeMin){
						costeMin=coste;
						furgoAAsignar = furgosLibres.get(j);
					}
				}
				
				gestor.asignarPedido(pedidosGrandes[i]);
				
				furgosLibres = gestor.getCodFurgoDisponibles();
				assertEquals("El número de furonetas disponibles no coincide", NUM_TRA-(i+1)>0?NUM_TRA-(i+1):0, furgosLibres.size());		
				for (int j=0;j<furgosLibres.size();j++) {
					assertNotEquals("Esta furgoneta no debería estar libre", furgoAAsignar, furgosLibres.get(j));		
					
				}
			}else{
				// no queda ninguna moto libre, así que se comprueba que se encola bien el pedido
				gestor.asignarPedido(pedidosGrandes[i]);
				ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
				assertEquals("El número de pedidos en espera de furgoneta no coincide", i-NUM_TRA+1, pedFurgo.size());
				
			}
		}
	}

		
	/**
	 * Test de notificarEntregaPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * FurgonetaSubcontratada y Pedido, y los métodos asignarPedido y add de GestionRepartoLocal.</p>
	 *  
	 * <p>Se crea un transporte de cada tipo y se crean pedidos para motos y furgonetas.
	 *  Se asignan estos pedidos a los 3 transportes y se encolan el resto de pedidos, 
	 * porque no quedan transportes disponibles. Luego, se van notificando las entregas
	 * de los pedidos y los transportes que se van quedando libres se re-asignan a pedidos
	 * pendientes hasta que no quedan pedidos pendientes. Se comprueba el estado de las colas
	 * y las asignaciones de transportes a pedidos tras las notificaciones.</p>
	 */	 
	@Test
	public void testNotificarEntregaPedido0() {
		Mapa mapa = new Mapa(200, 200);
		final int NUM_IT = 50;
		final double PESOMAXMOTO = 20;
		
		gestor = new GestionRepartoLocal();
		
		// se crea un transporte de cada tipo y se asignan a un gestor local
		Moto moto = new Moto("MOTO_TEST",mapa);
		mapa.addObjetoDinamico(moto.getCodigo(), new PosicionXY(0,0));
		FurgonetaPropia furgo = new FurgonetaPropia("FURGO_TEST",mapa,1000.0);
		FurgonetaSubcontratada furgoS = new FurgonetaSubcontratada("FURGO_TEST_2",mapa,10.0);
		mapa.addObjetoDinamico(furgo.getCodigo(), new PosicionXY(1,1));	
		mapa.addObjetoDinamico(furgoS.getCodigo(), new PosicionXY(2,1));	
		gestor.add(furgo);
		gestor.add(furgoS);
		gestor.add(moto);
		
		
		
		
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];;
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		// se crean pedidos, se asignan a los 3 transportes y los demás se encolan
		for (int i = 0; i <NUM_IT; i++){
			Cliente cliente = new Cliente("C"+i);
			mapa.addObjetoEstatico(cliente.getCodigo(), new PosicionXY(100+i,100+i));		
			Restaurante restaurante = new Restaurante("R"+i);
			mapa.addObjetoDinamico(restaurante.getCodigo(), new PosicionXY(100-i,100-i));		
			
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
			pedidosPequenos[i] = new Pedido(cliente, new PlatoComida[]{comidaPequena}, restaurante);
			
			gestor.asignarPedido(pedidosGrandes[i]);
			
			gestor.asignarPedido(pedidosPequenos[i]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", i, pedMoto.size());			
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", i-1>0?i-1:0, pedFurgo.size());
			
			for (int j=1;j<i;j++) {
				assertEquals("El código del cliente del pedido para moto no coincide",pedidosPequenos[j].getCliente().getCodigo(),pedMoto.get(j-1)[0]);
				assertEquals("El código del restaurante del pedido para moto no coincide",pedidosPequenos[j].getRestaurante().getCodigo(),pedMoto.get(j-1)[1]);
			}
			
			for (int j=2;j<i;j++){
				assertEquals("El código del cliente del pedido para furgoneta no coincide",pedidosGrandes[j].getCliente().getCodigo(),pedFurgo.get(j-2)[0]);
				assertEquals("El código del restaurante del pedido para furgoneta no coincide",pedidosGrandes[j].getRestaurante().getCodigo(),pedFurgo.get(j-2)[1]);	
			}
			
		}

		// se van notificando las entregas de los pedidos asignados y se van reasignando los transportes
		// que se van quedando libres. Se van comprobando las asignaciones de pedidos.
		
		for (int i = 1; i <NUM_IT; i++){
			gestor.notificarEntregaPedido(pedidosGrandes[i-1]);
			
			gestor.notificarEntregaPedido(pedidosPequenos[i-1]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", NUM_IT-i-1, pedMoto.size());			
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoMoto();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", NUM_IT-i-1, pedFurgo.size());
			
			for (int j=i+1;j<NUM_IT;j++) {
				assertEquals("El código del cliente del pedido para moto no coincide",pedidosPequenos[j].getCliente().getCodigo(),pedMoto.get(j-i-1)[0]);
				assertEquals("El código del restaurante del pedido para moto no coincide",pedidosPequenos[j].getRestaurante().getCodigo(),pedMoto.get(j-i-1)[1]);
				
				assertEquals("El código del cliente del pedido para furgoneta no coincide",pedidosGrandes[j].getCliente().getCodigo(),pedFurgo.get(j-i-1)[0]);
				assertEquals("El código del restaurante del pedido para furgoneta no coincide",pedidosGrandes[j].getRestaurante().getCodigo(),pedFurgo.get(j-i-1)[1]);
				
			}
		}
	}

	/**
	 * Test de notificarEntregaPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * y Pedido, y los métodos asignarPedido y add de GestionRepartoLocal.</p>
	 * 
	 * <p>Se crean motos y furgonetas, y se les asignan pedidos y se notifican sus entregas, de forma
	 * que siempre hay transportes disponibles de los dos tipos. Se comprueba que cuando se notifica 
	 * una entrega y no hay pedidos pendientes, 
	 * el transporte se queda disponible.</p>
	 */
	@Test
	public void testNotificarEntregaPedido1() {
		Mapa mapa = new Mapa(1100, 1100);
		final int NUM_IT = 50;
		final double PESOMAXMOTO = 20;
		
		PosicionXY[] posM =  {new PosicionXY(0,0), new PosicionXY(500,0),new PosicionXY(1000,0)};
		PosicionXY[] posF =  {new PosicionXY(0,5), new PosicionXY(500,5),new PosicionXY(1000,5)};
		PosicionXY[] posC =  {new PosicionXY(0,1), new PosicionXY(500,1),new PosicionXY(1000,1)};
		PosicionXY[] posR =  {new PosicionXY(0,10), new PosicionXY(500,10),new PosicionXY(1000,10)};
		
		gestor = new GestionRepartoLocal();
		
		// se crean 3 motos y 3 furgos y se asignan al gestor local
		Moto[] motos = {new Moto("MOTO_TEST_1",mapa),new Moto("MOTO_TEST_2",mapa),new Moto("MOTO_TEST_3",mapa)};
		for (int i=0;i<posM.length;i++){
			mapa.addObjetoDinamico(motos[i].getCodigo(), posM[i]);
			gestor.add(motos[i]);
		}
		
		FurgonetaPropia[] furgos = {new FurgonetaPropia("FURGO_TEST_1",mapa,1000.0),new FurgonetaPropia("FURGO_TEST_2",mapa,1000.0),new FurgonetaPropia("FURGO_TEST_3",mapa,1000.0)};
		for (int i=0;i<posF.length;i++){
			mapa.addObjetoDinamico(furgos[i].getCodigo(), posF[i]);	
			gestor.add(furgos[i]);
		}
		
		Cliente[] clientes = {new Cliente("C1"),new Cliente("C2"),new Cliente("C3")};
		for (int i=0;i<posC.length;i++)
			mapa.addObjetoEstatico(clientes[i].getCodigo(), posC[i]);
		
		
		Restaurante[] restaurantes = {new Restaurante("R1"),new Restaurante("R2"),new Restaurante("R3")};
		for (int i=0;i<posR.length;i++)
			mapa.addObjetoEstatico(restaurantes[i].getCodigo(), posR[i]);
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];;
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		// en cada iter, se asignan un pedido pequeño y otro grande, y se notifican sus entregas
		// siempre hay transportes disponibles
		// se comprueba que se liberan los transportes tras notificar
		for (int i = 0; i <NUM_IT; i++){
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (clientes[i%3], new PlatoComida[]{comidaGrande}, restaurantes[i%3]);
			pedidosPequenos[i] = new Pedido(clientes[i%3], new PlatoComida[]{comidaPequena}, restaurantes[i%3]);

			gestor.asignarPedido(pedidosPequenos[i]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", 0, pedMoto.size());			
			ArrayList<String> motosDisp = gestor.getCodMotosDisponibles();
			assertEquals("El número de motos disponibles no coincide", motos.length-1, motosDisp.size());			
			
			gestor.asignarPedido(pedidosGrandes[i]);	
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", 0, pedFurgo.size());
			ArrayList<String> fusgosDisp = gestor.getCodFurgoDisponibles();	
			assertEquals("El número de furgonetas disponibles no coincide", furgos.length-1, fusgosDisp.size());			
			
			for (int j=0;j<motos.length-1;j++) {
				assertNotEquals("Esa moto no debería estar libre, iteracion "+i,motos[i%3].getCodigo(),motosDisp.get(j));

				assertNotEquals("Esa furgoneta no debería estar libre, iteracion "+i,furgos[i%3].getCodigo(),fusgosDisp.get(j));
			}
			
			gestor.notificarEntregaPedido(pedidosPequenos[i]);

			motosDisp = gestor.getCodMotosDisponibles();
			assertEquals("El número de pedidos en espera de moto no coincide", motos.length, motosDisp.size());			

			gestor.notificarEntregaPedido(pedidosGrandes[i]);			

			fusgosDisp = gestor.getCodFurgoDisponibles();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", furgos.length, fusgosDisp.size());
		}

	}

	/**
	 * Test de notificarEntregaPedido al GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * y Pedido, y los métodos asignarPedido y add de GestionRepartoLocal.</p>
	 * 
	 * <p>Se crean motos y furgonetas, se les asignan pedidos y se notifican sus entregas, de forma
	 * que nunca hay más de un pedido pendiente de cada tipo. Se comprueba que se actualizan correctamente las colas de pedidos pendientes tras
	 * notificar las entregas.</p>
	 */
	@Test
	public void testNotificarEntregaPedido2() {
		Mapa mapa = new Mapa(1100, 1100);
		final int NUM_IT = 50;
		final double PESOMAXMOTO = 20;
		
		PosicionXY[] posM =  {new PosicionXY(0,0), new PosicionXY(500,0),new PosicionXY(1000,0)};
		PosicionXY[] posF =  {new PosicionXY(0,5), new PosicionXY(500,5),new PosicionXY(1000,5)};
		PosicionXY[] posC =  {new PosicionXY(0,1), new PosicionXY(500,1),new PosicionXY(1000,1)};
		PosicionXY[] posR =  {new PosicionXY(0,10), new PosicionXY(500,10),new PosicionXY(1000,10)};
		
		gestor = new GestionRepartoLocal();
		
		// se crean 3 motos y 3 furgos y se asignan al gestor local
		Moto[] motos = {new Moto("MOTO_TEST_1",mapa),new Moto("MOTO_TEST_2",mapa),new Moto("MOTO_TEST_3",mapa)};
		for (int i=0;i<posM.length;i++){
			mapa.addObjetoDinamico(motos[i].getCodigo(), posM[i]);
			gestor.add(motos[i]);
		}
		
		FurgonetaPropia[] furgos = {new FurgonetaPropia("FURGO_TEST_1",mapa,1000.0),new FurgonetaPropia("FURGO_TEST_2",mapa,1000.0),new FurgonetaPropia("FURGO_TEST_3",mapa,1000.0)};
		for (int i=0;i<posF.length;i++){
			mapa.addObjetoDinamico(furgos[i].getCodigo(), posF[i]);	
			gestor.add(furgos[i]);
		}
		
		Cliente[] clientes = {new Cliente("C1"),new Cliente("C2"),new Cliente("C3")};
		for (int i=0;i<posC.length;i++)
			mapa.addObjetoEstatico(clientes[i].getCodigo(), posC[i]);			
		
		
		Restaurante[] restaurantes = {new Restaurante("R1"),new Restaurante("R2"),new Restaurante("R3")};
		for (int i=0;i<posR.length;i++)
			mapa.addObjetoEstatico(restaurantes[i].getCodigo(), posR[i]);
		
		Pedido[] pedidosGrandes = new Pedido[NUM_IT];;
		Pedido[] pedidosPequenos = new Pedido[NUM_IT];
		
		// en las 3 primeras iteraciones, solo se asignan pedidos con lo que se asignan todos los transportes
		// luego, en cada iter se asigna un pedido de cada tipo y se notifican las entregas de 
		// los 3 más antiguos sin entregar, por tanto nunca hay más de un pedido pendiente de cada tipo
		
		for (int i = 0; i <NUM_IT; i++){
			int numEsperando = i<3?0:1;
			int numDisponibles = i<3?3-(i+1):0;
			
			PlatoComida comidaGrande = new PlatoComida("COMIDA_G_"+i, Math.random()*100, Math.random()*10+PESOMAXMOTO);
			PlatoComida comidaPequena = new PlatoComida("COMIDA_P_"+i, Math.random()*100, Math.random()*10);

			pedidosGrandes[i] = new Pedido (clientes[i%3], new PlatoComida[]{comidaGrande}, restaurantes[i%3]);
			pedidosPequenos[i] = new Pedido(clientes[i%3], new PlatoComida[]{comidaPequena}, restaurantes[i%3]);

			gestor.asignarPedido(pedidosPequenos[i]);
			
			ArrayList<String[]> pedMoto = gestor.getCodEsperandoMoto();
			assertEquals("El número de pedidos en espera de moto no coincide", numEsperando, pedMoto.size());			
			ArrayList<String> motosDisp = gestor.getCodMotosDisponibles();
			assertEquals("El número de motos disponibles no coincide", numDisponibles, motosDisp.size());			
			
			gestor.asignarPedido(pedidosGrandes[i]);
			
			ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();	
			assertEquals("El número de pedidos en espera de furgoneta no coincide", numEsperando, pedFurgo.size());
			ArrayList<String> fusgosDisp = gestor.getCodFurgoDisponibles();	
			assertEquals("El número de furgonetas disponibles no coincide", numDisponibles, fusgosDisp.size());			
			
			// hay un pedido de cada tipo pendiente
			if (i>=3){
				pedMoto = gestor.getCodEsperandoMoto();
				assertEquals("El número de pedidos en espera de moto no coincide", 1, pedMoto.size());
				
				gestor.notificarEntregaPedido(pedidosPequenos[i-3]);

				pedMoto = gestor.getCodEsperandoMoto();	
				assertEquals("El número de pedidos en espera de moto no coincide", 0, pedMoto.size());			

				pedFurgo = gestor.getCodEsperandoFurgo();	
				assertEquals("El número de pedidos en espera de furgoneta no coincide", 1, pedFurgo.size());
				
				gestor.notificarEntregaPedido(pedidosGrandes[i-3]);			

				pedFurgo = gestor.getCodEsperandoFurgo();		
				assertEquals("El número de pedidos en espera de furgoneta no coincide", 0, pedFurgo.size());
	
			}				
		}
		// se notifican los últimos pedidos grandes
		gestor.notificarEntregaPedido(pedidosGrandes[NUM_IT-3]);
		gestor.notificarEntregaPedido(pedidosGrandes[NUM_IT-2]);
		gestor.notificarEntregaPedido(pedidosGrandes[NUM_IT-1]);
		ArrayList<String> fusgosDisp = gestor.getCodFurgoDisponibles();	
		assertEquals("El número de furgonetas disponibles no coincide", 3, fusgosDisp.size());	
		
		// se notifican los últimos pedidos pequeños
		gestor.notificarEntregaPedido(pedidosPequenos[NUM_IT-3]);
		gestor.notificarEntregaPedido(pedidosPequenos[NUM_IT-2]);
		gestor.notificarEntregaPedido(pedidosPequenos[NUM_IT-1]);
		ArrayList<String> motosDisp = gestor.getCodMotosDisponibles();
		assertEquals("El número de motos disponibles no coincide", 3, motosDisp.size());
	}

	/**
	 * Test de notificarEntregaPedido de GestionRepartoLocal.
	 * 
	 * <p>Utiliza los constructores de GestionRepartoLocal, Moto, FurgonetaPropia, 
	 * FurgonetaSubcontratada y Pedido, y los métodos asignarPedido y add de GestionRepartoLocal.</p>
	 *  
	 * <p>Se crea un transporte de cada tipo y se comprueba que cuando se libera una moto,
	 * no hay pedidos de moto pendientes pero hay pedidos de furgonetas pendientes, se
	 * guarda la moto como disponible.</p>
	 */	 
	@Test
	public void testNotificarEntregaPedido3() {
		final double PESOMAXMOTO = 20;
		Mapa mapa = new Mapa(200, 200);
					
		gestor = new GestionRepartoLocal();
		
		// se crea un transporte de cada tipo y se asignan a un gestor local
		Moto moto = new Moto("MOTO_TEST",mapa);
		mapa.addObjetoDinamico(moto.getCodigo(), new PosicionXY(0,0));
		FurgonetaPropia furgo = new FurgonetaPropia("FURGO_TEST",mapa,1000.0);
		FurgonetaSubcontratada furgoS = new FurgonetaSubcontratada("FURGO_TEST_2",mapa,10.0);
		mapa.addObjetoDinamico(furgo.getCodigo(), new PosicionXY(1,1));	
		mapa.addObjetoDinamico(furgoS.getCodigo(), new PosicionXY(2,1));	
		gestor.add(furgo);
		gestor.add(furgoS);
		gestor.add(moto);
		
		Cliente cliente = new Cliente("C1");
		Restaurante restaurante = new Restaurante("R1");
		
		mapa.addObjetoEstatico(cliente.getCodigo(), new PosicionXY(10,10));
		mapa.addObjetoEstatico(restaurante.getCodigo(), new PosicionXY(5,10));
		
		PlatoComida comidaGrande = new PlatoComida("COMIDA_G_", Math.random()*100, Math.random()*10+PESOMAXMOTO);
		PlatoComida comidaPequena = new PlatoComida("COMIDA_P_", Math.random()*100, Math.random()*10);

		Pedido pedidoGrande = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
		Pedido pedidoGrande1 = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
		Pedido pedidoGrande2 = new Pedido (cliente, new PlatoComida[]{comidaGrande}, restaurante);
				
		Pedido pedidoPequeno = new Pedido(cliente, new PlatoComida[]{comidaPequena}, restaurante);
		
		gestor.asignarPedido(pedidoGrande);
		gestor.asignarPedido(pedidoGrande1);
		ArrayList<String> fusgosDisp = gestor.getCodFurgoDisponibles();	
		assertEquals("El número de furgonetas disponibles no coincide", 0, fusgosDisp.size());	
		
		// se encola el tercer pedido grande
		gestor.asignarPedido(pedidoGrande2);
		ArrayList<String[]> pedFurgo = gestor.getCodEsperandoFurgo();		
		assertEquals("El número de pedidos en espera de furgoneta no coincide", 1, pedFurgo.size());

		
		gestor.asignarPedido(pedidoPequeno);
		// se libera una moto, pero se necesita una furgo 
		gestor.notificarEntregaPedido(pedidoPequeno);
		ArrayList<String> motosDisp = gestor.getCodMotosDisponibles();
		assertEquals("El número de motos disponibles no coincide", 1, motosDisp.size());
		
		
		
	}

}
