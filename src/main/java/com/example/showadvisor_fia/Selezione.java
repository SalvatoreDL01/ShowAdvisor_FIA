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
/*
    public ArrayList<Individuo> selezione(Fitness f){
        individui = p.getLista();
        for(Individuo i : individui){
            FunzioneFitness.calcolaTotalFitness(f, i);
        }
        return this.orderByFitness();
    }

    private ArrayList<Individuo> orderByFitness(){

        ArrayList<Double> valori = new ArrayList<>();
        ArrayList<Individuo> ordinata = new ArrayList<>();

        for(int i = 0; i<individui.size(); i++)
            valori.add( i, individui.get(i).getFitnessTotale());
        Collections.sort(valori);
        int i = 0;
        int j = individui.size();
        int size = 0;
        while(j != i){
            for(Individuo individuo : individui){
                System.out.println("valore di fitness" + individuo.getFitnessTotale() + " individuo : " + individuo);
                if(individuo.getFitnessTotale() == valori.get(i)) {
                    ordinata.add(individuo);
                    size++;
                }
            }
            i++;
        }
        return ordinata;
    }
    */

    public ArrayList<Individuo> getIndividui() {
        return individui;
    }

    public void setIndividui(ArrayList<Individuo> individui) {
        this.individui = individui;
    }

    public Popolazione getP() {
        return p;
    }

    public void setP(Popolazione p) {
        this.p = p;
    }
}
