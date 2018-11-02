import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe responsavel por possuir os metodos da classe Cliente
 * @author Almir Crispiniano - 117210914
 *
 */
public class ClienteController {
	/**
	 * Mapa contendo um chave que representa o CPF e um valor que representa o cliente
	 * Comparator que organiza os clientes em ordem alfabetica pela seu nome
	 */
	private Map<String, Cliente> clientes;
	private Comparator<Cliente> ordemAlfabetica;

	public ClienteController() {
		this.clientes = new HashMap<>();
		this.ordemAlfabetica = new ClienteOrdemAlfabetica();
	}
	/**
	 * Metodo booleano que verifica se o mapa possui tal CPF
	 * @param cpf em String
	 * @return booleano
	 */
	public boolean existeCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}
	/**
	 * Metodo que valida se o CPF possui 11 digitos
	 * @param cpf
	 * @return booleano
	 */
	public boolean validaCpf(String cpf) {
		return (cpf.length() == 11);
	}
	
	/**
	 * Metodo que após verificar existencia do cliente cadastra o mesmo no mapa de clientes
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	public void adicionaCliente(String cpf,String nome, String email, String localizacao) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo");
		}
		if(email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(localizacao == null || localizacao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if(this.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		if(!this.validaCpf(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		Cliente c = new Cliente(cpf, nome, email, localizacao);
		this.clientes.put(cpf, c);
	}
	/**
	 * Metodo que retorna um cliente pelo seu cpf
	 * @param cpf
	 * @return toString to cliente escolhido
	 */
	public String exibeCliente(String cpf) {
		if(!this.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}else {
			return this.clientes.get(cpf).toString();
		}
	}
	/**
	 * Metodo que lista os clientes em ordem alfabetica
	 * @return String contendo uma lista dos clientes
	 */
	public String exibeClientes() {
		String lista = "";
		List<Cliente> listaOrd = new ArrayList<>();
		listaOrd.addAll(this.clientes.values());
		listaOrd.sort(ordemAlfabetica);
		for (Cliente c : listaOrd) {
			lista += c.toString() + " | ";
		}return lista;
	}
	/**
	 * Metodo que verifica se o cpf existe para depois editar o atributo escolhido
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if(!this.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if(atributo == null || atributo.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if(!atributo.equals("nome") || !atributo.equals("email") || !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if (atributo.equals("nome")) {
			this.clientes.get(cpf).setNome(novoValor);
		}
		if(atributo.equals("email")){
			this.clientes.get(cpf).setEmail(novoValor);
		}
		if(atributo.equals("localizacao")) {
			this.clientes.get(cpf).setLocalizacao(novoValor);
		}
	}
	
	/**
	 * Metodo que remove um cliente do mapa a partir do seu CPF
	 * @param cpf
	 * @return
	 */
	public Cliente removeCliente(String cpf) {
		if(!this.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.remove(cpf);
	}
}
