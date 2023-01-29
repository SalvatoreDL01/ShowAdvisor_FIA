package com.example.showadvisor_fia;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individuo {

    private List<Show> lista;
    private int nElementi;

    public Individuo(int n){

        lista = new ArrayList<>();
        nElementi = n;

    }

    public void crea(){

        //creazione di un individuo in maniera casuale

    }

    public boolean add(Show s){

        if(lista.size() > nElementi)
            return false;
        else{
            lista.add(s);
            return true;
        }

    }

    public Show get(int i){

        return lista.get(i);

    }

    public void replace(int i, Show s){

        lista.set(i, s);

    }

    public Show remove(int i){

        return lista.remove(i);

    }

    public void remove(Show s){

        lista.remove(s);

    }

}
