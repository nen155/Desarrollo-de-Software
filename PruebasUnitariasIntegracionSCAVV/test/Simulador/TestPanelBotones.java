package Simulador;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.Palanca;

public class TestPanelBotones {
	private Interfaz interfaz;
	private MouseEvent mouseEvent;
	private ActionEvent evento;
	@Before
	public void setUp() throws Exception {
		interfaz = new Interfaz();
        mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
        evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
	}

	@Test
	public void testEncendidoFrenando() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando frenar
		assertTrue(interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse(interfaz.getControl().freno.leerEstado());

	}

	@Test
	public void testEncendidoMantener() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando mantener
		assertFalse(interfaz.getPanelB().BotonMantener.isEnabled());
		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse(interfaz.getControl().estadoPalanca.leerEstado() == Palanca.MANTENIENDO);

	}

	@Test
	public void testEncendidoReiniciando() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando reiniciar
		assertFalse(interfaz.getPanelB().BotonReiniciar.isEnabled());
		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse(interfaz.getControl().estadoPalanca.leerEstado() == Palanca.REINICIANDO);

	}

	@Test
	public void testEncendidoParar() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando parar
		assertFalse(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse(interfaz.getControl().estadoPalanca.leerEstado() == Palanca.APAGADO);

	}

	@Test
	public void testEncendidoAcelerar() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando acelerar
		assertTrue(interfaz.getPanelB().BotonAcelerar.isEnabled());
		interfaz.getPanelB().BotonAcelerar.setSelected(true);
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getControl().acelera.leerEstado());

	}

	@Test
	public void testPararMantener() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando mantener
		assertFalse(interfaz.getPanelB().BotonMantener.isEnabled());
		interfaz.getPanelB().BotonMantenerActionPerformed(evento);
		assertFalse(interfaz.getControl().estadoPalanca.leerEstado() == Palanca.MANTENIENDO);
	}

	@Test
	public void testPararEncendido() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse(interfaz.getPanelB().BotonEncender.isEnabled());
		interfaz.getPanelB().BotonEncender.setSelected(false);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		assertFalse(interfaz.getControl().motor.leerEstado());

	}

	@Test
	public void testParadoFrenando() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando frenar
		assertTrue(interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getControl().freno.leerEstado());

	}

	@Test
	public void testPararReiniciando() { 
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando reiniciar
		assertTrue(interfaz.getPanelB().BotonReiniciar.isEnabled());
		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getControl().estadoPalanca.leerEstado() == Palanca.REINICIANDO);
	}

	@Test
	public void testParadoAcelerando() {
		// Enciendo el coche
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Intentando acelerar
		assertTrue(interfaz.getPanelB().BotonAcelerar.isEnabled());
		interfaz.getPanelB().BotonAcelerar.setSelected(true);
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(interfaz.getControl().acelera.leerEstado());
	}

	@Test
	public void testEncendido() {
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("No puedo encender como deberia", interfaz.getPanelB().BotonEncender.isEnabled());
		//Enciendo
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("No se enciende el motor como deberia", interfaz.getControl().motor.leerEstado());
		//Apago
		interfaz.getPanelB().BotonEncender.setSelected(false);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("No se apaga el motor como deberia", interfaz.getControl().motor.leerEstado());
	}

	@Test
	public void testApagadoAcelerar() {

		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse("Esta activado el boton acelerar cuando no deberia", interfaz.getPanelB().BotonAcelerar.isEnabled());

		// Acelero
		interfaz.getPanelB().BotonAcelerar.setSelected(true);
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		//No se deberia poder acelerar
		assertFalse("He acelerado cuando no debería", interfaz.getControl().acelera.leerEstado());
	}

	@Test
	public void testApagadoMantener() {
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse("Esta activado el boton mantener cuando no deberia", interfaz.getPanelB().BotonMantener.isEnabled());

		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		// Espero un par de vueltas
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertNotEquals("He mantenido la velocidad cuando no debería", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());
	}

	@Test
	public void testApagadoParar() {
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("Esta activado el boton mantener cuando no deberia", interfaz.getPanelB().BotonParar.isEnabled());
		
		interfaz.getPanelB().BotonPararActionPerformed(evento);
		
		// Espero un par de vueltas
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		assertNotEquals("He parado cuando no deberia", Palanca.APAGADO, interfaz.getControl().estadoPalanca.leerEstado());
	}

	@Test
	public void testApagadoReiniciar() {

		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("Está activado el boton de reiniciar cuando no deberia", interfaz.getPanelB().BotonReiniciar.isEnabled());

		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		// Espero un par de vueltas
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertNotEquals("He reinicado cuando no deberia", Palanca.REINICIANDO,interfaz.getControl().estadoPalanca.leerEstado());
	}

	@Test
	public void testApagadoFrenar() {
		// Espero al refresco de pantalla
		try {
			Thread.sleep(110);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("Está activado el boton de freno cuando no deberia", interfaz.getPanelB().BotonFreno.isEnabled());

		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		// Espero un par de vueltas
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("He frenado cuando no deberia", interfaz.getControl().freno.leerEstado());
	}


	@Test
	public void testAcelerarApagar() {
		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("He apagado el motor cuando no deberia", interfaz.getControl().motor.leerEstado());
	}
	@Test
	public void testAcelerarEncender() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("El boton de encendido está activado cuando no deberia", interfaz.getPanelB().BotonEncender.isEnabled());
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("He encendido cuando no deberia", interfaz.getControl().motor.leerEstado());
	}

	@Test
	public void testAcelerarMantener() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("No he mantenido cuando deberia", interfaz.getControl().estadoPalanca.leerEstado() == Palanca.MANTENIENDO);
	}

	@Test
	public void testAcelerarReiniciar() {
		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse("He reinciado cuando no deberia", interfaz.getControl().estadoPalanca.leerEstado() == Palanca.REINICIANDO);
	}
	@Test
	public void testAcelerarFrenar() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("El boton de frenar está activado cuando no deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse("He frenado cuando no deberia", interfaz.getControl().freno.leerEstado());
	}
	
	@Test
	public void testAcelerarParar() {
		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("He parado cuando no deberia", interfaz.getControl().estadoPalanca.leerEstado() == Palanca.APAGADO);
	}

	@Test
	public void testFrenarMantener() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Freno
		assertTrue("El freno no esta activado cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// No puedo mantener mientras freno
		assertFalse("No deberia estar activado mantener", interfaz.getPanelB().BotonMantener.isEnabled());
		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNotEquals("Se ha mantenido cuando no deberia", interfaz.getControl().estadoPalanca.leerEstado(),Palanca.MANTENIENDO);
	}

	@Test
	public void testFrenarReiniciar() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		// Freno
		assertTrue("El freno no esta activado cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// No puedo reinciar mientras freno
		assertFalse("Esta activado el reinicio cuando no deberia", interfaz.getPanelB().BotonReiniciar.isEnabled());
		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNotEquals("He cambiado a reinciar cuando no deberia", interfaz.getControl().estadoPalanca.leerEstado() , Palanca.REINICIANDO);
	}

	@Test
	public void testFrenarParar() {

		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		// Freno
		assertTrue("El freno no esta activado cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Puedo parar mientras freno
		assertTrue("El boton de para no esta activado cuando deberia", interfaz.getPanelB().BotonParar.isEnabled());
		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("No he podido cambiar a parar cuando deberia", interfaz.getControl().estadoPalanca.leerEstado(), Palanca.APAGADO);
	}

	@Test
	public void testFrenarAcelerar() {
		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Freno
		assertTrue("El freno no esta activado cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Puedo acelerar mientras freno.
		assertFalse("El boton de acelerar esta activado cuando no deberia", interfaz.getPanelB().BotonAcelerar.isEnabled());
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertFalse("He acelerado cuando no deberia", interfaz.getControl().acelera.leerEstado());
	}

	@Test
	public void testFrenarApagar() {
		// Enciendo
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Freno
		assertTrue("El freno no esta activado cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());
		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);
		

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Puedo apagar mientras freno
		assertFalse("El boton de apagar esta activado cuando no deberia", interfaz.getPanelB().BotonEncender.isEnabled());
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("He apagado cuando no deberia", interfaz.getControl().motor.leerEstado());
	}

	@Test
	public void testMantenerApagar() {
 
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No se ha mantenido cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());

		assertFalse("No deberia poder apagar si estoy manteniendo", interfaz.getPanelB().BotonEncender.isEnabled());

		interfaz.getPanelB().BotonEncender.setSelected(false);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("Se ha apagado cuando no deberia", interfaz.getControl().motor.leerEstado());
	}

	@Test
	public void testMantenerReiniciar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertEquals("No se ha mantenido cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());

		assertFalse("El boton de reiniciar esta activado cuando no deberia", interfaz.getPanelB().BotonReiniciar.isEnabled());

		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertEquals("Se ha reiniciado cuando no deberia", Palanca.REINICIANDO, interfaz.getControl().estadoPalanca.leerEstado());

	}
	
	@Test
	public void testMantenerParar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonMantenerActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertEquals("No se ha mantenido cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());


		assertTrue("No se puede parar cuando se deberia", interfaz.getPanelB().BotonParar.isEnabled());

		interfaz.getPanelB().BotonPararActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No esta parado cuando deberia", Palanca.APAGADO, interfaz.getControl().estadoPalanca.leerEstado());

	}


	@Test
	public void testMantenerFrenar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonMantenerActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertEquals("No se ha mantenido cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());


		assertTrue("No esta activado el boton de frenar cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());

		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("No he podido frenar cuando deberia", interfaz.getControl().freno.leerEstado());
	}
	@Test
	public void testMantenerAcelerar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonMantenerActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No se ha mantenido cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());
		

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertEquals("No se ha puesto en apagar cuando deberia", Palanca.APAGADO, interfaz.getControl().estadoPalanca.leerEstado());
		assertTrue("No se acelera cuando deberia", interfaz.getControl().acelera.leerEstado());
	}

	@Test
	public void testReiniciarApagar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertFalse("Puedo apagar cuando no deberia", interfaz.getPanelB().BotonEncender.isEnabled());

		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue("Se ha apagado cuando no se deberia", interfaz.getControl().motor.leerEstado());
	}
	@Test
	public void testReiniciarMantener() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertTrue("No he podido reiniciar cuando deberia", interfaz.getPanelB().BotonReiniciar.isEnabled());

		interfaz.getPanelB().BotonMantenerActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No estoy manteniendo cuando deberia", Palanca.MANTENIENDO, interfaz.getControl().estadoPalanca.leerEstado());
	}

	@Test
	public void testReiniciarParar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertFalse("Puedo parar cuando no deberia", interfaz.getPanelB().BotonParar.isEnabled());

		interfaz.getPanelB().BotonPararActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("He parado cuando no deberia", Palanca.APAGADO, interfaz.getControl().estadoPalanca.leerEstado());
	}
	@Test
	public void testReiniciarFrenar() {

		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("No puedo frenar cuando deberia", interfaz.getPanelB().BotonFreno.isEnabled());

		interfaz.getPanelB().BotonFreno.setSelected(true);
		interfaz.getPanelB().BotonFrenoActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("No he frenado cuando deberia", interfaz.getControl().freno.leerEstado());
	}
	
	@Test
	public void testReiniciarAcelerar() {


		// Enciendo el motor
		interfaz.getPanelB().BotonEncender.setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		interfaz.getPanelB().BotonReiniciarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("Acelerar esta desactivado cuando no deberia", interfaz.getPanelB().BotonAcelerar.isEnabled());

		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);


		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		assertTrue("No se ha acelerado cuando deberia", interfaz.getControl().acelera.leerEstado());
	}



}
