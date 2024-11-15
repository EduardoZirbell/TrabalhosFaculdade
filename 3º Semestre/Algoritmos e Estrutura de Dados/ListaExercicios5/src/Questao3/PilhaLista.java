package Questao3;

import Questao1.*;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada lista;

    public PilhaLista() {
        lista = new ListaEncadeada();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor;
        if (estaVazia()) {
            throw new PilhaVaziaException();
        } else {
            valor = peek();
            lista.retirar(valor);
        }
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada();
    }

    @Override
    public String toString() {
        String resultado = "";
        NoLista<T> atual = lista.getPrimeiro();

        while (atual != null) {
            if (atual != lista.getPrimeiro()) {
                resultado += ",";
            }

            resultado += atual.getInfo().toString();
            atual = atual.getProximo();
        }

        return resultado;
    }
}
