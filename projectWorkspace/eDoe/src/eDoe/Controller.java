package eDoe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
	
	private Map<String,Usuario> usuarios;
	
	private Map<String,Descritor> descritores;
	
	private int idItens; 
	
	public Controller() {
		this.usuarios = new LinkedHashMap<String,Usuario>();
		this.descritores = new TreeMap<String,Descritor>();
		this.idItens = 0;
	}
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		if (nome == null || nome.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");}
		
		if (email == null || email.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: email nao pode ser vazio ou nulo.");}
	
		if (celular == null || celular.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: celular nao pode ser vazio ou nulo.");}
	
		if (classe == null || classe.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: classe nao pode ser vazia ou nula.");}
		
		if (!classe.equals("PESSOA_FISICA") && !classe.equals("ONG") && !classe.equals("ORGAO_PUBLICO_ESTADUAL") && !classe.equals("ORGAO_PUBLICO_MUNICIPAL") && !classe.equals("SOCIEDADE") && !classe.equals("IGREJA") && !classe.equals("ORGAO_PUBLICO_FEDERAL") && !classe.equals("ASSOCIACAO")) {
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
		
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
	
		if (this.usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		
		else {
			this.usuarios.put(id,new Usuario(id,nome,email,celular,classe,"doador"));
			return this.usuarios.get(id).toString();
		}
		
	}

	public String pesquisaUsuarioPorId(String id) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
	
		else {
			return this.usuarios.get(id).toString();
		}
	}

	public String pesquisaUsuarioPorNome(String nome) {
		if (nome == null || nome.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");}
		
		else {
			String retorno = "";
			for (Usuario usuario : this.usuarios.values()) {
				if (usuario.getNome().equals(nome)) {retorno += usuario.toString() + " | ";}
			}
			
			if (retorno.trim().equals("")) {throw new IllegalArgumentException("Usuario nao encontrado: " + nome);}
			
			else {
				return retorno.substring(0, retorno.length()-3);
			}
		}	
	}

	public String atualizaUsuario(String id, String nome, String email, String celular) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
		else {
			
			if (nome != null && !nome.trim().equals("")) {
				this.usuarios.get(id).setNome(nome);
			}
			
			if (celular != null && !celular.trim().equals("")) {
				this.usuarios.get(id).setCelular(celular);
			}
			
			if (email != null && !email.trim().equals("")) {
				this.usuarios.get(id).setEmail(email);
			}
			
			return this.usuarios.get(id).toString();
			
		}
	}
	
	public void removeUsuario(String id) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
		else {
			this.usuarios.remove(id);
		}
		
	}

	public void adicionaDescritor(String descricao) {
		if (descricao == null || descricao.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (this.descritores.containsKey(descricao)) {throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao + ".");}
		
		else {
			this.descritores.put(descricao,new Descritor(descricao));
		}
		
	}

	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		if (descricaoItem == null || descricaoItem.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (quantidade <= 0) {throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		else {
			if (this.descritores.containsKey(descricaoItem)) {
				this.descritores.get(descricaoItem).aumentaQuant(quantidade);
			}
			
			if (!this.descritores.containsKey(descricaoItem)) {
				this.descritores.put(descricaoItem,new Descritor(descricaoItem,quantidade));
			}
			
			for (Item item : this.usuarios.get(idDoador).getItens().values()) {
				if (item.getDescricao().equals(descricaoItem) && item.getTags().equals(tags)) {
					item.aumentaQuant(quantidade);
					return item.getId();
				}
			}
			
			this.usuarios.get(idDoador).getItens().put(this.idItens,new Item(descricaoItem, quantidade, tags,idItens));
			this.idItens += 1;
			return (this.idItens-1);
		}
	}

	public String exibeItem(int id, String idDoador) {
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
		else {
			return this.usuarios.get(idDoador).getItens().get(id).toString();
		}
	}

	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (!this.usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
		else {
			if (String.valueOf(quantidade) != null) {
				if (this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).getQuant() > quantidade) {
					
					int diferenca = this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).getQuant() - quantidade;
					
					this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).diminuiQuant(diferenca);
				}
				
				if (this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).getQuant() < quantidade) {
					
					int diferenca = quantidade - this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).getQuant();
					
					this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).aumentaQuant(diferenca);
				}					
					
				this.usuarios.get(idDoador).getItens().get(id).setQuant(quantidade);
				
			}
			
		if (tags != null && !tags.trim().equals("")) {
			
			this.usuarios.get(idDoador).getItens().get(id).setTags(tags);
			
		}
		
		return this.usuarios.get(idDoador).getItens().get(id).toString();
			
		}
	}

	public void removeItemParaDoacao(int id, String idDoador) {
		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (!this.usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
		if (this.usuarios.get(idDoador).getItens().size() == 0) {
			throw new IllegalArgumentException("O Usuario nao possui itens cadastrados.");
		}
		
		else {
			int diferenca = this.usuarios.get(idDoador).getItens().get(id).getQuant();
			
			this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).diminuiQuant(diferenca);
			
			this.usuarios.get(idDoador).getItens().remove(id);
			
		}
	}

}
