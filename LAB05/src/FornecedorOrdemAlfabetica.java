import java.util.Comparator;
/**
 * Classe responsavel por implementar o comparator da classe fornecedor
 * @author Almir Crispiniano - 117210914
 *
 */
public class FornecedorOrdemAlfabetica implements Comparator<Fornecedor> {
	/**
	 * Metodo que compara dois fornecedores pelo seu nome
	 */
	@Override
	public int compare(Fornecedor o1, Fornecedor o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
