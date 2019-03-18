package prova2;

import java.util.HashMap;

public class Controller {

	int identificador;
	public HashMap<Integer, Encomenda> encomendas;
	public HashMap<Integer, Pacotao> pacotes;

	public Controller() {
		encomendas = new HashMap<>();
		pacotes = new HashMap<>();
		identificador = 100000000;
	}

	public int cadastraPac(int peso) {
		encomendas.put(identificador, new Pac(identificador, peso));

		identificador += 1;

		return identificador - 1;
	}

	public int cadastraSedex(int peso, int volume) {
		encomendas.put(identificador, new Sedex(identificador, peso, volume));

		identificador += 1;

		return identificador - 1;
	}

	public int cadastraCR(int folhas) {
		encomendas.put(identificador, new Cr(identificador, folhas));

		identificador += 1;

		return identificador - 1;
	}

	public String recuperaEncomenda(int codigo) {
		if (!encomendas.containsKey(codigo)) {
			throw new IllegalArgumentException(
					"Erro na recupecacao de encomenda: Codigo invalido ou não cadastrado");
		}
		return encomendas.get(codigo).toString();
	}

	public int recuperaCusto(int codigo) {
		if (!encomendas.containsKey(codigo)) {
			throw new IllegalArgumentException(
					"Erro na recupecacao do custo: Codigo invalido ou não cadastrado");
		}
		return encomendas.get(codigo).getCusto();
	}

	public int criaPacotao() {
		pacotes.put(identificador, new Pacotao());

		identificador += 1;

		return identificador - 1;
	}

	public void adicionaEncomenda(int pacotao, int encomenda) {
		if (!pacotes.containsKey(pacotao)) {
			throw new IllegalArgumentException(
					"Erro na adicao de encomendas: Pacotao invalida ou não cadastrada");
		}
		if (!encomendas.containsKey(encomenda)) {
			throw new IllegalArgumentException(
					"Erro na adicao de encomendas: Encomenda invalida ou não cadastrada");
		}

		pacotes.get(pacotao).adicionaEncomenda(encomendas.get(encomenda));
	}

	public int recuperaCustoPacotao(int pacotao) {
		if (!pacotes.containsKey(pacotao)) {
			throw new IllegalArgumentException(
					"Erro na recuperacao de custo do pacotao: Pacotao invalida ou não cadastrada");
		}

		return pacotes.get(pacotao).getCusto();
	}

}