package Sequencia;
public class Sequencia {
    public class Node {
        public Object value;
        Node next, prev;

        public Node(Object value){
            this.value = value;
        }
    }

    private Node headSentinela;
    private Node tailSentinela;
    private int size;


    public Sequencia(){
        this.size = 0;

        headSentinela = new Node(null);
        tailSentinela = new Node(null);
        headSentinela.next = tailSentinela;
        tailSentinela.prev = headSentinela;
    }

    public Object first() {
        if(size > 0){
            return headSentinela.next.value;
        } else {
            throw new RuntimeException("Lista esta vazia");
        }
    }


    public Object last() {
        if (size > 0){
            return tailSentinela.prev.value;
        } else {
            throw new RuntimeException("Lista esta vazia");
        }
    }


    public Node before(Node node) {
        if (node.prev == headSentinela) {
            throw new RuntimeException("Não existe nó antes");
        }
        return node.prev;
    }


    public Node after(Node node) {
        if (node.next == tailSentinela){
            throw new RuntimeException("Não existe nó depois");
        }
        return node.next;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isFirst(Node node) {
        return headSentinela.next == node;

    }

    public boolean isLast(Node node) {
        return  tailSentinela.prev == node;
    }

    public void replaceElement(Node node, Object o) {
        if (node == headSentinela || node == tailSentinela){
            throw new RuntimeException("Não é possivel alterar valor de nó sentinela");
        }
        node.value = o;
    }

    public void swapElements(Node node1, Node node2) {
        if ((node1 == headSentinela || node1 == tailSentinela) || (node2 == headSentinela || node2 == tailSentinela )){
            throw new RuntimeException("Não é possivel alterar valor de nó sentinela");
        }
        Object temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void insertBefore(Node node, Object o) {
        if (node == headSentinela){
            throw new RuntimeException("Não é possivel alterar valor de nó sentinela");
        }
        Node newNode = new Node(o);
        newNode.prev = node.prev;
        newNode.next = node;

        node.prev.next = newNode;
        node.prev = newNode;
        size++;
    }


    public void insertAfter(Node node, Object o) {
        if (node == tailSentinela){
            throw new RuntimeException("Não é possivel alterar valor de nó sentinela");
        }
        Node newNode = new Node(o);
        newNode.prev = node;
        newNode.next = node.next;

        node.next.prev = newNode;
        node.next = newNode;
        size++;
    }

    public void insertFirst(Object o) {
        Node newNode = new Node(o);
        newNode.prev = headSentinela;
        newNode.next = headSentinela.next;

        headSentinela.next.prev = newNode;
        headSentinela.next = newNode;
        size++;

    }

    public void insertLast(Object o) {
        Node newNode = new Node(o);
        newNode.prev = tailSentinela.prev;
        newNode.next = tailSentinela;

        tailSentinela.prev.next = newNode;
        tailSentinela.prev = newNode;
        size++;
    }

    public Object remove(Node node) {
        if (node == headSentinela || node == tailSentinela){
            throw new RuntimeException("Não é remover valor de nó sentinela");
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.value;
    }

    public Node atRank(int rank){
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Indice fora do limite");
        }

        Node current = headSentinela.next;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        return current;
    }

    public int rankOf(Node node){
        if (node == headSentinela || node == tailSentinela){
            throw new RuntimeException("Não é remover valor de nó sentinela");
        }
        int rank = 0;
        Node current = headSentinela.next;
        while (current != tailSentinela){
            if (current == node){
                return rank;
            }
            current = current.next;
            rank++;
        }
        throw new RuntimeException("Esse nó não faz parte da lista");
    }


    public Node elemAtRank(int rank) {
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank não ecncontrado");
        }

        Node current = headSentinela.next;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        return current;
    }


    public Object replaceAtRank(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank fora do limite ou não encontrado");
        }

        Node current = headSentinela.next;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        Object oldValue = current.value;
        current.value = o;
        return  oldValue;
    }


    public void insertAtRank(int rank, Object o) {

        if (rank < 0 || rank > size){
            throw new RuntimeException("Rank fora do limite ou não encontrado");
        }
        Node current;
        if (rank == size) {
            current = tailSentinela; // inserir no final
        } else {
            current = headSentinela.next; // inserir no meio
            for (int i = 0; i < rank; i++){
                current = current.next;
            }
        }

        Node newNode = new Node(o);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;

    }


    public Object removeAtRank(int rank) {
        if (isEmpty()){
            throw new RuntimeException("Sequencia vazia");
        }

        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank fora do indice");
        }

        Node nodeToRemove = headSentinela.next;
        for (int i = 0; i < rank; i++){
            nodeToRemove = nodeToRemove.next;
        }
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;

        size--;
        return nodeToRemove.value;
    }
}
