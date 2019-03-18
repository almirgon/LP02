package prova2;

import java.util.HashSet;

public class Pacotao {
	private HashSet<Encomenda> encomendas;

	public Pacotao() {
		encomendas = new HashSet<>();
	}

	public void adicionaEncomenda(Encomenda encomenda) {
		encomendas.add(encomenda);

	}

	public int getCusto() {
		int custo = 0;
		for (Encomenda i : encomendas) {
			custo += i.getCusto();
		}
		return custo;
	}
}