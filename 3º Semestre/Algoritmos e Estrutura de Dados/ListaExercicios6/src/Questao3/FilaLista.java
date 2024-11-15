package Questao3;

import Questao3.FilaCheiaException;
import Questao3.FilaVaziaException;

public class FilaLista<T> implements Fila<T>{
    private ListaEncadeada lista;
    public FilaLista(){
        this.lista = new ListaEncadeada<T>();
    }
    @Override
    public void inserir(T valor) {
        this.lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public T peek() {
        if(this.lista.estaVazia()){
            throw new FilaVaziaException();
        }
        return (T) this.lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor;
        if (estaVazia()) {
            throw new Questao1.FilaVaziaException();
        } else {
            valor = peek();
            lista.retirar(valor);
        }
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
