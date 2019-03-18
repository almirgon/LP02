package prova2;

public class Pac extends Encomenda {
	private int peso;

	public Pac(int identificador, int peso) {
		super(identificador);

		if (peso < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro do PAC: Peso nao pode ser menor que 0");
		}

		this.peso = peso;
	}

	@Override
	public int getCusto() {
		return 60 + peso * 6;
	}

	@Override
	public String toString() {
		return "EC" + super.toString() + peso + " kg";
	}
}