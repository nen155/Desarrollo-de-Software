package ControlVelocidad;
public class Acelerador implements Pedal {
	private boolean _estado;
	private final int aceleracion=300;
	public static final int ROZAMIENTO=100;
	private Eje eje;
	private double velAnt;
	public Acelerador() {
		_estado = false;
	}
	public void incrementar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion);
	}
	public double actualizarAcelerador(double velAnterior) {
		velAnt = velAnterior;
		return (aceleracion - (ROZAMIENTO*0.015*velAnterior));
	}
	public void soltarAcelerador() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void pisarAcelerador() {
		_estado = true;
	}

	@Override
	public void soltar() {
		this.soltarAcelerador();
		
	}
	@Override
	public int actualizar() {
		return (int)this.actualizarAcelerador(velAnt);
		
	}
	
}