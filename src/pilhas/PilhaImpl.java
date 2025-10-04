package pilhas;
import pilhas.Exeception.PilhaVaziaExeception;

import java.util.Arrays;

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
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public Object top() throws PilhaVaziaExeception {
        if (isEmpty()){
            throw new PilhaVaziaExeception("A pilhas.PilhaRubroNegro está vazia");
        }
        return itens[t];
    }

    @Override
    public void push(Object o) {
        if (t >= capacidade-1){
            if (FC==0){
                capacidade *= 2;
            } else {
                capacidade+= FC;
            }
            Object[] copia = new Object[capacidade];
            for (int i = 0; i < itens.length; i++){
                copia[i] = itens[i];
            }
            itens = copia;
        }
        itens[++t] = o;
    }

    @Override
    public Object pop() throws PilhaVaziaExeception {
        if (isEmpty()){
            throw new PilhaVaziaExeception("A pilhas.PilhaRubroNegro está vazia");
        }
        return itens[t--];
    }

    public void print(){
        System.out.println(Arrays.toString(itens));;
    }

}
