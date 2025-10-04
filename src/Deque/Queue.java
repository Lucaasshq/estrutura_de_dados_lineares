package Deque;

import Deque.Exeception.QueueVaziaExeception;

class Node {
    private Object value;
    private Node next;


    public Object getValue() {
        return value;
    }

    public void setValue(Object o) {
        value = o;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


public class Queue implements IQueue {
    private Node i = null;
    private Node f = null;
    private int size = 0;


    @Override
    public void enqueue(Object o) {
        Node newNode = new Node();
        newNode.setValue(o);
        newNode.setNext(null);
        if (i == null){
            i = newNode;
            f = newNode;
        } else {
            f.setNext(newNode);
            f = newNode;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new QueueVaziaExeception("Fila esta vazia");
        }
        Object valor = i.getValue();
        i = i.getNext();
        if (i == null) {
            f = null;
        }
        size--;
        return valor;
    }

    @Override
    public Object first() {
        if (isEmpty()){
            throw new QueueVaziaExeception("Fila esta vazia");
        }
        return i.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (i == null);
    }
}
