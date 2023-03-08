package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GaUtility {

    private int sizeMatingPool;
    private ArrayList<Show> listaTitoli;
    private int elementi;
    private Popolazione popolazione;

    public GaUtility(int sizeMatingPool, String tipo, Popolazione p) throws IOException {
        this.sizeMatingPool = sizeMatingPool;
        if(tipo.equals("MOVIE")) {
            listaTitoli = (ArrayList<Show>) new Parser().getListFilm();
            elementi = 2444;
        }
        else {
            listaTitoli = (ArrayList<Show>) new Parser().getListSerie();
            elementi = 722;
        }
        popolazione = p;
    }

    public Popolazione crossOver(Fitness f){
        Random random = new Random();
        Individuo i1 = null;
        Individuo i2 = null;
        int i;
        for(i=0; i<((popolazione.getnElementi()-sizeMatingPool)/2)-1; i++){
            Individuo iCross1 = popolazione.getLista().get(sizeMatingPool);
            Individuo iCross2 = popolazione.getLista().get(sizeMatingPool);
            int singlePoint = random.nextInt(popolazione.getLista().get(0).size());
            int j;
            for(j=0; j<popolazione.getLista().get(0).size()-1; j++){
                if(j < singlePoint){
                    //
                }
                else{
                    //
                }
            }
        }
    }

    static public Popolazione mutazione(Popolazione p, Fitness f) throws IOException {
        int x = 0;
        if(f.getTipologia().equals("MOVIE"))
            //numero di film nel dataset
            x = 2444;
        else
            //numero di serie nel dataset
            x = 722;
        //estrae una lista dal dataset corrispondente alla tipologia selezionata
        List<Show> showList = Parser.getInstance(f.getTipologia());

        ArrayList<Show> listShow = (ArrayList<Show>) showList;
        ArrayList<Individuo> list = p.getLista();

        Random random = new Random();

        int n = random.nextInt(x);
        for(Individuo i: list){
            //inizio algoritmo per trovare l'elemento peggiore
            double min = 0;
            int pos = 0;
            for(int j =0; j<5; j++){
                double fit = FunzioneFitness.calcolaNumericIndividualFitness(i.get(j), f);
                if(fit < min) {
                    min = fit;
                    pos = j;
                }
            }
            //fine algoritmo per trovare l'elemento peggiore
            while(i.contains(listShow.get(n))){
                n = random.nextInt(x);
            }
            i.add(pos, listShow.get(n));
        }

        for(Individuo ind: p.getLista())
            FunzioneFitness.calcolaTotalFitness(f, ind);

        return p;

    }

}
