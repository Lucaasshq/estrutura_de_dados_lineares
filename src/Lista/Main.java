package Lista;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA LISTA ===\n");


        Lista lista = new Lista(3);

        // Teste 1: Inserções básicas
        System.out.println("1. Inserções básicas:");
        lista.insertLast(10);
        lista.insertFirst(5);
        lista.insertLast(20);
        lista.printLista();

        // Teste 2: Redimensionamento
        System.out.println("\n2. Redimensionamento:");
        lista.insertLast(30);
        lista.insertLast(40);
        lista.printLista();

        // Teste 3: Acessos
        System.out.println("\n3. Acessos:");
        System.out.println("First: " + lista.first());
        System.out.println("Last: " + lista.last());
        System.out.println("Before(2): " + lista.before(2));
        System.out.println("After(1): " + lista.after(1));

        // Teste 4: Inserções específicas
        System.out.println("\n4. Inserções específicas:");
        lista.insertBefore(2, 15);
        lista.insertAfter(3, 25);
        lista.printLista();

        // Teste 5: Substituição e troca
        System.out.println("\n5. Substituição e troca:");
        lista.replaceElements(1, 12);
        System.out.println("Após replaceElements(1, 12):");
        lista.printLista();

        lista.swapElements(0, 2);
        System.out.println("Após swapElements(0, 2):");
        lista.printLista();

        // Teste 6: Remoções
        System.out.println("\n6. Remoções:");
        lista.remove(1);
        System.out.println("Após remove(1):");
        lista.printLista();

        lista.remove(0);
        System.out.println("Após remove(0):");
        lista.printLista();

        // Teste 7: Mais operações
        System.out.println("\n7. Novas inserções:");
        lista.insertFirst(100);
        lista.insertLast(200);
        lista.printLista();

        // Teste 8: Verificações
        System.out.println("\n8. Verificações:");
        System.out.println("isFirst(100): " + lista.isFirst(100));
        System.out.println("isLast(200): " + lista.isLast(200));
        System.out.println("isEmpty: " + lista.isEmpty());

        System.out.println("\n=== FIM DOS TESTES ===");
    }


}