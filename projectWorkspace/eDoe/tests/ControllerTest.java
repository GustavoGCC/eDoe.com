import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eDoe.Controller;

class ControllerTest {
	
	@Test
	void testAdicionaDoador() {
		Controller c = new Controller();
		c.adicionaDoador("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA");
		assertEquals(c.pesquisaUsuarioPorId("167"), "Joao Victor/167, joao.wanderley@ccc.ufcg.edu.br, 9999-8321, status: doador");
	}
	
	@Test
	void testPesquisaUsuarioPorId() {
		Controller c = new Controller();
		c.adicionaDoador("999", "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA");
		assertEquals(c.pesquisaUsuarioPorId("999"), "Lucas Leal/999, lucas.lucena@ccc.ufcg.edu.br, 2345-6780, status: doador");
	}
	
	@Test
	void testPesquisaUsuarioPorNome() {
		Controller c = new Controller();
		c.adicionaDoador("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "PESSOA_FISICA");
		assertEquals(c.pesquisaUsuarioPorNome("Daniel"), "Daniel/100, daniel.figueredo@ccc.ufcg.edu.br, 1010-2222, status: doador");
	}
	
	@Test
	void testAtualizaUsuario() {
		Controller c = new Controller();
		c.adicionaDoador("167", "Joao Vito", "joao.wander@ccc.ufg.edu.br", "9999-8123", "PESSOA_FISICA");
		c.atualizaUsuario("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321");
		assertEquals(c.pesquisaUsuarioPorId("167"), "Joao Victor/167, joao.wanderley@ccc.ufcg.edu.br, 9999-8321, status: doador");
	}
	
	@Test
	void testRemoveUsuario() {
		Controller c = new Controller();
		c.adicionaDoador("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA");
		c.adicionaDoador("999", "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA");
		c.adicionaDoador("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "PESSOA_FISICA");
		c.removeUsuario("999");
		assertThrows(IllegalArgumentException.class, ()->{c.pesquisaUsuarioPorId("999");} );
		
		try {c.pesquisaUsuarioPorId("999");
		}catch(IllegalArgumentException exception) {
			assertEquals(exception, "java.lang.IllegalArgumentException: Usuario nao encontrado: 999.");
		};
	}
	
	@Test
	void testAdicionaDescritor() {
		Controller c = new Controller();
		c.adicionaDescritor("cadeira de rodas");
		//assertEquals(c.des, "cadeira de rodas");
		
		
	}
	
	@Test
	void testAdicionaItemParaDoacao() {
		Controller c = new Controller();
		c.adicionaDoador("123", "Lucas", "lucas@ccc. edu", "1010-2222", "PESSOA_FISICA");
		c.adicionaDescritor("pesos");
		c.adicionaItemParaDoacao("123", "pesos", 1, "par de halteres,3kg");
		assertEquals(c.exibeItem(0 , "123"), "0 - pesos, tags: [par de halteres, 3kg], quantidade: 1");
	}
	
	@Test
	void testExibeItem() {
		
	}
	
	@Test
	void testAtualizaItemParaDoacao() {
		
	}
	
	@Test
	void testRemoveItemParaDoacao() {
		
	}
	
	@Test
	void testListaDescritoresDeItensParaDoacao() {
		Controller c = new Controller();
		c.adicionaDescritor("travesseiro");
		c.adicionaDoador("123", "Gustavo", "gustavo.campos@ccc.ufcg.edu.br", "9999-9999", "PESSOA_FISICA");
		c.adicionaItemParaDoacao("123", "travesseiro", 3, "macio");
		c.adicionaItemParaDoacao("123", "cama", 1, "madeira");
		c.adicionaItemParaDoacao("123", "travesseiro", 2, "macio");
		c.adicionaItemParaDoacao("123", "cama", 1, "com colchao");
		c.adicionaDescritor("xicara");
		assertEquals(c.listaDescritorDeItensParaDoacao(),"2 - cama | 2 - travesseiro | 0 - xicara");
	}
	
	@Test
	void testListaItensParaDoacao() {
		Controller c = new Controller();
		c.adicionaDoador("111", "Gustavo", "gustavo.campos", "9999-9999", "PESSOA_FISICA");
		c.adicionaDoador("222", "Gabriel", "gabriel.campos", "8888-8888", "PESSOA_FISICA");
		c.adicionaItemParaDoacao("111", "travesseiro", 3, "macio");
		c.adicionaItemParaDoacao("222", "cama", 1, "madeira");
		c.adicionaItemParaDoacao("111", "urso de pelucia", 4, "fofo");
		c.adicionaItemParaDoacao("222", "colchao", 3, "de penas");
}
	
	@Test
	void testPesquisaItemParaDoacaoPorDescricao() {
		Controller c = new Controller();
		c.adicionaDoador("111", "Gustavo", "gustavo.campos", "9999-9999", "PESSOA_FISICA");
		c.adicionaDoador("222", "Gabriel", "gabriel.campos", "8888-8888", "PESSOA_FISICA");
		c.adicionaItemParaDoacao("111", "cama elastica", 2, "pulavel");
		c.adicionaItemParaDoacao("222", "cama de casal", 1, "plus size");
		c.adicionaItemParaDoacao("111", "Cama de solteiro", 1, "infantil");
		
		try {c.pesquisaItemParaDoacaoPorDescricao("");
		}catch(IllegalArgumentException exception) {};
		
		try {c.pesquisaItemParaDoacaoPorDescricao(null);
		}catch(IllegalArgumentException exception) {};
		
		assertEquals(c.pesquisaItemParaDoacaoPorDescricao("cama"),"1 - cama de casal, tags: [plus size], quantidade: 1 | 2 - Cama de solteiro, tags: [infantil], quantidade: 2 | 0 - cama elastica, tags: [pulavel], quantidade: 2");
		assertEquals(c.pesquisaItemParaDoacaoPorDescricao("travesseiro"),"");
	}
}
