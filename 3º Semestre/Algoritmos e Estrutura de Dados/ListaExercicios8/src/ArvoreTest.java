import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ArvoreTest {
    @Test
    public void testToString() {
        NoArvore raiz = new NoArvore<>(1);
        Arvore arvore = new Arvore();

        NoArvore no2 = new NoArvore<>(2);
        NoArvore no3 = new NoArvore<>(3);
        NoArvore no4 = new NoArvore<>(4);
        NoArvore no5 = new NoArvore<>(5);
        NoArvore no6 = new NoArvore<>(6);
        NoArvore no7 = new NoArvore<>(7);
        NoArvore no8 = new NoArvore<>(8);
        NoArvore no9 = new NoArvore<>(9);
        NoArvore no10 = new NoArvore<>(10);

        raiz.inserirFilho(no2);
        raiz.inserirFilho(no3);
        raiz.inserirFilho(no4);
        arvore.setRaiz(raiz);
        no2.inserirFilho(no5);
        no2.inserirFilho(no6);
        no2.inserirFilho(no7);
        no3.inserirFilho(no8);
        no4.inserirFilho(no9);
        no4.inserirFilho(no10);
        String esperado = "<1<2<5><6><7>><3<8>><4<9><10>>>";
        assertEquals(esperado, arvore.toString());
    }
    @Test
    public void testPertenceTrue() {
        NoArvore raiz = new NoArvore<>(1);
        Arvore arvore = new Arvore();

        NoArvore no2 = new NoArvore<>(2);
        NoArvore no3 = new NoArvore<>(3);
        NoArvore no4 = new NoArvore<>(4);
        NoArvore no5 = new NoArvore<>(5);
        NoArvore no6 = new NoArvore<>(6);
        NoArvore no7 = new NoArvore<>(7);
        NoArvore no8 = new NoArvore<>(8);
        NoArvore no9 = new NoArvore<>(9);
        NoArvore no10 = new NoArvore<>(10);

        raiz.inserirFilho(no2);
        raiz.inserirFilho(no3);
        raiz.inserirFilho(no4);
        arvore.setRaiz(raiz);
        no2.inserirFilho(no5);
        no2.inserirFilho(no6);
        no2.inserirFilho(no7);
        no3.inserirFilho(no8);
        no4.inserirFilho(no9);
        no4.inserirFilho(no10);
        assertTrue(arvore.pertence(7));
    }

    @Test
    public void testPertenceFalse() {
        NoArvore raiz = new NoArvore<>(1);
        Arvore arvore = new Arvore();

        NoArvore no2 = new NoArvore<>(2);
        NoArvore no3 = new NoArvore<>(3);
        NoArvore no4 = new NoArvore<>(4);
        NoArvore no5 = new NoArvore<>(5);
        NoArvore no6 = new NoArvore<>(6);
        NoArvore no7 = new NoArvore<>(7);
        NoArvore no8 = new NoArvore<>(8);
        NoArvore no9 = new NoArvore<>(9);
        NoArvore no10 = new NoArvore<>(10);

        raiz.inserirFilho(no2);
        raiz.inserirFilho(no3);
        raiz.inserirFilho(no4);
        arvore.setRaiz(raiz);
        no2.inserirFilho(no5);
        no2.inserirFilho(no6);
        no2.inserirFilho(no7);
        no3.inserirFilho(no8);
        no4.inserirFilho(no9);
        no4.inserirFilho(no10);
        assertFalse(arvore.pertence(55));
    }

    @Test
    public void testContarNos() {
        NoArvore raiz = new NoArvore<>(1);
        Arvore arvore = new Arvore();

        NoArvore no2 = new NoArvore<>(2);
        NoArvore no3 = new NoArvore<>(3);
        NoArvore no4 = new NoArvore<>(4);
        NoArvore no5 = new NoArvore<>(5);
        NoArvore no6 = new NoArvore<>(6);
        NoArvore no7 = new NoArvore<>(7);
        NoArvore no8 = new NoArvore<>(8);
        NoArvore no9 = new NoArvore<>(9);
        NoArvore no10 = new NoArvore<>(10);

        raiz.inserirFilho(no2);
        raiz.inserirFilho(no3);
        raiz.inserirFilho(no4);
        arvore.setRaiz(raiz);
        no2.inserirFilho(no5);
        no2.inserirFilho(no6);
        no2.inserirFilho(no7);
        no3.inserirFilho(no8);
        no4.inserirFilho(no9);
        no4.inserirFilho(no10);
        assertEquals(10, arvore.contarNos());
    }
}