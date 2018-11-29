import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eDoe.Item;
import eDoe.Usuario;

class UsuarioTest {
	
	@Test
	void testExibeItem() {
		Usuario u = new Usuario("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		u.adicionaItem("alfinete", 2, "prata", 1);
		assertEquals(u.exibeItem(1), "1 - alfinete, tags: [prata], quantidade: 2" );
	}
	
	@Test
	void testAdicionaItem() {
		Usuario u = new Usuario("999", "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");
		u.adicionaItem("bola de volei", 2, "bola branca", 1);
		assertEquals(u.exibeItem(1), "1 - bola de volei, tags: [bola branca], quantidade: 2" );
	}
	
	@Test
	void testAtualizaItemParaDoacao() {
		Usuario u = new Usuario("999", "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");
		u.adicionaItem("bola de volei", 2, "bola branca", 1);
		u.atualizaItemParaDoacao(1, 1, "bola azul");
		assertEquals(u.exibeItem(1), "1 - bola de volei, tags: [bola azul], quantidade: 1" );
		
	}
	
	@Test
	void testToString() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.toString(), "Daniel/100, daniel.figueredo@ccc.ufcg.edu.br, 1010-2222, status: PESSOA_FISICA");
	}
	
	@Test
	void testGetNome() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getNome(), "Daniel");
	}
	
	@Test
	void testGetId() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getId(), "100");
	}
	
	@Test
	void testGetEmail() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getEmail(), "daniel.figueredo@ccc.ufcg.edu.br");
	}

	@Test
	void testGetCelular() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getCelular(), "1010-2222");
	}

	@Test
	void testGetClasse() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getClasse(), "doador");
	}

	@Test
	void testGetStatus() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		assertEquals(u.getStatus(), "PESSOA_FISICA");
	}

	@Test
	void testSetEmail() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		u.setEmail("figdan@hotmail.com");
		assertEquals(u.getEmail(), "figdan@hotmail.com");
	}
	
	@Test
	void testSetCelular() {
		Usuario u = new Usuario("100", "Daniel", "daniel.figueredo@ccc.ufcg.edu.br", "1010-2222", "doador", "PESSOA_FISICA");
		u.setCelular("1212-1111");
		assertEquals(u.getCelular(), "1212-1111");
	}
	
	
	
	@Test
	void testHashCode() {
		Usuario u = new Usuario("299", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		assertEquals(u.hashCode(), 49905);
		Usuario v = new Usuario(null, "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");
		assertEquals(v.hashCode(), 31);
	}		
	
	@Test
	void testGetItens() {
		Usuario u = new Usuario("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		u.adicionaItem("alfinete", 10, "prata", 1);
		u.adicionaItem("bola de volei", 2, "bola branca", 2);
		u.adicionaItem("bola de volei", 1, "bola azul", 3);

		assertEquals(u.getItens().toString(), "{1=1 - alfinete, tags: [prata], quantidade: 10, 2=2 - bola de volei, tags: [bola branca], quantidade: 2, 3=3 - bola de volei, tags: [bola azul], quantidade: 1}");
	}


	@Test
	void testSetNome() {
		Usuario u = new Usuario("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		u.setNome("Joao Wanderley");
		assertEquals(u.getNome(), "Joao Wanderley");
	}	
	
	@Test
	void testEquals() {
		Usuario user1 = new Usuario ("167", "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		Usuario userNull = new Usuario (null, "Joao Victor", "joao.wanderley@ccc.ufcg.edu.br", "9999-8321", "PESSOA_FISICA", "doador");
		Usuario user2 = new Usuario ("999", "Lucas Leal", "lucas.lucena@ccc.ufcg.edu.br", "2345-6780", "PESSOA_FISICA", "doador");
		Usuario userReceptor = new Usuario ("6060", "Casa da Crianca", "casa.da.crianca@gmail.com.br", "0800-7890", "ASSOCIACAO", "receptor");
		Usuario fullNull = new Usuario(null, null, null, null, null, null);
		assertEquals(user1.equals(user1), true);
		assertEquals(user1.equals(null), false);
		
		assertEquals(user1.equals(userReceptor), false);
		assertEquals(user1.equals(user2), false);
		
		assertEquals(user1.equals(userNull), false);
		assertEquals(userNull.equals(user1), false);
		
		assertEquals(user1.equals(fullNull), false);
		assertEquals(fullNull.equals(user1), false);

		
		
	}
	
}
