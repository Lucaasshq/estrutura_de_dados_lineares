package Lista;

public class Lista  {
    private Object[] array;
    private int size;
    private int capacidade;

    public Lista(int capacidade){
        this.array = new Object[capacidade];
        this.size = 0;
        this.capacidade = capacidade;
    }


    public void increase_capacity(){
        int nova_capacidade = capacidade * 2;
        Object[] novo_array = new Object[nova_capacidade];

        for (int i = 0; i < size; i++){
            novo_array[i] = array[i];
        }
        array = novo_array;
        capacidade = nova_capacidade;
    }



    public Object first() {
        if (isEmpty()){
            throw new RuntimeException("A lista esta vazia");
        }
        return array[0];
    }

    public Object last() {
        if (isEmpty()){
            throw new RuntimeException("A lista esta vazia");
        }
        return array[size()-1];
    }

    public Object before(int rank) {
        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }

        if (rank <= 0 || rank >= size()){
            throw new RuntimeException("indice invalido");
        }

        return array[rank-1];
    }

    public Object after(int rank) {

        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }

        if (rank < 0 || rank >= size()-1){
            throw new RuntimeException("indice invalido");
        }
        return array[rank+1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFirst(Object o) {
        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }
        return o.equals(array[0]);
    }

    public boolean isLast(Object o) {
        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }
        return o.equals(array[size-1]);
    }
    public Object replaceElements(int rank, Object o) {
        return null;
    }

    public void swapElements(int rank1, int rank2) {

    }

    public void insertBefore(int rank, Object o) {
        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }

        if (rank <= 0 || rank >= size()){
            throw new RuntimeException("indice invalido");
        }


    }

    public void insertAfter(int rank, Object o) {
        if (isEmpty()){
            throw new RuntimeException("Lista esta vazia");
        }

        if (rank < 0 || rank >= size()-1){
            throw new RuntimeException("indice invalido");
        }
    }

    public void insertFirst(Object o) {
        if (size() == capacidade){
            increase_capacity();
        }

        for (int i = size; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = o;
        size++;
    }

    public void insertLast(Object o) {
        if (size() == capacidade){
            increase_capacity();
        }

        array[size] = o;
        size++;
    }

    public Object remove(int rank) {
        if (isEmpty()){
            throw new RuntimeException("A Lista esta vazia");
        }
        Object elementoRemove = array[rank];

        for (int i = rank; i < size; i++){
            array[i] = array[i+1];
        }
        size--;
        return elementoRemove;
    }
}
