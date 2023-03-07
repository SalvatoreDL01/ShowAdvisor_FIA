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

        System.out.println("stampa della map dei generi");
        System.out.println(generi);
        System.out.println("stampa della map delle season");
        System.out.println(season);

        Collection interi = generi.values();
        Collection totS = season.values();

        int sommaG = 0, sommaS = 0;

        for(Object i : interi){
            int x = (Integer) i;
            sommaG += x;
        }
        for(Object i : totS){
            int x = (Integer) i;
            sommaS += x;
        }

        System.out.println("numero totale generi : " + sommaG);
        System.out.println("numero totale season : " + sommaS);
    }
}
