package Questao;

public abstract class ListaAbstract<T> {
	
	private T[] info;
	private int tamanho;

	public ListaAbstract() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}

	public boolean estaVazia() {
		return tamanho==0;
	}


	public int getTamanho() {
		return tamanho;
	}
	
	
	protected void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	

	protected void redimensionar() {
		T[] novo = (T[]) new Object[tamanho+10];
		for (int i=0; i<tamanho; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}
	

	public abstract void inserir(T dado);
	

	public void exibir() {
		for (int i=0; i<tamanho; i++)
			System.out.println(info[i]);
	}

	public abstract int buscar(T dado);


	public void retirar(T dado) {
		int posicao = buscar(dado);
		if (posicao > -1) {
			for (int i=posicao; i<tamanho-1; i++) {
				info[i] = info[i+1];
			}
			
			// limpa ultima posi��o
			info[tamanho-1] = null;
			tamanho--;
		}
	}
	

	public void liberar() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	

	public T obterElemento(int pos) {
		if (pos >= 0 && (pos < tamanho)) {
			return info[pos];
		} else {
			throw new IndexOutOfBoundsException("Posi��o inv�lida");
		}
	}
	

	@Override
	public String toString() {
		String resultado = "";
		
		for (int i=0; i<tamanho; i++) {
			if (i > 0)
				resultado += ",";
			resultado += info[i]; 
		}
		
		return resultado;
	}

	protected T[] getInfo() {
		return info;
	}


	/*


















	 */

	
	/**
	 * Avalia se o objeto corrente e outro objeto
	 * s�o iguais	 
	 * @param objeto outro objeto a ser comparado
	 * @return true se os objetos s�o iguais 
	 */
	@Override
	public boolean equals(Object objeto) {
		if (objeto == null)
			return false;
		if (objeto == this)
			return true;
		if (this.getClass() != objeto.getClass())
			return false;
		
		ListaAbstract outraLista = (ListaAbstract) objeto;
		
		if (this.getTamanho() != outraLista.getTamanho())
			return false;
		
		for (int i=0; i<this.getTamanho(); i++) {
			if (!this.info[i].equals(outraLista.info[i]))
				return false;
		}
		
		return true;
	}

}
