public class Facade {
	
	 ClienteController cliente;
	 FornecedorController fornecedor;
	
	public Facade() {
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}

	public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
		cliente.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return cliente.exibeCliente(cpf);
	}
	
	public String exibindoClientes() {
		return cliente.listarClientes();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		 cliente.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		cliente.removeCliente(cpf);
	}
	
	public void adicionaFornecedor(String nome,String email,String telefone) {
		fornecedor.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return fornecedor.exibeFornecedor(nome);
	}
	
	public String exibindoFornecedores() {
		return fornecedor.listaFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fornecedor.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		fornecedor.removeFornecedor(nome);
	}

}
