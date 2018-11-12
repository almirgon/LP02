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
	 * Um mapa com uma lista de produtos que repesenta as compras
	 * Um mapa com o valor das contas devedoras
	 */
	private String nome;
	private String email;
	private String telefone;
	private Map<String, Produto> produtos;
	private Comparator<Produto> produtoOrdemAlfabetica;
	private Map<String, List<Produto>> compras;
	private Map<String, Double> devedores;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
		this.produtoOrdemAlfabetica = new ProdutosOrdemAlfabetica();
		this.compras = new HashMap<>();
		this.devedores = new HashMap<>();

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
	
	/**
	 * Metodo que confere se um combo existe
	 * @param nome
	 * @param descricao
	 * @return 
	 */
	public boolean existeCombo(String nome, String descricao) {
		return this.existeProduto(nome, descricao);
	}
	/**
	 * Metodo que adiciona um combo no mapa de produtos
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param fator
	 * @param produtos
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao,double fator, List<Produto> produtos) {
		double preco = 0;
		for (Produto produto : produtos) {
			preco += produto.getPreco();
		}
		this.produtos.put(fornecedor, new Combo(nome, descricao, preco, fator, produtos));
	}
	/**
	 * Metodo que edita o fator de um combo
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 * @param novofator
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novofator) {
		((Combo) this.produtos.get(fornecedor)).setFator(novofator);
	}
	/**
	 * Metodo que exibe um produto ou combo
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
	 * Metodo que adiciona uma compra no mapa de compras 
	 * @param cpf
	 * @param nome_prod
	 * @param descricao_prod
	 */
	public void adicionaCompra(String cpf, String nome_prod, String descricao_prod) {
		Produto compra = produtos.get(nome_prod + " - " + descricao_prod);
		if (!compras.containsKey(cpf)) {
			compras.put(cpf, new ArrayList<>());
		}else {
			compras.get(cpf).add(compra);
		}
		Double valorAtual;
		if (!devedores.containsKey(cpf)) {
			valorAtual = 0.0;
		}else {
			valorAtual = devedores.get(cpf);
		}	
		this.compras.put(cpf, compras.get(cpf));
		this.devedores.put(cpf, valorAtual + compra.getPreco());
	}
	/**
	 * Metodo que retorna o valor devido de um cliente
	 * @param cpf
	 * @return
	 */
	public Double getDebito(String cpf) {
		return devedores.get(cpf);
	}
	/**
	 * Metodo que exibe as contas que um fornecedor possui
	 * @param cpf
	 * @return
	 */
	public String exibeContas(String cpf) {
		String lista = "";
		List<Produto> produtos = this.compras.get(cpf);
		for (int i = 0; i < produtos.size()-1; i++) {
			lista += produtos.get(i).toString() + System.lineSeparator();			
		}
		lista += produtos.get(produtos.size()-1).toString();
		return lista;
	}
	
	
}