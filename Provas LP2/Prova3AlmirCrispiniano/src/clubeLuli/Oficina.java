package clubeLuli;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Oficina extends Produto implements CalculoPreco {

	private double cargaHoraria;

	public Oficina(String nome, String categoria, double valor, double cargaHoraria) {
		super(nome, categoria, valor);
		if(cargaHoraria < 0) {
			throw new IllegalArgumentException("Carga horaria nao pode ser menor que 0");
		}
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double preco() {
		return this.valor * this.cargaHoraria;
	}

}
