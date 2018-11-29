package eDoe;

import java.util.Comparator;

public class ComparadorDeItemQuantidade implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getQuant()>o2.getQuant()) return -1;
		
		else if (o1.getQuant()<o2.getQuant()) return 1;
		
		else {
			return o1.getDescricao().compareTo(o2.getDescricao());
		}
	}
	

}
