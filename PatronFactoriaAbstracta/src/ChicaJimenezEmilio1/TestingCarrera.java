package ChicaJimenezEmilio1;

import java.util.ArrayList;
import java.util.Random;

public class TestingCarrera extends Thread {

	final static int N=20;
	static Random r = new Random();
	final static int BicicletasRetiradas = r.nextInt((N*10/100));
	public static void main(String[] args){
		ArrayList<Bicicleta> carrera1 = null;
		ArrayList<Bicicleta> carrera2 = null;
		System.out.println("Carrera con "+ N + " de montaña y " + N  + " de carretera");
		FactoriaCarrera fc = new FactoriaCarrera();

		carrera1=(fc.crearCarrera(Bicicleta.TC.CARRETERA));
		carrera2=(fc.crearCarrera(Bicicleta.TC.MONTANA));
		  try {
			  sleep(6000);
		  }
		  catch(java.lang.InterruptedException e){
		    e.printStackTrace();
		  }
		HebraCarreraCarretera hc = new HebraCarreraCarretera(fc,carrera1);
		HebraCarreraMontana hm = new HebraCarreraMontana(fc,carrera2);
		hc.start();
		hm.start();

		try {
			hc.getThread().join();
			hm.getThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bicicletas de Carretera retiradas: " + (N-carrera1.size()));
		System.out.println("Bicicletas de Montaña retiradas: " + (N-carrera2.size()));
	}
}
