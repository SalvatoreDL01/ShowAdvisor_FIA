package com.example.showadvisor_fia;

import java.util.ArrayList;

public class Popolazione {

    private ArrayList<Individuo> lista;
    private int nElementi;

    public Popolazione(int n){

        lista = new ArrayList<>();
        nElementi = n;

    }

    public void inizializza(){

        int i = 0;
        for(i=0; i<nElementi; i++){
            lista.add(new Individuo(6));
        }

        for(Individuo e: lista)
            e.crea();

    }

}
