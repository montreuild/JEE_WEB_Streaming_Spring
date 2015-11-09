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
import streaming.service.LienService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "AjouterLienServlet", urlPatterns = {"/ajouter_lien"})
public class AjouterLienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long filmId = new Long(req.getParameter("filmId"));
        req.setAttribute("filmId", filmId);
        req.getRequestDispatcher("ajouterLien.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Ajouter un lien *****");

        //Récupération du Film
        Film f = new Film();
        FilmService fs = new FilmService();
        f = fs.find(new Long(req.getParameter("filmId")));

        //Cration du lien avec ses valeurs
        Lien l = new Lien();
        l.setLangue(Lien.Langue.FR);//ENUMERATION A RECUPERER
        l.setQualite(Lien.Qualite.NORMAL);//ENUMERATION A RECUPERER
        l.setUrl(req.getParameter("url"));
        l.setFilm(f);

        //Enrigistrement du lien
        LienService ls = new LienService();
        ls.insert(l);
        
        //Retour vers la liste des liens
        resp.sendRedirect("lister_liens?filmId="+f.getId());

    }

}
