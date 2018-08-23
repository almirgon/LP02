import java.util.Scanner;

/**
 * 
 * Laboratório de Programação 2 - Lab 1
 * @author Almir Crispiniano - 117210914
 */

public class DobroTriplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int numero = sc.nextInt();
		System.out.println("dobro:" + (numero * 2) + ", triplo:" + (numero * 3));
	}

}
