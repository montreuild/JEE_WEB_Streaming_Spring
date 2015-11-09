/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "ListerFilmServlet", urlPatterns = {"/lister_films"})
public class ListerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Lister les films *****");

        //Récupère la liste des films et les places dans une variable listefilms
        FilmService fs = new FilmService();
        List<Film> listeFilms = fs.list();

        //Rendre la variable accecible aux Vues via la variable nommée mesFilms.
        req.setAttribute("mesFilms", listeFilms);

        //Forward vers JSP
        req.getRequestDispatcher("lister_films.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
    
    

}
