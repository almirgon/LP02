import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe que representa um Fornecedor do SAGA
 * @author Almir Crispiniano - 117210914
 *
 */
public class Fornecedor {
	/**
	 * Atributos que compoem um Fornecedor com nome, email e telefone representados em String
	 * Um mapa que contem os produtos que o fornecedor possui
	 * Comparator que organiza os produtos em ordem alfabetica
	 */
	private String nome;
	private String email;
	private String telefone;
	private Map<String, Produto> produtos;
	private Comparator<Produto> produtoOrdemAlfabetica;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
		this.produtoOrdemAlfabetica = new ProdutosOrdemAlfabetica();

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Metodo que gera um HashCode a partir do nome do fornecedor
	 * @return inteiro que representa o HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Metodo 'equals' que define que dois fornecedores são iguais se possuirem o mesmo nome
	 * @return booleano que define se os dois fornecedores sao iguais ou não
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	/**
	 * Metodo toString que retorna uma representacao textual da classe Fornecedor
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - " + this.getTelefone();
	}
	/**
	 * Metodo que verifica a existencia de um produto pela seu nome e descrição
	 */
	public boolean existeProduto(String nome, String descricao) {
		if(this.produtos.containsKey(nome)) {
			this.produtos.get(nome).getDescricao().equals(descricao);
			return true;
		}
		return false;
	}
	/**
	 * Metodo que adiciona um produto no mapa de produtos
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		if(!this.existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		Produto produto = new Produto(nome, descricao, preco);
		this.produtos.put(nome, produto);
	}
	/**
	 * Metodo que exibe um produto se ele não for nulo e sua descrição, se a mesma for igual ao parametro passado
	 * @param nome
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nome, String descricao) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}if(descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(this.existeProduto(nome, descricao)) {
			return this.produtos.get(nome).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		
	}
	/**
	 * Metodo que lista os produtos de um fornecedor em ordem alfabetica
	 * @return
	 */
	public String exibeProdutosFornecedor() {
		String lista = "";
		List<Produto> listaOrd = new ArrayList<>();
		listaOrd.addAll(this.produtos.values());
		listaOrd.sort(produtoOrdemAlfabetica);
		for (Produto p : listaOrd) {
			lista += p.toString() + " | ";
		}
		return lista;
	}
	
		
	/**
	 * Metodo que edita o preço de um produto
	 * @param nome
	 * @param descricao
	 * @param novoPreco
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		if(this.existeProduto(nome, descricao)) {
			this.produtos.get(nome).setPreco(novoPreco);
		}
	}
	/**
	 * Metodo que remove um produto do mapa de produtos
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String nome, String descricao) {
		if(!this.existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}this.produtos.remove(nome);
	}
}