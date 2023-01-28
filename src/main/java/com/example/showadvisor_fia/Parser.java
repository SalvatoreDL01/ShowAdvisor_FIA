package com.example.showadvisor_fia;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    static void parse() throws IOException {

        //funzione
        Path path = Paths.get("/home/giuseppe/IdeaProjects/ShowAdvisor_FIA/src/main/java/com/example/prova/t.json");
        String content = Files.readString(path);
        Show[] list = new Gson().fromJson(content, Show[].class);
        System.out.println(list[1213]);

    }

}
