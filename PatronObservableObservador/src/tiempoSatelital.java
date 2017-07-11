
public class tiempoSatelital implements Observador {
	ObservablePantalla observablePantalla;
	
	public tiempoSatelital(ObservablePantalla observablePantalla) {
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
