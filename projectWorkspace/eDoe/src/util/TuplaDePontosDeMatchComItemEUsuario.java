package util;

import eDoe.Item;
import eDoe.Usuario;
/**
 * Classe auxiliar criada apenas para guardar as informacoes de pontos de match,item e usuario durante
 * a execucao do metodo match do controlador, eliminando a necessidade de fazer varias transformacoes em String
 * @author Joao Victor Teodulo Wanderley
 *
 */
public class TuplaDePontosDeMatchComItemEUsuario implements Comparable<TuplaDePontosDeMatchComItemEUsuario> {
	/**
	 * Pontos de match calculados entre o item doado presente no objeto e um item necessario
	 * presente na funcao match do controlador
	 */
	private int pontosDeMatch;
	/**
	 * Item doado que e um candidato ao match
	 */
	private Item item;
	/**
	 * Usuario que possui o item doado que e candidato a match
	 */
	private Usuario usuario;
	/**
	 * Construtor que constroi a classe TuplaDePontosDeMatchComItemEUsuario, com base
	 * nos pontos de match, item e usuario passados
	 * @param pontosDeMatch pontos de match calculados entre o item doado presente no objeto e um item necessario
	 * presente na funcao match do controlador
	 * @param item item doado que e um candidato ao match
	 * @param usuario usuario que possui o item doado que e candidato a match
	 */
	public TuplaDePontosDeMatchComItemEUsuario(int pontosDeMatch, Item item, Usuario usuario) {
		this.pontosDeMatch = pontosDeMatch;
		this.item = item;
		this.usuario = usuario;
	}
	/**
	 * Metodo que retorna os pontos de match
	 * @return pontos de match
	 */
	public int getPontosDeMatch() {
		return this.pontosDeMatch;
	}
	/**
	 * Metodo que retorna o item doado
	 * @return item doado
	 */
	public Item getItem() {
		return this.item;
	}
	/**
	 * Metodo que retorna o usuario
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}
	/**
	 * Metodo para comparacao que compara primeiro a partir dos pontos de match(o maior vem primeiro)
	 * e se der empate e decidida a ordem com base no id(menor id vem antes)
	 */
	@Override
	public int compareTo(TuplaDePontosDeMatchComItemEUsuario o) {
		if (this.getPontosDeMatch() > o.getPontosDeMatch()) {
			return -1;
		} else if (this.getPontosDeMatch() < o.getPontosDeMatch()) {
			return 1;
		} else {
			if (this.getItem().getId() > o.getItem().getId()) {
				return 1;
			} else if (this.getItem().getId() < o.getItem().getId()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
