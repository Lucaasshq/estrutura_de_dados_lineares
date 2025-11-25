package Arvore;

import java.util.ArrayList;
import java.util.Iterator;

public class OutraArvoreBinariaPesquisa {

    private Node raiz;
    private int tamanho;  // Adicionei contador de tamanho

    public OutraArvoreBinariaPesquisa() {
        this.tamanho = 0;
    }

    public Node root() { return raiz; }
    public int size() { return tamanho; }
    public boolean isEmpty() { return raiz == null; }

    /* ============================
         INSERÇÃO
       ============================ */
    public void insert(int e) {
        if (raiz == null) {
            raiz = new Node(null, e);
            tamanho++;
            return;
        }

        Node atual = raiz;
        Node pai = null;

        while (atual != null) {
            pai = atual;
            if (e < atual.element) atual = atual.left;
            else if (e > atual.element) atual = atual.right;
            else return; // elemento já existe
        }

        Node novo = new Node(pai, e);

        if (e < pai.element) pai.left = novo;
        else pai.right = novo;

        tamanho++;
    }

    /* ============================
         BUSCA (versão iterativa também)
       ============================ */
    private Node search(Node n, int e) {
        if (n == null) return null;
        if (e == n.element) return n;
        if (e < n.element) return search(n.left, e);
        return search(n.right, e);
    }

    public Node search(int e) {
        // Versão iterativa (mais eficiente)
        Node atual = raiz;
        while (atual != null) {
            if (e == atual.element) return atual;
            else if (e < atual.element) atual = atual.left;
            else atual = atual.right;
        }
        return null;
    }

    public boolean contains(int e) {
        return search(e) != null;
    }

    /* ============================
         REMOVE — UMA FUNÇÃO
       ============================ */
    public void remove(int e) {
        Node pai = null;
        Node atual = raiz;

        // buscar
        while (atual != null && atual.element != e) {
            pai = atual;
            if (e < atual.element) atual = atual.left;
            else atual = atual.right;
        }

        if (atual == null) return;

        // CASO 1: folha
        if (atual.left == null && atual.right == null) {
            if (pai == null) raiz = null;
            else if (pai.left == atual) pai.left = null;
            else pai.right = null;
            tamanho--;
            return;
        }

        // CASO 2: um filho
        if (atual.left == null || atual.right == null) {
            Node filho = (atual.left != null ? atual.left : atual.right);

            if (pai == null) raiz = filho;
            else if (pai.left == atual) pai.left = filho;
            else pai.right = filho;

            filho.parent = pai;
            tamanho--;
            return;
        }

        // CASO 3: dois filhos
        Node pSucc = atual;
        Node succ = atual.right;

        while (succ.left != null) {
            pSucc = succ;
            succ = succ.left;
        }

        atual.element = succ.element;

        if (pSucc.left == succ)
            pSucc.left = succ.right;
        else
            pSucc.right = succ.right;

        if (succ.right != null)
            succ.right.parent = pSucc;

        tamanho--;
    }

    /* ============================
         TRAVESSIAS
       ============================ */
    public void preOrder(Node n) {
        if (n == null) return;
        System.out.print(n.element + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public void inOrder(Node n) {
        if (n == null) return;
        inOrder(n.left);
        System.out.print(n.element + " ");
        inOrder(n.right);
    }

    public void postOrder(Node n) {
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.element + " ");
    }

    /* ============================
         MÉTODOS ÚTEIS
       ============================ */
    public int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    public int depth(Node n) {
        if (n == null) return -1;
        int profundidade = 0;
        Node atual = n;
        while (atual != raiz) {
            profundidade++;
            atual = atual.parent;
        }
        return profundidade;
    }

    public Node min() {
        if (raiz == null) return null;
        Node atual = raiz;
        while (atual.left != null) {
            atual = atual.left;
        }
        return atual;
    }

    public Node max() {
        if (raiz == null) return null;
        Node atual = raiz;
        while (atual.right != null) {
            atual = atual.right;
        }
        return atual;
    }

    /* ============================
         ITERADORES (como na árvore simples)
       ============================ */
    public Iterator<Integer> elements() {
        ArrayList<Integer> lista = new ArrayList<>();
        inOrderElements(raiz, lista);
        return lista.iterator();
    }

    private void inOrderElements(Node n, ArrayList<Integer> lista) {
        if (n == null) return;
        inOrderElements(n.left, lista);
        lista.add(n.element);
        inOrderElements(n.right, lista);
    }

    public Iterator<Node> nodes() {
        ArrayList<Node> lista = new ArrayList<>();
        preOrderNodes(raiz, lista);
        return lista.iterator();
    }

    private void preOrderNodes(Node n, ArrayList<Node> lista) {
        if (n == null) return;
        lista.add(n);
        preOrderNodes(n.left, lista);
        preOrderNodes(n.right, lista);
    }

    /* ============================
         NODE
       ============================ */
    public class Node {
        Node parent;
        Node left;
        Node right;
        int element;

        public Node(Node p, int e) {
            parent = p;
            element = e;
        }

        public boolean isExternal() {
            return left == null && right == null;
        }

        public boolean isInternal() {
            return !isExternal();
        }

        public int getElement() {
            return element;
        }
    }

    /* ============================
         TESTE
       ============================ */
    public static void main(String[] args) {
        ArvoreBinariaPesquisa arv = new ArvoreBinariaPesquisa();

        int[] valores = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int v : valores) {
            arv.insert(v);
        }

        System.out.println("Em-Ordem:");
        arv.inOrder(arv.root());

        System.out.println("\nTamanho: " + arv.size());
        System.out.println("Altura: " + arv.height(arv.root()));
        System.out.println("Mínimo: " + arv.min().element);
        System.out.println("Máximo: " + arv.max().element);

        System.out.println("\nContém 6? " + arv.contains(6));
        System.out.println("Contém 99? " + arv.contains(99));

        System.out.println("\nRemovendo 3...");
        arv.remove(3);
        System.out.println("Em-Ordem após remoção:");
        arv.inOrder(arv.root());
        System.out.println("\nNovo tamanho: " + arv.size());
    }
}