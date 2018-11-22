package eDoe;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private String nome;
	private String id;
	private String email;
	private String celular;
	private String classe;
	private String status;
	private Map<Integer, Item> itens;
	
	public Usuario(String id, String nome, String email, String celular, String classe, String status){
		this.nome=nome;
		this.id=id;
		this.email=email;
		this.celular=celular;
		this.classe=classe;
		this.status=status;
		itens=new HashMap<>();
		
	}

	
	
	public String exibeItem(int id) {
		return itens.get(id).toString();
	}
	
	public void adicionaItemParaDoacao(String descricaoItem, int quantidade, String tags, int id) {
		itens.put(id, new Item(descricaoItem, quantidade, tags, id));
	}
	
	public String atualizaItemParaDoacao(int id, int quantidade, String tags) {
		itens.get(id).setQuant(quantidade);
		itens.get(id).setTags(tags);
		
		return itens.get(id).toString();
	}
	
	public String toString() {
		return nome+"/"+id+", "+email+", "+celular+", status: "+status;
	}
	
	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}

	public String getClasse() {
		return classe;
	}

	public String getStatus() {
		return status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	

	public Map<Integer, Item> getItens() {
		return itens;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public void setNome(String nome2) {
		this.nome = nome2;
		
	}
	
	
	
}
