package es.uva.inf.poo.entrega.test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.uva.inf.poo.entraga.clases.Estandar;
import es.uva.inf.poo.entraga.clases.Muelle;
import es.uva.inf.poo.entraga.clases.Puerto;
import es.uva.inf.poo.entraga.clases.Trayecto;

public class ContenedorTest {
	
	@Test
	public void testInicializoContenedorValido() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		assertEquals(c.getCodigoDueno(),"CSQ");
		assertEquals(c.getEquipamiento(),'U');
		assertEquals(c.getNumSerie(),305438);
		assertEquals(c.getDigitoControl(),3);
		assertEquals(c.getEstado(),"transito");
		assertTrue(c.getTecho());
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'P',"recogida",false);
		assertEquals(b.getEstado(),"recogida");
		assertFalse(b.getTecho());
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidoCodigoDueno() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQM",'U',305438,3,45.7,'K',12.6,'M',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidoLetraEquipamiento() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'M',305438,3,45.7,'K',12.6,'M',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidonumSerie() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',30543,3,45.7,'K',12.6,'M',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidoDigitoControl() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,5,45.7,'K',12.6,'M',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidoletraPeso() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'J',12.6,'M',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidoletraVol() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'O',"transito",false);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInicializoContenedorNoValidonEstado() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"parado",false);	
	}
	
	@Test
	public void testCambiarATransito() {
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"recogida",true);
		b.cambiarATransito();
		assertEquals(b.getEstado(),"transito");
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		c.cambiarATransito();
		assertEquals(c.getEstado(),"transito");
	}
	@Test 
	public void testGetNombre() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		assertEquals(c.getNombre(),"CSQU3054383");
	}

	@Test
	public void testCambiarARecogida() {
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"recogida",true);
		b.cambiarARecogida();
		assertEquals(b.getEstado(),"recogida");
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		c.cambiarARecogida();
		assertEquals(c.getEstado(),"recogida");
	}

	
	@Test
	public void testPesoEnKilosValido() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		assertEquals(c.pesoEnKilos(),45.7,0.01);
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'M',"transito",true);
		assertEquals(b.pesoEnKilos(),20.724,0.01);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPesoEnKilosNoValido() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,3,-45.7,'K',12.6,'M',"transito",true);
		
	} 
	@Test (expected = IllegalArgumentException.class)
	public void testCalcularVolMetrosNoValido() {
		@SuppressWarnings( "unused" )
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'K',-12.6,'M',"transito",true);
	}

	@Test
	public void testPesoEnLibras() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'M',"transito",true);
		assertEquals(c.pesoEnLibras(),45.7,0.01);
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'K',12.6,'M',"transito",true);
		assertEquals(b.pesoEnLibras(),100.77,0.01);
	}

	@Test
	public void testPesoEnMetrosCubicos() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'M',"transito",true);
		assertEquals(c.volumenEnMetrosCubicos(),12.6,0.001);
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'p',"transito",true);
		assertEquals(b.volumenEnMetrosCubicos(),0.3568,0.001);
	}

	@Test
	public void testPesoEnPiesCubicos() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'p',"transito",true);
		assertEquals(c.volumenEnPiesCubicos(),12.6,0.001);
		Estandar b = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'M',"transito",true);
		assertEquals(b.volumenEnPiesCubicos(),444.965,0.01);
	}

	@Test
	public void testTieneTechoTrue() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'p',"transito",true);
		assertTrue(c.tieneTecho());
	}
	@Test
	public void testTieneTechoFalse() {
		Estandar c = new Estandar("CSQ",'U',305438,3,45.7,'L',12.6,'p',"transito",false);
		assertFalse(c.tieneTecho());
	}
	

}
