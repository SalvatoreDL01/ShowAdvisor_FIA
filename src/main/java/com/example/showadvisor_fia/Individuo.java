package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*Classe che ha il compito di costruire un individuo */
public class Individuo extends ArrayList<Show>{

    private List<String> generi;
    private String runtimeDesiderato;
    private String tipologia;
    private int max;
    private int min;
/*

    public Fitness(List<String> generi, String runtimeDesiderato, String tipologia,int max,int min) {
        this.generi = generi;
        this.runtimeDesiderato = runtimeDesiderato;
        this.tipologia = tipologia;
        this.max = max;
        this.min = min;
    }*/
    private double fitnessTotale;
    private int nShow;

    public Individuo(int nShow, int fitnessTotale){
        this.nShow = nShow;
        this.fitnessTotale = fitnessTotale;
    }

    public Individuo(int initialCapacity) {
        super(initialCapacity);
    }

    public Individuo() {
        super();
    }

    public Individuo(Collection<? extends Show> c) {
        super(c);
    }

    //metodo per creare un individuo in modo casuale
    public void crea(String tipo) throws IOException {
        int x;
        if(tipo.equals("MOVIE"))
            x=2444;
        else
            x=722;

        Random random = new Random();
        Show show;
        List<Show> showList = Parser.getInstance(tipo);
        int i, n;
        for(i=0; i<nShow; i++){
            n = random.nextInt(x);
            show = showList.get(n);
            while(this.contains(show)){
                n = random.nextInt(x);
                show = showList.get(n);
            }
            this.add(show);
        }

    }

    //getter and setter
    public double getFitnessTotale() {
        return fitnessTotale;
    }

    public void setFitnessTotale(double fitnessTotale) {
        this.fitnessTotale = fitnessTotale;
    }

    public int getnShow() {
        return nShow;
    }

    public void setnShow(int nShow) {
        this.nShow = nShow;
    }

    public String toString(){
        String str = "";
        for(Show s: this)
            str += s.toString() + "\n";
        return  str;
    }

    //metodi sovrascritti di un ogetto List
    @Override
    public void trimToSize() {
        super.trimToSize();
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        super.ensureCapacity(minCapacity);
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
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    public Show get(int index) {
        return super.get(index);
    }

    @Override
    public Show set(int index, Show element) {
        return super.set(index, element);
    }

    @Override
    public boolean add(Show show) {
        return super.add(show);
    }

    @Override
    public void add(int index, Show element) {
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
    public int hashCode() {
        return super.hashCode();
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
    public boolean addAll(Collection<? extends Show> c) {
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Show> c) {
        return super.addAll(index, c);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    public ListIterator<Show> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public ListIterator<Show> listIterator() {
        return super.listIterator();
    }

    @Override
    public Iterator<Show> iterator() {
        return super.iterator();
    }

    @Override
    public List<Show> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(Consumer<? super Show> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Show> spliterator() {
        return super.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super Show> filter) {
        return super.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<Show> operator) {
        super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Show> c) {
        super.sort(c);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public Stream<Show> stream() {
        return super.stream();
    }

    @Override
    public Stream<Show> parallelStream() {
        return super.parallelStream();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
