package eDoe;

import java.util.ArrayList;
import java.util.Collections;

import easyaccept.EasyAccept;

public class Facade {
	private Controller c;
	
	public Facade() {this.c = new Controller();}
	
	public String adicionaDoador(String id, String nome, String email,String celular, String classe) {
		return c.adicionaDoador(id,nome,email,celular,classe);
	}
	
	public void lerReceptores(String caminho) {
		c.lerReceptores(caminho);
	}
	
	public String pesquisaUsuarioPorId(String id) {
		return c.pesquisaUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		return c.pesquisaUsuarioPorNome(nome);
	}
	
	public String atualizaUsuario(String id, String nome, String email, String celular) {
		return c.atualizaUsuario(id,nome,email,celular);
	}
	
	public void removeUsuario(String id) {
		c.removeUsuario(id);
	}
	
	public void adicionaDescritor(String descricao) {
		c.adicionaDescritor(descricao);
	}
	
	public int adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) {
		return c.adicionaItem(idDoador,descricaoItem,quantidade,tags);
	}
	
	public String exibeItem(int id, String idDoador) {
		return c.exibeItem(id,idDoador);
	}
	
	public String atualizaItemParaDoacao(int id, String idDoador, int quantidade, String tags) {
		return c.atualizaItem(id,idDoador,quantidade,tags);
	}
	
	public void removeItemParaDoacao(int id, String idDoador) {
		c.removeItem(id,idDoador);
	}
	
	public String listaDescritorDeItensParaDoacao() {
		return c.listaDescritorDeItensParaDoacao();
	}
	
	public String listaItensParaDoacao() {
		return c.listaItensParaDoacao();
	}
	
	public String pesquisaItemParaDoacaoPorDescricao(String desc) {
		return c.pesquisaItemParaDoacaoPorDescricao(desc);
	}
	
	public int adicionaItemNecessario(String idReceptor, String descricaoItem, int quantidade, String tags) {
		return c.adicionaItem(idReceptor,descricaoItem,quantidade,tags);
	}
	
	public String listaItensNecessarios() {
		return c.listaItensNecessarios();
	}
	
	public String atualizaItemNecessario(int id, String idReceptor, int quantidade, String tags) {
		return c.atualizaItem(id, idReceptor, quantidade, tags);
	}
	
	public void removeItemNecessario(int id, String idReceptor) {
		c.removeItem(id,idReceptor);
	}
	
	public static void main(String[] args) {
		args = new String[] {"eDoe.Facade","EasyAcceptTestes/use_case_1.txt","EasyAcceptTestes/use_case_2.txt","EasyAcceptTestes/use_case_3.txt","EasyAcceptTestes/use_case_4.txt"};
		EasyAccept.main(args);
	}
	
}
