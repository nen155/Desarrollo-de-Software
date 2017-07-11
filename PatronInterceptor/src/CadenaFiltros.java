import java.util.ArrayList;

public class CadenaFiltros {
	private ArrayList<Filtro> filtros;
	private Interfaz objetivo;
	
	public CadenaFiltros(){
		filtros = new ArrayList();
	}
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}
	public void ejecutar(double peticion){
		for(Filtro filtro : filtros){
			filtro.ejecutar(peticion);
		}
		
		objetivo.ejecutar(peticion);
	}
	public void setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}
}
