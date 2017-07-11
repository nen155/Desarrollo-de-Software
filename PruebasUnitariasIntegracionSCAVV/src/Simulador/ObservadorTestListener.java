package Simulador;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
 
public class ObservadorTestListener implements TestListener, Observador {
    private List<List<Object>> listaEvents;
     
    public ObservadorTestListener() {
        listaEvents = new  ArrayList<List<Object>>();
    }
     
    public List<List<Object>> getEventos() {
		return listaEvents;
	}


	public List<Object> newEventActualizar() {
        return Arrays.asList(new Object[]{"eventActualizar"});
    }
    public List<Object> newEventError() {
    	 return Arrays.asList(new Object[]{"eventError"});
    }
    public List<Object> newEventFailure() {
    	return Arrays.asList(new Object[]{"eventFailure"});
    }
    public List<Object> newEventStartTest() {
    	return Arrays.asList(new Object[]{"eventStartTest"});
    }
    public List<Object> newEventEndTest() {
    	return Arrays.asList(new Object[]{"eventEndTest"});
    }
     
    @Override
    public void actualizar() {
        listaEvents.add(newEventActualizar());
         
    }
 
    @Override
    public void addError(Test arg0, Throwable arg1) {
        listaEvents.add(newEventError());
         
    }
 
    @Override
    public void addFailure(Test arg0, AssertionFailedError arg1) {
        listaEvents.add(newEventFailure());
         
    }
 
    @Override
    public void endTest(Test arg0) {
        listaEvents.add(newEventEndTest());
         
    }
 
    @Override
    public void startTest(Test arg0) {
        listaEvents.add(newEventStartTest()); 
    }
 
}
