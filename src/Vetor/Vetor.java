package Vetor;

import Vetor.Exeception.RankNotFoundExeception;
import Vetor.Exeception.VetorCheioExeception;

import java.util.Arrays;

public class Vetor implements IVetor  {

    private Object[] array;
    private int size;

    public Vetor(int capacidade){
        this.array = new Object[capacidade];
        this.size = 0;
    }


    @Override
    public Object elemAtRank(int rank) {
        if (rank < 0 || rank >= size) {
            throw new RankNotFoundExeception("Rank fora do limte ou não encontrado");
        }
        return array[rank];
    }

    @Override
    public Object replaceArRank(int rank, Object o) {
        if (rank < 0 || rank >= size){
            throw new RankNotFoundExeception("Rank fora do limte ou não encontrado");
        }
        Object elemento_antigo = array[rank];
        array[rank] = o;
        return elemento_antigo;
    }

    @Override
    public void insertAtRank(int rank, Object o) {

        if (rank < 0 || rank > size) {
            throw new IndexOutOfBoundsException("Rank fora dos limites do vetor.");
        }

        if (size == array.length) {
            throw new VetorCheioExeception("Vetor esta cheio");
        }

        for (int i = size; i > rank; i--){
            array[i]= array[i-1];
        }
        array[rank] = o;
        size++;
    }

    @Override
    public Object removeAtRank(int rank) {
        if (rank < 0 || rank >= size){
            throw new RankNotFoundExeception("Rank fora do limte ou não encontrado");
        }
        Object elemento_remover = array[rank];

        for (int i = rank; i < size-1; i++){
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
        return elemento_remover;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void printVetor(){
        System.out.println(Arrays.toString(array));
    }
}
