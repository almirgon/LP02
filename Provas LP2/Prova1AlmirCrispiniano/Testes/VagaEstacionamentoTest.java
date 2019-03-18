import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VagaEstacionamentoTest {

	private String setor;
	private int posicao;

	@BeforeEach
	void setUp() throws Exception {
		VagaEstacionamento v1 = new VagaEstacionamento(setor, posicao);

	}

	@Test
	void setorNull() {
		assertThrows(NullPointerException.class, () -> new VagaEstacionamento(null, posicao));
	}

	@Test
	void setorVazio() {
		assertThrows(IllegalArgumentException.class, () -> new VagaEstacionamento("", posicao));
	}

}
