public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	@Override
	public void ordenar() {
		T[] info = getInfo();
		int i;
		int j;
		int n = info.length;

		// Percorre o vetor
		for (i=n-1; i>=1; i--) {
			boolean trocou = false;
			for (j=0; j<=i-1; j++) {
				// Verifica se o vetor[j] é maior que o vetor[j+1]
 				if (info[j].compareTo(info[j+1])>0) {
 					// caso verdadeiro, realiza a troca.
 					trocar(j,j+1);
					trocou = true;
				}
			}
			// Se não realizar nenhuma troca no for interno.
			// Significa que o vertor já está ordenado
			// Então para a execução do for externo.
			if (!trocou) {
				break;
			}
		}		
	}

	
}
