package Questao;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

	/**
	 * Adiciona um novo dado na lista
	 * @param dado Dado a ser adicionado na lista
	 */
	@Override
	public void inserir(T dado) {
		Object[] info = getInfo();

		// redimensionar caso faltar espa�o
		if (info.length == getTamanho()) {
			redimensionar();
		}
		
		// procura em que posi��o adicionar o dado 
		int posicao = procurarPosicaoInclusao(dado);
		
		if (posicao<getTamanho()) { // adicionar numa posi��o intermedi�ria
			deslocarDados(posicao);
		} 
		
		// armazena dado na posi��o localizada
		info = getInfo();
		info[posicao] = dado;

		// incrementa quantidade de dados armazenados
		setTamanho(getTamanho()+1);
	}
	
	
	/**
	 * Procura em que posi��o deve ser adicionado um dado
	 * @param itemAdicionar Dado a ser adicionado
	 * @return Posi��o do vetor onde ser� adicionado o elemento
	 */
	private int procurarPosicaoInclusao(T itemAdicionar) {
		Object[] info = getInfo();
		int i; // posi��o onde deve ser adicionado "dado"

		for (i=0; i<getTamanho(); i++) {
			// if (info[i] > itemAdicionar)
			if (((Comparable)info[i]).compareTo(itemAdicionar) > 0) {
				break;
			}
		}

		return i;
	}
	
	
	/**
	 * Desloca os elementos do vetor para a direita
	 * Desloca os elementos a partir da posi��o indicada
	 * @param posicao Posi��o inicial para efetuar o deslocamento
	 */
	private void deslocarDados(int posicao) {
		Object[] info = getInfo();
		for (int i=getTamanho()-1; i>=posicao; i--) {
			info[i+1] = info[i];
		}
	}

	/**
	 * Busca um dado na estrutura de dados utilizando
	 * o algoritmo de busca bin�ria
	 * @param valor a ser pesquisa
	 * @return Posi��o em que o dado foi localizado
	 */
	@Override
	public int buscar(T valor) {
		Object[] info = getInfo();
		
		int inicio = 0;
		int fim = getTamanho()-1;
		int meio;
		
		while (inicio <= fim) {
			meio = (inicio+fim)/2;
			
			int comparacao = valor.compareTo((T)info[meio]);
			if (comparacao < 0) { // se (valor < info[meio])
				fim = meio-1;
			} else {
				if (comparacao > 0) // se (valor > info[meio]
					inicio = meio+1;
				else
					return meio;
			}
		}
		
		return -1;
	}
	

}
