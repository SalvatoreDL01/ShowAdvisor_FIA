package com.example.showadvisor_fia;

import com.example.showadvisor_fia.Show;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
/*Classe che ha il compito di costruire un individuo */
public class Individuo extends ArrayList<Show> {

    private double fitnessTotale;

    public Individuo(int initialCapacity) {
        super(initialCapacity);
    }

    public Individuo() {
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
}
