package eDoe;

import java.util.Map;

public class Validacao {
	
	public Validacao() {
		
	}
	
	public void validaAdicionaDoador(String id, String nome, String email, String celular, String classe, Map<String,Usuario> usuarios) {
		verificaNuloOuVazio(nome, "Entrada invalida: nome nao pode ser vazio ou nulo.");
		
		verificaNuloOuVazio(email, "Entrada invalida: email nao pode ser vazio ou nulo.");
	
		verificaNuloOuVazio(celular, "Entrada invalida: celular nao pode ser vazio ou nulo.");
	
		verificaNuloOuVazio(classe, "Entrada invalida: classe nao pode ser vazia ou nula.");
		
		if (!classe.equals("PESSOA_FISICA") && !classe.equals("ONG") && !classe.equals("ORGAO_PUBLICO_ESTADUAL") && !classe.equals("ORGAO_PUBLICO_MUNICIPAL") && !classe.equals("SOCIEDADE") && !classe.equals("IGREJA") && !classe.equals("ORGAO_PUBLICO_FEDERAL") && !classe.equals("ASSOCIACAO")) {
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
		
		verificaNuloOuVazio(id, "Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
	
		if (usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja existente: " + id + ".");
		}
		
		
	}
	
	public void validapesquisaUsuarioPorId(String id,Map<String,Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}
	
	public void validapesquisaUsuarioPorNome(String nome) {
		
		if (nome == null || nome.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");}
		
	}
	
	public void verificaNuloOuVazio(String valor, String msg) {
		if (valor == null || valor.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
		
	}

	public void validaAtualizaUsuario(String id, String nome, String email, String celular,
			Map<String, Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}

	public void validaRemoveUsario(String id, Map<String, Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}

	public void validaAdicionaDescritor(String descricao, Map<String, Descritor> descritores) {
		if (descricao == null || descricao.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (descritores.containsKey(descricao.toLowerCase())) {throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao.toLowerCase() + ".");}
		
	}

	public void validaAdicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags, Map<String, Usuario> usuarios) {
		if (descricaoItem == null || descricaoItem.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (quantidade <= 0) {throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
	}

	public void validaAdicionaItemParaDoacao(int id, String idDoador, int quantidade, String tags,Map<String, Usuario> usuarios) {
		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (!usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}

	public void validaRemoveItemParaDoacao(int id, String idDoador, Map<String, Usuario> usuarios) {
		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (usuarios.get(idDoador).getItens().size() == 0) {
			throw new IllegalArgumentException("O Usuario nao possui itens cadastrados.");
		}
		
		if (!usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}

	public void validaExibeItem(int id, String idDoador, Map<String, Usuario> usuarios) {
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (!usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}
	
	

}
