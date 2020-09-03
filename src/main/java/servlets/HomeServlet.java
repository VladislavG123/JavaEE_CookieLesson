package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("name");

        Cookie cookie = new Cookie("myCookie", text);

        response.addCookie(cookie);

        response.sendRedirect("/");
    }

    private String getCookieValue(String name, Cookie[] cookies){
        if (cookies!=null){
            for (Cookie c: cookies){
                if (c.getName().equalsIgnoreCase(name)){
                    return c.getValue();
                }
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookies = request.getCookies();
        String cookieValue = getCookieValue("myCookie", cookies);
        cookieValue = cookieValue == null ? "Default site title" : cookieValue;

        request.setAttribute("title", cookieValue);

        // Form
        String dataString = getCookieValue("formData", cookies);
        FormData data;
        if (dataString == null) {
            data = new FormData("","",0,"", true);
        }
        else{
            data = new FormData(dataString);
        }
        request.setAttribute("formData", data);

        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
