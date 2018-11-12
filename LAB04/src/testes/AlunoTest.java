package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controle.Aluno;

/**
 * Classe responsavel por realizar os testes de aluno
 * @author Almir Crispiniano - 117210914
 *
 */
class AlunoTest {
	
	private Aluno a1;
	private Aluno a2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.a1 = new Aluno("117210914", "Almir", "Computacao");
		this.a2 = new Aluno("118156974", "Fernanda", "Historia");
	}

	@Test
	@DisplayName("teste nome nulo")
	void testNomeNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno("117210914", null, "Computacao");});
		assertEquals("nome nao pode ser nulo", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste nome vazio")
	void testNomeVazio() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno("117210914", "", "Computacao");});
		assertEquals("nome nao pode ser vazio", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste matricula nula")
	void testMatriculaNula() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno(null, "Almir", "Computacao");});
		assertEquals("matricula nao pode ser nula", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste matricula vazia")
	void testMatriculaVazia() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno("", "Almir", "Computacao");});
		assertEquals("matricula nao pode ser vazia", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste curso nulo")
	void testCursoNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno("117210914", "Almir", null);});
		assertEquals("curso nao pode ser nulo", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste curso vazio")
	void testCursoVazia() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Aluno("117210914", "Almir", "");});
		assertEquals("curso nao pode ser vazio", iae.getMessage());
	}
	
	@Test
	@DisplayName("teste alunos diferentes")
	void testAlunosDiferentes() {
		assertFalse(a1.equals(a2));
	}

}
