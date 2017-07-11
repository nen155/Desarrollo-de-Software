import java.util.ArrayList;

public class ObservablePantalla extends Observable {
	
	int temperatura;
	
	ArrayList<Observador> observadores;
	
	public ObservablePantalla() {
		super();
		this.observadores = new ArrayList();
	}
	

	public int getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}


	@Override
	public void incluirObservador(Observador o) {
		observadores.add(o);
		
	}

	@Override
	public void notificarObservador() {
		for(Observador o:observadores){
			o.manejarEvento();
		}
		
	}

}
