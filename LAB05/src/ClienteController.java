import java.util.HashMap;
import java.util.Map;
/**
 * Classe responsavel por possuir os metodos da classe Cliente
 * @author Almir Crispiniano - 117210914
 *
 */
public class ClienteController {
	
	private Map<String, Cliente> clientes;

	public ClienteController() {
		this.clientes = new HashMap<>();
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
	 * @return
	 */
	public boolean validaCpf(String cpf) {
		if (cpf.length() > 11 || cpf.length() < 11) {
			return false;
		}return true;
	}
	
	/**
	 * Metodo que após verificar existencia do cliente cadastra o mesmo no mapa 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	public void adicionaCliente(String cpf,String nome, String email, String localizacao) {
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo");
		}
		if(email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(localizacao == null || localizacao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if(this.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		if(!this.validaCpf(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (!this.existeCliente(cpf)) {
			Cliente c = new Cliente(cpf, nome, email, localizacao);
			this.clientes.put(cpf, c);
		}
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
	 * Metodo que varre os valores do mapa e adicionam todos os clientes em uma lista
	 * @return String contendo uma lista de clientes
	 */
	public String listarClientes() {
		String lista = "";
		for (Cliente c : this.clientes.values()) {
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
		if(this.existeCliente(cpf)) {
			if (atributo.equals("nome")) {
				clientes.get(cpf).setNome(novoValor);
			}else if(atributo.equals("email")){
				clientes.get(cpf).setEmail(novoValor);
			}else if(atributo.equals("localizacao")) {
				clientes.get(cpf).setLocalizacao(novoValor);
			}
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
		}else {
			return this.clientes.remove(cpf);
		}
	}

}

