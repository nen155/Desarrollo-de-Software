package ChicaJimenezEmilio1;

import java.util.ArrayList;

public abstract class Bicicleta {
	
	public static enum TC{MONTANA, CARRETERA}

	TC tipo;
	
	public TC getTipo(){
		return tipo;
	}
	public void setTipo(TC tipo){
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Bicicleta - " + getTipo() ;
	}

	
	
}
