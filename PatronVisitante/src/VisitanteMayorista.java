
public class VisitanteMayorista extends VisitanteEquipo {

	double precio=0;
	String nombres = "";
	static int visitas=0;
	
	public double getPrecio() {
		return precio;
	}
	

	public String getNombres() {
		return nombres;
	}
	

	public static int getVisitas() {
		return visitas;
	}


	@Override
	public void VisitarDisco(Disco d) {
		// TODO Auto-generated method stub
		visitas++;
		double precioFinal=d.precioNeto();
			if(visitas>=25){
				precioFinal=d.precioConDescuento();
			}
		precio += precioFinal -(precioFinal*0.15);
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
		precio += precioFinal -(precioFinal*0.15);
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
		precio += precioFinal -(precioFinal*0.15);
		nombres+=" "+b.nombre();
		
	}

	@Override
	public String toString() {
		int descuento=15;
		if(VisitanteMayorista.getVisitas()>=25)
			descuento+=5;
		return this.getClass().getSimpleName()+"\t"+VisitanteMayorista.getVisitas() +"\t\t\t" + precio + "\t\t\t"+descuento+"%" + "\t\t\t" + nombres;
	}

}
