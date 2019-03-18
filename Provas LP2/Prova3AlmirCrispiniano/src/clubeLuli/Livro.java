package clubeLuli;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Livro extends Produto implements CalculoPreco {

	private String estado;

	public Livro(String nome, String categoria, double valor, String estado) {
		super(nome, categoria, valor);
		if(estado == null || estado.trim().isEmpty()) {
			throw new IllegalArgumentException("Estado nao pode ser vazio ou nulo");
		}
		this.estado = estado;
	}

	@Override
	public double preco() {
		if (this.estado.equals("Usado".toLowerCase())) {
			return this.valor - (this.valor * 0.50);
		}
		return this.valor;
	}

}
