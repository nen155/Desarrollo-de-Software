package ControlVelocidad;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAutomatico.class, TestCalculadorVel.class, TestControlVelocidad.class, TestEje.class,
		TestPedal.class, TestReloj.class })
public class AllTests {

}
