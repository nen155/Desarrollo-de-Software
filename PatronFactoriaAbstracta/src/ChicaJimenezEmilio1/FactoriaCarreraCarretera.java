package ChicaJimenezEmilio1;

import java.util.ArrayList;


public class FactoriaCarreraCarretera implements Carrera {

		@Override
		public ArrayList<Bicicleta> crearCarrera(Bicicleta.TC tipo) {
			ArrayList<Bicicleta> carretera = new ArrayList(TestingCarrera.N);
			Pieza p = null;
			FactoriaPieza fp = null;
			
			for(int i=0;i<TestingCarrera.N;++i){
				BicicletaCarretera b = new BicicletaCarretera(tipo);
				//Añado el manillar
				 fp = new FactoriaManillarCarretera();
				 p = fp.crearPieza();
				 b.addPieza(p);
				 //Añador un cuadro
				 fp = new FactoriaCuadroCarretera();
				 p = fp.crearPieza();
				 b.addPieza(p);
				 //Añado dos ruedas a la bicicleta
				 fp = new FactoriaRuedasCarretera();
				 p = fp.crearPieza();
				 b.addPieza(p);
				 p = fp.crearPieza();
				 b.addPieza(p);
				 //Meto la bicicleta en la carrera
				 carretera.add(b);
				 
			}
			
			return carretera;
		}

}
