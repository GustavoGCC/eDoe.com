import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eDoe.Controller;

class ControllerTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testAdicionaDoador() {
		
	}
	
	@Test
	void testPesquisaUsuarioPorId() {
		
	}
	
	@Test
	void testPesquisaUsuarioPorNome() {
		
	}
	
	@Test
	void testAtualizaUsuario() {
		
	}
	
	@Test
	void testRemoveUsuario() {
		
	}
	
	@Test
	void testAdicionaDescritor() {
		
	}
	
	@Test
	void testAdicionaItemParaDoacao() {
		
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
		assertEquals(c.listaItensParaDoacao(),"2 - urso de pelucia, tags: [fofo], quantidade: 4, doador: Gustavo/111 | 3 - colchao, tags: [de penas], quantidade: 3, doador: Gabriel/222 | 0 - travesseiro, tags: [macio], quantidade: 3, doador: Gustavo/111 | 1 - cama, tags: [madeira], quantidade: 1, doador: Gabriel/222");
	}
	
	@Test
	void testPesquisaItemParaDoacaoPorDescricao() {
		Controller c = new Controller();
		c.adicionaDoador("111", "Gustavo", "gustavo.campos", "9999-9999", "PESSOA_FISICA");
		c.adicionaDoador("222", "Gabriel", "gabriel.campos", "8888-8888", "PESSOA_FISICA");
		c.adicionaItemParaDoacao("111", "cama elastica", 2, "pulavel");
		c.adicionaItemParaDoacao("222", "cama de casal", 1, "plus size");
		c.adicionaItemParaDoacao("111", "Cama de solteiro", 1, "infantil");
		
		try {c.PesquisaItemParaDoacaoPorDescricao("");
		}catch(IllegalArgumentException exception) {};
		
		try {c.PesquisaItemParaDoacaoPorDescricao();
		}catch(IllegalArgumentException exception) {};
		
		assertEquals(c.PesquisaItemParaDoacaoPorDescricao("cama"),"1 - cama de casal, tags: [plus size], quantidade: 1 | 2 - Cama de solteiro, tags: [infantil], quantidade: 2 | 0 - cama elastica, tags: [pulavel], quantidade: 2");
	}
}
