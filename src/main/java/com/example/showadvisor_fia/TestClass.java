package com.example.showadvisor_fia;


import java.io.IOException;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Popolazione popolazione = new Popolazione(500, 5);
        popolazione.inizializza("MOVIE");
        ArrayList<Integer> lista = new ArrayList<>();
        Individuo newIndividuo;
        Individuo max = new Individuo (5, 0);
        for(int i = 0; i< 500; i++){
            newIndividuo = evoluzione(popolazione);
            if(newIndividuo.getFitnessTotale() > max.getFitnessTotale() )
                max = newIndividuo;
            System.out.println("("+i+","+newIndividuo.getFitnessTotale()+")");
        }
        System.out.println(max);
        System.out.println("fitness  "+ max.getFitnessTotale());

    }

    public static Individuo evoluzione( Popolazione popolazione) throws IOException{
        ArrayList<String> listaGeneri = new ArrayList<>();
        listaGeneri.add("reality");
        listaGeneri.add("music");
        listaGeneri.add("sport");
        Fitness fitness = new Fitness("MOVIE", 0, 0, listaGeneri, 80, 100);
        GaUtility utility = new GaUtility(550, "MOVIE", fitness);

        utility.selezione(popolazione);
        utility.crossOver(popolazione);
        for(int i = 0; i<4; i++)
            utility.mutaPopolazione(popolazione);

        fitness.calcolaFitnessPopolazione(popolazione);
        return utility.finndBestIndividuo(popolazione);
    }

    public void test(int i, int n, int l){
        //metodo per il test
    }
}