import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eDoe.Item;

class ItemTeste {
	
	@Test
	void testToString() {
		Item i = new Item("armario", 1, "4 portas", 1);
		assertEquals(i.toString(), "1 - armario, tags: [4 portas], quantidade: 1");
	}
	
	@Test
	void testGetId() {
		Item i = new Item("armario", 1, "4 portas", 1);
		assertEquals(i.getId(), 1);
	}
	
	@Test
	void testAumentaQuant() {
		Item i = new Item("armario", 1, "4 portas", 1);
		i.aumentaQuant(2);
		assertEquals(i.getQuant(), 3);
	}
	
	@Test
	void testDiminuiQuant() {
		Item i = new Item("armario", 1, "4 portas", 1);
		i.aumentaQuant(2);
		i.diminuiQuant(1);
		assertEquals(i.getQuant(), 2);
	}
	
	@Test
	void testSetQuant() {
		Item i = new Item("armario", 1, "4 portas", 1);
		i.setQuant(12);
		assertEquals(i.getQuant(), 12);
	}
	
	@Test
	void testSetTags() {
		Item i = new Item("armario", 1, "4 portas", 1);
		i.setTags("2 portas");
		assertEquals(i.getTags(), "2 portas");
	}
	@Test
	void testGetDescricao() {
		Item i = new Item("armario", 1, "4 portas", 1);
		assertEquals(i.getDescricao(), "armario");
	}
	
	@Test
	void testSetDescricao() {
		Item i = new Item("armario", 1, "4 portas", 1);
		i.setDescricao("guarda roupa");
		assertEquals(i.getDescricao(), "guarda roupa");
	}
	
	@Test
	void testGetTags() {
		Item i = new Item("armario", 1, "4 portas", 1);
		assertEquals(i.getTags(), "4 portas");
	}

	@Test
	void testGetQuant() {
		Item i = new Item("armario", 1, "4 portas", 1);
		assertEquals(i.getQuant(), 1);
	}

	@Test
	void testCompareTo() {
		Item i1 = new Item("armario", 2, "4 portas", 2);
		Item i2 = new Item("guarda roupa", 1, "2 portas", 1);
		assertEquals(i1.compareTo(i2), -1);
		
		i2.setQuant(3);
		assertEquals(i1.compareTo(i2), 1);
		
		i1.aumentaQuant(1);
		assertEquals(i1.compareTo(i2), -6);
	}
	
	@Test
	void testHashCode() {
		Item i = new Item("armario", 1, "4 portas", 9);
		assertEquals(i.hashCode(), 40);
	}		
	
	/**
	@Test
	void test_() {
	}		
	  */
}
