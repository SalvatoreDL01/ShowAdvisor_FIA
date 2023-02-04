package com.example.showadvisor_fia;

import java.util.Comparator;
/*Classe che ha la funzione di abilitare il sorting in termini fitness individuale degli show*/
public class SortShowByFitness implements Comparator<Show> {
    @Override
    public int compare(Show o1, Show o2) {
        Double d = o1.getIndividualFitness();
        Double d2 = o2.getIndividualFitness();
        return d.compareTo(d2);
    }
}
