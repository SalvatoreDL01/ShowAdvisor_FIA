package com.example.showadvisor_fia;

import java.util.List;

public class FunzioneFitness {

    private final static double RUNTIMESERIECORTA = 27;
    private final static double RUNTIMESERIELUNGA = 44;
    private final static double CORTOMETRAGGIO = 75;
    private final static double LUNGOMETRAGGIO = 100;

    /*Metodo che calcola il valore di fitness di uno show*/
    public static double calcolaIndividualFitness(Individuo i,Show s,Fitness f){
        i.setScoreMedio(i.getScoreMedio()+s.getScore());
        double tot;
        if(s.getType().equals("MOVIE"))
            tot =Math.pow(s.getScore()* calcolaFitnessLunghezzaFilm(i.getnShowRuntime(),s.getRuntime(),f.getRuntimeDesiderato()),
                    calcolaFitnessGeneri(i.getnShowGeneri(),s.getGenres(),f.getGeneri()));
        else
            tot =Math.pow(s.getScore()*calcolaFitnessLunghezzaSeire(i.getnShowRuntime(),s.getRuntime(),f.getRuntimeDesiderato())
                    * calcolaFitnessSeasons(i.getsSeasonsCorrette(),Integer.parseInt(s.getSeasons()), f.getMax(), f.getTipologia())
                    ,calcolaFitnessGeneri(i.getnShowGeneri(),s.getGenres(),f.getGeneri()));
        s.setIndividualFitness(tot);
        return tot;
    }
    /*Metodo che calcola il valore della funzione di fitness dipendente dal numero di generi conosciuti.*/
    public static double calcolaFitnessGeneri(Integer i,String generiShow, List<String> desiderati){
        double punteggio=1;
        int iniziale = i;
        for(String genere: desiderati){
            if(generiShow.contains(genere)){
                punteggio += 1;
                if(i==iniziale)
                i++;
            }
        }
        if(punteggio == 1)
            return -desiderati.size();
        return punteggio;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaSeire(Integer i,double runtime, String lunghezza){
        if(runtime==0)
            return 0.5;
        if(lunghezza.equals("corta"))
            if(runtime<=RUNTIMESERIECORTA){
                i++;
                return 3.0;
            }
        else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=RUNTIMESERIELUNGA){
                i++;
                return 3.0;
            }
            else return 0.5;
        if(runtime>RUNTIMESERIECORTA && runtime<RUNTIMESERIELUNGA){
            i++;
            return 3.0;
        }
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal numero di stagioni massimo*/
    public static double calcolaFitnessSeasons(Integer i,int seasons, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max){
            i++;
            return 2;
        }
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal'intervallo di stagioni
    desiderate*/
    public static double calcolaFitnessSeasons(Integer i,int seasons,int min, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max && seasons >= min){
            i++;
            return 2;
        }
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su un film, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaFilm(Integer i,double runtime, String lunghezza){
        if(lunghezza.equals("corta"))
            if(runtime<=CORTOMETRAGGIO){
                i++;
                return 3.0;
            }
            else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=LUNGOMETRAGGIO){
                i++;
                return 3.0;
            }
            else return 0.5;
        if(runtime>CORTOMETRAGGIO && runtime<LUNGOMETRAGGIO){
            i++;
            return 3.0;
        }
        return 0.5;
    }
    /*Metodo che calcola la funzione di fitness di un individuo della popolazione e ordina il cuo contenuto per valore
     di fitness*/
    public static double calcolaTotalFitness(Fitness f, Individuo i){
        double tot=0;
        i.setFitnessTotale(0);
        i.setnShowRuntime(0);
        i.setScoreMedio(0.0);
        i.setsSeasonsCorrette(0);
        i.setnShowGeneri(0);
        for(Show s: i){
            tot += calcolaIndividualFitness(i,s,f);
        }
        i.setScoreMedio(i.getScoreMedio()/i.size());
        i.setFitnessTotale(tot/i.size());

        return tot/i.size();
    }




    /*Metodo che calcola il valore di fitness di uno show*/
    public static double calcolaNumericIndividualFitness(Show s,Fitness f){
        double tot;
        if(s.getType().equals("MOVIE"))
            tot =Math.pow(s.getScore()* calcolaFitnessLunghezzaFilm(s.getRuntime(),f.getRuntimeDesiderato()),
                    calcolaFitnessGeneri(s.getGenres(),f.getGeneri()));
        else
            tot =Math.pow(s.getScore()*calcolaFitnessLunghezzaSeire(s.getRuntime(),f.getRuntimeDesiderato())
                            * calcolaFitnessSeasons(Integer.parseInt(s.getSeasons()), f.getMax(), f.getTipologia())
                    ,calcolaFitnessGeneri(s.getGenres(),f.getGeneri()));
        s.setIndividualFitness(tot);
        return tot;
    }
    /*Metodo che calcola il valore della funzione di fitness dipendente dal numero di generi conosciuti.*/
    public static double calcolaFitnessGeneri(String generiShow, List<String> desiderati){
        double punteggio=1;
        for(String genere: desiderati){
            if(generiShow.contains(genere))
                punteggio += 1;
        }
        if(punteggio == 1)
            return -desiderati.size();
        return punteggio;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dalla lunghezza desiderata*/
    public static double calcolaFitnessLunghezzaSeire(double runtime, String lunghezza){
        if(runtime==0)
            return 0.5;
        if(lunghezza.equals("corta"))
            if(runtime<=RUNTIMESERIECORTA){
                return 3.0;
            }
            else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=RUNTIMESERIELUNGA){
                return 3.0;
            }
            else return 0.5;
        if(runtime>RUNTIMESERIECORTA && runtime<RUNTIMESERIELUNGA){
            return 3.0;
        }
        return 0.5;
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal numero di stagioni massimo*/
    public static double calcolaFitnessSeasons(int seasons, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max){
            return 2;
        }
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
            if(runtime<=CORTOMETRAGGIO){
                return 3.0;
            }
            else return 0.5;
        if(lunghezza.equals("lunga"))
            if(runtime>=LUNGOMETRAGGIO){
                return 3.0;
            }
            else return 0.5;
        if(runtime>CORTOMETRAGGIO && runtime<LUNGOMETRAGGIO){
            return 3.0;
        }
        return 0.5;
    }
}
// i.sort(new SortShowByFitness());