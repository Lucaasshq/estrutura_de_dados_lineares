package PilhaRubroNegro;

import pilhas.Pilha;
import pilhas.PilhaImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PilhaRubroNegro pp = new PilhaRubroNegroImpl(15);

        System.out.println("inserindo");
        for(int f=0;f<5;f++){
            System.out.println(f);
            pp.pushV(f);
        }
        System.out.println("retirando");
        for(int f=0;f<5;f++){
            pp.pushP(f);
        }

        pp.print();
        System.out.println(pp.popV());
        pp.pushV(5);
        pp.print();
        System.out.println(pp.topV());
        System.out.println(pp.topP());

//        pp.print();
//        System.out.println(pp.popP());
//        pp.pushP(55);
//        pp.print();
//        System.out.println(pp.topV());
//        System.out.println(pp.topP());

    }
}