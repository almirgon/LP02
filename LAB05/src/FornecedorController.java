import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe responsavel por possuir os metodos da classe Fornecedor
 * @author Almir Crispiniano - 117210914
 *
 */
public class FornecedorController {
	/**
	 * Mapa que a chave representa o nome do fornecedor e o valor um fornecedor
	 * Comparator que organiza os fornecedores em ordem alfabetica pelo seu nome
	 */
	private Map<String, Fornecedor> fornecedores;
	private Comparator<Fornecedor> ordAlfabetica;

	public FornecedorController() {
		this.fornecedores = new HashMap<>();
		this.ordAlfabetica = new FornecedorOrdemAlfabetica();
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
	 * Metodo que cadastra um fornecedor no mapa de fornecedores
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public void adicionaFornecedor(String nome,String email, String telefone) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		Fornecedor f = new Fornecedor(nome, email, telefone);
		this.fornecedores.put(nome, f);
		
	}
	/**
	 * Metodo que pesquisa um fornecedor pelo seu nome 
	 * @param nome
	 * @return uma String com sua representacao textual
	 */
	public String exibeFornecedor(String nome) {
		if(!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}else {
			return this.fornecedores.get(nome).toString();
		}
	}
	/**
	 * Metodo que lista todos os fornecedores em ordem alfabetica
	 * @return lista de fornecedores
	 */
	public String exibeFornecedores() {
		String lista = "";
		List<Fornecedor> listaOrd = new ArrayList<>();
		listaOrd.addAll(this.fornecedores.values());
		listaOrd.sort(ordAlfabetica);
		for (Fornecedor f : listaOrd) {
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
		if(atributo == null || atributo.trim().isEmpty()){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		if(!atributo.equals("email") || !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributo.equals("email")) {
			fornecedores.get(nome).setEmail(novoValor);
		}
		if(atributo.equals("telefone")) {
			fornecedores.get(nome).setTelefone(novoValor);
		}
	}
	/**
	 * Metodo que remove um fornecedor do mapa a partir do seu nome
	 * @param nome
	 * @return
	 */
	public Fornecedor removeFornecedor(String nome) {
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if(!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}return this.fornecedores.remove(nome);
	}
	/**
	 * Metodo que adiciona um produto a um fornecedor
	 * @param nomeFornecedor
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if(fornecedor == null || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nula.");
		}
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if(!this.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
	}
	/**
	 * Metodo que exibe um produto de um dado fornecedor
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @return String contendo representação textual do produto do fornecedor
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		if(!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(fornecedor == null || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		return fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}
	/**
	 * Metodo que edita um produto de um dado fornecedor
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param novoPreco
	 */
	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		if(!this.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(fornecedor == null || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	/**
	 * Metodo que remove um produto de um determinado fornecedor
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String fornecedor,String nome, String descricao) {
		if(!this.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(fornecedor == null || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
	public String exibeContasFornecedor(String cpf) {
		String lista = "";
		for (Fornecedor fornecedor : fornecedores.values()) {
			lista += fornecedor.exibeContas(cpf);
		}return lista;
	}

}