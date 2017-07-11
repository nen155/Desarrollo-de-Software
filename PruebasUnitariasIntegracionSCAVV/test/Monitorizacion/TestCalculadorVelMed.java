package Monitorizacion;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Monitorizacion.CalculadorVelMed;
import Simulador.Interfaz;

public class TestCalculadorVelMed {

	private Interfaz interfaz;
	private CalculadorVelMed cvm;
	private MouseEvent mouseEvent;
	private ActionEvent evento;

	@Before
	public void setUp() {
		interfaz = new Interfaz();
		cvm = interfaz.getMonitor().getVelMed();
		mouseEvent = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
		evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
	}

	@Test
	public void testCalcularVelocidadMedia() {
		// Enciendo
		interfaz.getPanelB().getBotonEncender().setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue("Deberia de haber aumentado la velocidad pero no lo ha hecho", cvm.leerVelMedia() > 0.0);

	}

	@Test
	public void testCalcularGastoMedio() {
		// Enciendo
		interfaz.getPanelB().getBotonEncender().setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		// Acelero
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue("Deberia haber aumentado el gasto medio pero no lo ha hecho", cvm.leerGastoMedio() > 0.0);
	}
}
