public class NoArvore<T> {
    private T info;
    private NoArvore primeiro;
    private NoArvore proximo;
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoArvore getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(NoArvore primeiro) {
        this.primeiro = primeiro;
    }
    public NoArvore getProximo() {
        return proximo;
    }
    public void setProximo(NoArvore proximo) {
        this.proximo = proximo;
    }
    public NoArvore(T info){
        this.info = info;
        primeiro = null;
        proximo = null;
    }
    public void inserirFilho(NoArvore<T> filho){
        filho.proximo = primeiro;
        primeiro = filho;
    }
}
