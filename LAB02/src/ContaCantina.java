/**
 * Classe que controla os gastos do aluno em uma cantina da universidade 
 * e documenta tanto a quantidade de itens consumidos como o valor gasto em centavos 
 * @author Almir Crispiniano - 117210914
 */
public class ContaCantina {
	/**
	 * Atributos que representam o nome da cantina em String, a quantidade de itens consumidos,
	 *  o valor gasto no consumo desses itens e o quanto falta pagar em inteiro
	 */
	private String nomeCantina;
	private int qtdItens;
	private int gastos;
	private int pago;
	private int falta;
	
	/**
	 * Construtor que recebo como parametro o nome da cantina 
	 * @param nomeCantina
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	/**
	 * Metodo que cadastra a quantidade de itens consumidos junto as seus respectivos
	 * valores em centavos 
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.gastos += valorCentavos;
	}
	
	/**
	 * Metodo que paga uma quantia igual ou menor ao debito,
	 * mas nunca superior
	 * @param valorCentavos
	 */
	public void pagaConta(int valorCentavos) {
		pago = gastos - valorCentavos;
	}
	/**
	 * Metodo que retorna o debito ainda existente na conta da cantina 
	 * @return
	 */
	public int getFaltaPagar() {
		this.falta = gastos - pago;
		return falta;
	}
	
	/**
	 * Metodo que retorna uma String no formatdo "nomeDacantina itensConsumidos GastosTotal"
	 */
	@Override
	public String toString() {
		return  nomeCantina + " " + qtdItens + " " + gastos;
	}
}
