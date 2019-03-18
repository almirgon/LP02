package clubeLuli;

/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Facade {

	private Controller controle;

	public Facade() {
		this.controle = new Controller();
	}

	public void adicionaOficina(String nome, String categoria, double valor, double cargaHoraria) {
		this.controle.adicionaOficina(nome, categoria, valor, cargaHoraria);

	}

	public void adicionaLivro(String nome, String categoria, double valor, String estado) {
		this.controle.adicionaLivro(nome, categoria, valor, estado);
	}

	public void adicionaJogo(String nome, String categoria, double valor) {
		this.controle.adicionaJogo(nome, categoria, valor);
	}

	public String exibirProduto(String nome) {
		return this.controle.exibirProduto(nome);
	}

	public double obterPreco(String nome) {
		return this.controle.obterPreco(nome);
	}
	
	public void criaCarrinho(int id) {
		this.controle.criaCarrinho(id);
	}
	
	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		this.controle.adicionaProdutoAoCarrinho(id, nomeProduto);
	}
	
	public double totalizaCarrinho(int id) {
		return this.controle.totalizaCarrinho(id);
	}

	public void configuraOrdenacao(String ord) {
		this.controle.configuraOrdenacao(ord);
	}
	
	public String listar() {
		return this.controle.listar();
	}

}
