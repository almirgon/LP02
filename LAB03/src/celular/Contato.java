package celular;
/**
 * Classe responsavel por guardar as informações, como nome, sobrenome e telefone
 * de cada contato
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
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.validarDados(nome, sobrenome, telefone);
		
		this.nome = nome; 
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	private void validarDados(String nome, String sobrenome, String telefone) {
		Validador.validaStringNaoNula(nome, "Nome inválido!");
		Validador.validaStringNaoNula(sobrenome, "Sobrenome Inválido!");
		Validador.validaStringNaoNula(telefone, "Telefone inválido!");
		Validador.validaStringNaoVazia(nome, "Nome vazio");
		
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
	 * Metodo equals que define que dois contatos são iguais se tiverem o mesmo nome e sobrenome
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
