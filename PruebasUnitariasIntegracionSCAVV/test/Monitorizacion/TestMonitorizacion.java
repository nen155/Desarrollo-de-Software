package Monitorizacion;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestMonitorizacion {

	Interfaz interfaz;
	MouseEvent mouseEvent;
	ActionEvent evento;

	@Before
	public void setUp() {
		this.interfaz = new Interfaz();
		mouseEvent = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
		evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
	}

	@Test
	public void testComprobarNotificacionesAceite() {
		// Enciendo
		interfaz.getPanelB().getBotonEncender().setSelected(true);
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

		// Establezco las revoluciones necesarias para que salte la notificación
		interfaz.getControl().eje.setVueltasTotales(500000);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No se ha notificado el aceite como debería", Notificaciones.NOTIFACEITE,
				interfaz.getMonitor().comprobarNotificacionesAceite());
	}

	@Test
	public void testComprobarNotificacionesPastillas() {

		// Enciendo
		interfaz.getPanelB().getBotonEncender().setSelected(true);
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

		// Establezco revoluciones para que salte el aviso de las pastillas
		interfaz.getControl().eje.setVueltasTotales(1000000);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No se han notificado las pastillas como debería", Notificaciones.NOTIFPASTILLAS,
				interfaz.getMonitor().comprobarNotificacionesPastillas());
	}

	@Test
	public void testComprobarNotificacionesGeneral() {

		// Enciendo
		interfaz.getPanelB().getBotonEncender().setSelected(true);
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

		// Establezco las vueltas necesarias para que se notifique la revision
		interfaz.getControl().eje.setVueltasTotales(10000000);

		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals("No se han notificado la revision como debería", Notificaciones.NOTIFREV,
				interfaz.getMonitor().comprobarNotificacionesGeneral());
	}
}
