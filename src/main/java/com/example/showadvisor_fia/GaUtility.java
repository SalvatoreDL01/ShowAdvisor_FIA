package com.example.showadvisor_fia;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GaUtility {

    static public Popolazione crossOver(Popolazione p){
        Random random = new Random();
        Popolazione popolazione = new Popolazione(4);
        for(Individuo i: p)
            popolazione.add(i);
        Individuo i1 = popolazione.remove(random.nextInt(popolazione.size()-1));
        Individuo i2 = popolazione.remove(random.nextInt(popolazione.size()-1));
        Individuo i3 = popolazione.remove(0);
        Individuo i4 = popolazione.remove(0);
        Individuo i5 = new Individuo();
        Individuo i6 = new Individuo();
        Individuo i7 = new Individuo();
        Individuo i8 = new Individuo();
        int point1 = random.nextInt(i1.size()-1), point2 = random.nextInt(i1.size()-1);
        for(int i=0; i<i1.size(); i++){
            if(i<point1){
                i5.add(i1.get(i));
                i6.add(i2.get(i));
            }//
            else{
                i5.add(i2.get(i));
                i6.add(i1.get(i));
            }
        }
        for(int i=0; i<i1.size(); i++){
            if(i<point2){
                i7.add(i2.get(i));
                i8.add(i3.get(i));
            }
            else{
                i7.add(i3.get(i));
                i8.add(i2.get(i));
            }
        }
        p.add(i5);
        p.add(i6);
        p.add(i7);
        p.add(i8);
        return p;
    }

    static public Popolazione mutazione(Popolazione p) throws IOException {

        Show[] showList = Parser.getInstance();
        ArrayList<Individuo> list = p.getLista();
        Random random = new Random();
        int n = random.nextInt(3000);
        for(Individuo i: list){
            while(i.contains(showList[n])){
                n = random.nextInt(3000);
            }
            int pos = random.nextInt(8);
            i.add(pos, showList[n]);
        }

        return p;

    }

}
