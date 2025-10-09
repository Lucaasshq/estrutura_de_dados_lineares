package pilhas.PilhaRubroNegro;

public class Main {
    public static void main(String[] args) {
        PilhaRubroNegro pp = new PilhaRubroNegroImpl(10);

        /**
         Calculado PUSH
         */
        long tempPushV = System.nanoTime();
        System.out.println("PushV");
        for(int f=0;f<10001;f++){
            pp.pushV(f);
        }
        long tempPushVFinal = System.nanoTime() - tempPushV;

        long tempPushP = System.nanoTime();
        System.out.println("PushP");
        for(int f=0;f<10001;f++){
            pp.pushP(f);
        }
        pp.print();
        long tempPushPFinal = System.nanoTime() - tempPushP;

        /**
         Calculado POP
         */
        long tempPopVInicial = System.nanoTime();
        System.out.println("PushV");
        for(int f=0;f<10000;f++){
            pp.popV();
        }
        long tempPopVFinal = System.nanoTime() - tempPopVInicial;

        long tempPopPInicial = System.nanoTime();
        System.out.println("PushP");
        for(int f=0;f<10000;f++){
            pp.popP();
        }
        long tempPopPFinal = System.nanoTime() - tempPopPInicial;
//        pp.print();
//        System.out.println(pp.popV());
//        pp.pushV(5);
//        pp.print();
//        System.out.println(pp.topV());
//        System.out.println(pp.topP());

      // pp.print();
       // System.out.println(pp.popP());
       // pp.pushP(55);
        System.out.println("""
                ==========Tempo de execução==========
                """);
        System.out.println("PushV ns: "+ tempPushVFinal);
        System.out.println("PushP ns: "+ tempPushPFinal);
        System.out.println("PopV ns: "+ tempPopVFinal);
        System.out.println("PopP ns: "+ tempPopPFinal);
    }
}