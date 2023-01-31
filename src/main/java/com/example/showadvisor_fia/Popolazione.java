package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;

public class Popolazione {

    private ArrayList<Individuo> lista;
    private int nElementi;

    public Popolazione(int n){

        lista = new ArrayList<>();
        nElementi = n;

    }

    public void inizializza() throws IOException {

        int i = 0;
        for(i=0; i<nElementi; i++){
            lista.add(new Individuo(8));
        }

        for(Individuo e: lista)
            e.crea();

    }

    public ArrayList<Individuo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Individuo> lista) {
        this.lista = lista;
    }

    public String toString(){
        String str = "";
        for(Individuo i: lista)
            str += i.toString();
        return str;
    }

}
