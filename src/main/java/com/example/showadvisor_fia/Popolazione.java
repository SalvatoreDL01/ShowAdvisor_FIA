package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;

public class Popolazione{

    private ArrayList<Individuo> lista;
    private int nElementi;

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

    //metodo per inizializzare una popolazione di nElementi individui chiamando il metodo crea per ogni individuo
    public void inizializza(String tipo) throws IOException {
        for(int i=0; i<nElementi;){
            System.out.println("sno qui siuuuuuuuum");
            Individuo individuo = new Individuo(10, 0);
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
