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
        return null;
    }

    @Override
    public Object last() {
        return null;
    }

    @Override
    public Object before(int p) {
        return null;
    }

    @Override
    public Object after(int p) {
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

    @Override
    public boolean isFirst(int r) {
        return r == 0;

    }

    @Override
    public boolean isLast(int r) {
        return  r == size-1;
    }

    @Override
    public Object replaceElements(int n, Object o) {
        return null;
    }

    @Override
    public void swapElements(int n, int q) {

    }

    @Override
    public void insertBefore(int n, Object o) {

    }

    @Override
    public void insertAfter(int n, Object o) {

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