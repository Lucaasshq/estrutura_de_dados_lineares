package Sequencia;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TESTE DO TAD SEQUÊNCIA ===\n");

        Sequencia seq = new Sequencia();

        // 1. Inserções básicas
        System.out.println("1. Inserções básicas:");
        seq.insertLast(10);
        seq.insertFirst(5);
        seq.insertLast(20);
        print(seq);

        // 2. Inserções específicas
        System.out.println("\n2. Inserções específicas:");
        Sequencia.Node n1 = seq.elemAtRank(1);
        seq.insertBefore(n1, 7);
        seq.insertAfter(n1, 15);
        print(seq);

        // 3. Substituição e troca
        System.out.println("\n3. Substituição e troca:");
        Sequencia.Node n0 = seq.elemAtRank(0);
        Sequencia.Node n3 = seq.elemAtRank(3);
        seq.replaceElement(n0, 100);
        seq.swapElements(n0, n3);
        print(seq);

        // 4. Remoções
        System.out.println("\n4. Remoções:");
        Sequencia.Node n2 = seq.elemAtRank(2);
        seq.remove(n2);
        print(seq);

        // 5. Métodos ponte
        System.out.println("\n5. Métodos ponte:");
        System.out.println("AtRank(1) -> " + seq.atRank(1).value);
        System.out.println("rankOf(first) -> " + seq.rankOf(seq.elemAtRank(0)));

        // 6. Inserção e remoção por rank
        System.out.println("\n6. Operações por rank:");
        seq.insertAtRank(1, 999);
        print(seq);

        seq.removeAtRank(2);
        print(seq);

        System.out.println("\n=== FIM ===");
    }


    private static void print(Sequencia seq) {
        System.out.print("[ ");

        if (!seq.isEmpty()) {
            Sequencia.Node atual = seq.elemAtRank(0);

            while (true) {
                System.out.print(atual.value + " ");


                if (seq.isLast(atual)) break;


                atual = seq.after(atual);
            }
        }

        System.out.println("]");
    }
}
