
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.*;

public class PanelBotones extends JPanel {

	
	
  private JButton BotonAcelerar;
  private JToggleButton BotonEncender;

  private JLabel EtiqMostrarEstado;
  
	

  public PanelBotones(){ 
	//Crear objetos-botones, etiquetas
	  BotonAcelerar = new JButton("Acelerar");
	  BotonEncender = new JToggleButton("Encender");
	  EtiqMostrarEstado = new JLabel("Apagado");
		//Fijar el aspecto de los paneles con setLayout() y setBorder()
	  	this.setLayout(new BorderLayout ());
	//crear subpaneles: ... new JPanel()
	  JPanel subpanel = new JPanel();
	//Adaptar las etiquetas e incluirlas en lo subpaneles
	  Border raisedbevel, loweredbevel;
	  raisedbevel = BorderFactory.createRaisedBevelBorder();
	  loweredbevel = BorderFactory.createLoweredBevelBorder();
	  subpanel.setBorder(raisedbevel);
	  subpanel.setPreferredSize(new Dimension(450, 75));
	  JPanel subpanel2 = new JPanel(null);
	  subpanel2.setBorder(raisedbevel);
	  subpanel2.setPreferredSize(new Dimension(450, 75));
	  BotonEncender.setBounds(subpanel2.getPreferredSize().width-335, 40, 100, 25);
	  BotonAcelerar.setBounds(subpanel2.getPreferredSize().width-210, 40, 100, 25);
	  BotonEncender.setForeground(new java.awt.Color (255 , 0 ,0 ) ) ;
	  BotonAcelerar.addActionListener(new ActionListener() {
			  public void actionPerformed (ActionEvent evt ) {
				  BotonAcelerarActionPerformed ( evt ) ; }
			   } ) ;
	  
	  BotonEncender.addActionListener(new ActionListener() {
		  public void actionPerformed (ActionEvent evt ) {
			  BotonEncenderActionPerformed ( evt ) ; }
		   } ) ;
	  EtiqMostrarEstado.setForeground(new java.awt.Color (255 , 0 ,0 ));
		//subpanel.add(EtiqMostrarEstado); this.add(subpanel2); ...
	  subpanel.add(EtiqMostrarEstado);
	  this.add(subpanel,BorderLayout.NORTH );
	//...lo mismo con los 2 botones
	  subpanel2.add(BotonEncender);
	  subpanel2.add(BotonAcelerar);
	  
	  this.add(subpanel2,BorderLayout.SOUTH );
		
  };//constructor

    	//Recogedor de eventos del boton Encender
    synchronized private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt){
	    	if (BotonEncender.isSelected()){
	    	//Programar el cambio de aspecto del botón
	    		BotonEncender.setText("Apagar");
	    		BotonEncender.setForeground(new java.awt.Color (0 , 0 ,255 ) ) ;
	    		EtiqMostrarEstado.setText( "Encendido" ) ;
	    	}
	    	else{
	    	//Programar el cambio de aspecto del botón
	    		BotonEncender.setText("Encender");
	    		BotonEncender.setForeground(new java.awt.Color (255 , 0 ,0 ) ) ;
	    		EtiqMostrarEstado.setText( "Apagado" ) ;
	    	}
    }
    	//Recogedor de eventos del boton Acelerar
    synchronized private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt){
    	if (BotonEncender.isSelected()){
	    	 EtiqMostrarEstado.setForeground(new java.awt.Color (255 , 0 ,0 ) ) ;
	    	 EtiqMostrarEstado.setText( "ACELERANDO" ) ;
    	}

    };

}
