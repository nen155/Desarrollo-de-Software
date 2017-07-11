package ControlVelocidad;
 
import static org.junit.Assert.*;
 
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
import Simulador.Interfaz;
 
public class TestReloj {
    private Interfaz interfaz;
    private  MouseEvent mouseEvent;
    private ActionEvent evento;
    @Before
    public void setUp() throws Exception {
        interfaz = new Interfaz();
        mouseEvent= new MouseEvent(new Label(),0,0,0,0,0,0, false);
        evento = new ActionEvent(mouseEvent.getSource(), mouseEvent.getID(), mouseEvent.paramString());
    }

    @Test
    public void testRun() {
        // Arranco
        interfaz.getPanelB().getBotonEncender().setSelected(true);
        interfaz.getPanelB().BotonEncenderActionPerformed(evento);
        // Acelero
        interfaz.getPanelB().BotonAcelerarActionPerformed(evento);
        assertTrue("La velocidad no es 0 como debería", interfaz.getControl().almacena.leerVelocidad()==0);
        //Espero un par de vueltas del reloj
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue("La velocidad no ha aumentado como debería", interfaz.getControl().almacena.leerVelocidad()>0);
         
    }
}