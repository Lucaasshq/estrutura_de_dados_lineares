package pilhas;

public class Main {
    public static void main(String[] args) {
        Integer[] b = new Integer[1];
        Pilha pp = new PilhaImpl(1,0);

        System.out.println("inserindo");
        for(int f=0;f<10;f++){
//            System.out.println(f);
            pp.push(f);
        }
//        System.out.println("retirando");
//        for(int f=0;f<10;f++){
//            System.out.print(f);
//            System.out.println(" - "+pp.pop());
//        }
        pp.print();
    }
}