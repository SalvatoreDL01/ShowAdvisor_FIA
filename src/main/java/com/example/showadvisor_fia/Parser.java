package com.example.showadvisor_fia;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static Show[] list = null;

    private static List<Show> listFilm = new ArrayList<Show>();
    private static List<Show> listSerie = new ArrayList<Show>();

    public Parser()throws IOException{
        Path path = Paths.get("C:/Users/utente/IdeaProjects/ShowAdvisor_FIA/src/main/webapp/Dataset/Dataset.json");
        String content = Files.readString(path);
        list = new Gson().fromJson(content, Show[].class);
        for(Show s: list)
            if(s.getType().contains("MOVIE"))
                listFilm.add(s);
        else
            listSerie.add(s);
    }

    public static List<Show> getInstance(String tipo) throws IOException {
        if(list == null)
            new Parser();
        if(tipo.equals("MOVIE"))
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
}
