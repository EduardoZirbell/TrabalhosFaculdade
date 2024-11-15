package exercicios.lista03;

public class ListaEncadeadaMemoryTest {

	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 100000; i++) {
            lista.inserir(i);
        }

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Memória usada pela lista encadeada: " + memoryUsed + " bytes");

	}

}
