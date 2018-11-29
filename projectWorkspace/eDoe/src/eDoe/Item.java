package eDoe;

/**
 * Item que é armazenado por usuario e representa um item doado ou um item necessario dependendo se o usuario for doador ou receptor
 * @author Gustavo Gurjão Camargo Campos, Joao Victor Teodulo Wanderley
 *
 */
public class Item implements Comparable<Item>{
	/**
	 * Descricao do item
	 */
	private String descricao;
	/**
	 * Quantidade do item
	 */
	private int quantidade;
	/**
	 * Tags do item no formato tag1,tag2,tag3,etc...
	 */
	private String Tags;
	/**
	 * Id unico do item
	 */
	private int id;
	/**
	 * Construtor de item, constroi o item a partir de uma descricao,quantidade,tags e id
	 * @param descricao Descricao do item
	 * @param quantidade Quantidade do item
	 * @param tags Tags do item no formato tag1,tag2,tag3,etc...
	 * @param id Id unico do item
	 */
	public Item(String descricao, int quantidade, String tags, int id) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.Tags = tags;
		this.id = id;
	}
	/**
	 * Representacao textual de Item no formato "id" - "descricao", tags: ["tags"], quantidade: "quantidade"
	 * @return a representacao textual de item no formato "id" - "descricao", tags: ["tags"], quantidade: "quantidade"
	 */
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
	/**
	 * hashCode de item baseado no id
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	/**
	 * equals de item baseado no id, se dois itens sao iguais o equals retorna true caso contrario false
	 */
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
	/**
	 * Um metodo que retorna a descricao, as tags e a quantidade do item, no formato: "descricao", tags: ["tags"], quantidade: "quantidade"
	 * @return a descricao, as tags e a quantidade do item, no formato: "descricao", tags: ["tags"], quantidade: "quantidade"
	 */
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
	/**
	 * Retorna o id
	 * @return o id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Aumenta a quantidade de acordo com o valor passado
	 * @param quant quantidade a ser aumentada
	 */
	public void aumentaQuant(int quant) {
		this.quantidade += quant;
	}
	/**
	 * Diminui a quantidade de acordo com o valor passado
	 * @param quant quantidade a ser diminuida
	 */
	public void diminuiQuant(int quant) {
		this.quantidade -= quant;
	}
	/**
	 * Muda a quantidade para o valor passado
	 * @param quant nova quantidade
	 */
	public void setQuant(int quant) {
		this.quantidade = quant;
	}
	/**
	 * Muda as tags para o valor passado
	 * @param tags novas tagas
	 */
	public void setTags(String tags) {
		this.Tags = tags;
	}
	/**
	 * Retorna a descricao
	 * @return a descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Muda a descricao para o valor passado
	 * @param descricao nova descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * Retorna as tags
	 * @return as tags
	 */
	public String getTags() {
		return Tags;
	}
	/**
	 * Retorna a quantidade
	 * @return a quantidade
	 */
	public int getQuant() {
		return this.quantidade;
	}
	/**
	 * Compara os itens naturalmente pela quantidade
	 */
	@Override
	public int compareTo(Item i) {
		if (this.getQuant()>i.getQuant()) return -1;
		
		else if (this.getQuant()<i.getQuant()) return 1;
		
		else {
			return this.getDescricao().compareTo(i.getDescricao());
		}	
	}
}
