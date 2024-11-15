package exercicios.lista02;

public class ListaEstaticaMemoryTest {

	public static void main(String[] args) {
		ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<>();

        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 100000; i++) {
            lista.inserir(i);
        }

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Memória usada pela lista estática: " + memoryUsed + " bytes");
	}

}
