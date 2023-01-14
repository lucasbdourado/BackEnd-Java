package com.javaserver.javaservers;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/servidores-app")
public class HelloServlet extends HttpServlet {
    private String message;
    private int count = 0;

    public void init() {
        message = "Servidores de Aplicação!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<div><p>Os servidores de aplicação também são conhecidos por middleware . O objetivo do servidor de aplicação é disponibilizar uma plataforma que separe do desenvolvedor de software algumas das complexidades de um sistema computacional. No desenvolvimento de aplicações comerciais, por exemplo, o foco dos desenvolvedores deve ser a resolução de problemas.</p></div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}