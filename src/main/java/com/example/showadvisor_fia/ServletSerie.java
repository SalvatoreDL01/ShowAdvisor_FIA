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
    }
