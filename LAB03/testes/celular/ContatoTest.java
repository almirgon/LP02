package celular;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.IllegalSelectorException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe responsável por realizar os testes de um Contato
 * @author Almir Crispiniano - 117210914
 *
 */

class ContatoTest {
	
	private Contato primeiro;
	private Contato segundo;
	private Contato terceiro;


	@BeforeEach
	void setUp() {
		this.primeiro = new Contato("Almir", "Crispiniano", "(83) 99669-0506");
		this.segundo = new Contato("Almir", "Crispiniano", "(83) 3063-4949");
		this.terceiro = new Contato("Thalyta","Barbosa", "(83) 99658-4523");
	}
	
	@Test
	@DisplayName("teste nome nulo")
	void testNomeNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato(null, "Crispiniano", "083 99669-0506");});
		assertEquals("nome nao pode ser null", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste nome vazio")
	void testNomeVazio() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato("", "Crispiniano", "083 99669-0506");});
		assertEquals("nome nao pode ser vazio", iae.getMessage());
	}
	
	@Test
	@DisplayName("test sobrenome nulo")
	void testSobrenomeNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato("Almir", null, "083 99669-0506");});
		assertEquals("sobrenome nao pode ser nulo", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste sobrenome vazio")
	void testSobrenomeVazio() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato("Almir", "", "083 99669-0506");});
		assertEquals("sobrenome nao pode ser vazio", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste telefone nulo")
	void testTelefoneNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato("Almir", "Crispiniano", null);});
		assertEquals("telefone nao pode ser nulo", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste telefone vazio")
	void testTelefoneVazio() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Contato("Thalyta", "Barbosa", "");});
		assertEquals("telefone nao pode ser vazio", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste dois contatos iguais")
	void testIguais() {
		assertTrue(primeiro.equals(segundo)); 
	}
	
	@Test
	@DisplayName("dois contatos diferentes")
	void testDiferentes() {
		assertFalse(primeiro.equals(terceiro));
	}

}