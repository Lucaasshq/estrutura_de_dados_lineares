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

    }
}
