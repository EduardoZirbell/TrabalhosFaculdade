import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenarTest {


    @Test
    private void testar(OrdenacaoAbstract<Integer> ordenacao) {
        Integer[] dados = new Integer[] {15,40,56,90,12,30,45};
        ordenacao.setInfo(dados);
        ordenacao.ordenar();

        for (int i = 0; i<dados.length; i++ ) {
            System.out.println(dados[i]);
        }
    }

    @Test
    public void testBolha() {
        OrdenacaoAbstract<Integer> ordenacao = new OrdenacaoBolha<>();
        testar(ordenacao);
    }

    @Test
    public void testBolhaOtimizado() {
        OrdenacaoAbstract<Integer> ordenacao = new OrdenacaoBolhaOtimizada<>();
        testar(ordenacao);
    }


    @Test
    public void testQuickSort() {
        OrdenacaoAbstract<Integer> ordenacao = new OrdenacaoQuickSort<>();
        testar(ordenacao);
    }

    @Test
    public void testMergeSort() {
        OrdenacaoAbstract<Integer> ordenacao = new OrdenacaoMergeSort<>();
        testar(ordenacao);
    }

}






























//1,17,20,33,43,75,80,88,92,95,98
//Ao aplicar o algoritmo de busca binária, quantas posições do vetor
//são lidas para buscar o valor 75?

/*Resposta: 1*/

//Ao executar o algoritmo de ordenação bolha, para ordE
//os dados de um vetor constituído dos valores
//17,94,22,-5,18 e 1 (nesta ordem), qual é a composição
//deste vetor, após executar a segunda passagem?
//Informe os valores separando-os por vírgula e sem
//espaços.

/*Resposta: 17,-5,18,1,22,94*/

//O número de matrícula é a chave de busca destes objetos
//no mapa de dispersão.
//Considere que o vetor encapsulado tenha 449 posições.
//Dos números de matrícula abaixo, qual deles colidiria com
//a chave 147.049?
//123449
//852147
//963258
//845693
//112253

/*Resposta: 123449*/

//Logo em seguida foi invocado metodo inserir(35). A
//fim de manter a árvore binária com a propriedade se ser
//uma "árvore binária de busca", pode-se afirmar que este
//novo nó será inserido como filho à

/*Resposta: direita de 35 */

//1,20,28,30,40,45,55,62,66,75,98
//Ao aplicar o algoritmo de busca linear, quantas posições do vetor
//são lidas ao executar o método buscar(5)?
//Lembre-se que o algoritmo de busca linear não tem nenhum pré-
//requisito quanto à composição dos dados.

/*Resposta: 11*/

//O número de matrícula é a chave de busca destes objetos no mapa de
//dispersão.
//Considere que o vetor encapsulado tenha 401 posições.
//Dos números de matrícula abaixo, qual deles colidiria com a chave
//623.000?
//235453
//552323
//125478
//265896
//415329

/*Resposta: 415329*/


//Considere o vetor abaixo.
//1 7 20 28 33 43 55 62 66 75 98
//0 1 2 3 4 5 6 7 8 9 10
//Ao aplicar o algoritmo de busca binária, quantas posições do vetor são lidas
//para buscar o valor 75?