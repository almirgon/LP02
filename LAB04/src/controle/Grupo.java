package controle;

import java.util.HashSet;
import java.util.Set;
/**
 * Classe que representa um conjunto de alunos em um grupo
 * @author Almir Crispiniano - 117210914
 *
 */
public class Grupo {
	/**
	 * Atributos em que o nome do grupo é representado em String e sua coleção 
	 * em um HashSet(não possui grupos repetidos e a ordem não importa)
	 */
	private String nomeGrupo;
	private Set<Aluno> alunos;
	
	public Grupo(String nomeGrupo) {
		if(nomeGrupo == null) {
			throw new IllegalArgumentException("nome do grupo nao pode ser nulo");
		}
		if(nomeGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("nome do grupo nao pode ser vazio");
		}
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet<>();
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}
	/**
	 * Metodo que adiciona um aluno em um grupo
	 * @param aluno
	 */
	public void alocaGrupo(Aluno aluno) {
		 this.alunos.add(aluno);
	}
	/**
	 * Metodo que gera um hashCode a partir do nome do grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	/**
	 * Metodo equals em que dois grupos são iguais se possuem o mesmo nome
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	/**
	 * Metodo que retorna uma representação textual dos grupos
	 */
	@Override
	public String toString() {
		String lista = "";
		lista += "Alunos do grupo " + this.getNomeGrupo() + ":" + System.lineSeparator();
		for (Aluno aluno : alunos) {
			lista += "* " + aluno.toString() + System.lineSeparator();
		}return lista;
	}

}
