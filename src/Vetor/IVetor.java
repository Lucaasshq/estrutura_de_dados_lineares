package Vetor;


/**
 * @author Lucas Henrique
 * @description Vetor
 * @matricula 20242014040042
 * @IFRN
 */

public interface IVetor {
    
    public Object elemAtRank(Integer r);

    public Object replaceArRank(Interger r, Object o);

    public void insertAtRank(Interger r, Object o);

    public Object removeAtRank(Interger r);

    public int size();

    public boolean isEmpty();
}
