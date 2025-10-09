package pilhas;
import pilhas.Exeception.PilhaVaziaExeception;
/**
 * @author Lucas Henrique
 * @description Pilha
 * @matricula 20242014040042
 * @IFRN
 */
public interface Pilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws PilhaVaziaExeception;
    public void push(Object o);
    public Object pop() throws PilhaVaziaExeception;
    public void print();
}
