package ControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Simulador.Interfaz;
import Simulador.PanelBotones;

@RunWith(Parameterized.class)
public class TestPedal {
	
	private Interfaz interfaz;
	private Pedal pedal;
	private MouseEvent mouseEvent;
	private ActionEvent evento;
	private PanelBotones panelBotones;

	public TestPedal(Interfaz inter,Pedal pedal){
		this.interfaz =inter;
		this.pedal =pedal;

	}
	 @Before
	public void setUp() throws Exception {
		 mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
		 evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
		 panelBotones=interfaz.getPanelB();
	}
	
	@Parameters
    public static Collection<Object[]> data() {
    		Interfaz inter = new Interfaz();
            return Arrays.asList(
            		new Object[]{inter,inter.getControl().acelera},
            		new Object[]{inter,inter.getControl().freno});
    }
    
	@Test
	public void testActualizar() {
		panelBotones.getBotonEncender().setSelected(true);
		panelBotones.BotonEncenderActionPerformed(evento);
		if(pedal instanceof Acelerador){
			panelBotones.BotonAcelerarActionPerformed(evento);
	        //Espero un par de vueltas del reloj
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			assertTrue("No se ha actualizado como deberia",300>pedal.actualizar());
		}else if(pedal instanceof Freno){
			panelBotones.getBotonFreno().setSelected(true);
			panelBotones.BotonFrenoActionPerformed(evento);
			assertEquals("No se ha actualizado como deberia",800,pedal.actualizar());
		}
	}
	
	@Test
	public void testSoltar() {
		panelBotones.getBotonEncender().setSelected(true);
		panelBotones.BotonEncenderActionPerformed(evento);
		 if(pedal instanceof Acelerador){
				panelBotones.BotonAcelerarActionPerformed(evento);
				panelBotones.getBotonFreno().setSelected(true);
				panelBotones.BotonFrenoActionPerformed(evento);
				assertFalse("No se ha soltado el acelerado como deberia",pedal.leerEstado());
				assertTrue("No se ha frenado como deberia",interfaz.getControl().freno.leerEstado());
		}else
			if(pedal instanceof Freno){
				panelBotones.getBotonFreno().setSelected(false);
				panelBotones.BotonFrenoActionPerformed(evento);
				assertFalse("No se ha soltado el freno como deberia",pedal.leerEstado());
			}
		
	}

}
