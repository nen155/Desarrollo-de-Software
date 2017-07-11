package ControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestEje {
	private Interfaz interfaz;
	private MouseEvent mouseEvent;
	private ActionEvent evento;
	private final double RADIO = 0.8;
	double velAnterior;
	int incrementoT; 
	int vueltasT;
	
    @Before
    public void setUp() throws Exception {
        interfaz = new Interfaz();
        mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
        evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
        velAnterior =  (300*RADIO)/40;
        incrementoT= (int) (300 - (100* 0.015 *velAnterior));
        vueltasT =  300+incrementoT;
    }

	@Test
	public void testIncrementarVueltas() {
        // Enciendo el coche
        interfaz.getPanelB().getBotonEncender().setSelected(true);
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        //Acelero
        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
        //Espero dos refrescos del reloj
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Compruebo si el nivel actual del deposito se corresponde con el que debería
        assertTrue(interfaz.getMonitor().getEje().leerRevoluciones()==vueltasT);
	}
	@Test
	public void testCalcularVelocidad() {
        // Enciendo el coche
        interfaz.getPanelB().getBotonEncender().setSelected(true);
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        //Acelero
        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
        //Espero dos refrescos del reloj
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long vueltasTotalesT = 300/24+(vueltasT/24);

        //Compruebo si el nivel actual del deposito se corresponde con el que debería
        assertTrue(interfaz.getMonitor().getEje().leerRevolucionesTotales()==vueltasTotalesT);
	}

}
