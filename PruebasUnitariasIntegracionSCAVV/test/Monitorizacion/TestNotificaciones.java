package Monitorizacion;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestNotificaciones {
	
	private Interfaz interfaz;
	MouseEvent mouseEvent;
    ActionEvent evento;
	
	@Before
	public void setUp() {
		interfaz = new Interfaz();
		mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
        evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
	}
	
	@Test
	public void testNotificarAceite() {
		interfaz.getPanelB().getBotonEncender().setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		
		
		//Establezco las revoluciones necesarias para que salte la notificación
		interfaz.getControl().eje.setVueltasTotales(500000);
		
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue("No se ha notificado el aceite como debería", interfaz.getMonitor().getNotify().notificarAceite());
	}

	@Test
	public void testNotificarPastillas() {

		interfaz.getPanelB().getBotonEncender().setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
		
		//Establezco revoluciones para que salte el aviso de las pastillas
		interfaz.getControl().eje.setVueltasTotales(1000000);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue("No se han notificado las pastillas como debería", interfaz.getMonitor().getNotify().notificarPastillas());
	}

	@Test
	public void testNotificarRevision() {
		
		interfaz.getPanelB().getBotonEncender().setSelected(true);
		interfaz.getPanelB().BotonEncenderActionPerformed(evento);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.getPanelB().BotonAcelerarActionPerformed(evento);

		
		//Establezco las vueltas necesarias para que se notifique la revision
		interfaz.getControl().eje.setVueltasTotales(10000000);
		
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue("No se han notificado la revision como debería", interfaz.getMonitor().getNotify().notificarRevision());
	}


}
