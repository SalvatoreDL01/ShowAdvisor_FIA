package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GaUtility {

    static public Popolazione crossOver(Popolazione p, Fitness f){
        Random random = new Random();
        Popolazione popolazione = new Popolazione(4);
        for(Individuo i: p.getLista())
            popolazione.getLista().add(i);
        System.out.println(popolazione.size());
        Individuo i1 = popolazione.getLista().remove(random.nextInt(3));
        Individuo i2 = popolazione.getLista().remove(random.nextInt(2));
        Individuo i3 = popolazione.getLista().remove(0);
        Individuo i4 = popolazione.getLista().remove(0);
        Individuo i5 = new Individuo();
        Individuo i6 = new Individuo();
        Individuo i7 = new Individuo();
        Individuo i8 = new Individuo();
        int point1 = random.nextInt(i1.size()-1), point2 = random.nextInt(i1.size()-1);
        for(int i=0; i<5; i++){
            if(i<point1){
                i5.add(i1.get(i));
                i6.add(i2.get(i));
            }//p
            else{
                i5.add(i2.get(i));
                i6.add(i1.get(i));
            }
        }
        for(int i=0; i<5; i++){
            if(i<point2){
                i7.add(i2.get(i));
                i8.add(i3.get(i));
            }
            else{
                i7.add(i3.get(i));
                i8.add(i2.get(i));
            }
        }
        p.getLista().add(i5);
        p.getLista().add(i6);
        p.getLista().add(i7);
        p.getLista().add(i8);
        for(Individuo ind: p.getLista())
            FunzioneFitness.calcolaTotalFitness(f, ind);
        return p;
    }

    static public Popolazione mutazione(Popolazione p, Fitness f) throws IOException {

        Show[] showList = Parser.getInstance();
        ArrayList<Individuo> list = p.getLista();
        Random random = new Random();
        int n = random.nextInt(3000);
        for(Individuo i: list){
            double min = 0;
            int pos = 0;
            for(int j =0; j<5; j++){
                double fit = FunzioneFitness.calcolaIndividualFitness(i.get(j), f);
                if(fit < min) {
                    min = fit;
                    pos = j;
                }
            }
            while(i.contains(showList[n])){
                n = random.nextInt(3000);
            }
            //int pos = random.nextInt(8);
            i.add(pos, showList[n]);
        }

        for(Individuo ind: p.getLista())
            FunzioneFitness.calcolaTotalFitness(f, ind);

        return p;

    }

}
