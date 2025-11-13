package Vetor;

import Vetor.Exeception.RankNotFoundExeception;
import Vetor.Exeception.VetorCheioExeception;

public class VetorLinkedList implements IVetor {

    class Node {
        Object value;
        Node next, prev;

        Node(Object value){
            this.value = value;
        }
    }

    private final Node headSentinela;
    private final Node tailSentinela;
    private int size;

    public VetorLinkedList(int capacidade){
        this.size = 0;

        headSentinela = new Node(null);
        tailSentinela = new Node(null);
        headSentinela.next = tailSentinela;
        tailSentinela.prev = headSentinela;
    }

    @Override
    public Node elemAtRank(int rank) {
        if (rank < 0 || rank >= size){
            throw new RankNotFoundExeception("Rank não ecncontrado");
        }

        Node current = headSentinela.next;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public Object replaceArRank(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RankNotFoundExeception("Rank fora do limite ou não encontrado");
        }

        Node current = elemAtRank(rank);
        Object oldValue = current.value;
        current.value = o;
        return  oldValue;
    }

    @Override
    public void insertAtRank(int rank, Object o) {

        if (rank < 0 || rank > size){
            throw new RankNotFoundExeception("Rank fora do limite ou não encontrado");
        }
        Node current;
        if (rank == size) {
            current = tailSentinela; // inserir no final
        } else {
            current = elemAtRank(rank); // inserir no meio
        }

        Node newNode = new Node(o);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;

    }

    @Override
    public Object removeAtRank(int rank) {
        Node nodeToRemove = elemAtRank(rank);
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;

        size--;
        return nodeToRemove.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void printVetorLinked(){
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = headSentinela.next;

        while (current != tailSentinela) {
            sb.append(current.value);
            if (current.next != tailSentinela) {
                sb.append(", ");
            }
            current = current.next;  
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
