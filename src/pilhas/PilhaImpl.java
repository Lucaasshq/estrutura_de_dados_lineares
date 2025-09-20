package pilhas;

import pilhas.Exeception.PilhaVaziaExeception;

import java.util.ArrayDeque;
import java.util.Stack;

public class PilhaImpl implements Pilha {

    private int capacidade;
    private Object[] itens;
    private int t;
    private int FC;

    public PilhaImpl(int capacidade, int crescimento){
        this.capacidade = capacidade;
        this.t = -1;
        this.FC = crescimento;
        if (crescimento <= 0){
            this.FC = 0;
        }
        itens =  new Object[capacidade];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object top() throws PilhaVaziaExeception {
        return null;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() throws PilhaVaziaExeception {
        return null;
    }
}
