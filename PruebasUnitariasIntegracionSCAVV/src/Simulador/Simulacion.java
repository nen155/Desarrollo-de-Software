package Simulador;
public class Simulacion extends Thread {
    private final int INTERVALO = 100;
    private ListaObservadoresObservables listaOO;
     
    public Simulacion(PanelEtiquetas panelEtiquetas, PanelBotones panelBotones){
    	//CAMBIADO
    	listaOO = new ListaObservadoresObservables();
    	listaOO.agregarObservador(panelEtiquetas);
    	listaOO.agregarObservador(panelBotones);
        //CAMBIADO
    }
    //Añadido
    public ListaObservadoresObservables getListaOO() {
		return listaOO;
	}
    //Añadido
	public void run() {
        while(true){
            try{ 
                sleep(INTERVALO);
            }catch(java.lang.InterruptedException e){e.printStackTrace();}
            listaOO.notificarObservador();
        }
    }
}