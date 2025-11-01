package Vetor;


/**
 * @author Lucas Henrique
 * @description Vetor
 * @matricula 20242014040042
 * @IFRN
 */

public interface IVetor {
    
    public Object elemAtRank(int r);

    public Object replaceArRank(int r, Object o);

    public void insertAtRank(int r, Object o);

    public Object removeAtRank(int r);

    public int size();

    public boolean isEmpty();
}
