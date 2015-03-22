package test;

import circuits.*;
import java.util.ArrayList;
import java.util.List;

public class TestCircuits {

    private static void printIds(Composant[] tab) {
        for (int i = 0; i < tab.length; i++)
            System.out.println(tab[i].getId());
    }

    private static void descriptions(Composant[] tab) {
        for (int i = 0; i < tab.length; i++)
            System.out.println(tab[i].description());
    }

    private static void traceEtats(Composant[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i].traceEtat());
        }
    }
    
    private static void test(Circuit circ) {
        //circ.nomenclature();
        circ.traceEtats();
        circ.probe();
        circ.traceEtats();
    }

    public static void main(String[] args) {
        //Construction
        Composant[] composants = new Composant[7];
        composants[0] = new Interrupteur();
        composants[1] = new Interrupteur();
        composants[2] = new Interrupteur();
        composants[3] = new Or();
        composants[4] = new And();
        composants[5] = new Not();
        composants[6] = new Vanne();

        //Connexions
        ((Vanne)composants[6]).setIn(composants[4]);
        ((And)composants[4]).setIn1(composants[3]);
        ((And)composants[4]).setIn2(composants[5]);
        ((Or)composants[3]).setIn1(composants[0]);
        //composants[0] = new LazySonde((Or)composants[3], "in1");
        ((Or)composants[3]).setIn2(composants[1]);
        ((Not)composants[5]).setIn(composants[2]);
        //((Not)composants[5]).setIn(new Sonde((Not)composants[5], "in1"));
        Circuit circuit = new Circuit("Circuit2ouf", composants);

        //Affichage
        /*System.out.println("Liste des composants");
        printIds(composants);

        System.out.println("\nDescription des composants");
        descriptions(composants);

        System.out.println("\nEtat des composants");
        traceEtats(composants);
        */
        
        test(circuit);

        System.out.println("\nAu revoir!");
    }
}
