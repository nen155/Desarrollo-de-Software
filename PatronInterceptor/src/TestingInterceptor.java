
public class TestingInterceptor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		gestorFiltros.setFiltro(new Calcular());
		gestorFiltros.setFiltro(new CalcularDistancia());
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		cliente.enviarPeticion(500);//numero inicial de vueltas del eje


	}

}
