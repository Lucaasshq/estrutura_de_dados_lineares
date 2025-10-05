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
    /**
     O(1)
      **/
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
    /**
     O(1)
     **/
    @Override
    public void addLast(Object o) {
        Node newNode = new Node(o);

        if (isEmpty()){
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    /**
     O(1)
     **/
    @Override
    public Object removeFirst() {
        if (isEmpty()){
            throw new DequeVaziaExeception("Deque vazio");
        }
        Object value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return value;
    }
    /**
     O(1)
     **/
    @Override
    public Object removeLast() {
        if (isEmpty()){
            throw new DequeVaziaExeception("Deque vazio");
        }
        Object value = tail.value;
        tail = tail.prev;
        if (tail == null){
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return value;
    }
    /**
     O(1)
     **/
    @Override
    public Object first() {
        if (isEmpty()){
            throw new DequeVaziaExeception("O Deque está vazio");
        }
        return head.value;
    }
    /**
     O(1)
     **/
    @Override
    public Object last() {
        if (isEmpty()){
            throw new DequeVaziaExeception("O Deque está vazio");
        }
        return  tail.value;
    }
    /**
     O(1)
     **/
    @Override
    public int size() {
        return size;
    }
    /**
     O(1)
     **/
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
