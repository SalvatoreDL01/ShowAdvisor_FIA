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


    public ArrayList<Individuo> selezione(Fitness f) {

        individui = p.getLista();
        return orderByFitness(individui, f);
    }

    //funzione che ordina la lista in base al valore di ogni individuo
    public static ArrayList<Individuo> orderByFitness(ArrayList<Individuo> individui, Fitness f) {

        ArrayList<Individuo> ordinata = new ArrayList<>();
        individui.sort(new SortIndividuiByNGeneri());
        do {
            ArrayList<Individuo> subList = new ArrayList<>();
            double numeroPrimi = individui.get(0).getnShowGeneri();

            for (Individuo i : individui) {
                //selezione per generi
                if (numeroPrimi == i.getnShowGeneri()) {
                    subList.add(i);
                }
                else {
                    numeroPrimi = i.getnShowGeneri();
                    break;
                }
            }
            subList.sort(new SortIndividuiByNRuntime());
            ArrayList<Individuo> subList1 = new ArrayList<>();
            int tipo = subList.get(0).getnShowRuntime();

            if (f.getTipologia().equals("SHOW")) {
                int runtime = subList.get(0).getnShowRuntime();
                for (Individuo i : subList) {
                    if (runtime == i.getnShowRuntime()) {
                        subList1.add(i);
                    } else {
                        runtime = i.getnShowRuntime();
                        break;
                    }
                }
                subList1.sort(new SortIndividuiByNSeason());
                tipo = subList1.get(0).getsSeasonsCorrette();
            } else
                subList1 = subList;

            ArrayList<Individuo> subList2 = new ArrayList<>();

            for (Individuo i : subList1) {
                if (f.getTipologia().equals("SHOW"))
                    if (tipo == i.getsSeasonsCorrette())
                        subList2.add(i);
                    else {
                        tipo = i.getsSeasonsCorrette();
                        break;
                    }
                else {
                    if (tipo == i.getnShowRuntime())
                        subList2.add(i);
                    else {
                        tipo = i.getsSeasonsCorrette();
                        break;
                    }
                }
            }
            subList2.sort(new SortIndividuiByScoreMedio());

            for (Individuo i : subList2)
                if (ordinata.size() < 4)
                    ordinata.add(i);
                else
                    break;

        }
        while(ordinata.size() < 4) ;

        return ordinata;

        /*
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
            i++;*/
    }

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
