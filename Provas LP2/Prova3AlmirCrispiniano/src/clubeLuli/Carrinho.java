package clubeLuli;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrinho {

	Set<Produto> produtos;

	public Carrinho() {
		this.produtos = new HashSet<>();
	}

	public void adiciona(Produto p) {
		this.produtos.add(p);
	}
	
	public double totalPreco() {
		double total = 0.0;
		for (Produto produto : produtos) {
			total += produto.getValor();
		}return total;
	}

}
