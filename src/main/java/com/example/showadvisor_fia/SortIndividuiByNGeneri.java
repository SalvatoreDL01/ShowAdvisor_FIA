package com.example.showadvisor_fia;

import java.util.Comparator;

public class SortIndividuiByNGeneri implements Comparator<Individuo> {

    @Override
    public int compare(Individuo o1, Individuo o2) {
        Double d = 0-o1.getnShowGeneri();
        Double d2 = 0-o2.getnShowGeneri();
        return d.compareTo(d2);
    }
}
