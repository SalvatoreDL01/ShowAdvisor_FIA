package com.example.showadvisor_fia;

import java.io.IOException;
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

    public void crea() throws IOException {

        Random random = new Random();
        Show individuo;
        Show[] showList = Parser.getInstance();
        int i, n;
        for(i=0; i<nElementi; i++){
            n = random.nextInt(3000);
            individuo = showList[n];
            while(lista.contains(individuo)){
                n = random.nextInt(3000);
                individuo = showList[n];
            }
            lista.add(individuo);
        }

    }

    public List<Show> getLista() {
        return lista;
    }

    public void setLista(List<Show> lista) {
        this.lista = lista;
    }

    public String toString(){
        String str = "";
        for(Show s: lista)
            str += s.toString() + "\n";
        return  str;
    }
}
