package eDoe;

public class Item implements Comparable<Item>{
	private String descricao;
	private int quantidade;
	private String Tags;
	private int id;
	
	public Item(String descricao, int quantidade, String tags, int id) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.Tags = tags;
		this.id = id;
	}

	@Override
	public String toString() {
		String[] listaTags = this.Tags.split(",");
		String tags = "";
		tags += this.id + " - " + this.descricao + ", tags: [";
		for (int i = 0; i < listaTags.length; i++) {
			tags += listaTags[i] + ", ";
		}
		String retorno = tags.substring(0,tags.length()-2);
		retorno += "], quantidade: " + this.quantidade;
		return retorno;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String getDescricaoETagsEQuantidades() {
		String[] listaTags = this.Tags.split(",");
		String tags = "";
		tags += this.descricao + ", tags: [";
		for (int i = 0; i < listaTags.length; i++) {
			tags += listaTags[i] + ", ";
		}
		String retorno = tags.substring(0,tags.length()-2);
		retorno += "], quantidade: " + this.quantidade;
		return retorno;
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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTags() {
		return Tags;
	}

	public int getQuant() {
		return this.quantidade;
	}

	@Override
	public int compareTo(Item i) {
		if (this.getQuant()>i.getQuant()) return -1;
		
		else if (this.getQuant()<i.getQuant()) return 1;
		
		else {
			return this.getDescricao().compareTo(i.getDescricao());
		}	
	}
}
