package com.example.showadvisor_fia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fitness {

    private ArrayList<String> listaGeneri;
    private HashMap<String, Integer> map = new HashMap<>();
    private String tipo;
    private int mediaGeneri = 433, stagionemin, stagionemax;

    private class Genere{
        private String nome;
        private int conteggio;

        public Genere(String nome, int conteggio){
            this.nome = nome;
            this.conteggio = conteggio;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getConteggio() {
            return conteggio;
        }

        public void setConteggio(int conteggio) {
            this.conteggio = conteggio;
        }
    }

    public Fitness(String tipo, int min, int max, ArrayList<String> listaGeneri, String durata){
        this.listaGeneri = listaGeneri;
        map.put("romance", 512);
        map.put("fantasy", 432);
        map.put("horror", 221);
        map.put("comedy", 1107);
        map.put("european", 338);
        map.put("documentation", 679);
        map.put("war", 116);
        map.put("thriller", 612);
        map.put("history", 183);
        map.put("animation", 345);
        map.put("drama", 1430);
        map.put("music", 136);
        map.put("action", 596);
        map.put("reality", 73);
        map.put("crime", 532);
        map.put("western", 55);
        map.put("family", 337);
        map.put("sport", 123);
        map.put("sci-fi", 416);
        this.tipo = tipo;
        stagionemax = max;
        stagionemin = min;
    }

    public void calcolaFitness(Individuo i){
        double fitness = 0;
        for(Show s:i){
            System.out.println("calcolafitness 1 ");
            String generi = s.getGenres();
            for(String g:listaGeneri){
                System.out.println("calcolafitness 2 ");
                if(generi.contains(g));
                    fitness += mediaGeneri/map.get(g);
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
    }

}
