import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * @author Almir Crispiniano - 117210914
 *
 */

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String simbolo = sc.next();
		if (simbolo.equals("+")) {
			double nUm = sc.nextDouble();
			double nDois = sc.nextDouble();
			System.out.println("RESULTADO: " + (nUm + nDois));
		} else if (simbolo.equals("-")) {
			double nUm = sc.nextDouble();
			double nDois = sc.nextDouble();
			System.out.println("RESULTADO: " + (nUm - nDois));
		} else if (simbolo.equals("*")) {
			double nUm = sc.nextDouble();
			double nDois = sc.nextDouble();
			System.out.println("RESULTADO: " + (nUm * nDois));
		} else if (simbolo.equals("/")) {
			double nUm = sc.nextDouble();
			double nDois = sc.nextDouble();
			if (nDois == 0.0) {
				System.out.println("ERRO");
			}else {
				System.out.println("RESULTADO: " + (nUm / nDois) );
			}
		} else {
			System.out.println("ENTRADA INVALIDA");
		}
	}
}