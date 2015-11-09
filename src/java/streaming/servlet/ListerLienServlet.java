/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.entity.Lien;
import streaming.service.FilmService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "ListerLienServlet", urlPatterns = {"/lister_liens"})
public class ListerLienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Lister les liens *****");
        
        //Recupération de l'ID du film
        Long filmId=new Long(req.getParameter("filmId"));
        //Récupère la liste des liens et les places dans une variable listeliens
        FilmService fs = new FilmService();
        Film film=new Film();
        film=fs.find(filmId);
        
        List<Lien> listeLiens = film.getLiens();
        
        //Rendre la variable accecible aux Vues via la variable nommée mesLiens.
        req.setAttribute("mesLiens", listeLiens);
        req.setAttribute("filmtitre",film.getTitre());
        req.setAttribute("filmId", filmId);

        //Forward vers JSP
        req.getRequestDispatcher("lister_liens.jsp").forward(req, resp);

    }

}
