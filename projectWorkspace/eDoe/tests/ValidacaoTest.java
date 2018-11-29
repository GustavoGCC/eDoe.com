import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import eDoe.*;

class ValidacaoTest {

	
	@Test
	void testValidaAdicionaDoador() {
		Validacao v = new Validacao();

		assertThrows(IllegalArgumentException.class, ()->{v.validaAdicionaDoador("100", "", "email", "celular", "classe", null);} );
		
		try {v.validaAdicionaDoador("100", "", "email", "celular", "classe", null);
		}catch(IllegalArgumentException exception) {
			assertEquals(exception, "Entrada invalida: nome nao pode ser vazio ou nulo.");
		};
		
		
	}

	@Test
	void testValidapesquisaUsuarioPorId() {

	}
	
	@Test
	void testValidapesquisaUsuarioPorNome() {

	}
	
	@Test
	void testVerificaNuloOuVazio() {

	}
	
	@Test
	void testValidaAtualizaUsuario() {

	}
	
	@Test
	void testValidaRemoveUsario() {

	}
	
	@Test
	void testValidaAdicionaDescritor() {

	}
	
	@Test
	void testValidaItemParaDoacao() {

	}
	
	@Test
	void testValidaAdicionaItemParaDoacao() {

	}
	
	@Test
	void testValidaRemoveItemParaDoacao() {

	}
	
	@Test
	void testValidaExibeItem() {

	}
	
	@Test
	void testValidaPesquisaItemParaDoacaoPorDescricao() {

	}
	
	@Test
	void test() {

	}

	
}
