package ChicaJimenezEmilio1;

import java.util.ArrayList;

import ChicaJimenezEmilio1.Bicicleta.TC;

public class BicicletaMontana extends Bicicleta {
	ArrayList<Pieza> piezas = new ArrayList(4);
	
	public void addPieza(Pieza p){
		piezas.add(p);
	}
	public BicicletaMontana(TC tipo){
		this.tipo=tipo;
		
	}
	@Override
	public String toString() {
		String bc="Bicicleta " + getTipo()+ " compuesta de : ";
		
		for(int i=0;i<piezas.size();++i){
			bc+=piezas.get(i).toString()+",";
		}
		return bc;
	}
}
