
public class GestorFiltros {
   CadenaFiltros cadenaFiltros;

   public GestorFiltros(Interfaz objetivo){
	   cadenaFiltros = new CadenaFiltros();
	   cadenaFiltros.setObjetivo(objetivo);
   }
   public void setFiltro(Filtro filtro){
	   cadenaFiltros.addFiltro(filtro);
   }

   public void peticionFiltro(double peticion){
	   cadenaFiltros.ejecutar(peticion);
   }
}
