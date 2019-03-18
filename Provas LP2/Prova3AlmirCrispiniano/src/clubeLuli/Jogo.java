package clubeLuli;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Jogo extends Produto implements CalculoPreco {

	public Jogo(String nome, String categoria, double valor) {
		super(nome, categoria, valor);
	}

	@Override
	public double preco() {
		if (this.getCategoria().equals("Infantil".toLowerCase())) {
			return this.valor - (this.valor * 0.05);
		}
		return this.valor;
	}


}
