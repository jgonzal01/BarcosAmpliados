package es.uva.inf.poo.entrega.test;
import org.junit.Test;
import static org.junit.Assert.*;
import es.uva.inf.poo.entraga.clases.*;

public class RefrigeradoTest {
	@Test
	public void testInicializacionReefrigeradoValido() {
		
		Refrigerado ref = new Refrigerado("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito");
		assertEquals(ref.getCodigoDueno(),"CSQ");
		assertEquals(ref.getEquipamiento(),'U');
		assertEquals(ref.getNumSerie(),305438);
		assertEquals(ref.getDigitoControl(),3);
		assertEquals(ref.getEstado(),"transito");
		assertTrue(ref.getTecho());
		Refrigerado b = new Refrigerado("CSQ",'U',305438,3,45.7,'L',12.6,'P',"recogida");
		assertEquals(b.getEstado(),"recogida");
		assertTrue(b.getTecho());
	}
	public void 
		
	}
	
}
