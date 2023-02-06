package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;

public class Popolazione {

    private ArrayList<Individuo> lista;
    private int nElementi;
    //Da aggiustare


    public Popolazione(int nElementi) {
        lista = new ArrayList<>();
        this.nElementi = nElementi;
    }

    public ArrayList<Individuo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Individuo> lista) {
        this.lista = lista;
    }

    public int getnElementi() {
        return nElementi;
    }

    public void setnElementi(int nElementi) {
        this.nElementi = nElementi;
    }

    public void inizializza() throws IOException {
        for(int i=0; i<nElementi; i++){
            lista.add(new Individuo());
        }
        for(Individuo e: lista)
            e.crea();
    }

    public String toString(){
        String str = "";
        for(Individuo i: lista)
            str += i.toString();
        return str;
    }


/*
    public void inizializza(){

        int i = 0;
        for(i=0; i<nElementi; i++){
            lista.add(new Individuo(6));
        }

        for(Individuo e: lista)
        //deve creare una popolazione. quindi x individui(liste di 5 show)
            e.crea();

    }
*/
}
