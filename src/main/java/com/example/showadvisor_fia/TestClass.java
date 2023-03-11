package com.example.showadvisor_fia;

import javax.management.InstanceNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Popolazione popolazione = new Popolazione(1000, 10);
        popolazione.inizializza("MOVIE");
        ArrayList<String> listaGeneri = new ArrayList<>();
        listaGeneri.add("action");
        listaGeneri.add("comedy");
        listaGeneri.add("european");
        Fitness fitness = new Fitness("MOVIE", 0, 0, listaGeneri);
        GaUtility utility = new GaUtility(5, "MOVIE", fitness);
        int nBest = 0;
        while(nBest > 5){
            nBest = 0;
            utility.selezione(popolazione);
            utility.crossOver(popolazione);
            utility.mutaPopolazione(popolazione);
            for(Show s: utility.finndBestIndividuo(popolazione)){
                if(fitness.fitnessShow(s) > 100)
                    nBest += 1;
            }
        }
        fitness.calcolaFitnessPopolazione(popolazione);
        System.out.println(utility.finndBestIndividuo(popolazione) + "\n" + fitness.calcolaFitness(utility.finndBestIndividuo(popolazione)));
        for(Show s: utility.finndBestIndividuo(popolazione)){
            System.out.println(fitness.fitnessShow(s));
        }
    }
}