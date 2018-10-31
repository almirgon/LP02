package celular;
import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab03
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Menu {
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air");
			System.out.println("");
			System.out.println("Opção> ");
			String opcao = sc.nextLine();
			
			if (opcao.equals("C")) {
				System.out.println("Posição: ");
				int posicao = sc.nextInt();
				sc.nextLine();
				if(!agenda.verificaExistencia(posicao)) {
					System.out.println("POSIÇÃO INVALIDA!");
				}else {
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Sobrenome: ");
					String sobrenome = sc.nextLine();
					System.out.println("Telefone: ");
					String telefone = sc.nextLine();
					agenda.cadastraContato(nome, sobrenome, telefone, posicao);
					System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
;				}
				
			}else if (opcao.equals("L")) {
				System.out.println(agenda.listarContato());
				
			}else if (opcao.equals("E")) {
				System.out.println("Contato> ");
				int posicao = sc.nextInt();
				if (agenda.verificaExistencia(posicao)) {
					System.out.println(agenda.exibirContato(posicao));
				}else {
					System.out.println("POSIÇÃO INVÁLIDA!");
				}
				
			}else if (opcao.equals("S")) {
				break;
				
			}else {
				System.out.println("OPÇÃO INVÁLIDA\n");
			}
		}
	}
	
}