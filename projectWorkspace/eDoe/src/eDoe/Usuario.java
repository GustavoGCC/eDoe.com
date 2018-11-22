package eDoe;

import java.util.Map;

public abstract class Usuario {
	protected String nome;
	protected String id;
	protected String email;
	protected String celular;
	protected String classe;
	protected String status;
	protected Map<Integer, String> itensParaDoacao;
	
	
	public String exibeItem(int id) {
		return itensParaDoacao.get(id).toString();
	}
	
	public void adicionaItemParaDoacao(String descricaoItem, int quantidade, String tags, int id) {
		itensParaDoacao.put(id, new ItemParaDoacao(descricaoItem, quantidade, tags, id));
	}
	
	public String atualizaItemParaDoacao(int id, int quantidade, String tags) {
		itensParaDoacao.get(id).setQuant(quantidade);
		itensParaDoacao.get(id).setTags(tags);
		
		return itensParaDoacao.get(id).toString();
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
	
	
	
}
