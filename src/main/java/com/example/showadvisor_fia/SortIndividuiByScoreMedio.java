package com.example.showadvisor_fia;

import java.util.Comparator;

public class SortIndividuiByScoreMedio implements Comparator<Individuo> {
    @Override
    public int compare(Individuo o1, Individuo o2) {
        Double d = 0-o1.getScoreMedio();
        Double d2 = 0-o2.getScoreMedio();
        return d.compareTo(d2);
    }
}
