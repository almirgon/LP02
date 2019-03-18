package clubeLuli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.OrdenaPorCategoria;
import comparators.OrdenaPorNome;
import comparators.OrdenaPorPreco;

/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Controller {

	private Map<String, Produto> produtos;

	private Map<Integer, Carrinho> carrinho;

	private Comparator<Produto> estrategia;

	public Controller() {
		this.produtos = new HashMap<>();
		this.carrinho = new HashMap<>();
	}

	public void adicionaOficina(String nome, String categoria, double valor, double cargaHoraria) {
		Oficina oficina = new Oficina(nome, categoria, valor, cargaHoraria);
		produtos.put(nome, oficina);

	}

	public void adicionaLivro(String nome, String categoria, double valor, String estado) {
		Livro livro = new Livro(nome, categoria, valor, estado);
		produtos.put(nome, livro);
	}

	public void adicionaJogo(String nome, String categoria, double valor) {
		Jogo jogo = new Jogo(nome, categoria, valor);
		produtos.put(nome, jogo);
	}

	public String exibirProduto(String nome) {
		return this.produtos.get(nome).toString();
	}

	public double obterPreco(String nome) {
		return produtos.get(nome).preco();
	}

	public void criaCarrinho(int id) {
		if (!carrinho.containsKey(id)) {
			throw new IllegalArgumentException("iD já existe");
		}
		carrinho.put(id, new Carrinho());
	}

	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		carrinho.get(id).adiciona(produtos.get(nomeProduto));
	}

	public double totalizaCarrinho(int id) {
		return carrinho.get(id).totalPreco();
	}

	public void configuraOrdenacao(String ord) {
		if (ord.equals("PRECO".toLowerCase())) {
			estrategia = new OrdenaPorPreco();
		}
		if (ord.equals("CATEGORIA".toLowerCase())) {
			estrategia = new OrdenaPorCategoria();
		}
		if (ord.equals("NOME".toLowerCase())) {
			estrategia = new OrdenaPorNome();
		}
	}

	public String listar() {
		List<Produto> ordem = new ArrayList<>(produtos.values());
		Collections.sort(ordem, estrategia);
		String lista = "";
		for (Produto produto : ordem) {
			lista += produto.toString() + ", ";
		}
		return lista;

	}

}
