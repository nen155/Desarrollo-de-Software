package ChicaJimenezEmilio1;

import java.util.ArrayList;

public class HebraCarreraCarretera extends Thread {
	 private Thread hilo;
	ArrayList<Bicicleta> carrera = null;
	FactoriaCarrera fc =null;
	public HebraCarreraCarretera(FactoriaCarrera fc,ArrayList<Bicicleta> carrera){
		this.fc=fc;
		this.carrera = carrera;
	}
	public void start () {
		 if (hilo == null) {
		      hilo = new Thread (this, "Carretera");
		      hilo.start ();
		    }
	}
	public Thread getThread(){
		return hilo;
	}
	public void run(){	
		for(int i=0;i<TestingCarrera.N;++i)
			if(i<carrera.size()){
				if(i<((carrera.size()*20/100)+TestingCarrera.BicicletasRetiradas)){
					System.out.println("Dorsal "+(i+1)+" RETIRADA "+carrera.get(i).toString());
					carrera.remove(i);
				}
				else{
					System.out.println("Dorsal "+(i+1)+" "+carrera.get(i).toString());
				}
			}
	}

}
