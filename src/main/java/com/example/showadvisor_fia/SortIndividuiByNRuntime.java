package com.example.showadvisor_fia;

import java.util.Comparator;

public class SortIndividuiByNRuntime  implements Comparator<Individuo> {
    @Override
    public int compare(Individuo o1, Individuo o2) {
        Integer d = o1.getnShowRuntime();
        Integer d2 = o2.getnShowRuntime();
        return d.compareTo(d2);
    }
}