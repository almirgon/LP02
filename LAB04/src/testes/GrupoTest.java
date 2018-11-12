package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controle.Grupo;
/**
 * Classe responsavel por realizar os testes de um Grupo
 * @author Almir Crispiniano - 117210914
 *
 */
class GrupoTest {
	
	private Grupo g1;
	private Grupo g2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.g1 = new Grupo("Projeto");
		this.g2 = new Grupo("PET");	
	}

	@Test
	@DisplayName("teste nome do grupo nulo")
	void testNomeNulo() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Grupo(null);});
		assertEquals("nome do grupo nao pode ser nulo", iae.getMessage());
	} 
	
	@Test
	@DisplayName("teste nome do grupo vazio")
	void testNomeVazio() {
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {new Grupo("");});
		assertEquals("nome do grupo nao pode ser vazio", iae.getMessage());
	} 
	
	@Test
	@DisplayName("teste diferença entre grupos")
	void testGruposDiferentes() {
		assertFalse(g1.equals(g2));
	} 

}
