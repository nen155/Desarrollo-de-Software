package ChicaJimenezEmilio1;

public class FactoriaManillarMontana implements FactoriaPieza {

	@Override
	public Pieza crearPieza() {
		return new ManillarMontana();
	}

}
