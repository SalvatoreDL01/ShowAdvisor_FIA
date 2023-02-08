package com.example.showadvisor_fia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// usata la tecnica truncation

public class Selezione {

    private ArrayList<Individuo> individui;
    private Popolazione p;
    private FunzioneFitness funzioneFitness;
    private ArrayList<Individuo> risultati;


    public ArrayList<Individuo> selezione(Fitness f){

        individui = p.getLista();

        //calcolo del valore della funzione di fitness per ogni individuo
        for(Individuo i : individui)
            i.setFitnessTotale(funzioneFitness.calcolaTotalFitness(f, i));

        //ordinamento della lista per valore di fitness totale
        ArrayList<Individuo> risultatiOrdinati = orderByFitness(individui);

        for(int i = 0; i<5; i++)
            risultati.add(risultatiOrdinati.get(i));

        return risultati;
    }

    //funzione che ordina la lista in base al valore di ogni individuo
    public static ArrayList<Individuo> orderByFitness(ArrayList<Individuo> individui){

        ArrayList<Individuo> ordinata = new ArrayList<>();
        ArrayList<Double> valori = new ArrayList();

        for(int i = 0; i<individui.size(); i++)
            valori.add( i, individui.get(i).getFitnessTotale());
        Collections.sort(valori);
        int i = 0;
        int j = individui.size();
        while(j != i){
            for(Individuo individuo : individui){
                if(individuo.getFitnessTotale() == valori.get(i))
                    ordinata.add(individuo);
            }
            i++;
        }

        return ordinata;
    }


}
