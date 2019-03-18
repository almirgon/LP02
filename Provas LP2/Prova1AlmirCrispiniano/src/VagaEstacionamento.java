import java.time.LocalTime;

/**
 * Classe que representa uma vaga de um estacinamento
 * 
 * @author Almir Crispiniano
 *
 */
public class VagaEstacionamento {

	private String placa;
	private String setor;
	private int posicao;
	private LocalTime horaOcupada;
	private boolean vagaDisponivel;

	public VagaEstacionamento(String setor, int posicao) {
		this.placa = "";
		this.setor = setor;
		this.posicao = posicao;
		this.horaOcupada = null;
		this.vagaDisponivel = true;
	}

	public String getSetor() {
		return setor;
	}

	public int getPosicao() {
		return posicao;
	}

	public boolean isVagaDisponivel() {
		return vagaDisponivel;
	}

	public String getPlaca() {
		return placa;
	}

	/**
	 * Metodo que cria uma vaga pela Setor e posição
	 * 
	 * @param codigoSetor
	 * @param posicao
	 */
	public void criarVaga(String codigoSetor, int posicao) {
		this.setor = codigoSetor;
		this.posicao = posicao;
	}

	/**
	 * Metodo que estaciona um carro de palca(String) numa vaga, cadastra sua hora e
	 * a torna ocupada
	 * 
	 * @param placa
	 */
	public void estacionar(String placa) {
		this.vagaDisponivel = false;
		this.placa = placa;
		this.horaOcupada = LocalTime.now();
	}

	/**
	 * Metodo que verifica se a vaga está disponivel
	 * 
	 * @return
	 */
	public boolean statusVaga() {
		if (this.vagaDisponivel) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que mostra a localização de um carro
	 * 
	 * @return
	 */
	public String localizacao() {
		return this.getSetor() + "/" + this.getPosicao();
	}

	/**
	 * Representação textual da classe
	 */

	@Override
	public String toString() {
		return this.getSetor() + " " + this.getPosicao() + " - " + this.isVagaDisponivel();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + posicao;
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		return result;
	}

	/**
	 * Duas vagas são iguais se possuem a mesma localização (setor + posição)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VagaEstacionamento other = (VagaEstacionamento) obj;
		if (posicao != other.posicao)
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}

}
