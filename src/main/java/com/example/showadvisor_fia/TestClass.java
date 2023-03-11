package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Popolazione popolazione = new Popolazione(10, 5);
        popolazione.inizializza("MOVIE");
        ArrayList<String> listaGeneri = new ArrayList<>();
        listaGeneri.add("action");
        listaGeneri.add("comedy");
        Fitness fitness = new Fitness("MOVIE", 0, 0, listaGeneri);
        fitness.calcolaFitnessPopolazione(popolazione);
        System.out.println(popolazione + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        GaUtility utility = new GaUtility(2, "MOVIE", fitness);
        utility.selezione(popolazione);
        for(Individuo i: popolazione.getLista())
            System.out.println(fitness.calcolaFitness(i));
    }
}