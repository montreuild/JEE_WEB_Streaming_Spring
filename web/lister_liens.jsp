<%-- 
    Document   : lister_liens
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
                         <a href="ajouter_lien?filmId=${filmId}">Ajouter un lien</a>
                         <div><p></p></div>
                    </div>
                         
                         <div><h1>${filmtitre}</h1></div>
                         
                    <table class="table table-striped">
                        
                            <th>Langue</th>
                            <th>Qualité</th>
                            <th>Url</samp></th>
                            <th></th>
                        
                    <c:forEach items="${mesLiens}" var="monLien">
                        <tr>
                            <td>${monLien.langue}</td>
                            <td>${monLien.qualite}</td>
                            <td>${monLien.url}</td>
                            <td><a class="label label-danger" href="supprimer_lien?lienId=${monLien.id}&filmId=${filmId}" >Supprimer</a></td>
                        </tr>
                    </c:forEach>
                    </table>
            </main>

            <footer class="footer col-lg-12 text-center">
                <c:import url="_footer.jsp" />
            </footer>
            
        </div>
            
            
        <!-- Autres styles-->
        <c:import url="_javascript.jsp" />
        
    </body>
</html>
