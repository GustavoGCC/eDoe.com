package eDoe;

public class Descritor {
	private String descricao;
	private int quant;
	
	public Descritor(String descricao) {
		this.descricao = descricao;
		this.quant = 0;
	}
	
	public Descritor(String descricao, int quant) {
		this.descricao = descricao;
		this.quant = quant;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public int getQuant() {
		return this.quant;
	}
	
	public void diminuiQuant(int quant) {
		this.quant -= quant;
	}
	
	public void aumentarQuant(int quant) {
		this.quant += quant;
	}

}
