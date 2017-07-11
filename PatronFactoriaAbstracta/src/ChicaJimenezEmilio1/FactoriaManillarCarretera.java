package ChicaJimenezEmilio1;

public class FactoriaManillarCarretera implements FactoriaPieza {

	@Override
	public Pieza crearPieza() { 
		return new ManillarCarretera();
	}

}
