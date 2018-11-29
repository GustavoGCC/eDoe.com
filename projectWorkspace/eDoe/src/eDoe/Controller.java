package eDoe;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Controlador do sistema, possui todas as informações e todos os métodos para o sistema funcionar.
 * @author Gustavo Gurjão Camargo Campos, Daniel de Matos Figueredo.
 *
 */
public class Controller {	
	/**
	 * Mapa de usuários do sistema, possui todos os usuários cadastrados no sistema, associados
	 * ao seu identificador unico: seu id(String).
	 */
	private Map<String,Usuario> usuarios;
	/**
	 * Mapa de todos os descritores do sistema, possui todos os descritores cadastrados,
	 * associados ao seu identificador único: sua descrição(String)
	 */
	private Map<String,Descritor> descritores;
	/**
	 * Contador para a adicão de itens.
	 */
	private int idItens;
	/**
	 * Realizador da validacao dos itens
	 */
	private Validacao validador;
	/**
	 * Construtor do controlador. Constroi o controlador a partir de um LinkedHashMap de usuarios (mantendo a ordem de insercao),
	 * um TreeMap de descritores(Ordem alfabetica das chaves), põe o idItens igual a zero para iniciar o sistema e constrói um novo
	 * validador.
	 */
	public Controller() {
		this.usuarios = new LinkedHashMap<String,Usuario>();
		this.descritores = new TreeMap<String,Descritor>();
		this.idItens = 0;
		this.validador = new Validacao();
	}
	/**
	 * Adiciona um doador ao sistema, a partir de seu id, nome,email, celular e classe.
	 * @param id identificador unico do usuario
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @param classe classe a qual o usuario pertence, como igreja, pessoa_fisica, ONG, entre outras.
	 * @return o identificador unico do doador
	 */
	public String adicionaDoador(String id, String nome, String email, String celular, String classe) {
		
		this.validador.validaAdicionaDoador(id, nome, email, celular, classe, this.usuarios);
		
		this.usuarios.put(id,new Usuario(id,nome,email,celular,classe,"doador"));
		return id;
		
	}
	/**
	 * Pesquisa um usuario de acordo com seu id
	 * @param id id do usuário a ser pesquisado
	 * @return a representacao em String do usuario
	 */
	public String pesquisaUsuarioPorId(String id) {
		this.validador.validapesquisaUsuarioPorId(id, this.usuarios);

		return this.usuarios.get(id).toString();
	}
	/**
	 * Pesquisa usuarios com um nome em especifico
	 * @param nome nome a ser pesquisado
	 * @return retorna a representacao em String de todos os usuarios com esse nome em ordem de insercao
	 */
	public String pesquisaUsuarioPorNome(String nome) {
			
			this.validador.validapesquisaUsuarioPorNome(nome);
		
			String retorno = "";
			for (Usuario usuario : this.usuarios.values()) {
				if (usuario.getNome().equals(nome)) {retorno += usuario.toString() + " | ";}
			}
			
			if (retorno.trim().equals("")) {throw new IllegalArgumentException("Usuario nao encontrado: " + nome + ".");}
			
			else {
				return retorno.substring(0, retorno.length()-3);
			}	
	}
	/**
	 * Atualiza informações do usuário: nome, email ou celular
	 * @param id id do usuario a ser alterado
	 * @param nome novo nome do usuário
	 * @param email novo email do usuário
	 * @param celular novo celular do usuário
	 * @return nova representação em String do usuário
	 */
	public String atualizaUsuario(String id, String nome, String email, String celular) {
			this.validador.validaAtualizaUsuario(id,nome,email,celular,this.usuarios);
			
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
	/**
	 * Remove um usuário e todos os itens pertencentes a ele do sistema de acordo com seu id
	 * @param id id do usuário a ser removido
	 */
	public void removeUsuario(String id) {
		this.validador.validaRemoveUsario(id,this.usuarios);
		
			for (Item item : this.usuarios.get(id).getItens().values()) {
				removeItemParaDoacao(item.getId(),id);
			}
			this.usuarios.remove(id);
		
	}
	/**
	 * Adiciona um novo descritor ao sistema
	 * @param descricao descrição do descritor do sistema
	 */
	public void adicionaDescritor(String descricao) {
		this.validador.validaAdicionaDescritor(descricao,this.descritores);

		this.descritores.put(descricao.toLowerCase(),new Descritor(descricao.toLowerCase()));

	}
	/**
	 * Adiciona um item para doação a um usuário
	 * @param idDoador id do usuário que irá doar o item
	 * @param descricaoItem descricao do item a ser doado
	 * @param quantidade quantidade do item a ser doado
	 * @param tags tags do item a ser doado
	 * @return o id do item a ser doado
	 */
	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		this.validador.validaAdicionaItemParaDoacao(idDoador,descricaoItem,quantidade,tags,this.usuarios);
		
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
	/**
	 * Exibe a representacao em String de um item do sistema
	 * @param id id do item a ser exibido
	 * @param idDoador id do doador ao qual pertence o item
	 * @return a representacao em String do item
	 */
	public String exibeItem(int id, String idDoador) {
		this.validador.validaExibeItem(id,idDoador,this.usuarios);
	
		return this.usuarios.get(idDoador).getItens().get(id).toString();
	}
	/**
	 * Atualiza a quantidade ou as tags de um item a ser doado.
	 * @param id id do item a ser modificado
	 * @param idDoador id do doador ao qual pertence o item
	 * @param quantidade nova quantidade do item
	 * @param tags novas tags do item
	 * @return a nova representação em String do item
	 */
	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		this.validador.validaAtualizaItemParaDoacao(id,idDoador,quantidade,tags,this.usuarios);
		
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
	/**
	 * Remove um item para doacao
	 * @param id id do item a ser removido
	 * @param idDoador id do doador ao qual o item pertence
	 */
	public void removeItemParaDoacao(int id, String idDoador) {
		this.validador.validaRemoveItemParaDoacao(id,idDoador,this.usuarios);
		
		int diferenca = this.usuarios.get(idDoador).getItens().get(id).getQuant();
			
		this.descritores.get(this.usuarios.get(idDoador).getItens().get(id).getDescricao()).diminuiQuant(diferenca);
			
		this.usuarios.get(idDoador).getItens().remove(id);

	}
	/**
	 * Le os receptores a partir de um arquivo csv
	 * @param caminho arquivo csv a ser lido
	 */
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
		
		s=s.trim();
		
		if (!s.equals("")) {
			s=s.substring(0, s.length()-1);
		}
		
		return s.trim();
		
	}
	
	public String listaItensParaDoacao() {
		TreeMap<Item,Usuario> lista = new TreeMap<>();
		String s="";
		
		for (Usuario i : usuarios.values()) {
			for (Item j : i.getItens().values()) {
				lista.put(j, i);
			}
		}
		
		for (Entry<Item,Usuario> entry : lista.entrySet()) {
			s+=entry.getKey().toString() + ", doador: " + entry.getValue().getNome() + "/" + entry.getValue().getId() + " | ";
		}
		
		s=s.trim();
		
		if (!s.equals("")) {
			s=s.substring(0, s.length()-1);
		}
		
		return s.trim();
		
	}
	
	
	public String pesquisaItemParaDoacaoPorDescricao(String pesquisa) {
		this.validador.validaPesquisaItemParaDoacaoPorDescricao(pesquisa);
		
		Map<String, Item> itensValidos=new TreeMap<>();
		
		String s="";
		
		for (Usuario i : usuarios.values()) {
			for (Item j : i.getItens().values())
				if (j.getDescricao().toLowerCase().contains(pesquisa.toLowerCase())) {
					itensValidos.put(j.getDescricao()+"|"+j.getId(), j);
			}
		}
		
		for (Item i : itensValidos.values()) {
			s+=i.toString()+" | ";
		}
		
		s=s.trim();
		
		if (!s.equals("")) {
			s=s.substring(0, s.length()-1);
		}
		
		return s.trim();
	}
	
	
	
	
	

}
