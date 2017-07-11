
public class CalcularDistancia implements Filtro{
	double radio = 0.3;
	public double ejecutar(Object o){
		double tiempo=100;
		double revoluciones = (double)o;
		revoluciones = (revoluciones*2*Math.PI)/60;
		double velocidad= revoluciones*radio;
		double distancia=tiempo*velocidad;
		System.out.printf("Distancia recorrida en 100s: %.2f m \n",distancia);
		return distancia;
	}
}
