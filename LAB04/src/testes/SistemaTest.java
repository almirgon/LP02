package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Sistema;

/**
 * Classe responsavel por realizar os testes do sistema
 * @author Almir Crispiniano - 117210914
 *
 */
class SistemaTest {
	
	private Sistema s1;

	@BeforeEach
	void setUp() throws Exception {
		this.s1 = new Sistema();
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
