package ChicaJimenezEmilio1;

public class FactoriaCuadroMontana implements FactoriaPieza {

	@Override
	public Pieza crearPieza() {
		// TODO Auto-generated method stub
		return new CuadroMontana();
	}

}
