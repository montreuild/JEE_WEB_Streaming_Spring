<%-- 
    Document   : _template
    Created on : 28 oct. 2015, 14:14:42
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

            <main class="contenu col-lg-12">

                <form action="ajouter_film" method="POST">

                    <div class="form-group">
                        <label for="titre">Titre: </label>
                        <input class="form-control" type="text" id="titre" name="titre" placeholder="Titre du Film" required>
                    </div>

                    <div class="form-group">
                        <label for="duree">Durée: </label>
                        <input class="form-control" type="number" id="duree" name="duree" value="90" required>

                    </div>

                    <div class="form-group">
                        <label for="duree">Année: </label>
                        <input class="form-control" type="number" id="annee" name="annee" value="2015" required>

                    </div>

                    <div class="form-group">
                        <label for="synopsis">Synopsis:</label>
                        <textarea class="form-control" id="synopsis" name="synopsis" placeholder="Description du film" required></textarea>
                    </div>

                    <div class="form-group">
                        <input class="form-control btn btn-primary" type="submit" value= "Enregistrer le film">
                    </div>
                </form>


            </main>

             <footer class="footer col-lg-12 text-center">
                <c:import url="_footer.jsp" />
            </footer>

        </div>


        <!-- Autres styles-->
        <c:import url="_javascript.jsp" />

    </body>
</html>
