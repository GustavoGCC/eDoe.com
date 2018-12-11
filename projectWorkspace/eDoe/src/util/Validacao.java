package util;

import java.util.Map;

import eDoe.Descritor;
import eDoe.Usuario;
/**
 * Classe criada para guardar as validacoes do controlador com o objetivo de aumentar a coesao
 * @author Gustavo Gurjão Camargo Campos ,Joao Victor Teodulo Wanderley 
 *
 */
public class Validacao {
	/**
	 * Construtor que constroi a classe sem nenhum atributo
	 */
	public Validacao() {
		
	}
	/**
	 * Metodo criado para validar o metodo adicionaDoador, checa se o id,nome,email,celular ou classe sao vazios ou nulos(caso sim joga uma excecao)
	 *   , ve se a classe e uma das classes aceitaveis(caso nao joga excecao) e por ultimo ve se o id ja foi registrado(caso sim joga uma excecao)
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param usuarios 
	 */
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
	/**
	 * Metodo que checa possiveis erros no metodo pesquisaUsuarioPorId e envia ou nao uma msensagem de erro
	 * @param id id do usuario
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validapesquisaUsuarioPorId(String id,Map<String,Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que checa possiveis erros em PesquisaUsuarioPorNome e envia ou nao uma mensagem de erro
	 * @param nome nome a ser pesquisado no metodo original
	 */
	public void validapesquisaUsuarioPorNome(String nome) {
		
		if (nome == null || nome.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: nome nao pode ser vazio ou nulo.");}
		
	}
	/**
	 * Metodo que verifica se algum valor e nulo ou vazio e envia uma mensagem de erro
	 * @param valor valor a ser verificado
	 * @param msg mensagem de erro
	 */
	public void verificaNuloOuVazio(String valor, String msg) {
		if (valor == null || valor.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
		
	}
	/**
	 * Metodo que verifica se ha algum erro na execucao de atualizaUsuario
	 * @param id id a ser verificado
	 * @param nome nome a ser verificado
	 * @param email email a ser verificado
	 * @param celular celular a ser verificado
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaAtualizaUsuario(String id, String nome, String email, String celular,
			Map<String, Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que verifica possiveis erros na execucao do metodo removeUsuario
	 * @param id id a ser verificado
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaRemoveUsario(String id, Map<String, Usuario> usuarios) {
		if (id == null || id.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(id)) {throw new IllegalArgumentException("Usuario nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que verifica possiveis erros na execucao de adicionaDescritor
	 * @param descricao descricao a ser verificada
	 * @param descritores Map que possui todos os descritores relacionados a seus identificadores unicos
	 */
	public void validaAdicionaDescritor(String descricao, Map<String, Descritor> descritores) {
		if (descricao == null || descricao.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (descritores.containsKey(descricao.toLowerCase())) {throw new IllegalArgumentException("Descritor de Item ja existente: " + descricao.toLowerCase() + ".");}
		
	}
	/**
	 * Metodo que verifica se ha possiveis erros na execucao do metodo adicionaItem
	 * @param idUsuario idUsuario a ser verificado
	 * @param descricaoItem descricao do item a ser verificada
	 * @param quantidade quantidade que sera verificada
	 * @param tags tags do item que serao verificadas
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaAdicionaItem(String idUsuario, String descricaoItem, int quantidade, String tags, Map<String, Usuario> usuarios) {
		if (descricaoItem == null || descricaoItem.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: descricao nao pode ser vazia ou nula.");}
		
		if (quantidade <= 0) {throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");}
		
		if (idUsuario == null || idUsuario.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idUsuario)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idUsuario + ".");}
		
	}

	/**
	 * Metodo que verifica a existencia de possiveis erros na execucao do metodo atualizaItem
	 * @param id id a ser verificado
	 * @param idUsuario id do usuario a ser verificado
	 * @param quantidade quantidade a ser verificada
	 * @param tags tags do item que serao verificadas
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaAtualizaItem(int id, String idUsuario, int quantidade, String tags,Map<String, Usuario> usuarios) {

		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idUsuario == null || idUsuario.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idUsuario)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idUsuario + ".");}
		
		if (!usuarios.get(idUsuario).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que verifica a existencia de possiveis erros na execucao do metodo removeItem
	 * @param id id a ser verificado
	 * @param idUsuario id do usuario que vai ser verificado
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaRemoveItem(int id, String idUsuario, Map<String, Usuario> usuarios) {
		if (id < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (idUsuario == null || idUsuario.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idUsuario)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idUsuario + ".");}
		
		if (usuarios.get(idUsuario).getItens().size() == 0) {
			throw new IllegalArgumentException("O Usuario nao possui itens cadastrados.");
		}
		
		if (!usuarios.get(idUsuario).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que verifica a existencia de possiveis erros na execucao de exibeItem
	 * @param id id a ser verificado
	 * @param idDoador id do usuario que sera verificado
	 * @param usuarios Map que possui todos os usuarios relacionados com seus identificadores unicos
	 */
	public void validaExibeItem(int id, String idDoador, Map<String, Usuario> usuarios) {
		if (idDoador == null || idDoador.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idDoador)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idDoador + ".");}
		
		if (!usuarios.get(idDoador).getItens().containsKey(id)) {throw new IllegalArgumentException("Item nao encontrado: " + id + ".");}
		
	}
	/**
	 * Metodo que verifica a existencia de possiveis erros na execucao de pesquisaItemParaDoacaoPorDescricao
	 * @param pesquisa substring que ira ser verificada
	 */
	public void validaPesquisaItemParaDoacaoPorDescricao(String pesquisa) {
		if (pesquisa==null) {
			throw new NullPointerException("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.");
		}
		
		if (pesquisa.trim().equals("")) {
			throw new IllegalArgumentException("Entrada invalida: texto da pesquisa nao pode ser vazio ou nulo.");
		}
		
	}
	public void validaMatch(String idReceptor, int idItemNecessario, Map<String, Usuario> usuarios) {
		if (idReceptor == null || idReceptor.trim().equals("")) {throw new IllegalArgumentException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");}
		
		if (!usuarios.containsKey(idReceptor)) {throw new IllegalArgumentException("Usuario nao encontrado: " + idReceptor + ".");}
		
		
		if (usuarios.get(idReceptor).getStatus().equals("doador")) {throw new IllegalArgumentException("O Usuario deve ser um receptor: " + idReceptor + ".");}
		
		if (idItemNecessario < 0) {throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");}
		
		if (!usuarios.get(idReceptor).getItens().containsKey(idItemNecessario)) {throw new IllegalArgumentException("Item nao encontrado: " + idItemNecessario + ".");}
	}
	public void validaRealizaDoacao(int idNecessario, int idDoado, String data) {
		if (idDoado < 0) throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if (idNecessario < 0) throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if (data==null) throw new NullPointerException("Entrada invalida: data nao pode ser vazia ou nula.");
		
		if (data.trim().equals("")) throw new IllegalArgumentException("Entrada invalida: data nao pode ser vazia ou nula.");
		
	}
	
	

}
