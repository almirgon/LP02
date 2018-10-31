package controle;

/**
 * Classe que representa a validação do programa (lança exceções)
 * @author Almir Crispiniano - 117210914
 *
 */
public class Validador {

	/**
	 * O métódo validaStringNaoVazia analisa se uma variável do tipo String contém espaços vazios
	 * @param dado
	 * @param mensagem
	 */
	
	public static void validaStringNaoVazia(String dado, String mensagem) {
		if (dado.trim().isEmpty()) {
			throw new IllegalArgumentException("Argumento inválido, " + mensagem + " vazio(a)");
		}
	}
	
	/**
	 * O método 'validaStringNaoNula' analisa se uma variável do tipo String é nula
	 * @param dado
	 */
	
	public static void validaStringNaoNula(String dado) {
		if (dado == null) {
			throw new NullPointerException("Argumento inválido, valor nulo");
		}
} 

}
