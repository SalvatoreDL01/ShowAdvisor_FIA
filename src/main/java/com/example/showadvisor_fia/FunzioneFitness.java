package com.example.showadvisor_fia;

import java.util.List;

public class FunzioneFitness {

    private final static double RUNTIMESERIECORTA = 27;
    private final static double RUNTIMESERIELUNGA = 50;
    private final static double CORTOMETRAGGIO = 50;
    private final static double LUNGOMETRAGGIO = 75;

    /*Metodo che calcola il valore di fitness di uno show*/
    public static double calcolaIndividualFitness(Show s,Fitness f){
        double tot;
        if(s.getType().equals("MOVIE"))
            tot = s.getScore()*calcolaFitnessGeneri(s.getGenres(),f.getGeneri())*
                    calcolaFitnessLunghezzaFilm(s.getRuntime(),f.getRuntimeDesiderato());
        else
            tot = s.getScore()*calcolaFitnessGeneri(s.getGenres(),f.getGeneri())*calcolaFitnessLunghezzaSeire
                    (s.getRuntime(),f.getRuntimeDesiderato())*
                    calcolaFitnessSeasons(Integer.parseInt(s.getSeasons()), f.getMax(), f.getTipologia());
        s.setIndividualFitness(tot);
        return tot;
    }
    /*Metodo che calcola il valore della funzione di fitness dipendente dal numero di generi conosciuti.*/
    public static double calcolaFitnessGeneri(String generiShow, List<String> desiderati){
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
    public static double calcolaFitnessLunghezzaSeire(double runtime, String lunghezza){
        if(runtime==0)
            return 0.5;
        if(lunghezza.equals("corta"))
            if(runtime<=RUNTIMESERIECORTA)
            return 3.0;
        else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=RUNTIMESERIELUNGA)
                return 3.0;
            else return 0.5;
        if(runtime>RUNTIMESERIECORTA && runtime<RUNTIMESERIELUNGA)
            return 3.0;
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal numero di stagioni massimo*/
    public static double calcolaFitnessSeasons(int seasons, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max)
            return 2;
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal'intervallo di stagioni
    desiderate*/
    public static double calcolaFitnessSeasons(int seasons,int min, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max && seasons >= min)
            return 2;
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su un film, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaFilm(double runtime, String lunghezza){
        if(lunghezza.equals("corta"))
            if(runtime<=CORTOMETRAGGIO)
                return 3.0;
            else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=LUNGOMETRAGGIO)
                return 3.0;
            else return 0.5;
        if(runtime>CORTOMETRAGGIO && runtime<LUNGOMETRAGGIO)
            return 3.0;
        return 0.5;
    }
    /*Metodo che calcola la funzione di fitness di un individuo della popolazione e ordina il cuo contenuto per valore
     di fitness*/
    public static double calcolaTotalFitness(Fitness f, Individuo i){
        double tot=0;
        for(Show s: i){
            tot += calcolaIndividualFitness(s,f);
        }
        i.setFitnessTotale(tot/i.size());

        return tot/i.size();
    }
}
// i.sort(new SortShowByFitness());