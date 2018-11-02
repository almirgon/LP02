/**
 * Classe que representa um Produto do SAGA
 * @author Almir Crispiniano - 117210914
 *
 */
public class Produto {
	/**
	 * Atributos que compoem um Produto sendo nome de descrição representados em String e preço em double
	 */
	private String nome;
	private String descricao;
	private double preco;

	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Metodo que gera um HashCode a partir do nome e descricao do Produto
	 * @return inteiro que representa o HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Metodo 'equals' que define que dois produtos são iguais se possuirem o mesmo nome e descrição
	 * @return booleano que define se os dois produtos sao iguais ou não
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	/**
	 * Metodo toString que retorna uma representacao textual da classe Produto
	 */
	@Override
	public String toString() {
		return this.getNome() + "-" + this.getDescricao() + "-" + this.getPreco();
	}

}