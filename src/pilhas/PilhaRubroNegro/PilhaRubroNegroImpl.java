package pilhas.PilhaRubroNegro;
import pilhas.Exeception.PilhaVaziaExeception;
import java.util.Arrays;

public class PilhaRubroNegroImpl implements PilhaRubroNegro {

    private int capacidade;
    private Object[] array;
    private int tamPilhaVermelho;
    private int tamPilhaPreta;

    public PilhaRubroNegroImpl(int capacidade) {
        this.capacidade = capacidade;
        this.tamPilhaVermelho = 0;
        this.tamPilhaPreta = 0;
        array = new Object[capacidade];
    }

    public void reduzir() {
        if (isEmpty()) {
            throw new PilhaVaziaExeception("A PilhaRubroNegro está vazia");
        }

        if ((tamPilhaPreta + tamPilhaVermelho) <= (capacidade / 3)) {

            int antigaCapacidade = capacidade;
            int novaCapacidade = capacidade / 2;

            Object[] novoArray = new Object[novaCapacidade];

            for (int i = 0; i < tamPilhaVermelho; i++) {
                novoArray[i] = array[i];
            }

            for (int i = 0; i < tamPilhaPreta; i++) {
                novoArray[novaCapacidade - 1 - i] = array[antigaCapacidade - 1 - i];
            }
            array = novoArray;
            capacidade = novaCapacidade;
        }
    }

    @Override
    public Object topV() throws PilhaVaziaExeception {
        if (isEmptyV()) {
            throw new PilhaVaziaExeception("PilhaRubroNegro está vazia");
        }
        return array[tamPilhaVermelho - 1];
    }

    @Override
    public Object topP() throws PilhaVaziaExeception {
        if (isEmptyP()) {
            throw new PilhaVaziaExeception("PilhaRubroNegro está vazia");
        }
        return array[capacidade - tamPilhaPreta];
    }

    @Override
    public void pushV(Object o) {
        if (tamPilhaVermelho + tamPilhaPreta >= capacidade) {
            int novaCapacidade = capacidade * 2;
            Object[] novoArray = new Object[novaCapacidade];

            // Copiando vermelho
            for (int i = 0; i < tamPilhaVermelho; i++) {
                novoArray[i] = array[i];
            }

            //  Copiando preto
            for (int i = 0; i < tamPilhaPreta; i++) {
                novoArray[novaCapacidade - 1 - i] = array[capacidade - 1 - i];
            }
            array = novoArray;
            capacidade = novaCapacidade;
        }
        array[tamPilhaVermelho] = o;
        tamPilhaVermelho++;
    }

    @Override
    public void pushP(Object o) {
        if (tamPilhaVermelho + tamPilhaPreta >= capacidade) {
            int novaCapacidade = capacidade * 2;
            Object[] novoArray = new Object[novaCapacidade];

            //Copiando vermelho
            for (int i = 0; i < tamPilhaVermelho; i++) {
                novoArray[i] = array[i];
            }

            //Copiando preto
            for (int i = 0; i < tamPilhaPreta; i++) {
                novoArray[novaCapacidade - 1 - i] = array[capacidade - 1 - i];
            }
            array = novoArray;
            capacidade = novaCapacidade;
        }
        tamPilhaPreta++;
        array[capacidade - tamPilhaPreta] = o;
    }

    @Override
    public Object popV() throws PilhaVaziaExeception {
        if (tamPilhaVermelho == 0) {
            throw new PilhaVaziaExeception(
                    "PilhaRubroNegro está vazia"
            );
        }
        Object o = array[tamPilhaVermelho - 1];
        tamPilhaVermelho--;
        if ((tamPilhaVermelho + tamPilhaPreta) <= capacidade / 3) {
            reduzir();
        }
        return o;
    }

    @Override
    public Object popP() throws PilhaVaziaExeception {
        if (tamPilhaPreta == 0) {
            throw new PilhaVaziaExeception(
                    "PilhaRubroNegro está vazia"
            );
        }
        Object o = array[capacidade - tamPilhaPreta];
        tamPilhaPreta--;

        if ((tamPilhaVermelho + tamPilhaPreta) <= capacidade / 3) {
            reduzir();
        }
        return o;
    }

    @Override
    public int sizeV() {
        return tamPilhaVermelho;
    }

    @Override
    public int sizeP() {
        return tamPilhaPreta;
    }

    @Override
    public boolean isEmptyV() {
        return tamPilhaVermelho == 0;
    }

    @Override
    public boolean isEmptyP() {
        return tamPilhaPreta == 0;
    }

    @Override
    public boolean isEmpty() {
        return tamPilhaVermelho == 0 && tamPilhaPreta == 0;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
