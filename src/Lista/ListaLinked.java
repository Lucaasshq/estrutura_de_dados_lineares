package Lista;

public class ListaLinked implements ILista {
    private class Node {
        Object value;
        Node next, prev;

        public Node(Object value){
            this.value = value;
        }
    }

    private Node headSentinela;
    private Node tailSentinela;
    private int size;

    public ListaLinked(){
        this.size = 0;

        headSentinela = new Node(null);
        tailSentinela = new Node(null);
        headSentinela.next = tailSentinela;
        tailSentinela.prev = headSentinela;
    }


    @Override
    public Object first() {
        if(size > 0){
            return headSentinela.next.value;
        } else {
            throw new RuntimeException("Lista esta vazia");
        }
    }

    @Override
    public Object last() {
        if (size > 0){
            return tailSentinela.prev.value;
        } else {
            throw new RuntimeException("Lista esta vazia");
        }
    }

    @Override
    public Object before(int rank) {
        if (rank <= 0 || rank >= size){
            throw new RuntimeException("Não há elemento anterior");
        }

        Node current = getAtNode(rank);
        return current.prev.value;
    }

    @Override
    public Object after(int rank) {
        if (rank < 0 || rank >=size-1){
            throw new RuntimeException("Não há elemento posterior");
        }
        Node current = getAtNode(rank);
        return current.next.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFirst(int r) {
        return r == 0;

    }

    @Override
    public boolean isLast(int r) {
        return  r == size-1;
    }

    @Override
    public Object replaceElements(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank fora do limite da Lista");
        }
        Node current = getAtNode(rank);
        Object oldElement = current.value;
        current.value = o;
        return oldElement;
    }

    @Override
    public void swapElements(int rank1, int rank2) {
        if ((rank1 < 0 || rank1 >= size) || (rank2 < 0 || rank2 >= size)){
            throw new RuntimeException("Rank fora do limite da Lista");
        }
        Node node1 = getAtNode(rank1);
        Node node2 = getAtNode(rank2);
        Object valueNode1 = node1.value;
        node1.value = node2.value;
        node2.value = valueNode1;
    }

    @Override
    public void insertBefore(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank fora do limite da Lista");
        }
        Node current = getAtNode(rank);
        Node newNode = new Node(o);

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;
        size++;

    }

    @Override
    public void insertAfter(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RuntimeException("Rank fora do limite da Lista");
        }
        Node current = getAtNode(rank);
        Node newNode = new Node(o);

        newNode.prev = current;
        newNode.next = current.next;

        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public void insertFirst(Object o) {
        Node newNode = new Node(o);
        newNode.prev = headSentinela;
        newNode.next = headSentinela.next;

        headSentinela.next.prev = newNode;
        headSentinela.next = newNode;
        size++;

    }

    @Override
    public void insertLast(Object o) {
         Node newNode = new Node(o);
         newNode.prev = tailSentinela.prev;
         newNode.next = tailSentinela;

         tailSentinela.prev.next = newNode;
         tailSentinela.prev = newNode;
         size++;
    }

    @Override
    public Object remove(int rank) {
        if (rank >= size || rank < 0){
            throw new RuntimeException("Rank fora do limite da Lista");
        }
        Node nodeToRemove = getAtNode(rank);
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        size--;
        return  nodeToRemove.value;
    }

    private Node getAtNode(int rank){
        if (rank < 0 || rank >= size){
            throw new IndexOutOfBoundsException("Indice fora do limite");
        }

        Node current = headSentinela.next;
        for (int i = 0; i < rank; i++){
            current = current.next;
        }
        return current;
    }

}