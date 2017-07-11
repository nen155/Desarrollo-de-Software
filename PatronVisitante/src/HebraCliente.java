
public class HebraCliente extends Thread {
	Thread hilo;
	VisitanteEquipo ve;
	public HebraCliente(VisitanteEquipo cliente){
		ve = cliente;
		
	}
	public void run(){
		Disco ssd = new Disco("Disco SSD 2,5 500GB");
		ve.VisitarDisco(ssd);
		Tarjeta red = new Tarjeta("TPLink 2,4GHz B/G/N 1w");
		ve.VisitarTarjeta(red);
		Bus bus = new Bus("Bus bidireccional 6Gb/s");
		ve.VisitarBus(bus);
		System.out.println(ve.toString());
	}
	public void start () {
		 if (hilo == null) {
		      hilo = new Thread (this, "Clientes");
		      hilo.start ();
		    }
	}

}
