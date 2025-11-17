package Deque;

public class FilaArrayCircular {
    private int inicio;
    private int fim;
    private int size;
    private Object[] elements;
    private int capacidade;

    public FilaArrayCircular(int capacidade){
        this.elements = new Object[capacidade];
        this.capacidade = capacidade;
        this.size = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean isFull(){
        return capacidade == size;
    }

    public Object first() {
        if (isEmpty()){
            throw new RuntimeException("Deque vazio");
        }
        return elements[inicio];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Object o){
        if (isFull()){
            increase_capacity();
        }
        elements[fim] = o;
        fim = (fim + 1) % capacidade;
        size++;
    }

    public Object dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Deque vazio");
        }
        Object removedItem = elements[inicio];
        elements[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        size--;
        return removedItem;
    }

    public void increase_capacity(){
        Object[] newArray = new Object[capacidade * 2];
        for (int i = 0; i < size; i++){
            newArray[i] = elements[(inicio + i) % capacidade];
        }
        elements = newArray;
        capacidade *= 2;
        inicio = 0;
        fim = size;
    }
}
