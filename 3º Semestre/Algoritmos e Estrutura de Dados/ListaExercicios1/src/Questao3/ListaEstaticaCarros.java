package Questao3;

public class ListaEstaticaCarros {
	private Carro[] info;
	private int tamanho;
	
	public ListaEstaticaCarros() {
		info = new Carro[10];
		tamanho = 0;
	}
	
	private void redimensionar() {
		Carro[] novoInfo = new Carro[info.length + 10];

        for (int i = 0; i < info.length; i++) {
            novoInfo[i] = info[i];
        }

        info = novoInfo;
	}
	
	public void inserir(Carro carro) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = carro;
        tamanho++;
    }
	
	public void exibir() {
		for (int i = 0; i < tamanho; i++) {
			Carro carro = info[i];
			System.out.println("[" + i + "]: " + carro);
		}
    }
	
	public int buscar(String placa) {
        for (int i = 0; i < tamanho; i++) {
            if (placa == info[i].getPlaca()) {
                return i;
            }
        }
        return -1;
    }
	
	public void retirar(String placa) {
        int posicao = buscar(placa);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

	public void liberar() {
        info = new Carro[10];
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Carro obterElemento(int posicao) {
        if(posicao >= 0 && posicao < tamanho){
        	return info[posicao];
        }
        throw new IndexOutOfBoundsException();
    }
    
    public boolean estaVazia(){
        if(tamanho > 0){
            return false;
        } else{
            return true;
        }
    }
    
    @Override
	public String toString() {
		String resultado = "";
		for (int i = 0; i < tamanho; i++) {
			if (i > 0) {
				resultado += ", ";
			}
			Carro carro = info[i];
			resultado += carro.toString();
		}		
		return resultado;
	}
}
