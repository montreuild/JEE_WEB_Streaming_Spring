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
import streaming.service.LienService;

/**
 *
 * @author ETY
 */
@WebServlet(name = "SupprimerLienServlet", urlPatterns = {"/supprimer_lien"})
public class SupprimerLienServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*** Supprimer un lien *****");

        //Récup prams d'URL
        long id = new Long(req.getParameter("lienId"));

        //Appel du service pour suipprimer le lien
        LienService ls = new LienService();
        ls.delete(id);
        
        long filmId=new Long(req.getParameter("filmId"));
        
        //Retour vers la liste des liens
        resp.sendRedirect("lister_liens?filmId="+filmId);

    }

}
