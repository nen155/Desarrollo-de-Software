package ChicaJimenezEmilio1;

import java.util.ArrayList;

public class FactoriaCarreraMontana implements Carrera {

	@Override
	public ArrayList<Bicicleta> crearCarrera(Bicicleta.TC tipo) {
		ArrayList<Bicicleta> montana = new ArrayList(TestingCarrera.N);
		Pieza p = null;
		FactoriaPieza fp = null;

		for(int i=0;i<TestingCarrera.N;++i){
			BicicletaMontana b = new BicicletaMontana(tipo);
			//Añado el manillar
			 fp = new FactoriaManillarMontana();
			 p = fp.crearPieza();
			 b.addPieza(p);
			 //Añador un cuadro
			 fp = new FactoriaCuadroMontana();
			 p = fp.crearPieza();
			 b.addPieza(p);
			 //Añado dos ruedas a la bicicleta
			 fp = new FactoriaRuedasMontana();
			 p = fp.crearPieza();
			 b.addPieza(p);
			 p = fp.crearPieza();
			 b.addPieza(p);
			 //Meto la bicicleta en la carrera
			 montana.add(b);
			 
		}
		return montana;
	}
	
}
