package com.example.showadvisor_fia;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletSerie", value = "/ServletSerie")
public class ServletSerie extends HttpServlet{

    private String message;
    ArrayList<String> listaGeneri = new ArrayList<>();
    private int minSeason;
    private int maxSeason;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Popolazione popolazione = new Popolazione(500, 5);
        popolazione.inizializza("SHOW");

        int durataIntero = Integer.parseInt(request.getParameter("durataSerie"));

        minSeason = Integer.parseInt(request.getParameter("minSeason"));
        maxSeason = Integer.parseInt(request.getParameter("maxSeason"));
        String durata = convertiDurata(durataIntero);
        System.out.println(durata);
        String[] checkBox = request.getParameterValues("generiSerie");

        if(checkBox != null && checkBox.length != 0)
            for(String s : checkBox)
                listaGeneri.add(s);


        Individuo newIndividuo;
        Individuo max = new Individuo(5, 0);
        for (int i = 0; i < 500; i++) {
            newIndividuo = evoluzione(popolazione);
            if (newIndividuo.getFitnessTotale() > max.getFitnessTotale())
                max = newIndividuo;

        }
        HttpSession session = request.getSession();
        session.setAttribute("tipo", "SERIE");
        session.setAttribute("individuo",popolazione.getLista().get(0));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
        System.out.println(max);
        System.out.println("fitness  " + max.getFitnessTotale());

    }
    public Individuo evoluzione( Popolazione popolazione) throws IOException{
        Fitness fitness = new Fitness("MOVIE", minSeason, maxSeason, listaGeneri, 80, 100);
        GaUtility utility = new GaUtility(550, "MOVIE", fitness);

        utility.selezione(popolazione);
        utility.crossOver(popolazione);
        for(int i = 0; i<4; i++)
            utility.mutaPopolazione(popolazione);

        fitness.calcolaFitnessPopolazione(popolazione);
        return utility.finndBestIndividuo(popolazione);
    }

    public static String convertiDurata(int valore){
        String durata = "errore";

        if(valore == 3){
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



/*
        private String message;


        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            Popolazione popolazione = new Popolazione(8);
            popolazione.inizializza("SHOW");
            List<String> generi = new ArrayList<String>();
            ArrayList<Individuo> banca = new ArrayList<>();

            int durataIntero = Integer.parseInt(request.getParameter("durataSerie"));
            int minSeason = Integer.parseInt(request.getParameter("minSeason"));
            int maxSeason = Integer.parseInt(request.getParameter("maxSeason"));

            String durata = convertiDurata(durataIntero);
            String[] checkBox = request.getParameterValues("generiSerie");

            if(checkBox != null && checkBox.length != 0)
                for(String s : checkBox)
                    generi.add(s);

            Fitness fitness = new Fitness( generi, durata, "SHOW",maxSeason, minSeason);
            Selezione sel = new Selezione();

            for(int i=0;i<5000;i++){
                sel.setP(popolazione);
                ArrayList<Individuo> l= sel.selezione(fitness);
                popolazione.setLista(l);
                GaUtility.crossOver(popolazione, fitness);
                GaUtility.mutazione(popolazione, fitness);

            }
            sel.setP(popolazione);
            popolazione.setLista(sel.selezione(fitness));
            HttpSession session = request.getSession();
            session.setAttribute("tipo", "SERIE");
            session.setAttribute("individuo",popolazione.getLista().get(0));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        public static String convertiDurata(int valore){
            String durata = "errore";

            if(valore == 3){
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
*/
