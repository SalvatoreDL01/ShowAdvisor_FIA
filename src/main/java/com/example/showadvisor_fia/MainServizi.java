package com.example.showadvisor_fia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MainServizi {

    public static void main(String[] args) throws IOException {
        Parser p = new Parser();
        HashMap<String, Integer> generi = p.contaGeneri();
        HashMap<String, Integer> season = p.contaSeason();
        HashMap<Double, Integer> score = p.contaScore();

        System.out.println("stampa della map dei generi");
        System.out.println(generi);
        System.out.println("stampa della map delle season");
        System.out.println(season);
        System.out.println("stampa della map dello score");
        System.out.println(score);

        Collection interi = generi.values();
        Collection totS = season.values();
        Collection sc = score.values();

        Collection sKey = score.keySet();


        int sommaG = 0, sommaS = 0;
/*
        System.out.println("risultati dei generi");
        for(Object i : interi){
            int x = (Integer) i;
            System.out.println(x);
        }

        System.out.println("risultati delle season");
        for(Object i : totS){
            int x = (Integer) i;
            System.out.println(x);
        }
*/
        System.out.println("risultati dello score");
        for(Object i : sc){
            int x = (Integer) i;
            System.out.println(x);
        }

        System.out.println("\n\nchiavi dello score");
        for(Object i : sKey){
            Double x = (Double) i;
            System.out.println(x);
        }


        System.out.println("numero totale generi : " + sommaG);
        System.out.println("numero totale season : " + sommaS);
    }
}
