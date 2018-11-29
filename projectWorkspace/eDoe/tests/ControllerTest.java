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
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: 999.");
		};
	}
	
	@Test
	void testAdicionaDescritor() {
		Controller c = new Controller();
		c.adicionaDescritor("cadeira de rodas");
		//assertEquals(c.des, "cadeira de rodas");
		
		
	}
	
	@Test
	void testAdicionaItem() {
		Controller c = new Controller();
		c.adicionaDoador("123", "Lucas", "lucas@ccc. edu", "1010-2222", "PESSOA_FISICA");

		c.adicionaDescritor("leite");
		c.adicionaItem("123", "leite", 1, "lata,em po");
		assertEquals(c.exibeItem(0 , "123"), "0 - leite, tags: [lata, em po], quantidade: 1");

		c.adicionaDescritor("pesos");
		c.adicionaItem("123", "pesos", 1, "par de halteres,3kg");
		assertEquals(c.exibeItem(1 , "123"), "1 - pesos, tags: [par de halteres, 3kg], quantidade: 1");
	}
	
	@Test
	void testAtualizaItem() {
		Controller c = new Controller();
		c.adicionaDoador("123", "Lucas", "lucas@ccc. edu", "1010-2222", "PESSOA_FISICA");
		c.adicionaDescritor("leite");
		c.adicionaItem("123", "leite", 1, "lata,em po");

		c.atualizaItem(0, "123", 2, "caixa");
		assertEquals(c.exibeItem(0, "123"), "0 - leite, tags: [caixa], quantidade: 2");
	}
	
	@Test
	void testRemoveItem() {
		Controller c = new Controller();
		c.adicionaDoador("123", "Lucas", "lucas@ccc. edu", "1010-2222", "PESSOA_FISICA");
		c.adicionaDescritor("pesos");
		
		c.adicionaItem("123", "leite", 2, "caixa");
		c.adicionaItem("123", "leite", 1, "lata,em po");
		c.removeItem(0, "123");
	
		
	}
	
	@Test
	void testListaDescritoresDeItensParaDoacao() {
		Controller c = new Controller();
		c.adicionaDescritor("travesseiro");
		c.adicionaDoador("123", "Gustavo", "gustavo.campos@ccc.ufcg.edu.br", "9999-9999", "PESSOA_FISICA");
		c.adicionaItem("123", "travesseiro", 3, "macio");
		c.adicionaItem("123", "cama", 1, "madeira");
		c.adicionaItem("123", "travesseiro", 2, "macio");
		c.adicionaItem("123", "cama", 1, "com colchao");
		c.adicionaDescritor("xicara");
		assertEquals(c.listaDescritorDeItensParaDoacao(),"2 - cama | 2 - travesseiro | 0 - xicara");
	}
	
	@Test
	void testListaItensParaDoacao() {
		Controller c = new Controller();
		c.adicionaDoador("111", "Gustavo", "gustavo.campos", "9999-9999", "PESSOA_FISICA");
		c.adicionaDoador("222", "Gabriel", "gabriel.campos", "8888-8888", "PESSOA_FISICA");
		c.adicionaItem("111", "travesseiro", 3, "macio");
		c.adicionaItem("222", "cama", 1, "madeira");
		c.adicionaItem("111", "urso de pelucia", 4, "fofo");
		c.adicionaItem("222", "colchao", 3, "de penas");
		assertEquals(c.listaItensParaDoacao(),"2 - urso de pelucia, tags: [fofo], quantidade: 4, doador: Gustavo/111 | 3 - colchao, tags: [de penas], quantidade: 3, doador: Gabriel/222 | 0 - travesseiro, tags: [macio], quantidade: 3, doador: Gustavo/111 | 1 - cama, tags: [madeira], quantidade: 1, doador: Gabriel/222");

}
	
	@Test
	void testPesquisaItemParaDoacaoPorDescricao() {
		Controller c = new Controller();
		c.adicionaDoador("111", "Gustavo", "gustavo.campos", "9999-9999", "PESSOA_FISICA");
		c.adicionaDoador("222", "Gabriel", "gabriel.campos", "8888-8888", "PESSOA_FISICA");
		c.adicionaItem("111", "cama elastica", 2, "pulavel");
		c.adicionaItem("222", "cama de casal", 1, "plus size");
		c.adicionaItem("111", "Cama de solteiro", 1, "infantil");
		
		try {c.pesquisaItemParaDoacaoPorDescricao("");
		}catch(IllegalArgumentException exception) {};
		
		try {c.pesquisaItemParaDoacaoPorDescricao(null);
		}catch(NullPointerException exception) {};
		
		assertEquals(c.pesquisaItemParaDoacaoPorDescricao("travesseiro"),"");
		assertEquals(c.pesquisaItemParaDoacaoPorDescricao("cama"),"1 - cama de casal, tags: [plus size], quantidade: 1 | 2 - cama de solteiro, tags: [infantil], quantidade: 1 | 0 - cama elastica, tags: [pulavel], quantidade: 2");
	}
	
	@Test
	void testAdicionaItemNecessario() {
		Controller c = new Controller();
		c.lerReceptores("arquivos_sistema/novosReceptores.csv");
		c.lerReceptores("arquivos_sistema/atualizaReceptores.csv");
		c.adicionaItem("84473712044", "cama", 2, "madeira");
		
		try {c.adicionaItem("","cama",3,"barata");
		}catch(IllegalArgumentException exception) {};
		
		try {c.adicionaItem(null,"cama",3,"barata");
		}catch(IllegalArgumentException exception) {};
		
		try {c.adicionaItem("34473712041","",3,"barata");
		}catch(IllegalArgumentException exception) {};
		
		try {c.adicionaItem("34473712041",null,3,"barata");
		}catch(IllegalArgumentException exception) {};
		
		try {c.adicionaItem("34473712041","cama",-1,"barata");
		}catch(IllegalArgumentException exception) {};
		
	}
	
	@Test
	void testListaItensNecessarios() {
		Controller c = new Controller();
		c.lerReceptores("arquivos_sistema/novosReceptores.csv");
		c.lerReceptores("arquivos_sistema/atualizaReceptores.csv");
		c.adicionaItem("84473712044", "cama", 2, "madeira");
		c.adicionaItem("84473712044", "carro", 1, "vermelho");
		c.adicionaItem("80643201009", "sofa", 3, "couro");
		assertEquals(c.listaItensNecessarios(),"0 - cama, tags: [madeira], quantidade: 2, receptor: Murilo Luiz Brito/84473712044 | 1 - carro, tags: [vermelho], quantidade: 1, receptor: Murilo Luiz Brito/84473712044 | 2 - sofa, tags: [couro], quantidade: 3, receptor: Tomas Otavio Lucas Teixeira/80643201009");
	}
	
	@Test
	void testAtualizaItemNecessario() {
		Controller c = new Controller();
		c.lerReceptores("arquivos_sistema/novosReceptores.csv");
		c.lerReceptores("arquivos_sistema/atualizaReceptores.csv");
		c.adicionaItem("84473712044", "cama", 2, "madeira");
		c.adicionaItem("84473712044", "carro", 1, "vermelho");
		c.adicionaItem("80643201009", "sofa", 3, "couro");
		c.atualizaItem(0, "84473712044", 1, null);
		assertEquals(c.exibeItem(0, "84473712044"),"0 - cama, tags: [madeira], quantidade: 1");
		c.atualizaItem(1, "84473712044", 0, "azul");
		assertEquals(c.exibeItem(1, "84473712044"),"1 - carro, tags: [azul], quantidade: 1");
		
		try {c.atualizaItem(0, "123", 1, "azul");
		}catch(IllegalArgumentException exception) {};

		try {c.atualizaItem(1, "84473712044", -1, "azul");
		}catch(IllegalArgumentException exception) {};
		
		try {c.atualizaItem(2, null, 1, "azul");
		}catch(IllegalArgumentException exception) {};
		
		try {c.atualizaItem(0, "", 1, "azul");
		}catch(IllegalArgumentException exception) {};
		
	}
	
	@Test
	void testRemocaoDeItemNecessario() {
		Controller c = new Controller();
		c.lerReceptores("arquivos_sistema/novosReceptores.csv");
		c.lerReceptores("arquivos_sistema/atualizaReceptores.csv");
		c.adicionaItem("84473712044", "cama", 2, "madeira");
		c.adicionaItem("84473712044", "carro", 1, "vermelho");
		c.adicionaItem("80643201009", "sofa", 3, "couro");
		c.removeItem(0, "84473712044");
		
		try {c.removeItem(0, "");
		} catch(IllegalArgumentException exception) {};
		
		try {c.removeItem(0, null);
		} catch(IllegalArgumentException exception) {};
		
		try {c.removeItem(-1, "84473712044");
		} catch(IllegalArgumentException exception) {};
		
		try {c.removeItem(0, "111");
		} catch(IllegalArgumentException exception) {};
		
		try {c.removeItem(0, "58090077080");
		} catch(IllegalArgumentException exception) {};
	
	}
}
