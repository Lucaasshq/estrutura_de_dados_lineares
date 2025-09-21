package PilhaRubroNegro;
import pilhas.Exeception.PilhaVaziaExeception;

import java.util.Arrays;

public class PilhaRubroNegroImpl implements PilhaRubroNegro {

    private int capacidade;
    private Object[] array;
    private int tamPilhaVermelho;
    private int tamPilhaPreta;

    public PilhaRubroNegroImpl(int capacidade){
        this.capacidade = capacidade;
        this.tamPilhaVermelho = 0;
        this.tamPilhaPreta = 0;
        array =  new Object[capacidade];
    }

    @Override
    public int size() {
        return (tamPilhaVermelho) + (tamPilhaPreta);
    }

    @Override
    public boolean isEmpty() {
        return tamPilhaVermelho == 0 && tamPilhaPreta == 0;
    }

    @Override
    public Object topV() throws PilhaVaziaExeception {
        if (isEmpty()){
            throw new PilhaVaziaExeception("A PilhaRubroNegro está vazia");
        }
        return array[tamPilhaVermelho-1];
    }

    @Override
    public Object topP() throws PilhaVaziaExeception {
        if (isEmpty()){
            throw new PilhaVaziaExeception("A PilhaRubroNegro está vazia");
        }
       return array[capacidade-tamPilhaPreta];
    }

    @Override
    public void pushV(Object o) {
        if (tamPilhaVermelho + tamPilhaPreta >= capacidade-1){
         int novaCapacidade = capacidade * 2;
          Object[] novoArray = new Object[novaCapacidade];

          // Copiando vermelho
          for (int i = 0; i < tamPilhaVermelho; i++){
              novoArray[i] = array[i];
          }

          //  Copiando preto
          for (int i = 0; i < tamPilhaPreta; i++){
            novoArray[novaCapacidade-1-i] = array[capacidade-1-i];
          }
          array = novoArray;
          capacidade = novaCapacidade;
        }
        array[tamPilhaVermelho] = o;
        tamPilhaVermelho++;
    }

    @Override
    public void pushP(Object o) {
        if (tamPilhaVermelho + tamPilhaPreta >= capacidade-1){
            int novaCapacidade = capacidade * 2;
            Object[] novoArray = new Object[novaCapacidade];

            //Copiando vermelho
            for (int i = 0; i < tamPilhaVermelho; i++){
                novoArray[i] = array[i];
            }

            //Copiando preto
            for (int i = 0; i < tamPilhaPreta; i++){
                novoArray[novaCapacidade-1-i] = array[capacidade-1-i];
            }
            array = novoArray;
            capacidade = novaCapacidade;
        }
        tamPilhaPreta++;
        array[capacidade-tamPilhaPreta] = o;
    }

    @Override
    public Object popV() throws PilhaVaziaExeception {
        if (tamPilhaVermelho == 0) {
            throw new PilhaVaziaExeception("A PilhaRubroNegro está vazia");
        }
        return array[--tamPilhaVermelho];
    }

    @Override
    public Object popP() throws PilhaVaziaExeception {
        if (tamPilhaPreta == 0){
            throw new PilhaVaziaExeception("A PilhaRubroNegro está vazia");
        }
        tamPilhaPreta--;
        return array[capacidade - tamPilhaPreta-1];
    }

    public void print(){
        System.out.println(Arrays.toString(array));
    }dd
}
