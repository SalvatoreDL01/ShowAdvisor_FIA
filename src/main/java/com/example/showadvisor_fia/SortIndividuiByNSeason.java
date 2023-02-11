package com.example.showadvisor_fia;

import java.util.Comparator;

public class SortIndividuiByNSeason  implements Comparator<Individuo> {
    @Override
    public int compare(Individuo o1, Individuo o2) {
        Integer d = o1.getsSeasonsCorrette();
        Integer d2 = o2.getsSeasonsCorrette();
        return d.compareTo(d2);
    }
}
