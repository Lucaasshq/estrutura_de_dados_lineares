package PilhaRubroNegro;

import pilhas.Exeception.PilhaVaziaExeception;

public interface PilhaRubroNegro {
    public int sizeV();
    public int sizeP();
    public boolean isEmptyV();
    public boolean isEmptyP();
    public boolean isEmpty();
    public Object topV() throws PilhaVaziaExeception;
    public Object topP() throws PilhaVaziaExeception;
    public void pushV(Object o);
    public void pushP(Object o);
    public Object popV() throws PilhaVaziaExeception;
    public Object popP() throws PilhaVaziaExeception;
    public void print();
    public void reduzir();

}
