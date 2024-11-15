import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class MapaDispersaoTest {
    @Test
    public void validaInserirAluno() {
        Aluno aluno = new Aluno(123000, "Walter", LocalDate.of(2000, 1, 1));
        MapaDispersao mapaDispersao = new MapaDispersao<>(127);
        Aluno aluno2 = new Aluno(119849, "Walter", LocalDate.of(2000, 1, 1));
        mapaDispersao.inserir(123000, aluno);
        mapaDispersao.inserir(119849, aluno2);

        Assert.assertEquals(aluno, mapaDispersao.buscar(123000));
    }

    @Test
    public void validaInserirDiversosAlunos() {
        Aluno aluno1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno aluno3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno aluno4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        MapaDispersao mapaDispersao = new MapaDispersao<>(53);
        mapaDispersao.inserir(12000, aluno1);
        mapaDispersao.inserir(14000, aluno2);
        mapaDispersao.inserir(12500, aluno3);
        mapaDispersao.inserir(13000, aluno4);
        Assert.assertEquals(aluno1, mapaDispersao.buscar(12000));
        Assert.assertEquals(aluno2, mapaDispersao.buscar(14000));
        Assert.assertEquals(aluno3, mapaDispersao.buscar(12500));
        Assert.assertEquals(aluno4, mapaDispersao.buscar(13000));
    }

    @Test
    public void validaInserirBuscarAlunoCColisao() {
        Aluno aluno1 = new Aluno(12500, "Jean", LocalDate.of(2000, 1, 1));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno aluno3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno aluno4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));
        MapaDispersao mapaDispersao = new MapaDispersao<>(53);
        mapaDispersao.inserir(12500, aluno1);
        mapaDispersao.inserir(14000, aluno2);
        mapaDispersao.inserir(14226, aluno3);
        mapaDispersao.inserir(17180, aluno4);
        Assert.assertEquals(aluno1, mapaDispersao.buscar(12500));
        Assert.assertEquals(aluno2, mapaDispersao.buscar(14000));
        Assert.assertEquals(aluno3, mapaDispersao.buscar(14226));
        Assert.assertEquals(aluno4, mapaDispersao.buscar(17180));
    }
    @Test
    public void validaRealocarMapa(){
        Aluno aluno1 = new Aluno(12500, "Jean", LocalDate.of(2000, 1, 1));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno aluno3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno aluno4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));
        MapaDispersao mapaDispersao = new MapaDispersao<>(53);
        mapaDispersao.inserir(12500, aluno1);
        mapaDispersao.inserir(14000, aluno2);
        mapaDispersao.inserir(14226, aluno3);
        mapaDispersao.inserir(17180, aluno4);
        mapaDispersao.realocarMapa(5);
        Assert.assertEquals(aluno1, mapaDispersao.buscar(12500));
        Assert.assertEquals(aluno2, mapaDispersao.buscar(14000));
        Assert.assertEquals(aluno3, mapaDispersao.buscar(14226));
        Assert.assertEquals(aluno4, mapaDispersao.buscar(17180));
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