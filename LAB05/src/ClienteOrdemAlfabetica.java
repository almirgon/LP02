import java.util.Comparator;
/**
 * Classe responsavel por implementar o comparator da classe cliente
 * @author Almir Crispiniano - 117210914
 *
 */
public class ClienteOrdemAlfabetica implements Comparator<Cliente> {
	/**
	 * Metodo que compara dois clientes pelo seu nome
	 */
	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getNome().compareTo(c2.getNome());
	}

}
