public class ArvoreBinariaTest {

    public static void main(String[] args) {

        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, no4, no5);

        NoArvoreBinaria no7 = new NoArvoreBinaria(7);
        NoArvoreBinaria no6 = new NoArvoreBinaria(6, no7, null);

        NoArvoreBinaria no3 = new NoArvoreBinaria(3, null, no6);

        NoArvoreBinaria no1 = new NoArvoreBinaria(1, no2, no3);

        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.setRaiz(no1);

        System.out.println("A árvore possui: " + arvore.contarNos() + " nós.");
        System.out.println(arvore.toString());
    }
}