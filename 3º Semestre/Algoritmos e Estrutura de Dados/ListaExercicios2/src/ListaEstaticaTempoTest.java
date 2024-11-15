package exercicios.lista02;

public class ListaEstaticaTempoTest {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<>();

        for (int i = 0; i < 100000; i++) {
            lista.inserir(i);
        }

        long endTime = System.nanoTime();
        // Tempo em milissegundos
        long duration = (endTime - startTime) / 1000000; 
        System.out.println("Tempo total para lista estática: " + duration + "ms");
	}

}
