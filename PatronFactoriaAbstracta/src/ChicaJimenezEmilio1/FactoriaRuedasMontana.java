package ChicaJimenezEmilio1;

public class FactoriaRuedasMontana implements FactoriaPieza {

	@Override
	public Pieza crearPieza() {
		// TODO Auto-generated method stub
		return new RuedaMontana();
	}

}
