package celular;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.IllegalSelectorException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author almirgc
 *
 */

class ContatoTest {
	
	private Contato primeiro;


	@BeforeEach
	void setUp() {
		this.primeiro = new Contato("Almir", "Crispiniano", "(83) 99146-0685");
	}
	
	@Test
	public void nomeNulo() {
		assertThrows(NullPointerException.class, () -> new Contato(null ,"Crispiniano", "(83) 99146-1685"));
	}
	
	@Test 
	public void sobrenomeNulo() {
		assertThrows(NullPointerException.class, () -> new Contato("Almir" ,null, "(83) 99146-1685"));
	}

	@Test
	public void telefoneNulo() {
		assertThrows(NullPointerException.class, () -> new Contato("Almir" ,"Crispiniano", null));
	}
	
	@Test
	public void nomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("" ,"Crispiniano", "(83) 99146-1685"));
	}
	
	@Test
	public void sobrenomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("Almir" ,"", "(83) 99146-1685"));
	}
	
	@Test
	public void telefoneVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("Almir" ,"Crispiniano", ""));
	}
	
	
	@Test
	public void testToString() {
		assertEquals(primeiro.toString(), "Almir Crispiniano - (83) 99146-0685");
	}
	
	

}


