import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * @author Almir Crispiniano - 117210914
 *
 */
public class Funcao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nUm = sc.nextInt();
		int nDois = sc.nextInt();
		int nTres = sc.nextInt();
		int nQuatro = sc.nextInt();
		if (nUm < nDois && nDois < nTres && nTres < nQuatro) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		}else if (nUm > nDois && nDois > nTres && nTres > nQuatro) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		}else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}

}
