package ChicaJimenezEmilio1;

import java.util.ArrayList;

public class FactoriaCarrera implements Carrera {
	
	public ArrayList<Bicicleta> crearCarrera(Bicicleta.TC tipo) {
		ArrayList<Bicicleta> carrera = null;
		if(tipo==Bicicleta.TC.MONTANA){
			FactoriaCarreraMontana fcm = new FactoriaCarreraMontana();
			carrera = fcm.crearCarrera(tipo);
		}
		else if(tipo==Bicicleta.TC.CARRETERA){
			FactoriaCarreraCarretera fcc = new FactoriaCarreraCarretera();
			carrera = fcc.crearCarrera(tipo);
		}
		
		return carrera;
	}

}
