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

    private static List listFilm = new ArrayList<Show>();
    private static List listSerie = new ArrayList<Show>();

    public Parser()throws IOException{
        Path path = Paths.get("/home/giuseppe/IdeaProjects/ShowAdvisor_FIA/src/main/webapp/Dataset/Dataset.json");
        String content = Files.readString(path);
        list = new Gson().fromJson(content, Show[].class);
        for(Show s: list)
            if(s.getType().equals("MOVIE"))
                listFilm.add(s);
        else
            listSerie.add(s);
    }

    public static Show[] getInstance() throws IOException {
        if(list == null){
            new Parser();
            return list;
        }
        else return list;
    }

    public List getListFilm() {
        return listFilm;
    }

    public List getListSerie() {
        return listSerie;
    }
}
