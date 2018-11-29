import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eDoe.Descritor;

class DescritorTest {


	
	@Test
	void testGetDescricao() {
		Descritor d = new Descritor("cama");
		assertEquals(d.getDescricao(), "cama");
	}		
	
	@Test
	void testGetQuant() {
		Descritor d = new Descritor("cama", 2);
		assertEquals(d.getQuant(), 2);
	}		

	@Test
	void testDiminuiQuant() {
		Descritor d = new Descritor("cama", 2);
		d.diminuiQuant(1);
		assertEquals(d.getQuant(), 1);
	}
	
	@Test
	void testAumentaQuant() {
		Descritor d = new Descritor("cama", 2);
		d.aumentaQuant(1);
		assertEquals(d.getQuant(), 3);
	}
	
	@Test
	void testToString() {
		Descritor d = new Descritor("cama", 2);
		assertEquals(d.toString(), "2 - cama");
	}
	

}
