package com.example.showadvisor_fia;

import java.util.List;

public class FunzioneFitness {
    private static int SEASONCORTS = 2;
    private static int SEASONLUNGA = 4;
    private static double RUNTIMESERIECORTA = 27;
    private static double RUNTIMESERIELUNGA = 50;
    private static double CORTOMETRAGGIO = 15;
    private static double LUNGOMETRAGGIO = 75;
    /*Metodo che calcola il valore di fitness di uno show*/
    public static double calcolaIndividualFitness(Show s,Fitness f){
        double type;
        double tot;
        if(s.getType().equals(f.getTipologia()))
            type=2.0;
        else
            type=0.5;
        if(s.getType().equals("MOVIE"))
            tot = s.getScore()*type*calgolaFitnessGeneri(s.getGenres(),f.getGeneri())*calcolaFitnessLunghezzaFilm(s.getRuntime(),f.getRuntimeDesiderato());
        else
            tot = s.getScore()*type*calgolaFitnessGeneri(s.getGenres(),f.getGeneri())*calcolaFitnessLunghezzaSeire(Integer.parseInt(s.getSeasons()),s.getRuntime(),f.getRuntimeDesiderato());
        s.setIndividualFitness(tot);
        return tot;
    }
    /*Metodo che calcola il valore della funzione di fitness dipendente dal numero di generi conosciuti.*/
    public static double calgolaFitnessGeneri(String generiShow, List<String> desiderati){
        double punteggio=0;
        for(String genere: desiderati){
            if(generiShow.contains(genere))
                punteggio += 1;
        }
        if(punteggio == 0)
            return 0.5;
        return punteggio;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaSeire(int seasons, double runtime, String lunghezza){
        if(seasons==0)
            return 0.5;
        if(lunghezza.equals("corta"))
            return (SEASONCORTS/seasons)*(RUNTIMESERIECORTA/runtime);
        if(lunghezza.equals("lunga"))
            return (seasons/SEASONLUNGA)*(runtime/RUNTIMESERIELUNGA);
        if(seasons>SEASONCORTS && seasons<SEASONLUNGA && runtime>RUNTIMESERIECORTA && runtime<RUNTIMESERIELUNGA)
            return 3.0;
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su un film, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaFilm(double runtime, String lunghezza){
        if(lunghezza.equals("corta"))
            return (CORTOMETRAGGIO/runtime);
        if(lunghezza.equals("lunga"))
            return (runtime/LUNGOMETRAGGIO);
        if(runtime>CORTOMETRAGGIO && runtime<LUNGOMETRAGGIO)
            return 3.0;
        return 0.5;
    }
    /*Metodo che calcola la funzione di fitness di un individuo della popolazione e ordina il cuo contenuto per valore di fitness*/
    public static void calcolaTotalFitness(Fitness f, Individuo i){
        double tot=0;
        for(Show s: i){
            tot += calcolaIndividualFitness(s,f);
        }
        i.setFitnessTotale(tot);
        //l'ordinamento per fitness può essere ritardato a poco prima di stampare la lista all'utente
        i.sort(new SortShowByFitness());
    }
}
