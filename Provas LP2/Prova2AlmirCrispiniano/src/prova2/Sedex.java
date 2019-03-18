package prova2;

public class Sedex extends Encomenda {

	private int volume;
	private int peso;

	public Sedex(int identificador, int peso, int volume) {
		super(identificador);

		if (peso < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro do SEDEX: Peso nao pode ser menor que 0");
		}

		if (volume < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro do SEDEX: Volume nao pode ser menor que 0");
		}

		this.peso = peso;
		this.volume = volume;
	}

	@Override
	public int getCusto() {
		return 100 + (22 * peso) + (100 * volume);
	}

	@Override
	public String toString() {
		return "SE" + super.toString() + peso + " kg " + volume + " m3";
	}
}