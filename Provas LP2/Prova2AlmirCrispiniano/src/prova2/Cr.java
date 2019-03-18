package prova2;

public class Cr extends Encomenda {

	private int folhas;

	public Cr(int identificador, int folhas) {
		super(identificador);

		if (folhas < 0) {
			throw new IllegalArgumentException("Erro no cadastro do CR: Folhas nao pode ser menor que 0");
		}

		this.folhas = folhas;
	}

	@Override
	public int getCusto() {
		return folhas;
	}

	@Override
	public String toString() {
		return "CR" + super.toString() + folhas + " folha(s)";
	}
}