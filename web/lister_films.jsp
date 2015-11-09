<%-- 
    Document   : lister_films
    Created on : 28 oct. 2015, 11:37:35
    Author     : ETY
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>JSP Page</title>

        <!--Bootstrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Autres styles-->
        <c:import url="_stylesheets.jsp" />


    </head>
    <body>

        <div class="container">
            <header class="header">
                <c:import url="_header.jsp" />
            </header>

            <div class="menu">
                <c:import url="_menu.jsp" />
            </div>



            <main class="col-lg-12">
                <div class="text-center">
                    <a href="ajouterFilm.jsp">Ajouter un film</a>
                    <div><p></p></div>
                </div>

                
                    <c:forEach items="${mesFilms}" var="monFilm">
                        <div class="panel panel-success col-lg-6">
                            <div class="panel-heading col-lg-12" >
                                <div class="col-lg-8">${monFilm.titre}</div>
                                <div class="col-lg-2"><a class="label label-primary" href="lister_liens?filmId=${monFilm.id}" >Liens</a></div>
                                <div class="col-lg-2"><a class="label label-danger" href="supprimer_film?filmId=${monFilm.id}" >Supprimer</a></div>
                            </div>
                            <div class="panel-boddy col-lg-12">
                                <p>Année:<samp> ${monFilm.annee}</samp></p>
                                <p>Durée:<samp> ${monFilm.duree} min</samp></p>
                                <p>Synopsis:<samp> ${monFilm.synopsis}</samp></p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </main>

            <footer class="footer col-lg-12 text-center">
                <c:import url="_footer.jsp" />
            </footer>

        </div>


        <!-- Autres styles-->
        <c:import url="_javascript.jsp" />

    </body>
</html>
