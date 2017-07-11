
public class Cliente {
   GestorFiltros gestorFiltros;

   public void setGestorFiltros(GestorFiltros gestorFiltros){
      this.gestorFiltros = gestorFiltros;
   }

   public void enviarPeticion(double peticion){
	   gestorFiltros.peticionFiltro(peticion);
   }
}
