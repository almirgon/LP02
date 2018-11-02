import easyaccept.EasyAccept;

/**
 * Classe responsavel por abstrair todo o sistema SAGA
 * @author Almir Crispiniano - 117210914
 *
 */
public class Facade {
	
	 ClienteController cliente;
	 FornecedorController fornecedorController;
	
	public Facade() {
		this.cliente = new ClienteController();
		this.fornecedorController = new FornecedorController();
	}
	
	public static void main(String[] args) {
		args = new String[] { "Facade", "acceptance_tests/use_case_1.txt","acceptance_tests/use_case_2.txt","acceptance_tests/use_case_3.txt" };
		EasyAccept.main(args);
	}	

	public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
		cliente.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return cliente.exibeCliente(cpf);
	}
	
	public String exibindoClientes() {
		return cliente.exibeClientes();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		 cliente.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		cliente.removeCliente(cpf);
	}
	
	public void adicionaFornecedor(String nome,String email,String telefone) {
		fornecedorController.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return fornecedorController.exibeFornecedor(nome);
	}
	
	public String exibindoFornecedores() {
		return fornecedorController.exibeFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fornecedorController.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		fornecedorController.removeFornecedor(nome);
	}
	
	public void adicionaProduto(String fornecedores, String nome, String descricao, double preco) {
		fornecedorController.adicionaProduto(fornecedores, nome, descricao, preco);
	}
	
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return fornecedorController.exibeProduto(fornecedor, nome, descricao);
	}

	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		fornecedorController.editaProduto(fornecedor, nome, descricao, novoPreco);
	}
	
	public void removeProduto(String fornecedor,String nome, String descricao) {
		fornecedorController.removeProduto(fornecedor, nome, descricao);
	}

}
