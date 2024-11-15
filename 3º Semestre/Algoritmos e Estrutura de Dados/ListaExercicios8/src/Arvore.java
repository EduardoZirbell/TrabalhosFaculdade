public class Arvore<T> {
    private NoArvore raiz;
    public Arvore(){

    }
    public NoArvore getRaiz() {
        return raiz;
    }
    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    public boolean pertence(T info){
        if(raiz == null){
            return false;
        } else{
            return pertence(raiz, info);
        }
    }

    private boolean pertence(NoArvore no,T info){
        if(no.getInfo() == info){
            return true;
        } else{
            NoArvore percorrer;
            percorrer = no.getPrimeiro();
            while(percorrer != null){
                if(pertence(percorrer, info)){
                    return true;
                }
                percorrer = percorrer.getProximo();
            }
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore no) {
        if (no == null) {
            return 0;
        } else {
            int cont = 1;
            NoArvore filho = no.getPrimeiro();
            while(filho != null){
                cont += contarNos(filho);
                filho = filho.getProximo();
            }
            return cont;
        }
    }

    @Override
    public String toString() {
        if(raiz == null){
            return "";
        } else{
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore no){
        String str = "<";
        str = str + no.getInfo();

        NoArvore percorrer = no.getPrimeiro();
        while(percorrer != null){
            str = str + obterRepresentacaoTextual(percorrer);
            percorrer = percorrer.getProximo();
        }
        str = str + ">";
        return str;
    }
}
