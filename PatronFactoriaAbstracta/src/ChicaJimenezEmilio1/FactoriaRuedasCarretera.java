package ChicaJimenezEmilio1;

public class FactoriaRuedasCarretera implements FactoriaPieza {

	@Override
	public Pieza crearPieza() {
		return new RuedaCarretera();
	}

}
