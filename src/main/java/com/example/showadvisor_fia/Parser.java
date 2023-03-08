package com.example.showadvisor_fia;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

    private HashMap<String, Integer> nGeneri = new HashMap<>();

    private HashMap<String, Integer> nSeason = new HashMap<>();

    private HashMap<Double, Integer> nScore = new HashMap<>();
    private static Show[] list = null;

    private static List<Show> listFilm = new ArrayList<Show>();
    private static List<Show> listSerie = new ArrayList<Show>();

    public Parser() throws IOException {
        Path path = Paths.get("C:\\Users\\gioac\\IdeaProjects\\ShowAdvisor_FIA\\src\\main\\webapp\\Dataset\\Dataset.json");
        String content = Files.readString(path);
        list = new Gson().fromJson(content, Show[].class);
        for (Show s : list)
            if (s.getType().contains("MOVIE"))
                listFilm.add(s);
            else
                listSerie.add(s);
    }

    public static List<Show> getInstance(String tipo) throws IOException {
        if (list == null)
            new Parser();
        if (tipo.equals("MOVIE"))
            return listFilm;
        else
            return listSerie;
    }

    public List<Show> getListFilm() {
        return listFilm;
    }

    public List<Show> getListSerie() {
        return listSerie;
    }

    public HashMap<String, Integer> contaGeneri() {
        boolean f = false;

        List serie = new ArrayList();

        for (Show s : list) {
            char[] g = s.getGenres().toCharArray();
            int l = g.length, i = 0;
            String genere;
            while (i < l-1) {
                genere = "";
                while (g[i] != '[' && g[i] != ',' && g[i] != ']' && g[i] != '\'') {
                    genere = genere + g[i];
                    i++;
                    f = true;
                }
                if(f == true) {
                    if (!nGeneri.containsKey(genere) && !genere.equals(""))
                            nGeneri.put(genere, 0);
                    nGeneri.put(genere, nGeneri.get(genere) + 1);
                }
                i++;
                f = false;
            }
        }
        return nGeneri;
    }

    public HashMap<String, Integer> contaSeason() {

        for (Show s : list) {
            if (!nSeason.containsKey(s.getSeasons()))
                nSeason.put(s.getSeasons(), 0);
            nSeason.put(s.getSeasons(), nSeason.get((s.getSeasons())) + 1);
        }
        return nSeason;
    }

    public HashMap<Double, Integer> contaScore() {

        for (Show s : list) {
            if (!nScore.containsKey(s.getScore()))
                nScore.put(s.getScore(), 0);
            nScore.put(s.getScore(), nScore.get((s.getScore())) + 1);
        }
        return nScore;
    }

}



