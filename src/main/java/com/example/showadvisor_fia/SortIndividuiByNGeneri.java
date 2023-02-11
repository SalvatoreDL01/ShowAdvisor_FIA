package com.example.showadvisor_fia;

import java.util.Comparator;

public class SortIndividuiByNGeneri implements Comparator<Individuo> {

    @Override
    public int compare(Individuo o1, Individuo o2) {
        Integer d = o1.getnShowGeneri();
        Integer d2 = o2.getnShowGeneri();
        return d.compareTo(d2);
    }
}
