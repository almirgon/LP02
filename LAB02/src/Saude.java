/**
 * Classe responsavel por acompanhar a saude fisica e mental do aluno
 * @author Almir Crispiniano - 117210914
 */
public class Saude {
	/**
	 * Atributos que representam a saude fisica e mental do aluno em String
	 */
	private String saudeFisica;
	private String saudeMental;
	
	/**
	 * Construtor que inicia a saude fisica e mental do aluno como boas
	 * @param saudeFisica
	 * @param saudeMental
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/**
	 * Metodo que define a saude mental do aluno
	 * @param valor
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	/**
	 * Metodo que define a saude fisica do aluno
	 * @param valor
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Metodo que analisa a saude fisica e mental do aluno e retorna o valor
	 * da sua saude geral 
	 * @return
	 */
	public String getStatusGeral() {
		if (this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
			return "boa";
		}else if (this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca")) {
			return "fraca";
		}else {
			return "ok";
		}
	}
	
	/**
	 * Metodo que retorna a String presente no metodo getStatusGeral()
	 */
	@Override
	public String toString() {
		return getStatusGeral();
	}
	

}
