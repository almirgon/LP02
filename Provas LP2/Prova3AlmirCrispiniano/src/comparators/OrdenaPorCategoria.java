package comparators;

import java.util.Comparator;

import clubeLuli.Produto;
/**
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class OrdenaPorCategoria implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getCategoria().compareTo(o2.getCategoria());
	}
	

}
