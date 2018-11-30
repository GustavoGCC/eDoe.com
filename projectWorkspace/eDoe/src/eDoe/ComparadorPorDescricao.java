package eDoe;

import java.util.Comparator;
/**
 * Comparador especifico que foi criado para ordenar dois itens em ordem alfabetica com base em descricao
 * @author Daniel de Matos Figueredo
 *
 */
public class ComparadorPorDescricao implements Comparator<Item> {
	/**
	 * Construtor que constroi a classe sem nenhum atributo
	 */
	public ComparadorPorDescricao() {
		
	}
	/**
	 * Ordena dois itens em ordem alfabetica com base em descricao
	 */
	@Override
	public int compare(Item o1, Item o2) {
		return o1.getDescricao().compareTo(o2.getDescricao());
		
	}
}
