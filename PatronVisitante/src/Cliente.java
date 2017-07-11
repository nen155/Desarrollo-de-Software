import java.util.Random;

public class Cliente {
	
	public static void main(String args[]){
		
		System.out.println("Cliente \t\tNumero de Peticiones  \tPrecio unitario \tDescuento \t\tEquipo");
		for(int i=0;i<100;i++){
			HebraCliente clientes = new HebraCliente(obtenerCliente());
			clientes.start();
		}
	}
	public static VisitanteEquipo obtenerCliente(){
		Random r = new Random();
		VisitanteEquipo ve =null;
		int res = r.nextInt(3);
		switch (res)
		{
			case 0:
				ve=new VisitanteRegular();
				break;
			case 1:
				ve=new VisitanteMayorista();
				break;
			case 2:
				ve=new VisitanteVIP();
				break;
			
		}
		return ve;
	}

}
