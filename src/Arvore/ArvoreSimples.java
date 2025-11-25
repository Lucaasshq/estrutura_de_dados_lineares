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
        return node.getElement();
    }

    public void swapElement(Node node1, Node node2){
        Object temp = node1.o;
        node1.o = node2.o;
        node2.o = temp;
    }

    public int depth(Node node){
        return profundidade(node);
    }

    private int profundidade(Node node){
        if (node == raiz){
            return 0;
        } else {
            return 1+profundidade(node.parent());
        }
    }

    public boolean isEmpty(){
        return false;
    }

    public int height(Node node){
        if (isExternal(node)){
            return 0;
        } else {
           int h = 0;
           Iterator<Node> filhos = node.children();
            while (filhos.hasNext()){
                Node filho =  filhos.next();
                h = Math.max(h, height(filho));
            }
            return 1+h;
        }
    }

    public int size(){
        return tamanho;
    }

    public Iterator<Object> elements(){
        ArrayList<Object> elems = new ArrayList<>();
        Iterator<Node> iterator = nodes();
        while (iterator.hasNext()){
            elems.add(iterator.next().getElement());
        }
        return elems.iterator();
    }

    private void preOrder(Node n, ArrayList<Node> lista){
        lista.add(n);
        Iterator<Node> listIt = n.children();
        while (listIt.hasNext()){
            preOrder(listIt.next(), lista);
        }
    }

    public Iterator<Node> nodes(){
        ArrayList<Node> lista = new ArrayList<>();
        preOrder(raiz, lista);
        return lista.iterator();
    }

    public Object replaceElement(Node node, Object o){
        node.o = o;
        return o;
    }


    public class Node {
        private Node pai;
        private Object o;
        private ArrayList<Node> filhos = new ArrayList<>();

        public Node(Node pai, Object o){
            this.pai = pai;
            this.o = o;
        }

        public Object getElement() {return o;}
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
