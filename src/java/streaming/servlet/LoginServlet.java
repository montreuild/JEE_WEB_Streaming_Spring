/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        boolean connexion = false;

        if ("streaming".equals(login) && "streaming".equals(mdp)) {
            connexion = true;
            req.getSession().setAttribute("estLogge", connexion);
            req.getSession().setAttribute("user", "admin");
            req.getRequestDispatcher("lister_films").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }

    }

}
