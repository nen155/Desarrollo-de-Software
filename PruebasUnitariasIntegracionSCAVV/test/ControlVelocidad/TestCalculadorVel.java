package ControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestCalculadorVel {
	 private Interfaz interfaz;
	 public final double RADIO = 0.8;
	 private MouseEvent mouseEvent;
	 private ActionEvent evento;
	 double velocidadT;

	@Before
	public void setUp() throws Exception {
	    interfaz = new Interfaz();
	    mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
	    evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
	    velocidadT = (300*RADIO)/40;
	}
	   
	@Test
	public void testCalcularVelocidad() {
	        // Enciendo
	        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
	        // Acelero
	        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
	        //Espero una vuelta
	        try {
	            Thread.sleep(250);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        assertEquals("La velocidad no es la esperada",velocidadT,interfaz.getControl().almacena.leerVelocidad(),0);
	}

}
