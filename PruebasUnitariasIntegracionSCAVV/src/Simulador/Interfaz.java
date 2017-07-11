package Simulador;
import javax.swing.*;
import ControlVelocidad.*;
import Monitorizacion.*;

@SuppressWarnings("serial")
public class Interfaz extends JApplet {
	JLabel etiquetaVelAuto, etiquetaEstado;
	Simulacion simulacion;
	Monitorizacion monitor;
	ControlVelocidad control;
	PanelBotones panelB;
	PanelEtiquetas panelE;
	
	///Añadido
	
	public PanelBotones getPanelB() {
		return panelB;
	}
	public PanelEtiquetas getPanelE() {
		return panelE;
	}
	public Monitorizacion getMonitor() {
		return monitor;
	}
	public ControlVelocidad getControl() {
		return control;
	}
	///Añadido
	
	public void init(){
		this.setSize(800,600);
	}
	public Interfaz(){
		panelE = new PanelEtiquetas(this);
		panelB = new PanelBotones(this);
		simulacion =new Simulacion(panelE,panelB);
		control = new ControlVelocidad();
		monitor = new Monitorizacion(control.eje);		
		panelE.aniadirComponentes(monitor, control);
		panelB.aniadirComponentes(monitor, control);
		simulacion.start();			
		control.start();
		monitor.start();
		add(panelB);		
		add(panelE);
		setVisible(true);
		destroy();
	}
}