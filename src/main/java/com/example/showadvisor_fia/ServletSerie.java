package com.example.showadvisor_fia;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletSerie", value = "/ServletSerie")
public class ServletSerie extends HttpServlet{

        private String message;

        public void init() {
            message = "Hello World!";
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            Popolazione popolazione = new Popolazione(8);
            popolazione.inizializza("MOVIE");
            List<String> generi = new ArrayList<String>();
            ArrayList<Individuo> banca = new ArrayList<>();

            int durataIntero = Integer.parseInt(request.getParameter("durataSerie"));
            int minSeason = Integer.parseInt(request.getParameter("minSeason"));
            int maxSeason = Integer.parseInt(request.getParameter("maxSeason"));

            String durata = convertiDurata(durataIntero);
            String tipo="SHOW";
            String[] checkBox = request.getParameterValues("generiSerie");

            if(checkBox != null && checkBox.length != 0)
                for(String s : checkBox)
                    generi.add(s);

            Fitness fitness = new Fitness( generi, durata, tipo,maxSeason);
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
                    System.out.println(ind.getFitnessTotale());
                    System.out.println(ind);
                }

            }
            sel.setP(popolazione);
            System.out.println("migliore\n"+popolazione.getLista().get(0));
        }

        public static String convertiDurata(int valore){
            String durata = "errore";

            if(valore != 1 && valore != 2 && valore != 0){
                Random r = new Random();
                valore = r.nextInt(2-0+1) - 0;
            }

            if(valore == 0)
                durata = "corta";
            else
                if(valore == 1)
                    durata = "media";
                else
                    if(valore == 2)
                        durata = "lunga";
            return durata;
        }

        public void destroy() {
        }

    }
