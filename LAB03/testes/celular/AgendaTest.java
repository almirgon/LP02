package celular;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Classe responsavel por realizar os testes da Agenda
 * @author Almir Crispiniano - 117210914
 *
 */
class AgendaTest {
	
	Agenda agenda1;
	Agenda agenda2;

	@BeforeEach
	void setUp() throws Exception {
		this.agenda1 = new Agenda();
		this.agenda2 = new Agenda();
		
	}

	@Test
	@DisplayName("teste de existencia da posicao 0 no array")
	void testVerificaExistencia0() {
		assertFalse(agenda1.verificaExistencia(0));
	}
	
	@Test
	@DisplayName("teste de existencia da posicao 1 no array")
	void testVerificarExistencia1() {
		assertTrue(agenda1.verificaExistencia(1));
	}
	
	@Test
	@DisplayName("teste de existencia da posicao 101 no array")
	void testVerificaExistencia101() {
		assertFalse(agenda1.verificaExistencia(101));
	}
	
	@Test
	@DisplayName("teste de existencia da posicao 100 no array")
	void testVerificaExistencia100() {
		assertTrue(agenda1.verificaExistencia(100));
	}

	@Test
	@DisplayName("teste cadastro de um contato valido")
	 void testaCadastroContatoValido() {
		assertTrue(agenda1.cadastraContato("Almir", "Crispiniano", "083 99669-0506", 1));
		assertTrue(agenda1.cadastraContato("Thalyta", "Barbosa", "083 99678-9678", 99));
		
	} 

	@Test
	@DisplayName("teste exibir contato")
	void testExibirContato() {
		agenda1.cadastraContato("Almir", "Crispiniano", "083 99669-0506", 1);
		assertEquals(agenda1.exibirContato(1), "Almir Crispiniano - 083 99669-0506");
	}

	@Test
	@DisplayName("verifica se duas agendas sao iguais")
	void testAgendasIguais() {
		agenda1.cadastraContato("Almir", "Crispiniano", "083 99669-0506", 1);
		agenda2.cadastraContato("Almir", "Crispiniano", "083 99669-0506", 1);
		assertTrue(agenda1.equals(agenda2));
	}

}
