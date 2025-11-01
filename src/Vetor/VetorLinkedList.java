package Vetor;

import Vetor.Exeception.RankNotFoundExeception;
import Vetor.Exeception.VetorCheioExeception;

public class VetorLinkedList implements IVetor {

    class Node {
        Object value;
        Node next, prev;

        Node(Object value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private int capacidade;

    public VetorLinkedList(int caoacidade){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacidade = 0;
    }

    @Override
    public Node elemAtRank(int rank) {
        if (rank < 0 || rank >= size){
            throw new RankNotFoundExeception("Rank não ecncontrado");
        }

        Node current = head;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public Object replaceArRank(int rank, Object o) {
        return null;
    }

    @Override
    public void insertAtRank(int rank, Object o) {

        if (rank < 0 || rank > size){
            throw new RankNotFoundExeception("Rank fora do limite ou não encontrado");
        }

        if (size == capacidade){
            throw new VetorCheioExeception("Vetor está cheio.");
        }
        Node newNode = new Node(o);
        // Lista vazia
        if (isEmpty()){
            head = tail = newNode;

            // Inseri no inicio
        } else if (rank == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            // insere no final
        } else if (rank == size()) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else {
            Node currentNode = elemAtRank(rank);
            Node prevNode = currentNode.prev;

            newNode.prev = prevNode;
            newNode.next = currentNode;

            prevNode.next = newNode;
            currentNode.prev = newNode;
        }
        size++;

    }

    @Override
    public Object removeAtRank(int rank) {
        return null;
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
