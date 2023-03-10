package com.example.showadvisor_fia;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletFilm", value = "/ServletFilm")
public class ServletFilm extends HttpServlet {

    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //raccolta dati dalla jsp
        Popolazione popolazione = new Popolazione(4);
        popolazione.inizializza("MOVIE");
        ArrayList<String> generi = new ArrayList<String>();

        int durataIntero = Integer.parseInt(request.getParameter("durataFilm"));

        String durata = convertiDurata(durataIntero);
        String[] checkBox = request.getParameterValues("generiFilm");

        if(checkBox != null && checkBox.length != 0)
            for(String s : checkBox)
                generi.add(s);


        Fitness fitness = new Fitness("MOVIE",0,0, generi, durata);
        GaUtility ga = new GaUtility(2, "MOVIE", popolazione);

        for(int i=0;i<5000;i++) {
            //ArrayList<Individuo> l = ga.selezione(fitness);
            //popolazione.setLista(l);
            ga.setPopolazione(popolazione);
            ga.crossOver(fitness);
            ga.mutazione(fitness);
        }/*
        ga.setPopolazione(popolazione);
        popolazione.setLista(ga.selezione(fitness));*/
        HttpSession session = request.getSession();
        session.setAttribute("tipo", "FILM");
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

}
