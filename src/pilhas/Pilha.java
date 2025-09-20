package pilhas;

import pilhas.Exeception.PilhaVaziaExeception;

public interface Pilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws PilhaVaziaExeception;
    public void push(Object o);
    public Object pop() throws PilhaVaziaExeception;
    public void print();
}
