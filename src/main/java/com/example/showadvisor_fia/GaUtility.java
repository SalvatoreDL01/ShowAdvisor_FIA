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

    public Individuo finndBestIndividuo(Popolazione popolazione){
        int pos = 0;
        double bestFit = 0;
        for(int k=0; k<popolazione.getLista().size(); k++){
            if(popolazione.getLista().get(k).getFitnessTotale() > bestFit){
                bestFit = popolazione.getLista().get(k).getFitnessTotale();
                pos = k;
            }
        }
        return popolazione.getLista().get(pos);
    }

    //metodo per la selezione di sizeMatingPool elementi
    public void selezione(Popolazione popolazione){
        fitness.calcolaFitnessPopolazione(popolazione);
        Collections.sort(popolazione.getLista(), (i1, i2) -> {
            return Double.compare(i1.getFitnessTotale(), i2.getFitnessTotale());
        });
        int i;
        for(i=sizeMatingPool; i<popolazione.getLista().size();){ //prendiamo i migliori mille
            popolazione.getLista().remove(i);
        }
    }

    //metodo per la mutazione di un singolo individuo
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

    //metodo per la mutazione di una popolazione di individui
    public void mutaPopolazione(Popolazione p) throws IOException {
        for(Individuo i: p.getLista())
            this.mutazione(i);
        fitness.calcolaFitnessPopolazione(p);
    }

    public void crossOver(Popolazione popolazione){
        Random random = new Random();
        int i;
        Individuo iCross1 = null;
        Individuo iCross2 = null;
        while(popolazione.getLista().size() < popolazione.getNumIndividui()){
            Individuo i1 = new Individuo(popolazione.getNumShow(), 0);
            iCross1 = popolazione.getLista().get(random.nextInt(sizeMatingPool - 1));
            iCross2 = popolazione.getLista().get(random.nextInt(sizeMatingPool - 1));
            int singlePoint = random.nextInt(popolazione.getLista().get(0).size());
            int j;
            for(j=0; j<popolazione.getLista().get(0).size(); j++){
                if(j < singlePoint)
                    i1.add(iCross1.get(j));
                else
                    i1.add(iCross2.get(j));
            }
            popolazione.getLista().add(i1);
        }
        fitness.calcolaFitnessPopolazione(popolazione);
    }
}
