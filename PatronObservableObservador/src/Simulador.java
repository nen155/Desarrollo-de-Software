import java.util.Random;

public class Simulador extends Thread {
	int t2,t1;
	ObservablePantalla observablePantalla;
	public Simulador(int t1,int t2,ObservablePantalla observablePantalla){
		this.t1=t1;
		this.t2=t2;
		this.observablePantalla =observablePantalla;
	}
	
	public void run(){
		Random r= new Random(t2);

		int temperatura;

		while (true){
			
		  temperatura= r.nextInt((t2-t1)+1)+t1;
		  observablePantalla.setTemperatura(temperatura);

		  try {
			  sleep(6000);
		  }
		  catch(java.lang.InterruptedException e){
		    e.printStackTrace();
		  }

		  observablePantalla.notificarObservador();

		}
	}
	
}
