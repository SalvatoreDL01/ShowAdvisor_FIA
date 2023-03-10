package com.example.showadvisor_fia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fitness {

    private ArrayList<String> listaGeneri;
    private HashMap<String, Double> map = new HashMap<>();
    private String tipo;
    private int stagionemin, stagionemax;
    private double mediaGeneri = 3000;

    public Fitness(String tipo, int min, int max, ArrayList<String> listaGeneri){
        this.listaGeneri = listaGeneri;
        map.put("romance", 512.0);
        map.put("fantasy", 432.0);
        map.put("horror", 221.0);
        map.put("comedy", 1107.0);
        map.put("european", 338.0);
        map.put("documentation", 679.0);
        map.put("war", 116.0);
        map.put("thriller", 612.0);
        map.put("history", 183.0);
        map.put("animation", 345.0);
        map.put("drama", 1430.0);
        map.put("music", 136.0);
        map.put("action", 596.0);
        map.put("reality", 73.0);
        map.put("crime", 532.9);
        map.put("western", 55.0);
        map.put("family", 337.0);
        map.put("sport", 123.0);
        map.put("sci-fi", 416.0);
        this.tipo = tipo;
        stagionemax = max;
        stagionemin = min;
    }

    public double calcolaFitnessPopolazione(Popolazione p){
        double fitness = 0;
        for(Individuo i :p.getLista()){
            fitness += this.calcolaFitness(i);
        }
        return fitness;
    }

    public double calcolaFitness(Individuo i){
        double fitness = 0;
        for(Show s:i){
            String generi = s.getGenres();
            for(String g:listaGeneri){
                if(generi.contains(g))
                    fitness += (mediaGeneri / (map.get(g)));
            }
            if(s.getScore() >= 8 && s.getScore() <= 10)
                fitness += 10;
            if(s.getScore() >= 6 && s.getScore() <= 8)
                fitness += 7;
            if(s.getScore() >= 5 && s.getScore() <= 6)
                fitness += 3;
            if(s.getScore() >= 4 && s.getScore() <= 5)
                fitness += 1;
            if(s.getScore() >= 1 && s.getScore() <= 2)
                fitness -= 3;
            if(s.getScore() >= 0 && s.getScore() <= 1)
                fitness -= 10;
            if(tipo.equals("SHOW")){
                if(Integer.parseInt(s.getSeasons()) >= stagionemin && Integer.parseInt(s.getSeasons()) <= stagionemax){
                    fitness += 10;
                }
                if(Integer.parseInt(s.getSeasons()) <= stagionemin){
                    fitness -= stagionemin - Integer.parseInt(s.getSeasons());
                }
                if(Integer.parseInt(s.getSeasons()) >= stagionemax){
                    fitness -= Integer.parseInt(s.getSeasons()) - stagionemax;
                }
            }
        }
        i.setFitnessTotale(fitness);
        return fitness;
    }

    public double fitnessShow(Show s){
        double fitness = 0;
        String generi = s.getGenres();
        for(String g:listaGeneri){
            if(generi.contains(g))
            fitness += (mediaGeneri / (map.get(g)));
        }
        if(s.getScore() >= 8 && s.getScore() <= 10)
            fitness += 10;
        if(s.getScore() >= 6 && s.getScore() <= 8)
            fitness += 7;
        if(s.getScore() >= 5 && s.getScore() <= 6)
            fitness += 3;
        if(s.getScore() >= 4 && s.getScore() <= 5)
            fitness += 1;
        if(s.getScore() >= 1 && s.getScore() <= 2)
            fitness -= 3;
        if(s.getScore() >= 0 && s.getScore() <= 1)
            fitness -= 10;
        if(tipo.equals("SHOW")) {
            if (Integer.parseInt(s.getSeasons()) >= stagionemin && Integer.parseInt(s.getSeasons()) <= stagionemax) {
                fitness += 10;
            }
            if (Integer.parseInt(s.getSeasons()) <= stagionemin) {
                fitness -= stagionemin - Integer.parseInt(s.getSeasons());
            }
            if (Integer.parseInt(s.getSeasons()) >= stagionemax) {
                fitness -= Integer.parseInt(s.getSeasons()) - stagionemax;
            }
        }
        return fitness;
    }

}
