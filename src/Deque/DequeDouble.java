package Deque;

import Deque.Exeception.DequeVaziaExeception;

public class DequeDouble implements IDeque {

    private class Node {
        Object value;
        Node next, prev;

        Node(Object value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;


    @Override
    public void addFirst(Object o) {
        Node newNode = new Node(o);
        if (isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode ;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object o) {
        Node newNode = new Node(o);

        if (isEmpty()){
            tail = head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object first() {
        if (isEmpty()){
            throw new DequeVaziaExeception("O Deque está vazio");
        }
        return head.value;
    }

    @Override
    public Object last() {
        if (isEmpty()){
            throw new DequeVaziaExeception("O Deque está vazio");
        }
        return  tail.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
