package Questao;

public class ListaEstatica<T> extends ListaAbstract<T> {


	public void inserir(T dado) {
		if (getTamanho() == getInfo().length) {
			redimensionar();
		}

		getInfo()[getTamanho()] = dado;
		setTamanho( getTamanho() + 1);
	}
	

	public int buscar(T dado) {
		for (int i=0; i<getTamanho(); i++) {
			if (getInfo()[i].equals(dado)) {
				return i;
			}
		}

		return -1;
	}
		
	
}
