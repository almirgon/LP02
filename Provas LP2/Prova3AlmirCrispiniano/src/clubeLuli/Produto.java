package clubeLuli;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public abstract class Produto implements CalculoPreco {

	protected String nome;
	protected String categoria;
	protected double valor;

	public Produto(String nome, String categoria, double valor) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo");
		}
		if(categoria == null || categoria.trim().isEmpty()) {
			throw new IllegalArgumentException("Categoria nao pode ser vazia ou nula");
		}
		if(valor < 0) {
			throw new IllegalArgumentException("Valor nao pode ser negativo");
		}
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Dois produtos são iguais se eles tiverem o mesmo nome e a mesma categoria
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
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + this.getNome() + "," + this.getCategoria() + ", " + this.getValor() + "]";
	}

	@Override
	public abstract double preco();

}
