package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.*;

public class GaUtility {
    private int sizeMatingPool;
    private ArrayList<Show> listaTitoli;
    private int elementi;
    private String tipo;
    private Popolazione popolazione;

    public GaUtility(int sizeMatingPool,String tipo, Popolazione p) throws IOException {
        this.sizeMatingPool = sizeMatingPool;
        this.tipo = tipo;
        if(tipo.equals("MOVIE"))
            elementi = 2444;
        else
            elementi = 722;
        popolazione = p;
    }

   public void calcola(Fitness f){
        for(Individuo i : popolazione.getLista())
            f.calcolaFitness(i);
   }

    public Popolazione crossOver(Fitness f){
        Random random = new Random();
        int i;
        for(i=0; i<((popolazione.getnElementi()-sizeMatingPool)/2)-1; i++){

            System.out.println("crossover 1");
            Individuo i1 = new Individuo();
            Individuo i2 = new Individuo();
            Individuo iCross1 = popolazione.getLista().get(sizeMatingPool);
            Individuo iCross2 = popolazione.getLista().get(sizeMatingPool);
            int singlePoint = random.nextInt(popolazione.getLista().get(0).size());
            int j;
            for(j=0; j<popolazione.getLista().get(0).size()-1; j++){
                System.out.println("crossover 2");
                if(j < singlePoint){
                    i1.add(iCross1.get(j));
                    i2.add(iCross2.get(j));
                }
                else{
                    i1.add(iCross2.get(j));
                    i2.add(iCross1.get(j));
                }
            }
            popolazione.getLista().add(i1);
            popolazione.getLista().add(i2);
        }
        System.out.println("\n\n");
        return popolazione;
    }

    public Popolazione mutazione(Fitness f) throws IOException {
        int x = 0;
        if(tipo.equals("MOVIE"))
            //numero di film nel dataset
            x = 2444;
        else
            //numero di serie nel dataset
            x = 722;
        //estrae una lista dal dataset corrispondente alla tipologia selezionata
        List<Show> showList = Parser.getInstance(this.tipo);

        ArrayList<Show> listShow = (ArrayList<Show>) showList;
        ArrayList<Individuo> list = popolazione.getLista();

        Random random = new Random();
/*
        int n = random.nextInt(x);
        for(Individuo i: list){

            System.out.println("mutazione 1");
            //inizio algoritmo per trovare l'elemento peggiore
            double min = 0;
            int pos = 0;
            for(int j =0; j<5; j++){
                f.calcolaFitness(i);
                double fit = i.getFitnessTotale();
                if(fit < min) {
                    min = fit;
                    pos = j;
                }
            }
            //fine algoritmo per trovare l'elemento peggiore
            while(i.contains(listShow.get(n))){

                System.out.println("mutazione 2");
                n = random.nextInt(x);
            }
            i.add(pos, listShow.get(n));
        }
*/
        System.out.println("grandezza lista : " + popolazione.getLista().size());
        for(Individuo ind: popolazione.getLista())
            f.calcolaFitness(ind);

        System.out.println("\n\n");
        return popolazione;
    }


    public ArrayList<Individuo> selezione(Fitness f){
        for(Individuo i : popolazione.getLista()){
            f.calcolaFitness(i);
        }
        return this.orderByFitness();
    }

    private ArrayList<Individuo> orderByFitness(){

        ArrayList<Double> valori = new ArrayList<>();
        ArrayList<Individuo> ordinata = new ArrayList<>();
        ArrayList<Individuo> individui = popolazione.getLista();

        for(int i = 0; i<popolazione.getLista().size(); i++)
            valori.add( i, popolazione.getLista().get(i).getFitnessTotale());
        Collections.sort(valori);
        int i = 0;
        int j = popolazione.getLista().size();
        int size = 0;
        while(j != i){
            for(int x = 0; x<sizeMatingPool; x++ ){
                System.out.println("seleziobee");
                if(individui.get(x).getFitnessTotale() == valori.get(i)) {
                    ordinata.add(individui.get(x));
                }
            }
            i++;
        }
        System.out.println("\n\n");
        return ordinata;

    }

    public int getSizeMatingPool() {
        return sizeMatingPool;
    }

    public void setSizeMatingPool(int sizeMatingPool) {
        this.sizeMatingPool = sizeMatingPool;
    }

    public ArrayList<Show> getListaTitoli() {
        return listaTitoli;
    }

    public void setListaTitoli(ArrayList<Show> listaTitoli) {
        this.listaTitoli = listaTitoli;
    }

    public int getElementi() {
        return elementi;
    }

    public void setElementi(int elementi) {
        this.elementi = elementi;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Popolazione getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(Popolazione popolazione) {
        this.popolazione = popolazione;
    }


}
