package com.example.showadvisor_fia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Execution", value = "/Execution")
public class Execution extends HttpServlet {/*
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Popolazione popolazione = new Popolazione(8);
        popolazione.inizializza("MOVIE");
        System.out.println(popolazione.getLista());
        List<String> generi = new ArrayList<String>();
        ArrayList<Individuo> banca = new ArrayList<>();

        generi.add("fantasy");
        generi.add("european");
        generi.add("documentation");

        String tipo="SHOW";
        String runtime = "corta";

        Fitness fitness = new Fitness( generi, runtime, tipo,2,1);
        Selezione sel = new Selezione();
        for(int i=0;i<1000;i++){
            System.out.println("fdbfuksri\n");
        sel.setP(popolazione);
        ArrayList<Individuo> l= sel.selezione(fitness);
        popolazione.setLista(l);
        System.out.println("popolazione size" + popolazione.getLista().size());
        GaUtility.crossOver(popolazione, fitness);
        GaUtility.mutazione(popolazione, fitness);
            for(Individuo ind:l){
                System.out.println(ind);
            }

        }
        sel.setP(popolazione);
        System.out.println("migliore\n"+popolazione.getLista().get(0));
    }

    public void destroy() {
    }*/
}