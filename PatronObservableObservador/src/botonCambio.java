
public class botonCambio implements Observador {
	
	ObservablePantalla observablePantalla;
	
	public void setTemperatura(int t){
		observablePantalla.setTemperatura(t);
	}
	
	public botonCambio(ObservablePantalla observablePantalla) {
		super();
		this.observablePantalla = observablePantalla;
	}
	@Override
	public int getTemperatura(){
		return observablePantalla.getTemperatura();
	}

	@Override
	public void manejarEvento() {
		GestionGraficaPantalla.getPantalla().setObservador(this);
		GestionGraficaPantalla.getPantalla().refrescarPantalla();
	}

}
