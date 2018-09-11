/**
 * 
 * Classe que representa o gerenciamento de espaço nas contas dos alunos nos LCC'S
 * 
 * @author Almir Crispiniano - 117210914
 */
public class ContaLaboratorio {
	/**
	 * Nome do laboratório em String. Cota e espaço representados em inteiro 
	 * no formato de 0000 MB
	 */
	private String nomeLaboratorio;
	private int cota;
	private int espaco;
	
	/**
	 * Primeiro construtor que constrói uma conta no laboratorio a partir 
	 * do nome do mesmo e já possui a cota de 2000MB como parametro definido
	 * @param nomeLaboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}
	
	/**
	 * Segundo construtor com cota definida pelo usuário
	 * @param nomeLaboratorio em string
	 * @param cota no formatado 0000 MB
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Metodo que representa o consumo de espaço no laboratorio que é incrementado
	 * pelo parametro mbytes (inteiro)
	 * @param mbytes
	 */
	public void consomeEspaco(int mbytes) {
		this.espaco += mbytes;
	}
	
	/**
	 * Metodo que representa o a limpeza de espaço nas contas dos laboratorios
	 * @param mbytes
	 */
	public void liberaEspaco(int mbytes) {
		this.espaco -= mbytes;
	}
	
	/**
	 * Metodo que retorna um valor boleano verdadeiro 
	 * se o espaço ocupado ficar igual ou maior que a cota do laboratorio
	 * @return
	 */
	public boolean atingiuCota() {
		if (this.espaco >= this.cota) {
			return true;
		}return false;
	}
	
	/**
	 * Metodo que retorna uma String que representa a conta do aluno no laboratorio
	 * Utiliza o formato "nomeDolaboratorio espacoOcupado/cota"
	 */
	@Override
	public String toString() {
		return  nomeLaboratorio + " " + espaco + "/" + cota;
	}

}
