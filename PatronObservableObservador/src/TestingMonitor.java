
public class TestingMonitor {
	public static void main(String[] args){
		ObservablePantalla observablePantalla = new ObservablePantalla();
		Simulador s = new Simulador(3,20,observablePantalla);
		
		botonCambio b = new botonCambio(observablePantalla);
		tiempoSatelital t = new tiempoSatelital(observablePantalla);
		graficaTemperatura g = new graficaTemperatura(observablePantalla);
		
		observablePantalla.incluirObservador(b);
		observablePantalla.incluirObservador(g);
		observablePantalla.incluirObservador(t);
		s.run();
	}

}
