package bsu.rfe.java.group8.laba8.Guscha.varA9.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bsu.rfe.java.group8.laba8.Guscha.varA9.entity.ChatUser;


public class ViewServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        boolean b=false;
        for (ChatUser aUser: activeUsers.values()) {
            if(aUser.getName().equals((String)request.getSession().getAttribute("name"))){
                b=true;
            }
        }
        if(!b)
            response.sendRedirect(response.encodeRedirectURL("/lab_8C/login.do"));
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>\n<html>" +
                "<head>" +
                "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>" +
                "<title>Чат</title>" +
                "</head>");


        pw.println( "<frameset rows=\"900,10\">" +
                "<frameset cols=\"5,2\">"+

                "<frame name=\"frameMessages\" src=\"/lab_8C/message.do\">"+
                "<frame name=\"frameUsers\" src=\"/lab_8C/users.do\" noresize>" +

                "</frameset>"+
                "</frameset>");
        pw.println("</html>");
    }
}
