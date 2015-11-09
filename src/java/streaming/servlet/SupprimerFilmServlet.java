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
import streaming.service.FilmService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "SupprimerFilmServlet", urlPatterns = {"/supprimer_film"})
public class SupprimerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Supprimer un film *****");

        //Récup prams d'URL
        long id = new Long(req.getParameter("filmId"));

        //Appel du service pour suipprimer le film
        FilmService fs = new FilmService();
        fs.delete(id);

        //Retour vers la liste des films
        resp.sendRedirect("lister_films");

    }

}
