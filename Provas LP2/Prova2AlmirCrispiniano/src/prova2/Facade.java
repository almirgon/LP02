package prova2;

public class Facade {

	Controller controller;

	public Facade() {
		controller = new Controller();
	}

	public int cadastraPac(int peso) {
		return controller.cadastraPac(peso);
	}

	public int cadastraSedex(int peso, int volume) {
		return controller.cadastraSedex(peso, volume);
	}

	public int cadastraCR(int folhas) {
		return controller.cadastraCR(folhas);
	}

	public String recuperaEncomenda(int codigo) {
		return controller.recuperaEncomenda(codigo);
	}

	public int recuperaCusto(int codigo) {
		return controller.recuperaCusto(codigo);
	}

	public int criaPacotao() {
		return controller.criaPacotao();
	}

	public void adicionaEncomenda(int pacotao, int encomenda) {
		controller.adicionaEncomenda(pacotao, encomenda);
	}

	public int recuperaCustoPacotao(int pacotao) {
		return controller.recuperaCustoPacotao(pacotao);
	}

}