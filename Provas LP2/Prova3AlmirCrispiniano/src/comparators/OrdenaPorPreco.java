package comparators;

import java.util.Comparator;

import clubeLuli.Produto;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class OrdenaPorPreco implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return (int) (o1.getValor() - o2.getValor());
	}

}
