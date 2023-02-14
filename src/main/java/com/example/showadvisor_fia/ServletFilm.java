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

@WebServlet(name = "ServletFilm", value = "/ServletFilm")
public class ServletFilm extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Popolazione popolazione = new Popolazione(8);
        popolazione.inizializza("MOVIE");
        List<String> generi = new ArrayList<String>();
        ArrayList<Individuo> banca = new ArrayList<>();

        int durataIntero = Integer.parseInt(request.getParameter("durataFilm"));

        String durata = convertiDurata(durataIntero);
        String[] checkBox = request.getParameterValues("generiFilm");

        if(checkBox != null && checkBox.length != 0)
            for(String s : checkBox)
                generi.add(s);

        Fitness fitness = new Fitness( generi, durata, "MOVIE", 0, 0);
        Selezione sel = new Selezione();

        for(int i=0;i<1000;i++){
            sel.setP(popolazione);
            ArrayList<Individuo> l= sel.selezione(fitness);
            popolazione.setLista(l);
            GaUtility.crossOver(popolazione, fitness);
            GaUtility.mutazione(popolazione, fitness);
            for(Individuo ind:l){
                System.out.println(ind.getFitnessTotale());
                System.out.println(ind);
            }

        }
        sel.setP(popolazione);
        System.out.println("migliore\n"+popolazione.getLista().get(0));
        HttpSession session = request.getSession();
        session.setAttribute("individuo", popolazione.getLista().get(0));
        session.setAttribute("tipo", "FILM");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    public static String convertiDurata(int valore){
        String durata = "errore";

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
