package ControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import Simulador.Interfaz;

public class TestControlVelocidad {
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
	public void testControlarEstado() {
        // Arranco
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        assertTrue("El motor no esta encendido como deberia",interfaz.getControl().motor.leerEstado());
        // Acelero
        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
        assertTrue("No se acelera como deberia",interfaz.getControl().acelera.leerEstado());
        // Espero 6 vueltas 
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int velocidadDeAceleracion = interfaz.getControl().almacena.leerVelocidad();
        assertTrue("No se acelera como deberia", velocidadDeAceleracion>0);
        
        //Pruebo mantener la velocidad
        interfaz.getPanelB().BotonMantenerActionPerformed(evento);
        //Guardo la velocidad mantenida
        int velocidadAMantener = interfaz.getControl().almacena.leerVelocidad();
        
        //Espero un par de vueltas
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Compruebo la velocidad mantenida
        assertEquals("La velocidad no se ha mantenido como deberia",velocidadAMantener,interfaz.getControl().almacena.leerVelocidad());
        
        //Pruebo el freno
        interfaz.getPanelB().getBotonFreno().setSelected(true);
        interfaz.getPanelB().BotonFrenoActionPerformed(evento);

        assertTrue("No frena como debería",interfaz.getControl().freno.leerEstado());
        // Espero un par de vueltas
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Intento frenar
        interfaz.getPanelB().getBotonFreno().setSelected(false);
        interfaz.getPanelB().BotonFrenoActionPerformed(evento);
        
        int velocidadFrenada =interfaz.getControl().almacena.leerVelocidad();

        assertTrue("Deberia estar desacelerando y no lo hace como deberia",velocidadDeAceleracion > velocidadFrenada);
        
        assertTrue("No se ha quedado en punto muerto como deberia",interfaz.getControl().estadoPalanca.leerEstado()==Palanca.APAGADO);
        // Espero un par de vueltas
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        assertTrue("No está habiendo rozamiento",interfaz.getControl().almacena.leerVelocidad() < velocidadFrenada );
        
        //Ahora reinicio la velocidad
        interfaz.getPanelB().BotonReiniciarActionPerformed(evento);
        // Espero a que reinicie
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        int velReincio = interfaz.getControl().almacena.leerVelocidad();
        int velSelec=interfaz.getControl().almacena.leerVelSeleccionada();

        assertTrue("El control automatico no ha sido reiniciado como deberia",(velSelec-6 <= velReincio)&&(velReincio <= velSelec+6));
        
        // Apago
        interfaz.getPanelB().getBotonEncender().setSelected(false);
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        
        //Freno
        interfaz.getPanelB().getBotonFreno().setSelected(true);
        interfaz.getPanelB().BotonFrenoActionPerformed(evento);
        // Espero una vuelta
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        velocidadFrenada = velReincio - interfaz.getControl().almacena.leerVelocidad();
        velReincio = interfaz.getControl().almacena.leerVelocidad();
        //Dejo de frenar
        interfaz.getPanelB().getBotonFreno().setSelected(false);
        interfaz.getPanelB().BotonFrenoActionPerformed(evento);
        // Espero una vuelta
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        assertTrue("No se frena como deberia",velocidadFrenada >  (velReincio - interfaz.getControl().almacena.leerVelocidad()));
		
	}
}
