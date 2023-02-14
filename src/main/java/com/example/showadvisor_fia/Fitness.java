package com.example.showadvisor_fia;

import java.util.List;

public class Fitness {
    private List<String> generi;
    private String runtimeDesiderato;
    private String tipologia;
    private int max;
    private int min;

    public Fitness(List<String> generi, String runtimeDesiderato, String tipologia,int max,int min) {
        this.generi = generi;
        this.runtimeDesiderato = runtimeDesiderato;
        this.tipologia = tipologia;
        this.max = max;
        this.min = min;
    }

    public List<String> getGeneri() {
        return generi;
    }

    public void setGeneri(List<String> generi) {
        this.generi = generi;
    }

    public String getRuntimeDesiderato() {
        return runtimeDesiderato;
    }

    public void setRuntimeDesiderato(String runtimeDesiderato) {
        this.runtimeDesiderato = runtimeDesiderato;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
