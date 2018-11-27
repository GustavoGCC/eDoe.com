package eDoe;

import java.util.Map;

public class Validacao {
	
	public Validacao() {
		
	}
	
	public boolean validaAdicionaDoador(String id, String nome, String email, String celular, String classe, Map<String,Usuario> usuarios) {
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
		
		return True;
		
	}
	
	public void verificaNuloOuVazio(String valor, String msg) {
		if (valor == null || valor.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
		
	}

}
