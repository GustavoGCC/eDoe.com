package eDoe;
/**
 * Classe que serve para guardar descricoes de itens ja armazenadas no sistema com sua quantidade atuais(como um inventario),
 *   considerando os itens doados apenas
 * @author Joao Victor Teodulo Wanderley
 *
 */
public class Descritor {
	/**
	 * A descricao em si
	 */
	private String descricao;
	/**
	 * A quantidade de itens doados que estao disponiveis no sistema
	 */
	private int quant;
	/**
	 * Construtor que constroi a partir de uma descricao fornecida e comeca com uma quantidade 0
	 * @param descricao descricao do item em questao
	 */
	public Descritor(String descricao) {
		this.descricao = descricao;
		this.quant = 0;
	}
	/**
	 * Construtor que constroi a partir de uma descricao e quantidade fornecidas
	 * @param descricao descricao do item em questao
	 * @param quant quantidade atual no sistema
	 */
	public Descritor(String descricao, int quant) {
		this.descricao = descricao;
		this.quant = quant;
	}
	/**
	 * Um metodo que retorna a descricao
	 * @return a descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}
	/**
	 * Um metodo que retorna a quantidade
	 * @return a quantidade
	 */
	public int getQuant() {
		return this.quant;
	}
	/**
	 * Diminui a quantidade com base em um numero passado
	 * @param quant a quantidade que sera diminuida
	 */
	public void diminuiQuant(int quant) {
		this.quant -= quant;
	}
	/**
	 * Aumenta a quantidade com base em um numero passado
	 * @param quant a quantidade a ser aumentada
	 */
	public void aumentaQuant(int quant) {
		this.quant += quant;
	}
	/**
	 * Representacao textual de Descritor no formato:"quantidade" - "descricao"
	 */
	@Override
	public String toString() {
		return this.quant + " - " + this.descricao;
	}
}
