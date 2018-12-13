package eDoe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * Classe que serve para representar um usuario do sistema,seja doador ou receptor.
 * @author Daniel de Matos Figueredo.
 *
 */
public class Usuario implements Serializable{
	/**
	 * String que representa o nome do usuario
	 */
	private String nome;
	/**
	 * String que representa o id unico do usuario
	 */
	private String id;
	/**
	 * String que representa o email do usuario
	 */
	private String email;
	/**
	 * String que representa o numero de celular do usuario
	 */
	private String celular;
	/**
	 * String que representa que tipo de entidade e o Usuario(pessoa fisica,organizacao religiosa,etc...)
	 */
	private String classe;
	/**
	 * String que representa se o usuario e um doador ou um receptor
	 */
	private String status;
	/**
	 * Mapa cuja chave equivale a um id e cujo valor equivale ao item que e identificado por aquele id
	 */
	private Map<Integer, Item> itens;
	/**
	 * Construtor da classe de Usuario, constroi com base nos valores passados de nome, id, email, celular,
	 * classe, status e apos isso e construido um HashMap para o atributo itens
	 * @param id id unico do usuario
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular numero de celular do usuario
	 * @param classe que tipo de entidade e o Usuario(pessoa fisica,organizacao religiosa,etc...)
	 * @param status status do usuario(se e um doador ou um receptor)
	 */
	public Usuario(String id, String nome, String email, String celular, String classe, String status){
		this.nome=nome;
		this.id=id;
		this.email=email;
		this.celular=celular;
		this.classe=classe;
		this.status=status;
		this.itens=new HashMap<>();
		
	}	
	/**
	 * Metodo que retorna a representacao em String de um item que o usuario contem, baseado no id do item
	 * @param id id do item requisitado
	 * @return representacao em String do item requisitado
	 */
	public String exibeItem(int id) {
		return itens.get(id).toString();
	}
	/**
	 * Metodo que adiciona um novo item ao mapa do atributo itens, cuja chave e o id e o valor e um item criado com
	 * as informacoes passadas
	 * @param descricaoItem descricao do item a ser adicionado
	 * @param quantidade quantidade do item a ser adicionado
	 * @param tags tags do item a ser adicionado
	 * @param id id do item a ser adicionado
	 */
	public void adicionaItem(String descricaoItem, int quantidade, String tags, int id) {
		itens.put(id, new Item(descricaoItem, quantidade, tags, id));
	}
	/**
	 * Metodo que muda a quantidade e as tags de um item , com base no id do item que sera modificado
	 * e os novos valores
	 * @param id id do item a ser modificado
	 * @param quantidade nova quantidade do item modificado
	 * @param tags novas tags do item modificado
	 * @return a nova representacao textual do item modificado
	 */
	public String atualizaItemParaDoacao(int id, int quantidade, String tags) {
		itens.get(id).setQuant(quantidade);
		itens.get(id).setTags(tags);
		
		return itens.get(id).toString();
	}
	/**
	 * Metodo que retorna a representacao textual do usuario no formato:'"nome"/"id", "email", "celular", status: "status"'
	 */
	public String toString() {
		return nome+"/"+id+", "+email+", "+celular+", status: "+status;
			  
	}
	/**
	 * Metodo que retorna o nome do usuario
	 * @return nome do usuario
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo que retorna o id do usuario
	 * @return id do usuario
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo que retorna o email do usuario
	 * @return email do usuario
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo que retorna o numero de celular do usuario
	 * @return numero de celular do usuario
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * Metodo que retorna a classe do usuario
	 * @return a classe do usuario
	 */
	public String getClasse() {
		return classe;
	}
	/**
	 * Metodo que retorna o status do usuario
	 * @return o status do usuario
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Metodo que modifica o email do usuario
	 * @param email novo email do usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodo que modifica o numero de celular do usuario
	 * @param celular novo numero de celular
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**
	 * Metodo que retorna o mapa dos itens de usuario
	 * @return os itens de usuario no formato de mapa
	 */
	public Map<Integer, Item> getItens() {
		return itens;
	}
	/**
	 * Hashcode do usuario baseado em seu id
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/**
	 * Equals do usuario baseado no id, se dois usuarios tem o mesmo id ele retorna True
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/**
	 * Metodo que modifica o nome do usuario
	 * @param nome2 novo nome do usuario
	 */
	public void setNome(String nome2) {
		this.nome = nome2;
		
	}
	
	
	
}
