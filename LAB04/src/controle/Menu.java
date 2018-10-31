package controle;

import java.util.Scanner;

/**
 * Classe principal
 * 
 * @author Almir Crispiniano - 117210914
 *
 */
public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sistema s1 = new Sistema();

		try {
			while (true) {
				System.out.println("(C)adastrar Aluno");
				System.out.println("(E)xibir Aluno");
				System.out.println("(N)ovo Grupo");
				System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
				System.out.println("(R)egistrar Aluno que Respondeu");
				System.out.println("(I)mprimir Alunos que Responderam");
				System.out.println("(O)ra, vamos fechar o programa!\n");
				System.out.println("Opção> ");
				String opcao = sc.nextLine();

				if (opcao.equalsIgnoreCase("C")) {
					System.out.println("Matricula: ");
					String matricula = sc.nextLine();
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Curso: ");
					String curso = sc.nextLine();
					Aluno aluno = new Aluno(matricula, nome, curso);

					if (s1.validaMatricula(matricula)) {
						if (s1.existenciaAluno(matricula)) {
							System.out.println("MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator());
						} else {
							s1.cadastraAluno(matricula, aluno);
							System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
						}
					} else {
						System.out.println("MATRÍCULA INVÁLIDA!" + System.lineSeparator());
					}

				} else if (opcao.equalsIgnoreCase("E")) {
					System.out.println("Matricula: ");
					String matricula = sc.nextLine();
					if (s1.existenciaAluno(matricula)) {
						System.out.println(s1.consultaAluno(matricula));
					} else {
						System.out.println("Aluno não cadastrado." + System.lineSeparator());
					}

				} else if (opcao.equalsIgnoreCase("N")) {
					System.out.println("Grupo: ");
					String nome = sc.nextLine();
					if (s1.exitenciaGrupo(nome)) {
						System.out.println("GRUPO JÁ CADASTRADO!" + System.lineSeparator());
					} else {
						Grupo grupo = new Grupo(nome);
						s1.cadastraGrupo(nome.toLowerCase(), grupo);
						System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
					}

				} else if (opcao.equalsIgnoreCase("A")) {
					System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
					String op = sc.nextLine();
					if (op.equalsIgnoreCase("A")) {
						System.out.println("Matricula: ");
						String matricula = sc.nextLine();
						System.out.println("Grupo: ");
						String nome = sc.nextLine();
						if (s1.existenciaAluno(matricula)) {
							if (s1.exitenciaGrupo(nome)) {
								s1.alocarAluno(matricula, nome.toLowerCase());
								System.out.println("ALUNO ALOCADO!" + System.lineSeparator());
							} else {
								System.out.println("Grupo não cadastrado." + System.lineSeparator());
							}
						} else {
							System.out.println("Aluno não cadastrado." + System.lineSeparator());
							if (!s1.exitenciaGrupo(nome)) {
								System.out.println("Grupo não cadastrado." + System.lineSeparator());
							}
						}
					} else if (op.equalsIgnoreCase("I")) {
						System.out.println("Grupo: ");
						String nomeGrupo = sc.nextLine();
						if (s1.exitenciaGrupo(nomeGrupo.toLowerCase())) {
							System.out.println(s1.imprimirGrupo(nomeGrupo.toLowerCase()));
						} else {
							System.out.println("Grupo não cadastrado." + System.lineSeparator());
						}
					}

				} else if (opcao.equalsIgnoreCase("R")) {
					System.out.println("Matricula:" + System.lineSeparator());
					String matricula = sc.nextLine();
					if (s1.validaMatricula(matricula)) {
						s1.adicionaAlunoQueRespondeu(matricula);
						System.out.println("ALUNO REGISTRADO!" + System.lineSeparator());
					} else {
						System.out.println("Aluno não cadastrado." + System.lineSeparator());
					}

				} else if (opcao.equalsIgnoreCase("I")) {
					System.out.println(s1.listaAlunosQueResponderam());

				} else if (opcao.equalsIgnoreCase("O")) {
					break;
				} else {
					System.out.println("Opcao invalida");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
