package com.example.showadvisor_fia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Execution", value = "/Execution")
public class Execution extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Popolazione popolazione = new Popolazione(8);
        popolazione.inizializza();
        System.out.println(popolazione.getLista());
        List<String> generi = new ArrayList<String>();

        generi.add("horror");
        generi.add("crime");
        generi.add("thriller");

        String tipo="MOVIE";
        String runtime = "corta";

        Fitness fitness = new Fitness( generi, runtime, tipo,0);

        for(int i=0;i<1000;i++){
            System.out.println("fdbfuksri\n");
        Selezione sel = new Selezione();
        sel.setP(popolazione);
        ArrayList<Individuo> l= sel.selezione(fitness);
        popolazione.setLista(l);

        GaUtility.crossOver(popolazione);
        GaUtility.mutazione(popolazione);
            for(Individuo ind:l){
                System.out.println(ind.getFitnessTotale());
            }
        }
        List<Individuo> li = popolazione.getLista();
        Individuo max = li.get(0);
        for(Individuo ind:li){
            FunzioneFitness.calcolaTotalFitness(fitness,ind);
            if(ind.getFitnessTotale()>max.getFitnessTotale())
                max=ind;
        }
        System.out.println(max);
        System.out.println(max.getFitnessTotale());
    }

    public void destroy() {
    }
}