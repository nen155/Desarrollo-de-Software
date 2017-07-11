package ControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestAutomatico {
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
	public void testMantenerVelocidad() {
        //Enciendo
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        //Acelero
        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
        //Espero un par de vueltas
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Mantengo la velocidad
        interfaz.getPanelB().BotonMantenerActionPerformed(evento);
        //Leo la velocidad mantenida
        int velocidadAMantener = interfaz.getControl().almacena.leerVelocidad();
        
        //Espero un par de vueltas
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("La velocidad no ha sido mantenida como deberia",velocidadAMantener,interfaz.getControl().almacena.leerVelocidad());
        
        
	}

}
