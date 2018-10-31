package celular;

public class Validador {
	
	public static void validaStringNaoNula(String str, String msg) {
		if (str == null) {
			throw new NullPointerException(msg);
		}
	}
	
	public static void validaStringNaoVazia(String str, String msg) {
		if (str == "") {
			throw new IllegalArgumentException(msg);
		}
		
	}

}
