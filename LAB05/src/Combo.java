import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um combo de Produtos
 * @author Almir Crispiniano - 117210914
 *
 */
public class Combo extends Produto {
	/**
	 * O fator reprenta um double que define o preço de um combo
	 * Produtos é uma lista contendo os produtos de um combo
	 */
	private double fator;
	private List<Produto> produtos;

	public Combo(String nome, String descricao, double preco, double fator, List<Produto> produtos) {
		super(nome, descricao, preco);
		this.fator = fator;
		this.produtos = new ArrayList<>();
	}

	public double getFator() {
		return fator;
	}

	public void setFator(double fator) {
		this.fator = fator;
	}
	
	
	
	
	
	

}
