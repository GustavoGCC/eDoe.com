package eDoe;

import java.io.Serializable;
/**
 * Classe que guarda as informacoes de uma doacao realizada,funcionando como um historico
 * @author Daniel de Matos Figueredo
 *
 */
public class Doacao implements Comparable<Doacao>, Serializable{
	/**
	 * String que guarda a data da doacao realizada
	 */
	String data;
	/**
	 * String que guarda a descricao do item doado
	 */
	String descricaoItemDoado;
	/**
	 * Construtor da classe Doacao, constroi a partir da data e descricao passada
	 * @param data
	 * @param descricaoItemDoado
	 */
	public Doacao(String data,String descricaoItemDoado) {
		this.data = data;
		this.descricaoItemDoado = descricaoItemDoado;
	}
	/**
	 * Metodo que retorna a data em que a doacao foi realizada
	 * @return a data em que a doacao foi realizada
	 */
	public String getData() {
		return data;
	}
	/**
	 * Metodo que retorna a descricao do item que foi doado
	 * @return a descricao do item que foi doado
	 */
	public String getDescricaoItemDoado() {
		return descricaoItemDoado;
	}
	/**
	 * Metodo para comparacao que compara a partir primeiro da data(a doacao mais antiga vem primeiro) e se der empate
	 * a partir da ordem alfabetica da descricao guardada
	 */
	@Override
	public int compareTo(Doacao o) {
		String datas1[] = new String[3];
		String datas2[] = new String[3];
		
		datas1 = data.split("/");
		datas2 = o.getData().split("/");
		
		int dia1 = Integer.parseInt(datas1[0]); 
		int mes1 = Integer.parseInt(datas1[1]); 
		int ano1 = Integer.parseInt(datas1[2]); 
		
		int dia2 = Integer.parseInt(datas2[0]); 
		int mes2 = Integer.parseInt(datas2[1]); 
		int ano2 = Integer.parseInt(datas2[2]);
		
		if (ano1 < ano2) return -1;
		
		else if (ano1 > ano2) return 1;
		
		else if (mes1 < mes2) return -1;
		
		else if (mes1 > mes2) return 1;
		
		else if (dia1 < dia2) return -1;
		
		else if (dia1 > dia2) return 1;
		
		else return descricaoItemDoado.compareTo(o.getDescricaoItemDoado());
	}
	
	
}
