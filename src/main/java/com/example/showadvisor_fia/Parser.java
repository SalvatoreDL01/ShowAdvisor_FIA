package com.example.showadvisor_fia;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    private static Show[] list = null;

    private Parser()throws IOException{
        Path path = Paths.get("/home/giuseppe/IdeaProjects/ShowAdvisor_FIA/src/main/webapp/Dataset/Dataset.json");
        String content = Files.readString(path);
        list = new Gson().fromJson(content, Show[].class);
    }

    public static Show[] getInstance() throws IOException {
        if(list == null){
            new Parser();
            return list;
        }
        else return list;
    }

}
