package Deque;

public class Main {
    public static void main(String[] args) {

        DequeDouble deque = new DequeDouble();

        for (int i = 0; i < 10; i++){
            deque.addFirst(i);
        }

        for (int i = 0; i < 10; i++){
            System.out.println(deque.removeLast());
        }

        System.out.println("=============================================");

        for (int i = 0; i < 10; i++){
            deque.addLast(i);
        }

        for (int i = 0; i < 10; i++){
            System.out.println(deque.removeFirst());
        }
    }
}
