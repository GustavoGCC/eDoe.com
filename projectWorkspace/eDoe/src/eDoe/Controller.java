package eDoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Controller {
	/** Galera, isso é so uma anotação para que vcs saibam o que foi feito, o problema do jar 
	 * ja esta resolvido mas precisso que vcs testem, caso ainda tenha problema ele se resolve
     * deletando o jar e indo em configure build path e depois add external jar apos isso basta escolher o easyaccept.jar;
	 * para simplificar a validacao eu criei uma classe Validacao, quem for adaptar a validacao siga o modelo de
	 * adicionarDoador
	 * 
	 * Atualizacao: eu acho que eu consigi resolver definitivamente com uma mudanca que fiz 
	 */
	
	
	private Map<String,Usuario> usuarios;
	
	private Map<String,Descritor> descritores;
	
	private int idItens;
	
	private Validacao validador;
	
	public Controller() {
		this.usuarios = new LinkedHashMap<String,Usuario>();
		this.descritores = new TreeMap<String,Descritor>();
		this.idItens = 0;
		this.validador = new Validacao();
	}
	
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		
		this.validador.validaAdicionaDoador(id, nome, email, celular, classe, this.usuarios);
		
		this.usuarios.put(id,new Usuario(id,nome,email,celular,classe,"doador"));
		return id;
		
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
			
			if (retorno.trim().equals("")) {throw new IllegalArgumentException("Usuario nao encontrado: " + nome + ".");}
			
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
			for (Item item : this.usuarios.get(id).getItens().values()) {
				removeItemParaDoacao(item.getId(),id);
			}
			this.usuarios.remove(id);
		}
		
	}

	public void adicionaDescritor(String descricao) {
		if (descricao == null || descricao.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (this.descritores.containsKey(descricao.toLowerCase())) {throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao.toLowerCase() + ".");}
		
		else {
			this.descritores.put(descricao.toLowerCase(),new Descritor(descricao.toLowerCase()));
		}
		
	}

	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		if (descricaoItem == null || descricaoItem.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (quantidade <= 0) {throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");}
		
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		else {
			for (Item item : this.usuarios.get(idDoador).getItens().values()) {
				if (item.getDescricao().toLowerCase().equals(descricaoItem.toLowerCase()) && item.getTags().equals(tags)) {
					
					int diferenca = quantidade - item.getQuant();
					
					this.descritores.get(descricaoItem).aumentaQuant(diferenca);
									
					item.setQuant(quantidade);
					
					return item.getId();
				}
			}
			
			if (this.descritores.containsKey(descricaoItem.toLowerCase())) {
				this.descritores.get(descricaoItem.toLowerCase()).aumentaQuant(quantidade);
			}
			
			if (!this.descritores.containsKey(descricaoItem.toLowerCase())) {
				this.descritores.put(descricaoItem.toLowerCase(),new Descritor(descricaoItem.toLowerCase(),quantidade));
			}
			
			this.usuarios.get(idDoador).getItens().put(this.idItens,new Item(descricaoItem.toLowerCase(), quantidade, tags,idItens));
			
			this.idItens += 1;
			
			return (this.idItens-1);
		}
	}

	public String exibeItem(int id, String idDoador) {
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!this.usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
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
			if (quantidade != 0) {
				if (this.usuarios.get(idDoador).getItens().get(id).getQuant() > quantidade) {
					
					int diferenca = this.usuarios.get(idDoador).getItens().get(id).getQuant() - quantidade;
					
					this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).diminuiQuant(diferenca);
				}
				
				if (this.usuarios.get(idDoador).getItens().get(id).getQuant() < quantidade) {
					
					int diferenca = quantidade - this.usuarios.get(idDoador).getItens().get(id).getQuant();
					
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
		
		if (this.usuarios.get(idDoador).getItens().size() == 0) {
			throw new IllegalArgumentException("O Usuario nao possui itens cadastrados.");
		}
		
		if (!this.usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
		else {
			int diferenca = this.usuarios.get(idDoador).getItens().get(id).getQuant();
			
			this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).diminuiQuant(diferenca);
			
			this.usuarios.get(idDoador).getItens().remove(id);
		}
	}

	public void lerReceptores(String caminho){
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(caminho));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String linha = null;
		
		while(sc.hasNextLine()) {
			
			linha = sc.nextLine();
			
			if (linha.equals("id,nome,E-mail,celular,classe"))
				continue;
			
			String[] dadosReceptor = linha.split(",");
			
			if (this.usuarios.containsKey(dadosReceptor[0])) {
				this.usuarios.get(dadosReceptor[0]).setNome(dadosReceptor[1]);
				this.usuarios.get(dadosReceptor[0]).setEmail(dadosReceptor[2]);
				this.usuarios.get(dadosReceptor[0]).setCelular(dadosReceptor[3]);
			}
			
			else {this.usuarios.put(dadosReceptor[0], new Usuario(dadosReceptor[0],dadosReceptor[1],dadosReceptor[2],dadosReceptor[3],dadosReceptor[4],"receptor"));}
		}
		
		sc.close();
		
	}
	
	public String listaDescritorDeItensParaDoacao() {
		String s="";
		
		for (Descritor i : descritores.values()) {
			s+=i.toString()+" | ";
		}
		
		return s.trim();
		
	}
	
	
	public String pesquisaItemParaDoacaoPorDescricao(String pesquisa) {
		if (pesquisa==null) {
			throw new NullPointerException("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.");
		}
		
		if (pesquisa.trim()=="") {
			throw new IllegalArgumentException("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.");
		}
		
		String s="";
		
		for (String i : descritores.keySet()) {
			if (i.contains(pesquisa.toLowerCase())) {
				s+=i.toString()+" | ";
			}
		}
		
		return s.trim();
	}
	
	
	
	
	

}
