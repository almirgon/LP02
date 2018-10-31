package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe que representa o sistema de controle de alunos
 * @author Almir Crispiniano - 117210914
 *
 */
public class Sistema {
	/**
	 * Atributos privados em que o primeiro representa um mapa dos alunos associados a suas matriculas 
	 * e as informações da classe Aluno
	 * O Segundo representa uma mapa dos grupos associados a sua matricula e seus Alunos
	 * O terceiro representa uma lista(Segue ordem e pode conter elementos repetidos) dos alunos
	 * que responderam ao questionario
	 */
	private Map<String,Aluno> alunos;
	private Map<String, Grupo> grupos;
	private List<Aluno> alunosQueResponderam;

	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosQueResponderam = new ArrayList<>();
	} 
	/**
	 * Metodo que transforma a matricula em inteiro e verifica se ela é valida(maior que 0)
	 * @param matricula
	 * @return
	 */
	public boolean validaMatricula(String matricula) {
		int numero = Integer.parseInt(matricula);
		if (numero <= 0) { 
			return false; 
			}return true;
	}
	/**
	 * Metodo que cadastra aluno em um mapa sendo a chave a sua matricula e o seu valor o aluno
	 * @param matricula
	 * @param aluno
	 * @return
	 */
	public Aluno cadastraAluno(String matricula, Aluno aluno) {
		return this.alunos.put(matricula, aluno);
	}
	/**
	 * Metodo que verifica a existencia do aluno no mapa pela sua matricula
	 * @param matricula
	 * @return
	 */
	public boolean existenciaAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	/**
	 * Metodo que consulta o aluno pela sua matricula
	 * @param matricula
	 * @return
	 */
	public Aluno consultaAluno(String matricula) {
		return this.alunos.get(matricula);
	}
	/**
	 * Metodo que cadastra um grupo ao receber o nome do mesmo
	 * @param nomeGrupo
	 * @param grupo
	 * @return
	 */
	public Grupo cadastraGrupo(String nomeGrupo, Grupo grupo) {
		return this.grupos.put(nomeGrupo, grupo);
	}
	/**
	 * Metodo que verifica a existencia do grupo pelo nome do mesmo
	 * @param nomeGrupo
	 * @return
	 */
	public boolean exitenciaGrupo(String nomeGrupo) {
		return this.grupos.containsKey(nomeGrupo.toLowerCase());
	}
	/**
	 * Metodo que aloca um aluno em um grupo
	 * @param matricula
	 * @param nome
	 */
	public void alocarAluno(String matricula, String nome) {
		this.grupos.get(nome).alocaGrupo(this.alunos.get(matricula));
	}
	/**
	 * Metodo que imprime um grupo de alunos
	 * @param nome
	 * @return
	 */
	public String imprimirGrupo(String nome) {
		return this.grupos.get(nome).toString() + System.lineSeparator();
	}
	/**
	 * Metodo que adiciona na lista os alunos que responderam o questionario
	 * @param matricula
	 */
	public void adicionaAlunoQueRespondeu(String matricula) {
		this.alunosQueResponderam.add(this.alunos.get(matricula));
	}
	/**
	 * Metodo que lista em ordem os alunos que responderam o questionario
	 * @return
	 */
	public String listaAlunosQueResponderam() {
		String lista = "";
		lista += "Alunos: " + System.lineSeparator();
		for (int i = 0; i < alunosQueResponderam.size(); i++) {
			lista += (i+1) + ". " + alunosQueResponderam.get(i) + System.lineSeparator();
		}return lista;
	}
}
