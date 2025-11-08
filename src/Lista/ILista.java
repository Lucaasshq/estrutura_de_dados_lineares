package Lista;

import org.w3c.dom.Node;

public interface ILista {

    public Object first();
    public Object last();
    public Object before(int n);
    public Object after(int n);
    public int size();
    public boolean isEmpty();
    //metodo de fila
    public boolean isFirst(int r);
    

    public boolean isLast(int r);

    public Object replaceElements(int n, Object o);
    public void swapElements(int n, int j);
    public void insertBefore(int n, Object o);
    public void insertAfter(int n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(int n);

}
