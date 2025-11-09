package Lista;

public class Lista  {
    private Object[] array;
    private int size;

    public Lista(int capacidade){
        this.array = new Object[capacidade];
        this.size = 0;
    }



    public Object first() {
        return array[0];
    }

    public Object last() {
        return array[array.length-1];
    }

    public Object before(Object node) {
        return null;
    }

    public Object after(int n) {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFirst(int r) {
        return false;
    }

    public boolean isLast(int r) {
        return false;
    }

    public Object replaceElements(int n, Object o) {
        return null;
    }

    public void swapElements(int n, int j) {

    }

    public void insertBefore(int n, Object o) {

    }

    public void insertAfter(int n, Object o) {

    }

    public void insertFirst(Object o) {

    }

    public void insertLast(Object o) {

    }

    public Object remove(int n) {
        return null;
    }
}
