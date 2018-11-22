package eDoe;

public class ItemParaDoacao {
	private String descricao;
	private int quantidade;
	private String Tags;
	private int id;
	
	public ItemParaDoacao(String descricao, int quantidade, String tags, int id) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.Tags = tags;
		this.id = id;
	}

	@Override
	public String toString() {
		return " - " + this.descricao + ", tags: [" + this.Tags + "], quantidade: " + this.quantidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemParaDoacao other = (ItemParaDoacao) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void aumentaQuant(int quant) {
		this.quantidade += quant;
	}
	
	public void diminuiQuant(int quant) {
		this.quantidade -= quant;
	}
	
	public void setQuant(int quant) {
		this.quantidade = quant;
	}
	
	public void setTags(String tags) {
		this.Tags = tags;
	}

	
}
