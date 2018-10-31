package celular;

import java.util.Arrays;

/**
 * Classe responsavel por gerar agenda a partir dos contatos existentes no array
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Agenda {
	/**
	 * Array que representa os contatos de uma agenda telefonica
	 */
	private Contato contatos[];

	/**
	 * Construtor que inicia a agenda com 100 contatos
	 */
	public Agenda() {
		this.contatos = new Contato[100];

	}

	/**
	 * Metodo que analisa se o contato existe
	 * 
	 * @param posicao, o contato só pode existe entre a posição 1 e 100
	 * @return valor booleano
	 */
	public boolean verificaExistencia(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que analisa se o contato existe naquela posição
	 * 
	 * @param posicao
	 * @return valor booleano
	 */
	public boolean verificaContato(int posicao) {
		if (this.verificaExistencia(posicao)) {
			if (this.contatos[posicao - 1] == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	/**
	 * Metodo que cadastra contato no array, após verificar sua existencia, ao
	 * receber como parametros
	 * 
	 * @param nome      em String
	 * @param sobrenome em String
	 * @param telefone  em String
	 * @param posicao   em inteiro
	 * @return
	 */
	public void cadastraContato(String nome, String sobrenome, String telefone, int posicao) {
		if (this.verificaExistencia(posicao)) {
			throw new IllegalArgumentException("POSICAO INVALIDA");
		}
		contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}

	/**
	 * Metodo que cria um objeto c e armazena os contatos no array e depois o mostra
	 * pelo metodo toString()
	 * 
	 * @param posicao
	 * @return String
	 */
	public String exibirContato(int posicao) {
		Contato c = this.contatos[posicao - 1];
		return c.toString();
	}

	public String listarContato() {
		String lista = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				lista += (i + 1) + "-" + contatos[i].meuContato() + System.lineSeparator();
			}

		}
		return lista;
	}

	/**
	 * Gera um hashCode a partir do array de contatos
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	/**
	 * Metodo equals que compara se duas agendas são iguais São iguais: se as duas
	 * possuem os mesmos contatos nas mesma posições
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}

}
