import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import eDoe.ComparadorDeArrayDeInformacoesDeItem;
import eDoe.Item;

class ComparadorDeArrayDeInformacoesDeItemTest {

	@Test
	void testCompare() {
		String[] array1 = new String[2];
		array1[0] = "2";
		array1[1] = null;
		
		String[] array2 = new String[2];
		array2[0] = "1";
		array2[1] = "B ,texto aleatorio";
		
		String[] array3 = new String[2];
		array3[0] = "100";
		array3[1] = "A ,texto aleatorio";
		
		ArrayList<String[]> lista = new ArrayList();
		lista.add(array1);
		lista.add(array2);
		lista.add(array3);
		
		Collections.sort(lista, new ComparadorDeArrayDeInformacoesDeItem());
		
		assertEquals(lista.get(0),array2);
	}

}
