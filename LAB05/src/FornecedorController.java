import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsavel por possuir os metodos da classe Fornecedor
 * @author Almir Crispiniano - 117210914
 *
 */
public class FornecedorController {
	
	private Map<String, Fornecedor> fornecedores;
	private Map<Fornecedor, Produto> produtoDosFornecedores;

	public FornecedorController() {
		this.fornecedores = new HashMap<>();
		this.produtoDosFornecedores = new HashMap<>();
	}
	
	/**
	 * Metodo booleano que verifica existencia de um fornecedor
	 * @param nome
	 * @return
	 */
	public boolean existeFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}
	/**
	 * Metodo que cadastra um fornecedor no mapa de fornecedores(se esse fornecedor não existir)
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public void adicionaFornecedor(String nome,String email, String telefone) {
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		if(!this.existeFornecedor(nome)) {
			Fornecedor f = new Fornecedor(nome, email, telefone);
			this.fornecedores.put(nome, f);
		}
	}
	/**
	 * Metodo que pesquisa um fornecedor pelo seu nome e exibe sua representacao texutal
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		if(!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}else {
			return this.fornecedores.get(nome).toString();
		}
	}
	/**
	 * Metodo que lista todos os fornecedores do mapa
	 * @return
	 */
	public String listaFornecedores() {
		String lista = "";
		for (Fornecedor f : this.fornecedores.values()) {
			lista += f.toString() + " | ";
		}return lista;
	}
	/**
	 * Metodo que verifica se o fornecedor existe e recebe um atributo para ser editado em um novo valor
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (this.existeFornecedor(nome)) {
			if(atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			}else if(atributo.equals("email")) {
				fornecedores.get(nome).setEmail(novoValor);
			}else if(atributo.equals("telefone")) {
				fornecedores.get(nome).setTelefone(novoValor);
			}
		}
		
	}
	/**
	 * Metodo que remove um fornecedor do mapa a partir do seu nome
	 * @param nome
	 * @return
	 */
	public Fornecedor removeFornecedor(String nome) {
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if(!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}return this.fornecedores.remove(nome);
	}
	
	/**
	 * Metodo que verifica a existencia de um fornecedor de tal produto
	 * @param fornecedor
	 * @return
	 */
	public boolean existefornecedorDoProduto(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.containsKey(fornecedor);
	}
	/**
	 * Metodo que cadastra um produto em um fornecedor
	 * @param fornecedor
	 * @param preco
	 * @param nome
	 * @param descricao
	 */
	public void adicionafornecedorDoProduto(Fornecedor fornecedor, String preco, String nome, String descricao) {
		if(this.existefornecedorDoProduto(fornecedor)) {
			Produto p = new Produto(preco, nome, descricao);
			this.produtoDosFornecedores.put(fornecedor, p);
		}
	}
	/**
	 * Metodo que retorna a representacao textual de um produto a partir do seu fornecedor
	 * @param fornecedor
	 * @return
	 */
	public String exibeProdutoDeFornecedor(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.get(fornecedor).toString();
	}
	
	public void listarProdutosFornecedor(Fornecedor fornecedor) {
		
	}
	
	public void listarProdutosTodosOsFornecedores() {
		
	}
	
	public void EditaProdutoDoFornecedor() {
		
	}
	/**
	 * Metodo que remove um produto do mapa a partir do seu fornecedor
	 * @param fornecedor
	 * @return
	 */
	public Produto removerProdutoDoFornecedor(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.remove(fornecedor);
	}

}
