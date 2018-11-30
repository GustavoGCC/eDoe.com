package eDoe;

import java.util.Comparator;

public class ComparadorPorDescricao implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getDescricao().compareTo(o2.getDescricao());
		
	}
}
