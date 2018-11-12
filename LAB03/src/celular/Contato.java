package celular;

/**
 * Classe responsavel por guardar as informações, como nome, sobrenome e
 * telefone de cada contato
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Contato {
	/**
	 * Atibutos que representam um contato em String
	 */
	private String nome;
	private String sobrenome;
	private String telefone;

	/**
	 * Construtor que valida os dados dos testes
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null) {
			throw new IllegalArgumentException("nome nao pode ser null");
		}

		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("nome nao pode ser vazio");
		}

		if (sobrenome == null) {
			throw new IllegalArgumentException("sobrenome nao pode ser nulo");
		}

		if (sobrenome.trim().isEmpty()) {
			throw new IllegalArgumentException("sobrenome nao pode ser vazio");
		}

		if (telefone == null) {
			throw new IllegalArgumentException("telefone nao pode ser nulo");
		}

		if (telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("telefone nao pode ser vazio");
		}

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo que retorna o nome completo do contato
	 * 
	 * @return String
	 */
	public String meuContato() {
		return this.getNome() + " " + this.getSobrenome();
	}

	/**
	 * Metodo que retorna uma String contendo todos os dados de um contato
	 */
	@Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome() + " - " + this.getTelefone();
	}

	/**
	 * Gera o hashCode do contato a partir do seu nome
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	/**
	 * Metodo equals que define que dois contatos são iguais se tiverem o mesmo nome
	 * e sobrenome
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

}
