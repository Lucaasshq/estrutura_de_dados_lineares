package Vetor;

public class Main {
    public static void main(String[] args) {

        Vetor v = new Vetor(10);

        for (int i = 0; i < 10; i++){
            v.insertAtRank(i,i);
        }

        v.printVetor();
        System.out.println(v.elemAtRank(5));

        v.replaceArRank(5, 10);
        v.printVetor();

        System.out.println(v.removeAtRank(2));
        v.printVetor();
        System.out.println(v.removeAtRank(5));
        v.printVetor();

        System.out.println("==============Linked vetor==============");

        VetorLinkedList v2 = new VetorLinkedList(10);

        for (int i = 0; i < 10; i++){
            v2.insertAtRank(i,i);
        }

        v2.printVetorLinked();

        System.out.println(v2.replaceArRank(5, 10));
        v2.printVetorLinked();

        System.out.println(v2.removeAtRank(2));
        v2.printVetorLinked();
        System.out.println(v2.removeAtRank(5));
        v2.printVetorLinked();

    }
}
