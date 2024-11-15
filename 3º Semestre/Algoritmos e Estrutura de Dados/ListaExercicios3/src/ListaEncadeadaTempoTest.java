package exercicios.lista03;

public class ListaEncadeadaTempoTest {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

		for (int i = 0; i < 100000; i++) {
			lista.inserir(i);
		}

		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos
		System.out.println("Tempo total para lista encadeada: " + duration + "ms");
	}

}
