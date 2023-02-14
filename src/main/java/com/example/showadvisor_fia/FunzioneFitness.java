package com.example.showadvisor_fia;

import java.util.List;

public class FunzioneFitness {

    private final static double RUNTIMESERIECORTA = 27;
    private final static double RUNTIMESERIELUNGA = 44;
    private final static double CORTOMETRAGGIO = 80;
    private final static double LUNGOMETRAGGIO = 120;
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dalla lunghezza desiderata*/
    public static void calcolaFitnessLunghezzaSeire(Individuo i,double runtime, String lunghezza){
        if(lunghezza.equals("corta"))
            if(runtime<=RUNTIMESERIECORTA){
                i.setnShowRuntime(i.getnShowRuntime()+1);
            }
        if(lunghezza.equals("lunga"))
            if(runtime>=RUNTIMESERIELUNGA){
                i.setnShowRuntime(i.getnShowRuntime()+1);
            }
        if(runtime>RUNTIMESERIECORTA && runtime<RUNTIMESERIELUNGA){
            i.setnShowRuntime(i.getnShowRuntime()+1);
        }
    }
    /*Metodo che calcola i valori di fitness di uno show*/
    public static void calcolaIndividualFitness(Individuo i,Show s,Fitness f){
        //aggiunge lo score allo score medio per ottenere quello totale
        i.setScoreMedio(i.getScoreMedio()+s.getScore());
        //calcola il numero totale di generi sull'individuo che rispecchiano quelli selezionati dall'utente
        calcolaFitnessGeneri(i,s.getGenres(),f.getGeneri());
        if(s.getType().equals("SHOW")){
            //calcola il numero di serie che si trovano in quell'intervallo di runtime
            calcolaFitnessLunghezzaSeire(i,s.getRuntime(),f.getRuntimeDesiderato());
            //calcola in numero di serie che rispecchiano l'intervallo di stagioni specificato
            calcolaFitnessSeasons(i,Integer.parseInt(s.getSeasons()),f.getMin(), f.getMax(),f.getTipologia());
        }
        else
            //calcola il numero di film che si trovano in quell'intervallo di runtime
            calcolaFitnessLunghezzaFilm(i,s.getRuntime(),f.getRuntimeDesiderato());
    }
    /*Metodo che calcola il valore della funzione di fitness dipendente dal numero di generi conosciuti.*/
    public static void calcolaFitnessGeneri(Individuo i,String generiShow, List<String> desiderati){
        for(String genere: desiderati){
            if(generiShow.contains(genere)){
                i.setnShowGeneri(i.getnShowGeneri()+1);
            }
        }
    }

    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal numero di stagioni massimo*/
    public static void calcolaFitnessSeasons(Individuo i,int seasons, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
        if(seasons <= max){
            i.setsSeasonsCorrette(i.getsSeasonsCorrette()+1);
        }
    }
    /*Metodo che calcola il valore della funzione di fitness, su una serie, dipendente dal'intervallo di stagioni
    desiderate*/
    public static void calcolaFitnessSeasons(Individuo i,int seasons,int min, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return;
        if(seasons <= max && seasons >= min){
            i.setsSeasonsCorrette(i.getsSeasonsCorrette()+1);
        }
    }
    /*Metodo che calcola il valore della funzione di fitness, su un film, dipendente dalla lunghezza desiderata*/
    public static void calcolaFitnessLunghezzaFilm(Individuo i,double runtime, String lunghezza){
        if(lunghezza.equals("corta"))
            if(runtime<=CORTOMETRAGGIO){
                i.setnShowRuntime(i.getnShowRuntime()+1);
            }
        else return;
        if(lunghezza.equals("lunga"))
            if(runtime>=LUNGOMETRAGGIO){
                i.setnShowRuntime(i.getnShowRuntime()+1);
            }
            else return;
        if(runtime>CORTOMETRAGGIO && runtime<LUNGOMETRAGGIO){
            i.setnShowRuntime(i.getnShowRuntime()+1);
        }
    }
    /*Metodo che calcola la funzione di fitness di un individuo della popolazione */
    public static void calcolaTotalFitness(Fitness f, Individuo i){
        //azzeramento dei valori di fitness
        i.setFitnessTotale(0);
        i.setnShowRuntime(0);
        i.setScoreMedio(0.0);
        i.setsSeasonsCorrette(0);
        i.setnShowGeneri(0.0);
        for(Show s: i){
            calcolaIndividualFitness(i,s,f);
        }
        //fa la media dei generi rispecchiati sui vari show dell'individuo
        i.setnShowGeneri(i.getnShowGeneri()/i.size());
        //fa la media dello score dell'individuo
        i.setScoreMedio(i.getScoreMedio()/i.size());
    }

    /*Metodo che calcola il valore di uno show*/
    public static double calcolaNumericIndividualFitness(Show s,Fitness f){
        double tot;
        if(s.getType().equals("MOVIE"))
            tot =Math.pow(s.getScore()* calcolaValoreLunghezzaFilm(s.getRuntime(),f.getRuntimeDesiderato()),
                    calcolaValoreGeneri(s.getGenres(),f.getGeneri()));
        else
            tot =Math.pow(s.getScore()*calcolaValoreLunghezzaSeire(s.getRuntime(),f.getRuntimeDesiderato())
                            * calcolaValoreSeasons(Integer.parseInt(s.getSeasons()),f.getMin() ,f.getMax(), f.getTipologia())
                    ,calcolaValoreGeneri(s.getGenres(),f.getGeneri()));
        s.setIndividualFitness(tot);
        return tot;
    }
    /*Metodo che calcola il valore dipendente dal numero di generi conosciuti.*/
    public static double calcolaValoreGeneri(String generiShow, List<String> desiderati){
        double punteggio=1;
        for(String genere: desiderati){
            if(generiShow.contains(genere))
                punteggio += 1;
        }
        if(punteggio == 1)
            return -desiderati.size();
        return punteggio;
    }
    /*Metodo che calcola il valore, su una serie, dipendente dalla lunghezza desiderata*/
    public static double calcolaValoreLunghezzaSeire(double runtime, String lunghezza){
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
    /*Metodo che calcola il valore, su un film, dipendente dalla lunghezza desiderata*/
    public static double calcolaValoreLunghezzaFilm(double runtime, String lunghezza){
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
    /*Metodo che calcola il valore, su una serie, dipendente dal numero di stagioni massimo*/
    public static double calcolaValoreSeasons(int seasons, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max){
            return 2;
        }
        return 0.5;
    }
    /*Metodo che calcola il valore, su una serie, dipendente dal'intervallo di stagioni
    desiderate*/
    public static double calcolaValoreSeasons(int seasons,int min, int max,String tipologia){
        if(seasons==0 || tipologia.equals("MOVIE"))
            return 0.5;
        if(seasons <= max && seasons >= min)
            return 2;
        return 0.5;
    }

}