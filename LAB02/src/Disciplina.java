import java.util.Arrays;

/**
 * Classe que documenta as horas estudadas, recebe as notas, calcula a media
 * e por ela define a aprovacaoo ou não do aluno na disciplina
 * @author Almir Crispiniano - 117210914
 */

public class Disciplina {
	/**
	 * Atributos que representam a disciplina em String, horas estudadas para ela em inteiros, 
	 * notas e sua media final em double
	 */
	private String nomeDisciplina;
	private int horasTrabalhadas;
	private double media;
	private double[] notas = new double[4];
	private int numeroNotas;
	
	/**
	 * Construtor que recebe como parametro o nome da disciplina
	 * @param nomeDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	
	}
	
	public Disciplina(int numeroNotas) {
		this.numeroNotas = numeroNotas;
	}
	
	public Disciplina(int numeroNotas, double[] ponderamento) {
		this.numeroNotas = numeroNotas;
	}
	
	
	/**
	 * Metodo que cadastra o numero de horas dedicadas a disciplina
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas += horas;
	}
	
	/**
	 * Metodo que cadastra as quatros notas em um Array
	 * @param nota
	 * @param valorNota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Metodo privado usado para calcular a media das notas guardadas no array de Notas.
	 * @return media
	 */
	private double media() {
		this.media = ((notas[0] + notas[1] + notas[2] + notas[3])/4);
		return media;
	}
	
	/**
	 * Metodo booleano que ao analisar a media retorna a aprovação
	 * (se a mesma for maior que 7.0) ou não na disciplina
	 * @return
	 */
	public boolean aprovado() {
		return (this.media() >= 7.0);
	}
	
	
	@Override
	public String toString() {
		return  nomeDisciplina + " " + horasTrabalhadas + " "
				+ media + " " + Arrays.toString(notas);
	}
	
}
