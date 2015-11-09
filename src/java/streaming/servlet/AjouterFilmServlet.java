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
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "AjouterFilmServlet", urlPatterns = {"/ajouter_film"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Ajouter un film *****");

        Film f = new Film();

        f.setTitre(req.getParameter("titre"));
        f.setDuree(new Integer(req.getParameter("duree")));
        f.setAnnee(new Integer(req.getParameter("annee")));
        f.setSynopsis(req.getParameter("synopsis"));

        FilmService fs = new FilmService();
        fs.insert(f);

        //Retour vers la liste des films
        resp.sendRedirect("lister_films");

    }

}
