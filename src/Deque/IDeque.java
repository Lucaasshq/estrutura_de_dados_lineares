package Deque;

/**
 * @author Lucas Henrique
 * @description Deque usando Lista Simples encadeada
 * @matricula 20242014040042
 * @IFRN
 */
public interface IDeque {
    public void addFirst(Object o);
    public void addLast(Object o);
    public Object removeFirst();
    public Object removeLast();
    public Object first();
    public Object last();
    public int size();
    public boolean isEmpty();
}
