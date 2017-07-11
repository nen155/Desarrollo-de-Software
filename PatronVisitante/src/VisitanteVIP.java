
public class VisitanteVIP extends VisitanteEquipo {

	double precio=0;
	static int visitas=0;
	String nombres = "";
	
	public double getPrecio() {
		return precio;
	}
	

	public static int getVisitas() {
		return visitas;
	}


	public String getNombres() {
		return nombres;
	}


	@Override
	public void VisitarDisco(Disco d) {
		// TODO Auto-generated method stub
		visitas++;
		double precioFinal=d.precioNeto();
			if(visitas>=25){
				precioFinal=d.precioConDescuento();
			}
		precio += precioFinal -(precioFinal*0.10);
		nombres+=" "+d.nombre();
	}

	@Override
	public void VisitarTarjeta(Tarjeta t) {
		// TODO Auto-generated method stub
		visitas++;
		double precioFinal=t.precioNeto();
			if(visitas>=25){
				precioFinal=t.precioConDescuento();
			}
		precio += precioFinal -(precioFinal*0.10);
		nombres+=" "+t.nombre();
	}

	@Override
	public void VisitarBus(Bus b) {
		// TODO Auto-generated method stub
		visitas++;
		double precioFinal=b.precioNeto();
			if(visitas>=25){
				precioFinal=b.precioConDescuento();
			}
		precio += precioFinal -(precioFinal*0.10);
		nombres+=" "+b.nombre();
		
	}


	@Override
	public String toString() {
		int descuento=10;
		if(VisitanteVIP.getVisitas()>=25)
			descuento+=5;
		return this.getClass().getSimpleName()+"\t\t"+VisitanteVIP.getVisitas() +"\t\t\t" + precio  + "\t\t\t"+descuento+"%" + "\t\t\t" + nombres;
	}
	

}
