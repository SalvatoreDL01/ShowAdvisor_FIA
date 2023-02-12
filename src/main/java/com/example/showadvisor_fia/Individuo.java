package com.example.showadvisor_fia;

import com.example.showadvisor_fia.Show;

import java.io.IOException;
import java.util.*;

/*Classe che ha il compito di costruire un individuo */
public class Individuo extends ArrayList<Show> {

    private double fitnessTotale;
    //fitness multi obiettivo
    private Double nShowGeneri;
    private Integer sSeasonsCorrette;
    private Integer nShowRuntime;
    private Double scoreMedio;

    public Individuo(int initialCapacity) {
        super(initialCapacity);
    }

    public Individuo() {
        nShowGeneri=0.0;
        nShowRuntime=0;
        scoreMedio=0.0;
    }

    public Individuo(Collection c) {
        super(c);
    }

    public double getFitnessTotale() {
        return fitnessTotale;
    }

    public void setFitnessTotale(double fitnessTotale) {
        this.fitnessTotale = fitnessTotale;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return super.toArray(a);
    }

    @Override
    public Show get(int index) {
        return super.get(index);
    }

    @Override
    public Show set(int index, Show element) {
        if(index<5)
            return super.set(index, element);
        return null;
    }

    public Double getnShowGeneri() {
        return nShowGeneri;
    }

    public void setnShowGeneri(Double nShowGeneri) {
        this.nShowGeneri = nShowGeneri;
    }

    public Integer getnShowRuntime() {
        return nShowRuntime;
    }

    public void setnShowRuntime(Integer nShowRuntime) {
        this.nShowRuntime = nShowRuntime;
    }

    public Double getScoreMedio() {
        return scoreMedio;
    }

    public void setScoreMedio(Double scoreMedio) {
        this.scoreMedio = scoreMedio;
    }

    public Integer getsSeasonsCorrette() {
        return sSeasonsCorrette;
    }

    public void setsSeasonsCorrette(Integer sSeasonsCorrette) {
        this.sSeasonsCorrette = sSeasonsCorrette;
    }

    @Override
    public boolean add(Show o) {
        if(this.size()<6)
            return super.add(o);
        return false;
    }

    @Override
    public void add(int index, Show element) {
        if(this.size()<6 && index <5)
            super.add(index, element);
    }

    @Override
    public Show remove(int index) {
        return super.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void sort(Comparator c) {
        super.sort(c);
    }

    public void crea(String tipo) throws IOException {
        int x;
        if(tipo.equals("MOVIE"))
            x=2444;
        else
            x=722;

        Random random = new Random();
        Show individuo;
        List<Show> showList = Parser.getInstance(tipo);
        int i, n;
        for(i=0; i<5; i++){
            n = random.nextInt(x);
            individuo = showList.get(n);
            while(this.contains(individuo)){
                n = random.nextInt(x);
                individuo = showList.get(n);
            }
            this.add(individuo);
        }

    }

    public String toString(){
        String str = "";
        for(Show s: this)
            str += s.toString() + "\n";
        return  str;
    }
}
