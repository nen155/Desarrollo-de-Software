package Simulador;
 
import static org.junit.Assert.*;
 

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junit.framework.TestCase;
import junit.framework.TestResult;


public class TestObservable extends TestCase {
    private Interfaz interfaz;
    private TestResult resultadoTest;
    private ObservadorTestListener observadorTestListener;
    private ListaObservadoresObservables listaOO;
    
    public TestObservable(String nombreMetodo){
    	super(nombreMetodo);   
    }
    
	@Before
    public void setUp() throws Exception {
        observadorTestListener = new ObservadorTestListener();
        resultadoTest = new TestResult();
        //Añado el listener al TestResult para que escuche los eventos
        resultadoTest.addListener(observadorTestListener);
        interfaz = new Interfaz(); 
        //Cojo la lista de la interfaz creada para simular correctamente
        listaOO = interfaz.simulacion.getListaOO();

    }
 
    @Test
    public void testAgregarObservador() {
    	//Hay dos observadores agregados previamente ya que se agregan en Simulacion
    	assertEquals("La lista no tiene 2 elementos como deberia",listaOO.getObservadores().size(),2);
    	//Añado el mook oberserver para que realice el evento actualizar y me avise
    	listaOO.agregarObservador(observadorTestListener);
    	//Compruebo que ha subido el contador de la lista
    	assertEquals("La lista no tiene 3 elementos como deberia",listaOO.getObservadores().size(),3);
    }
 
    @Test
    public void testEliminarObservador() {
        testAgregarObservador();
         
        listaOO.eliminarObservador(interfaz.getPanelB());
        assertEquals("La lista no tiene 2 elementos como deberia", listaOO.getObservadores().size(),2);
         
        listaOO.eliminarObservador(interfaz.getPanelE());
        assertEquals("La lista no tiene 1 elemento como deberiar", listaOO.getObservadores().size(),1);
        
        listaOO.eliminarObservador(observadorTestListener);
        assertEquals("La lista no esta vacia como deberia", listaOO.getObservadores().size(),0);
         
    }
    @Test
    public void testNotificarObservador() {
    	 testAgregarObservador();
    	 //Inicio el test para que me proporcione el evento de nuevoEventoInicioTest
    	 resultadoTest.startTest(new TestObservable("testNotificarObservador"));
    	 //Notifico a los observadores por lo que debería haber un evento creado
         listaOO.notificarObservador();
         //Me creo una lista de esperados y la relleno con los que debería haber
         List<List<Object>> esperados = new ArrayList<List<Object>>();
         esperados.add(observadorTestListener.newEventStartTest());
         esperados.add(observadorTestListener.newEventActualizar());
         //Compruebo que las listas contienen los mismos eventos
         assertEquals("No coinciden los elementos de las listas como debería",esperados,observadorTestListener.getEventos());
    }    
 
}
