public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho){
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave){
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa noMapa = new NoMapa<T>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }

    public T buscar(int chave){
        int indice = calcularHash(chave);
        if(info[indice] != null){
            NoMapa noMapa = new NoMapa<T>();
            noMapa.setChave(chave);
            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if(no != null) {
                return no.getInfo().getInfo();
            }
        }
        return null;
    }

    public void remover(int chave){
        int indice = calcularHash(chave);

        if(info[indice] != null){
            NoMapa noMapa = new NoMapa<T>();
            noMapa.setChave(chave);
            info[indice].retirar(noMapa);
        }
    }
    public void realocarMapa(int novoTamanho) {
        ListaEncadeada<NoMapa<T>>[] antigo = info;
        info = new ListaEncadeada[novoTamanho];

        for (int i = 0; i < antigo.length; i++) {
            if (antigo[i] != null) {
                NoLista<NoMapa<T>> p = antigo[i].getPrimeiro();
                while (p != null) {
                    inserirElemento(p.getInfo());
                    p = p.getProximo();
                }
            }
        }
    }

    private void inserirElemento(NoMapa<T> no) {
        inserir(no.getChave(), no.getInfo());
    }
}
