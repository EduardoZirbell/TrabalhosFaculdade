package algoritmo.aula1;

public class App {

    public static void main(String[] args) {
        ListaEstatica listaEstatica = new ListaEstatica();

        listaEstatica.inserir(7);
        listaEstatica.inserir(30);
        listaEstatica.inserir(4);
        listaEstatica.inserir(53);
        listaEstatica.inserir(6);
        listaEstatica.inserir(9);
        listaEstatica.inserir(25);
        listaEstatica.inserir(42);
        listaEstatica.inserir(14);
        listaEstatica.inserir(76);
        listaEstatica.inserir(1);
        listaEstatica.inserir(88);

        int indiceEncontrado = listaEstatica.buscar(1);
        System.out.println("O indice encontrado foi: " + indiceEncontrado);

        listaEstatica.retirar(76);

        int indiceNaoEncontrado = listaEstatica.buscar(76);
        System.out.println("O indice encontrado foi: " + indiceNaoEncontrado);
    }
}
