public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	@Override
	public void ordenar() {
		mergeSort(0, getInfo().length-1);
	}

	private void mergeSort(int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(inicio, meio);
			mergeSort(meio+1, fim);
			merge(inicio, fim, meio);
		}
	}

	private void merge(int inicio, int fim, int meio) {
		T[] info = getInfo();
		
		// Faz a divisão dos vetores.
		int tamEsquerda = meio-inicio+1;
		T[] esquerda = (T[]) new Comparable[tamEsquerda];
		for (int i=0; i<=tamEsquerda-1; i++) {
			esquerda[i] = info[inicio+i];
		}
		
		int tamDireita = fim-meio;
		T[] direita = (T[]) new Comparable[tamDireita];
		for (int i=0; i<=tamDireita-1; i++) {
			direita[i] = info[meio+1+i];
		}
		
		int cEsq=0;
		int cDir=0;
		
		// Inicia o merge
		int i;
		for (i=inicio; i<=fim; i++) {
			if ((cEsq < tamEsquerda) && (cDir < tamDireita)) {
				// Se esquerda menor que direita, copia primeiro os valores da esquerda
				if (esquerda[cEsq].compareTo(direita[cDir]) < 0) { 
					info[i] = esquerda[cEsq];
					cEsq++;
				} else {
					// Se direita menor que esquerda, copia primeiro os valores da direita
					info[i] = direita[cDir];
					cDir++;
				}
			} else
				break;
		}

		// Copia os valores que sobraram na esquerda.
		copiarValorSobra(i, info, esquerda, cEsq);

		// Copia os valores que sobraram na direita.
		copiarValorSobra(i, info, direita, cDir);
	}

	private void copiarValorSobra(int i, T[] info, T[] subvetor, int posCopiar) {
		while (posCopiar < subvetor.length) {
			info[i] = subvetor[posCopiar];
			posCopiar++;
			i++;
		}
	}

}
