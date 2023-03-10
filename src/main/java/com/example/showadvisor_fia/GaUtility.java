package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.*;

public class GaUtility {
    private int sizeMatingPool, elementi;
    private Fitness fitness;
    private String tipo;

    public GaUtility(int sizeMatingPool,String tipo, Fitness f) throws IOException {
        this.sizeMatingPool = sizeMatingPool;
        if(tipo.equals("MOVIE"))
            elementi = 2444;
        else
            elementi = 722;
        this.fitness = f;
        this.tipo = tipo;
    }

    public void mutazione(Individuo i) throws IOException {
        int n, posizionePeggiore = 0;
        double valorePeggiore = fitness.fitnessShow(i.get(0));
        //ricerca dell'elemmento peggiore e salvataggio della sua posizione nell'individuo
        for(n=0; n<i.size(); n++){
            //System.out.println(fitness.fitnessShow(i.get(n)));
            if(fitness.fitnessShow(i.get(n)) < valorePeggiore){
                valorePeggiore = fitness.fitnessShow(i.get(n));
                posizionePeggiore = n;
            }
        }
        Random random = new Random();
        List<Show> showList = Parser.getInstance(tipo);
        i.set(posizionePeggiore, showList.get(random.nextInt(elementi)));
        fitness.calcolaFitness(i);
    }

    public void mutaPopolazione(Popolazione p) throws IOException {
        for(Individuo i: p.getLista()){
            this.mutazione(i);
        }
    }

    /*
    public Popolazione crossOver(Fitness f){
        Random random = new Random();
        int i;
        for(i=0; i<((popolazione.getnElementi()-sizeMatingPool)/2)-1; i++){
            Individuo i1 = new Individuo();
            Individuo i2 = new Individuo();
            Individuo iCross1 = popolazione.getLista().get(sizeMatingPool);
            Individuo iCross2 = popolazione.getLista().get(sizeMatingPool);
            int singlePoint = random.nextInt(popolazione.getLista().get(0).size());
            int j;
            for(j=0; j<popolazione.getLista().get(0).size()-1; j++){
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
        return popolazione;
    }

     */

    /*public Popolazione mutazione(Fitness f) throws IOException {
        int x = 0;
        if(tipo.equals("MOVIE"))
            //numero di film nel dataset
            x = 2444;
        else
            //numero di serie nel dataset
            x = 722;
        //estrae una lista dal dataset corrispondente alla tipologia selezionata
        List<Show> showList = Parser.getInstance(f.getTipo());

        ArrayList<Show> listShow = (ArrayList<Show>) showList;
        ArrayList<Individuo> list = popolazione.getLista();

        Random random = new Random();

        int n = random.nextInt(x);
        for(Individuo i: list){
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
                n = random.nextInt(x);
            }
            i.add(pos, listShow.get(n));
        }

        for(Individuo ind: popolazione.getLista())
            f.calcolaFitness(ind);

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
                System.out.println("valore di fitness" + individui.get(x).getFitnessTotale() + " individuo : " + individui.get(x));
                if(individui.get(x).getFitnessTotale() == valori.get(i)) {
                    ordinata.add(individui.get(x));
                    size++;
                }
            }
            i++;
        }
        return ordinata;
    }

     */
}
