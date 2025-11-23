package Arvore;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreSimples {

    Node raiz;
    int tamanho;

    public ArvoreSimples(Object o){
        this.raiz = new Node(null, o);
        this.tamanho = 1;
    }

    public Node root(){
        return raiz;
    }

    public Node parent(Node node){
        return node.parent();
    }

    public Iterator<Node> children(Node node){
        return node.children();
    }

    public boolean isInternal(Node node){
        return node.childrenNumber() > 0;
    }

    public boolean isExternal(Node node){
        return node.childrenNumber() == 0;
    }

    public boolean isRoot(Node node){
        return node.equals(raiz);
    }

    public void addChild(Node pai, Object o){
        Node newNode = new Node(pai, o);
        pai.addChild(newNode);
        tamanho++;
    }

    public Object remove(Node node){
        Node pai = node.parent();
        if (pai != null && isExternal(node)){
            pai.removeChild(node);
        } else {
            throw new RuntimeException("Nó invalido");
        }
        tamanho--;
        return node.element();
    }

    public int depth(Node node){
        int profundidade = profundidade(node);
        return profundidade;
    }

    private int profundidade(Node node){
        if (node == raiz){
            return 0;
        } else {
            return 1+profundidade(node.parent());
        }
    }


    public class Node {
        private Node pai;
        private Object o;
        private ArrayList<Node> filhos = new ArrayList<>();

        public Node(Node pai, Object o){
            this.pai = pai;
            this.o = o;
        }

        public Object element() {return o;}
        public Node parent(){return pai;}
        public void setElement(Object o){this.o = o;}
        public void addChild(Node node){ filhos.add(node);}
        public void removeChild(Node node){filhos.remove(node);}
        public int childrenNumber() {return filhos.size();}
        public Iterator<Node> children() {
            return filhos.iterator();
        }
    }
}
