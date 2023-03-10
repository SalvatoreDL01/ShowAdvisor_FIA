package com.example.showadvisor_fia;

import java.util.ArrayList;
import java.util.List;

public class Fitness {

    private ArrayList<String> listaGeneri = new ArrayList<>();
    private String tipo;
    private int mediaGeneri = 433, stagionemin, stagionemax;
    private ArrayList<Genere> generiUtente = new ArrayList<>();
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

    public Fitness(String tipo, int min, int max, ArrayList<String> generi, String runtime){
        listaGeneri.add(new Genere("romance", 512));
        listaGeneri.add(new Genere("fantasy", 432));
        listaGeneri.add(new Genere("horror", 221));
        listaGeneri.add(new Genere("comedy", 1107));
        listaGeneri.add(new Genere("european", 338));
        listaGeneri.add(new Genere("documentation", 679));
        listaGeneri.add(new Genere("war", 116));
        listaGeneri.add(new Genere("thriller", 612));
        listaGeneri.add(new Genere("history", 183));
        listaGeneri.add(new Genere("animation", 345));
        listaGeneri.add(new Genere("drama", 1430));
        listaGeneri.add(new Genere("music", 136));
        listaGeneri.add(new Genere("action", 596));
        listaGeneri.add(new Genere("reality", 73));
        listaGeneri.add(new Genere("crime", 532));
        listaGeneri.add(new Genere("western", 55));
        listaGeneri.add(new Genere("family", 337));
        listaGeneri.add(new Genere("sport", 123));
        listaGeneri.add(new Genere("sci-fi", 416));
        this.tipo = tipo;
        stagionemax = max;
        stagionemin = min;
        this.generiUtente = generi;
    }

    public void calcolaFitness(Individuo i){
        double fitness = 0;
        for(Show s:i){
            String generi = s.getGenres();
            for(Genere g:listaGeneri){
                if(generiUtente.contains(g.getNome()))
                    fitness += mediaGeneri/g.getConteggio();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Genere> getListaGeneri() {
        return listaGeneri;
    }

    public void setListaGeneri(ArrayList<Genere> listaGeneri) {
        this.listaGeneri = listaGeneri;
    }

    public int getMediaGeneri() {
        return mediaGeneri;
    }

    public void setMediaGeneri(int mediaGeneri) {
        this.mediaGeneri = mediaGeneri;
    }

    public int getStagionemin() {
        return stagionemin;
    }

    public void setStagionemin(int stagionemin) {
        this.stagionemin = stagionemin;
    }

    public int getStagionemax() {
        return stagionemax;
    }

    public void setStagionemax(int stagionemax) {
        this.stagionemax = stagionemax;
    }
}
