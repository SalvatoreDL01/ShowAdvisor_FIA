package com.example.showadvisor_fia;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Popolazione popolazione = new Popolazione(8);
        popolazione.inizializza();
        System.out.println(popolazione.getLista());
        popolazione.getLista().remove(7);
        popolazione.getLista().remove(6);
        popolazione.getLista().remove(5);
        popolazione.getLista().remove(4);
        popolazione = GaUtility.crossOver(popolazione);
        System.out.println("dopo il crossover");
        System.out.println(popolazione.getLista());
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}