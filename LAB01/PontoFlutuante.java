import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * @author Almir Crispiniano - 117210914
 *
 */
public class PontoFlutuante {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float numeroUm = sc.nextFloat();
		float numeroDois = sc.nextFloat();
		float media = (numeroUm + numeroDois)/2;
		if (media >= 7.0) {
			System.out.println("pass: True!");
		}else {
			System.out.println("pass: False!");
		}
				
	}
}