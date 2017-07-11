
public class GestionGraficaPantalla {
	 static Observador observador;
	 private static GestionGraficaPantalla pantalla;
	 
	 public  static GestionGraficaPantalla getPantalla() {
	 
	 if (pantalla==null) {
		 pantalla = new GestionGraficaPantalla();
	 }
	 return pantalla;
	 }
	 
	 private GestionGraficaPantalla(){

	 }
	 public static void setObservador(Observador o){
		 observador = o;
	 }

	public static void refrescarPantalla(){
		if(observador instanceof botonCambio)
		System.out.println("La temperatura en grados Celsius: "+observador.getTemperatura()+"Cº Farenheit: "+(observador.getTemperatura()+32));
		else
			if(observador instanceof graficaTemperatura)
				System.out.println("Gráfica en grados Celsius: "+observador.getTemperatura()+"Cº Farenheit: "+(observador.getTemperatura()+32));
			else
				if(observador instanceof tiempoSatelital)
					System.out.println("Tiempo satelital en grados Celsius: "+observador.getTemperatura()+"Cº Farenheit: "+(observador.getTemperatura()+32));
	}
}

