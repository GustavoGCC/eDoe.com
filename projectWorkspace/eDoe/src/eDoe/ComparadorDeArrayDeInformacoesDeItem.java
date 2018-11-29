package eDoe;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparadorDeArrayDeInformacoesDeItem implements Comparator<String[]> {

	@Override
	public int compare(String[] o1, String[] o2) {
		if (Integer.valueOf(o1[0]) > Integer.valueOf(o2[0])) {
			return 1;
		}else if (Integer.valueOf(o1[0]) < Integer.valueOf(o2[0])) {
			return -1;
		} else {
			return 0;
		}
	}

}
