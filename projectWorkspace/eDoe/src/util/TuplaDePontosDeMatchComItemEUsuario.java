package util;

import eDoe.Item;
import eDoe.Usuario;

public class TuplaDePontosDeMatchComItemEUsuario implements Comparable<TuplaDePontosDeMatchComItemEUsuario> {
	private int pontosDeMatch;
	private Item item;
	private Usuario usuario;
	
	public TuplaDePontosDeMatchComItemEUsuario(int pontosDeMatch, Item item, Usuario usuario) {
		this.pontosDeMatch = pontosDeMatch;
		this.item = item;
		this.usuario = usuario;
	}
	
	public int getPontosDeMatch() {
		return this.pontosDeMatch;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

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
