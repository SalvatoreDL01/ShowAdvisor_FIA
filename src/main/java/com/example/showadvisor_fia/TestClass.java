package com.example.showadvisor_fia;


import java.io.IOException;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Popolazione popolazione = new Popolazione(800, 5);
        popolazione.inizializza("MOVIE");
        ArrayList<Integer> lista = new ArrayList<>();
        Individuo newIndividuo;
        Individuo max = new Individuo (5, 0);
        for(int i = 0; i< 1000; i++){
            newIndividuo = evoluzione(popolazione);
            if(newIndividuo.getFitnessTotale() > max.getFitnessTotale() )
                max = newIndividuo;
            System.out.println("("+i+","+newIndividuo.getFitnessTotale()+")");
        }
        System.out.println(max);
        System.out.println("fitness  "+ max.getFitnessTotale());
        /*for(int i=1; i<5000; i += 70){
            System.out.println("(" + i + ", " + evoluzione(i) + ")");
        }*/

    }

    public static Individuo evoluzione( Popolazione popolazione) throws IOException{
        ArrayList<String> listaGeneri = new ArrayList<>();
        listaGeneri.add("reality");
        listaGeneri.add("music");
        listaGeneri.add("sport");
        Fitness fitness = new Fitness("MOVIE", 0, 0, listaGeneri, 80, 100);
        GaUtility utility = new GaUtility(700, "MOVIE", fitness);

        utility.selezione(popolazione);
        utility.crossOver(popolazione);
        for(int i = 0; i<4; i++)
            utility.mutaPopolazione(popolazione);

        fitness.calcolaFitnessPopolazione(popolazione);
        return utility.finndBestIndividuo(popolazione);
    }
}