package prova2;

public abstract class Encomenda {
	protected int identificador;

	public Encomenda(int identificador) {
		this.identificador = identificador;
	}

	public abstract int getCusto();

	public String toString() {
		return identificador + " - ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encomenda other = (Encomenda) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}

}