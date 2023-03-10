package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;

public class Popolazione{

    private ArrayList<Individuo> lista;
    private int numIndividui, numShow;

    public Popolazione(int numIndividui, int numShow) {
        lista = new ArrayList<>();
        this.numIndividui = numIndividui;
        this.numShow = numShow;
    }

    public ArrayList<Individuo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Individuo> lista) {
        this.lista = lista;
    }

    //metodo per inizializzare una popolazione di nElementi individui chiamando il metodo crea per ogni individuo
    public void inizializza(String tipo) throws IOException {
        for(int i=0; i<numIndividui;){
            Individuo individuo = new Individuo(numShow, 0);
            individuo.crea(tipo);
            if(!lista.contains(individuo)){
                lista.add(individuo);
                i++;
            }
        }
    }

    public String toString(){
        String str = "";
        for(Individuo i: lista)
            str += i.toString();
        return str;
    }

}
