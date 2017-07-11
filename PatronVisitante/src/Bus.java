
public class Bus extends Equipo {

	public Bus(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double potencia() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public double precioNeto() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public double precioConDescuento() {
		// TODO Auto-generated method stub
		return precioNeto()-(precioNeto()*0.05);
	}

	@Override
	public void aceptar(VisitanteEquipo ve) {
		// TODO Auto-generated method stub
		ve.VisitarBus(this);
	}

}
