import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import eDoe.*;
import util.Validacao;

class ValidacaoTest {

	
	@Test
	void testValidaAdicionaDoador() {
		Validacao v = new Validacao(); 

		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaDoador("100", "", "email", "celular", "classe", null);} );
		
		try {v.validaAdicionaDoador("100", "", "email", "celular", "classe", null);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: nome nao pode ser vazio ou nulo.");
		};
		
		
	}  

	@Test
	void testValidaPesquisaUsuarioPorId() {
		Validacao v = new Validacao();
		String id1 = "999";
		String id2 = "123"; 
		Usuario u1 = new Usuario(id1, "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put(id1, u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validapesquisaUsuarioPorId(null,usuarios);} );
		 
		assertThrows(IllegalArgumentException.class, ()->{v.validapesquisaUsuarioPorId("",usuarios);} );
		
		assertThrows(IllegalArgumentException.class, ()->{v.validapesquisaUsuarioPorId(id2, usuarios);} );
		
		try {v.validapesquisaUsuarioPorId("", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}; 
		
		try {v.validapesquisaUsuarioPorId(id2, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id2 + ".");
		};
		
		
	}
	
	@Test
	void testValidapesquisaUsuarioPorNome() {
		Validacao v = new Validacao();
		String nome1 = "Lucas Leal";
		Usuario u1 = new Usuario("999", nome1, "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put("999", u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validapesquisaUsuarioPorNome(null);} );
		
		try {v.validapesquisaUsuarioPorNome(null);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: nome nao pode ser vazio ou nulo.");
		};
		
	}
	
	@Test
	void testVerificaNuloOuVazio() {
		Validacao v = new Validacao();
		
		assertThrows(IllegalArgumentException.class, ()->{v.verificaNuloOuVazio(null, "mensagem vazia");} );
		
		assertThrows(IllegalArgumentException.class, ()->{v.verificaNuloOuVazio("", "mensagem vazia");} );
		
		try {v.verificaNuloOuVazio(null, "Mensagem de Erro");
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Mensagem de Erro");
		};
		 
		try {v.verificaNuloOuVazio("", "Mensagem de Erro");
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Mensagem de Erro");
		};
		
	}
	
	@Test
	void testValidaAtualizaUsuario() {
		Validacao v = new Validacao();
		String nome1 = "Lucas Leal";
		String id2 = "123";
		Usuario u1 = new Usuario("999", nome1, "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put("999", u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaUsuario(null, "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaUsuario("", "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaUsuario(id2, "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);});

		try {v.validaAtualizaUsuario(null, "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaAtualizaUsuario("", "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaAtualizaUsuario(id2, "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "5555-6780", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id2 + ".");
		};
			
	}
	
	@Test
	void testValidaRemoveUsario() {
		Validacao v = new Validacao();
		String nome1 = "Lucas Leal";
		String id1 = "999";
		String id2 = "123";
		Usuario u1 = new Usuario(id1, nome1, "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put(id1, u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveUsario(null, usuarios);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveUsario("", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveUsario(id2, usuarios);});

		try {v.validaRemoveUsario(null, usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaRemoveUsario("", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaRemoveUsario(id2, usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id2 + ".");
		};
	}
	  
	@Test
	void testValidaAdicionaDescritor() {
		Validacao v = new Validacao();
		String descricao1 = "Cadeira";
		Descritor d1 = new Descritor(descricao1);
		
		Map<String, Descritor> descritores = new HashMap<>();
		descritores.put(descricao1, d1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaDescritor(null, descritores);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaDescritor("", descritores);});
  
		try {v.validaAdicionaDescritor(null, descritores);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: descricao nao pode ser vazia ou nula.");
		};
		
		try {v.validaAdicionaDescritor("", descritores);  
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: descricao nao pode ser vazia ou nula.");
		};
		
		try {v.validaAdicionaDescritor(descricao1, descritores);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Descritor de Item ja existente: " + descricao1.toLowerCase() + ".");
		};  
	} 
	
	
	@Test
	void testValidaAdicionaItem() {
		Validacao v = new Validacao();
		Item i = new Item("armario", 1, "4 portas", 1);
		
		String nome1 = "Lucas Leal";
		String id1 = "999";
		String id2 = "100";
		Usuario u1 = new Usuario(id1, nome1, "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put(id1, u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem(id1, null, 1, "4 portas", usuarios);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem(id1, "", 1, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem(id1, "Armario", 0, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem(null, "Armario", 1, "4 portas", usuarios);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem("", "Armario", 1, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaItem(id2, "Armario", 1, "4 portas", usuarios);});

		try {v.validaAdicionaItem(id1, null, 1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: descricao nao pode ser vazia ou nula.");
		};
		
		try {v.validaAdicionaItem(id1, "", 1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: descricao nao pode ser vazia ou nula.");
		};
		
		try {v.validaAdicionaItem(id1, "Armario", -1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: quantidade deve ser maior que zero.");
		};
		
		try {v.validaAdicionaItem(null, "Armario", 1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaAdicionaItem("", "Armario", 1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		 
		try {v.validaAdicionaItem(id2, "Armario", 1, "4 portas", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id2 + ".");
		};
		
	}  
	
	
	@Test
	void testValidaAtualizaItem() {
		Validacao v = new Validacao();
		Item i = new Item("armario", 1, "4 portas", 1);
		
		String nome1 = "Lucas Leal";
		String id1 = "999";
		String id2 = "100";
		Usuario u1 = new Usuario(id1, nome1, "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put(id1, u1);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaItem(-2, id1, 1, "4 portas", usuarios);});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaItem(1, null, 1, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaItem(1, "", 1, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaItem(1, id2, 1, "4 portas", usuarios);});

		assertThrows(IllegalArgumentException.class, ()->{v.validaAtualizaItem(1000, id1, 1, "4 portas", usuarios);});

		try {v.validaAtualizaItem(-2, id1, 1, "4 portas", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do item nao pode ser negativo.");
		};
		
		try {v.validaAtualizaItem(1, null, 1, "4 portas", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaAtualizaItem(1, "", 1, "4 portas", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		};
		
		try {v.validaAtualizaItem(1, id2, 1, "4 portas", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id2 + ".");
		};
		
		try {v.validaAtualizaItem(1000, id1, 1, "4 portas", usuarios);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Item nao encontrado: " + 1000 + "."); 
		};
	}
	
	
	@Test
	void testValidaRemoveItem() {
		Validacao v = new Validacao();
	
		String id1 = "999";
		String id2 = "100";
		String id3 = "200";
		Usuario u1 = new Usuario(id1, "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");
		Usuario u2 = new Usuario(id2, "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");

		u1.adicionaItem("armario", 1, "4 portas", 1);

		Map<String, Usuario> usuarios = new HashMap<>();
		usuarios.put(id1, u1);
		usuarios.put(id2, u2);
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(-2, id1, usuarios);;});
		
		try {v.validaRemoveItem(-2, id1, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do item nao pode ser negativo."); 
		};
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(1, null, usuarios);;});
		
		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(1, "", usuarios);;});
		
		try {v.validaRemoveItem(1, null, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo."); 
		};
		
		try {v.validaRemoveItem(1,   "", usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Entrada invalida: id do usuario nao pode ser vazio ou nulo."); 
		};

		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(1, id3, usuarios);;});
		
		try {v.validaRemoveItem(1, id3, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Usuario nao encontrado: " + id3 + "."); 
		};

		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(1, id2, usuarios);;});
		
		try {v.validaRemoveItem(1, id2, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: O Usuario nao possui itens cadastrados."); 
		};

		assertThrows(IllegalArgumentException.class, ()->{v.validaRemoveItem(10, id1, usuarios);;});
		
		try {v.validaRemoveItem(10, id1, usuarios);;
		}catch(IllegalArgumentException exception) {
			assertEquals(exception.toString(), "java.lang.IllegalArgumentException: Item nao encontrado: " + 10 + "."); 
		};
		
	} 
	
	@Test
	void testValidaExibeItem() {
		

	}
	
	@Test
	void testValidaPesquisaItemParaDoacaoPorDescricao() {

	}
}
