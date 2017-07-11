
public class Calcular implements Filtro{
	double radio = 0.3;
	public double ejecutar(Object o) {
		double revoluciones = (double)o;
		revoluciones = (revoluciones*2*Math.PI)/60;
		double velocidad= revoluciones*radio;
		System.out.printf("Nueva velocidad: %.2f (m/s)\n",velocidad);
		return velocidad;
	}
}
