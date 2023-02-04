package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GaUtility {

    static public Popolazione crossOver(Popolazione p){

        ArrayList<Show> l1 = new ArrayList<>();
        ArrayList<Show> l2 = new ArrayList<>();
        ArrayList<Show> l3 = new ArrayList<>();
        ArrayList<Show> l4 = new ArrayList<>();

        int i = p.getLista().get(0).getLista().size();
        Random random = new Random();
        int crossOverPoint = random.nextInt(8);
        for(int j=0; j<i; j++){
            if(j < crossOverPoint){
                l1.add(p.getLista().get(0).getLista().get(j));
                l2.add(p.getLista().get(1).getLista().get(j));
            }
            else{
                l2.add(p.getLista().get(0).getLista().get(j));
                l1.add(p.getLista().get(1).getLista().get(j));
            }

        }
        for(int j=0; j<i; j++){
            if(j < crossOverPoint){
                l3.add(p.getLista().get(2).getLista().get(j));
                l4.add(p.getLista().get(3).getLista().get(j));
            }
            else{
                l4.add(p.getLista().get(2).getLista().get(j));
                l3.add(p.getLista().get(3).getLista().get(j));
            }

        }

        Individuo individuo = new Individuo(8);
        individuo.setLista(l1);
        p.getLista().add(individuo);
        individuo.setLista(l2);
        p.getLista().add(individuo);
        individuo.setLista(l3);
        p.getLista().add(individuo);
        individuo.setLista(l4);
        p.getLista().add(individuo);

        return p;

    }

    static public Popolazione mutazione(Popolazione p) throws IOException {

        Show[] showList = Parser.getInstance();
        ArrayList<Individuo> lista = p.getLista();
        Random random = new Random();
        int n = random.nextInt(3000);
        for(Individuo i: lista){
            while(i.getLista().contains(showList[n])){
                n = random.nextInt(3000);
            }
            int pos = random.nextInt(8);
            i.getLista().add(pos, showList[n]);
        }

        return p;

    }

}
