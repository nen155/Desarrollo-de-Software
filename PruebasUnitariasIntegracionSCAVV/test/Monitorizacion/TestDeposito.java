package Monitorizacion;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestDeposito {
	private Interfaz interfaz;
	MouseEvent mouseEvent;
    ActionEvent evento;
    double depositoT;
    final double RATIO_CONUSMO = 0.0000000005;
    
    @Before
    public void setUp() throws Exception {
        interfaz = new Interfaz();
        mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
        evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
        
    }
	@Test
	public void testActualizarDeposito() {
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
        depositoT = 100- ((300*(300/15))*RATIO_CONUSMO);
        //Compruebo si el nivel actual del deposito se corresponde con el que debería
        assertTrue(interfaz.getMonitor().getDeposi().leerNivelActual()==depositoT);
        
	}

}
