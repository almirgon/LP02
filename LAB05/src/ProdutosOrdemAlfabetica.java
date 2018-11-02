import java.util.Comparator;
/**
 * Classe responsavel por implementar o comparator da classe produto
 * @author Almir Crispiniano - 117210914
 *
 */
public class ProdutosOrdemAlfabetica implements Comparator<Produto> {
	/**
	 * Metodo que compara dois produtos pelo seu nome
	 */
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
	

}
