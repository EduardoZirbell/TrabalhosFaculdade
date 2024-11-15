package listaexercicios4;

/**
 *
 * @author eduar
 */
public class Teste {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        
        lista.inserir(1);
        lista.inserir(2);
        
        lista.exibirOrdemInversa();
        
        lista.clonar().exibirOrdemInversa();
    }
}
