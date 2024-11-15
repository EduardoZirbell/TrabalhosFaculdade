package exercicios.lista02;

public class ListaEstaticaGenerica<ClasseParametrizada> {
	
	private ClasseParametrizada[] info;
	private int tamanho;
	
	/**
	 * Construtor padrão: Cria o vetor para armazenar os dados 
	 * e estabelece que a lista está vazia
	 */
	public ListaEstaticaGenerica() {
		info = (ClasseParametrizada[]) new Object[10];
		tamanho = 0;
	}
	
	/**
	 * Redimensiona a capacidade do vetor.
	 */
	private void redimensionar() {
		// Cria um novo vetor com o tamanho do vetor atual + 10 posições.
		ClasseParametrizada[] novoInfo = (ClasseParametrizada[]) new Object[info.length + 10];
		// Percorre o vetor atual.
		for (int indice = 0; indice < info.length; indice++) {
			// Copia o valor do indice do vetor atual, para o novo vetor na mesma posição
			novoInfo[indice] = info[indice];
		}
		// Atualiza a variável info, para o novo vetor com maior capacidade.
		info = novoInfo;
	}
	
	/**
	 * Insere um elemento na lista.
	 * @param valor - o elemento que será inserido.
	 */
	public void inserir(ClasseParametrizada valor) {
		// Verifica se o vetor atual ainda tem posições disponíveis.
		if (tamanho == info.length) {
			// Caso o vetor já estiver cheio, realiza o redimensionamento.
			redimensionar();
		}
		// Insere o elemento na próxima posição disponível.
		info[tamanho] = valor;
		// Incrementa a variável de controle do tamanho do vetor.
		tamanho++;
	}
	
	/**
	 * Exibe as posições preenchidas do vetor e seus respectivos valores.
	 */
	public void exibir() {
		// Percorre o vetor.
		for (int indice = 0; indice < tamanho; indice++) {
			// Obtém o valor do indice.
			ClasseParametrizada valor = info[indice];
			// Imprime o valor no console.
			System.out.println("[" + indice + "]: " + valor);
		}
	}
	
	/**
	 * Busca por um valor na lista, se encontrar retorna o indice do mesmo no vetor.
	 * Caso não encontre, retornará -1.
	 * @param valor - o elemento que será pesquisado.
	 * @return um int que representa o indice do elemento no vetor.
	 */
	public int buscar(ClasseParametrizada valor) {
		// Percorre o vetor.
		for (int indice = 0; indice < tamanho; indice++) {
			// Obtém o valor do indice.
			ClasseParametrizada valorLista = info[indice];
			// Verifica se o valor é igual ao valor informado.
			if (valorLista.equals(valor)) {
				// Caso encontar o valor, retorna o indice do mesmo.
				return indice;
			}
		}
		// Se não encontrou nenhum elemento igual, retorna -1.
		return -1;
	}
	
	/**
	 * Remove um elemento da lista. 
	 * @param valor - o elemento que será removido.
	 */
	public void retirar(ClasseParametrizada valor) {
		// Busca indice do elemento que deverá ser removido.
		int indice = buscar(valor);
		// Se encontar, realiza a remoção.
		if (indice > -1) {
			// Percorre o vetor a partir do indice do elemento que deve ser removido.
			for (int indiceFor = indice; indiceFor < tamanho - 1; indiceFor++) {
				// Move todos os valores para a esquerda
				info[indiceFor] = info[indiceFor + 1];
			}
		}
		// Decrementa a variável de tamanho da lista.
		tamanho--;
	}
	
	/**
	 * Realiza a liberação da lista.
	 */
	public void liberar() {
		// Cria um novo vetor e atribui para a variável info.
		info = (ClasseParametrizada[]) new Object[10];
		// Atualiza a variável de controle do tamanho da lista para zero elementos.
		tamanho = 0;
	}
	
	/**
	 * Retorna o elemento baseado no indice do vetor.
	 * @param posicao - o indice que será utilizado para encontrar o elemento.
	 * @return o elemento da posição informada se existir a posição na lista, caso contrário irá lançar uma exceção.
	 */
	public ClasseParametrizada obterElemento(int posicao) {
		// Verifica se a posição informada é maior que zero e menor que o tamanho da lista.
		if (posicao >= 0 && (posicao < tamanho)) {
			// Se a posição estiver contida na lista, retorna o elemento.
			return info[posicao];
		}
		// Caso contrário lança a exceção.
		throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Retorna se a lista está vazia.
	 * @return um valor verdadeiro se a lista estiver vazia, e um valor falso caso a lista possua algum elemento.
	 */
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	/**
	 * Retorna o tamanho da lista
	 * @return um inteiro com a quantidade de elementos da lista.
	 */
	public int getTamanho() {
		return tamanho;
	}
	
	@Override
	public String toString() {
		String resultado = "";
		// Percorre o vetor.
		for (int indice = 0; indice < tamanho; indice++) {
			// Verifica se é o primeiro elemento.
			if (indice > 0) {
				// Se não for o primeiro elemento, adiciona uma ",".
				resultado += ", ";
			}
			// Obtém o valor do índice.
			ClasseParametrizada valor = info[indice];
			// Concatena na variável de resultado.
			resultado += valor.toString();
		}
		// Retorna o resultado, com todos os elementos separados por ",".
		return resultado;
	}

	public void inverter() {
		
		// Inicia a varável esquerda com 0
		int esquerda = 0;
		// Inicia a variável direita com o último indice do vetor.
		int direita = tamanho - 1;
		
		// enquanto a variávelel esquerda for menor que a direita, vai executar
		while (esquerda < direita) {
			// Copia o valor do indice da esquerda para uma variável temporária.
			ClasseParametrizada temp = info[esquerda];
			// Copia o valor do indice da direita para o indice da esquerda.
			info[esquerda] = info[direita];
			// Atribui o valor da variável temporária para o indice da posição da direita.
			info[direita] = temp;

			// Incrementa a variável da esquerda.
			esquerda++;
			// Decrementa a variável da direita.
			direita--;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}
