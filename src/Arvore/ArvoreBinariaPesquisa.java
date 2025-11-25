package Arvore;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinariaPesquisa {

    private Node raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    /* ===========================================
            MÉTODOS DO TAD ÁRVORE
       =========================================== */

    public Node root() {
        return raiz;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public Node parent(Node n) {
        return n.parent;
    }

    public boolean isRoot(Node n) {
        return n == raiz;
    }

    public int depth(Node n) {
        if (n == raiz) return 0;
        return 1 + depth(n.parent);
    }

    public int height(Node n) {
        if (n == null || n.isExternal()) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    /* ===========================================
            TAD ÁRVORE BINÁRIA
       =========================================== */

    public Node leftChild(Node n) {
        return n.left;
    }

    public Node rightChild(Node n) {
        return n.right;
    }

    public boolean hasLeft(Node n) {
        return n.hasLeft();
    }

    public boolean hasRight(Node n) {
        return n.hasRight();
    }


    /* ===========================================
            INSERÇÃO (BST)
       =========================================== */

    public Node insert(int key) {

        if (raiz == null) {
            raiz = new Node(null, key);
            tamanho++;
            return raiz;
        }

        Node atual = raiz;
        Node pai = null;

        while (atual != null) {
            pai = atual;
            int v = (int) atual.element;

            if (key < v)
                atual = atual.left;
            else
                atual = atual.right;
        }

        Node novo = new Node(pai, key);

        if (key < (int) pai.element)
            pai.left = novo;
        else
            pai.right = novo;

        tamanho++;
        return novo;
    }


    /* ===========================================
            REMOVE EM APENAS UMA FUNÇÃO
       =========================================== */

    public void remove(int key) {
        Node pai = null;
        Node atual = raiz;

        // 1) Buscar o nó
        while (atual != null && (int) atual.element != key) {
            pai = atual;
            if (key < (int) atual.element)
                atual = atual.left;
            else
                atual = atual.right;
        }

        if (atual == null) return; // não achou

        // -------- CASO 1: NÓ FOLHA --------
        if (atual.left == null && atual.right == null) {

            if (pai == null) { // era raiz
                raiz = null;
            }
            else if (pai.left == atual)
                pai.left = null;
            else
                pai.right = null;

            tamanho--;
            return;
        }

        // -------- CASO 2: UM FILHO --------
        if (atual.left == null || atual.right == null) {

            Node filho = (atual.left != null) ? atual.left : atual.right;

            if (pai == null)
                raiz = filho;
            else if (pai.left == atual)
                pai.left = filho;
            else
                pai.right = filho;

            filho.parent = pai;
            tamanho--;
            return;
        }

        // -------- CASO 3: DOIS FILHOS --------
        Node pSucc = atual;
        Node succ = atual.right;

        while (succ.left != null) {
            pSucc = succ;
            succ = succ.left;
        }

        // copiar valor do sucessor
        atual.element = succ.element;

        // remover sucessor
        if (pSucc.left == succ) {
            pSucc.left = succ.right;
            if (succ.right != null) succ.right.parent = pSucc;
        } else {
            pSucc.right = succ.right;
            if (succ.right != null) succ.right.parent = pSucc;
        }

        tamanho--;
    }

    /* ===========================================
            TRAVESSIAS
       =========================================== */

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

    /* ===========================================
            ITERAÇÃO DE NODES (como ArvoreSimples)
       =========================================== */

    public Iterator<Node> nodes() {
        ArrayList<Node> lista = new ArrayList<>();
        preOrderList(raiz, lista);
        return lista.iterator();
    }

    private void preOrderList(Node n, ArrayList<Node> lista) {
        if (n == null) return;
        lista.add(n);
        preOrderList(n.left, lista);
        preOrderList(n.right, lista);
    }

    public Iterator<Object> elements() {
        ArrayList<Object> elems = new ArrayList<>();
        Iterator<Node> it = nodes();
        while (it.hasNext())
            elems.add(it.next().element);

        return elems.iterator();
    }


    /* ===========================================
            DESENHAR ARVORE
       =========================================== */

    public void desenharArvore() {
        int h = height(raiz);
        int largura = (int) Math.pow(2, h + 1) - 1;

        String[][] mat = new String[h + 1][largura];

        for (int i = 0; i <= h; i++)
            for (int j = 0; j < largura; j++)
                mat[i][j] = " ";

        preencherMatriz(raiz, mat, 0, 0, largura - 1);

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < largura; j++)
                System.out.print(mat[i][j]);
            System.out.println();
        }
    }

    private void preencherMatriz(Node n, String[][] mat, int linha, int esq, int dir) {
        if (n == null) return;

        int meio = (esq + dir) / 2;
        mat[linha][meio] = String.valueOf(n.element);

        preencherMatriz(n.left, mat, linha + 1, esq, meio - 1);
        preencherMatriz(n.right, mat, linha + 1, meio + 1, dir);
    }


    /* ===========================================
                    NODE (NO ESTILO DA ARVORESIMPLES)
       =========================================== */

    public class Node {

        private Node parent;
        private Object element;
        private Node left;
        private Node right;

        public Node(Node parent, Object element) {
            this.parent = parent;
            this.element = element;
        }

        public Object getElement() { return element; }

        public Node parent() { return parent; }

        public boolean hasLeft() { return left != null; }

        public boolean hasRight() { return right != null; }

        public boolean isExternal() {
            return left == null && right == null;
        }

        public boolean isInternal() {
            return !isExternal();
        }

        public int childrenNumber() {
            int c = 0;
            if (left != null) c++;
            if (right != null) c++;
            return c;
        }

        public Iterator<Node> children() {
            ArrayList<Node> f = new ArrayList<>();
            if (left != null) f.add(left);
            if (right != null) f.add(right);
            return f.iterator();
        }
    }



    /* ===========================================
                   MAIN DE TESTE
       =========================================== */

    public static void main(String[] args) {

        ArvoreBinariaPesquisa arv = new ArvoreBinariaPesquisa();

        int[] valores = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int v : valores)
            arv.insert(v);

        System.out.println("\n=== ÁRVORE ===");
        arv.desenharArvore();

        System.out.println("\nPré-Ordem:");
        arv.preOrder(arv.root());

        System.out.println("\n\nEm-Ordem:");
        arv.inOrder(arv.root());

        System.out.println("\n\nPós-Ordem:");
        arv.postOrder(arv.root());
        System.out.println();

        System.out.println("\nRemovendo 3...");
        arv.remove(3);
        arv.desenharArvore();
    }
}
