package controle;
/**
 * Classe que representa um Aluno
 * @author Almir Crispiniano - 117210914
 *
 */
public class Aluno {
	/**
	 * Atributos que representam em String a matricula, o nome e o curso do Aluno
	 */
	private String matricula;
	private String nome;
	private String curso;
	
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}
	/**
	 * Metodo hashcode que gera um codigo unico se as matriculas forem iguais
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	/**
	 * Metodo equals em que dois objetos são iguais se possuem a mesma matricula
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	/**
	 * Metodo toString que retorna uma representação textual da classe aluno
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}
}
