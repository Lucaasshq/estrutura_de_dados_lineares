package Deque;

public interface IQueue {
    public void enqueue(Object o);
    public Object dequeue();
    public Object first();
    public int size();
    public boolean isEmpty();


}
