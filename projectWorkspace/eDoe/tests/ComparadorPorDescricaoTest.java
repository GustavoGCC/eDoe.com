import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import eDoe.Controller;
import eDoe.Item;
import util.ComparadorPorDescricao;

class ComparadorPorDescricaoTest {

	@Test
	void testCompare() {
		Controller c = new Controller();
		ArrayList<Item> lista = new ArrayList();
		lista.add(new Item("cadeira", 2, "premium,gamer", 0));
		lista.add(new Item("cd", 1, "xuxa", 0));
		lista.add(new Item("bola", 2, "futebol,couro", 0));
		Collections.sort(lista, new ComparadorPorDescricao());
		assertEquals(lista.get(0),new Item("bola", 2, "futebol,couro", 0));
	}

}
