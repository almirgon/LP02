/**
 * Classe que representa o sistema de estacionamento
 * 
 * @author almirgc
 *
 */
public class Sistema {

	private int caixa;
	private int tamanho;
	private int contador;
	private VagaEstacionamento[] vagas;

	/**
	 * Construtor com numero de vagas definido pelo usuário
	 * 
	 * @param tamanho
	 */
	public Sistema(int tamanho) {
		this.caixa = 0;
		this.tamanho = tamanho;
		this.vagas = new VagaEstacionamento[tamanho];
	}

	/**
	 * Construtor com 50 vagas
	 */
	public Sistema() {
		this.caixa = 0;
		this.tamanho = 50;
		this.contador = 0;
		this.vagas = new VagaEstacionamento[tamanho];
	}

	/**
	 * Metodo que repsenta um estacionamento de um carro em uma vaga
	 * 
	 * @param contador
	 * @param vagas
	 * @param setor
	 * @param posicao
	 */
	public void estacionaNaVaga(int contador, VagaEstacionamento vagas, String setor, int posicao, String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (this.vagas[i] == null) {
				this.vagas[contador - tamanho] = new VagaEstacionamento(setor, posicao);
				contador += 1;
				this.vagas[i].estacionar(placa);
			} else {
				// Lança uma exerção se tentar estacionar em uma vaga ocupada
				throw new IllegalArgumentException("A vaga já está ocupada");
			}
		}
	}

	public void LiberaVaga() {
		// Por motivos de tempo não consegui acabar esse metodo
		// O metodo iria pecorrer o array de vagas e após encontrar a vaga que desejo
		// iria
		// Tornar essa vaga disponivel para outro carro(boolean), pegar a sua hora de
		// saida e subtrair com a de entrada e assim
		// Calcular o valor do estacionamento
		// Se for menor que 2 hrs o caixa recebe R$ 5, se não ele recebe esse valor + R$
		// 1 por hora extra
	}

	/**
	 * Metodo que retorna um painel com as vagas livres
	 * 
	 * @return
	 */
	public String painelVagasLivres() {
		String lista = "";
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] == null) {
				lista = (i + 1) + " " + vagas[i].localizacao() + System.lineSeparator();
			}
		}
		return lista;
	}

	/**
	 * Metodo que localiza um carro por sua placa
	 * 
	 * @param placa
	 * @return
	 */

	public String localizaCarro(String placa) {
		String local = "";
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getPlaca() == placa) {
				local = vagas[i].localizacao();
			}
		}
		return local;

	}

	public void imprimeLucro() {
		// Por motivos de tempo não consegui acabar esse metodo(não será void será int)
		// Esse metodo será representado por inteiro e irá retornar o valor total do
		// caixa do estacionamento
	}

}
