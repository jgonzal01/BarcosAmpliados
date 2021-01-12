package es.uva.inf.poo.entrega.test;

import org.junit.Test;
import static org.junit.Assert.*;
import es.uva.inf.poo.entraga.clases.*;
import java.time.LocalDate;

public class FlatRackTest {
	@Test
	public void testInicializacionFlatRackValido() {
		
		FlatRack flatrack = new FlatRack("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito");
		assertEquals(flatrack.getCodigoDueno(),"CSQ");
		assertEquals(flatrack.getEquipamiento(),'U');
		assertEquals(flatrack.getNumSerie(),305438);
		assertEquals(flatrack.getDigitoControl(),3);
		assertEquals(flatrack.getEstado(),"transito");
		assertTrue(flatrack.getTecho());
		FlatRack b = new FlatRack("CSQ",'U',305438,3,45.7,'L',12.6,'P',"recogida");
		assertEquals(b.getEstado(),"recogida");
		assertFalse(b.getTecho());
	}
	@Test (expected = IllegalArgumentException.class)
	public void anadirTrayectoTCamionNoValido() {
		@SuppressWarnings( "unused" )
		FlatRack flatrack  = new FlatRack("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito");
		Puerto puertoA = new Puerto("ES", "EEE");
		Puerto puertoB = new Puerto("SS", "EWE");
		Muelle muelleA = new Muelle(22,true, 2.3, 2.2, true, true, true);
		
		Muelle muelleB = new Muelle(22,true, 22.3, 22.2, true, true, true);
		
		LocalDate salida = LocalDate.of(2001, 5, 13);
		LocalDate llegada = LocalDate.of(2001, 5, 23);
		
		TCamion tray = new TCamion(puertoA, muelleA,puertoB,muelleB, salida,llegada);
		flatrack.anadirTrayecto(tray);
		
	}@Test (expected = IllegalArgumentException.class)
	public void anadirTrayectoPackCamionBarcoNoValido() {
		@SuppressWarnings( "unused" )
		FlatRack flatrack  = new FlatRack("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito");
		Puerto puertoA = new Puerto("ES", "EEE");
		Puerto puertoB = new Puerto("SS", "EWE");
		Puerto puertoC = new Puerto("Sw", "WWE");
		Muelle muelleA = new Muelle(22,true, 2.3, 2.2, true, true, true);
		
		Muelle muelleB = new Muelle(22,true, 22.3, 22.2, true, true, true);
		Muelle muellec = new Muelle(22,true, 12.3, 52.2, true, true, true);
		
		LocalDate salida = LocalDate.of(2001, 5, 13);
		LocalDate intermedio = LocalDate.of(2001, 5, 16);
		LocalDate llegada = LocalDate.of(2001, 5, 23);
		
		PackCamionBarco tray = new PackCamionBarco(puertoA, muelleA,puertoB,muelleB,puertoC, muelleC, salida,intermedio,llegada);
		flatrack.anadirTrayecto(tray);
		
	}@Test (expected = IllegalArgumentException.class)
	public void anadirTrayectoPackCamionTrenNoValido() {
		@SuppressWarnings( "unused" )
		FlatRack flatrack  = new FlatRack("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito");
		Puerto puertoA = new Puerto("ES", "EEE");
		Puerto puertoB = new Puerto("SS", "EWE");
		Puerto puertoC = new Puerto("Sw", "WWE");
		Muelle muelleA = new Muelle(22,true, 2.3, 2.2, true, true, true);
		
		Muelle muelleB = new Muelle(22,true, 22.3, 22.2, true, true, true);
		Muelle muellec = new Muelle(22,true, 12.3, 52.2, true, true, true);
		
		LocalDate salida = LocalDate.of(2001, 5, 13);
		LocalDate intermedio = LocalDate.of(2001, 5, 16);
		LocalDate llegada = LocalDate.of(2001, 5, 23);
		
		PackCamionTren tray = new PackCamionTren(puertoA, muelleA,puertoB,muelleB,puertoC, muelleC, salida,intermedio,llegada);
		flatrack.anadirTrayecto(tray);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
