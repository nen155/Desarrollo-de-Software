package ChicaJimenezEmilio1;

public class FactoriaCuadroCarretera implements FactoriaPieza {

	@Override
	public Pieza crearPieza() {
		return new CuadroCarretera();
	}

}
