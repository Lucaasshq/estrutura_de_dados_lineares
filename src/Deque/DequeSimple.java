package Deque;

import Deque.Exeception.DequeVaziaExeception;

/**
 * @author Lucas Henrique
 * @description Deque usando Lista Simples encadeada
 * @matricula 20242014040042
 * @IFRN
 */

public class DequeSimple implements IDeque {

    public class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // O(1)
    @Override
    public void addFirst(Object o) {
        Node newNode = new Node(o);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // O(1)
    @Override
    public void addLast(Object o) {
        Node newNode = new Node(o);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // O(1)
    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new DequeVaziaExeception("Fila esta vazia");
        }
        Object valor = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return valor;
    }

    // O(n)
    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new DequeVaziaExeception("Fila esta vazia");
        }
        Object valor = tail.value;
        if (size == 1) {
            head = tail = null;

            Node atual = head;
            while (atual.next != tail) {
                atual = atual.next;
            }
            atual.next = null;
            tail = atual;
        }
        size--;
        return valor;
    }

    // O(1)
    @Override
    public Object first() {
        if (isEmpty()) {
            throw new DequeVaziaExeception("Deque esta vazia");
        }
        return head.value;
    }

    // O(1)
    @Override
    public Object last() {
        if (isEmpty()) {
            throw new DequeVaziaExeception("Deque esta vazia");
        }
        return tail.value;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return (head == null);
    }
}
