<%-- 
    Document   : _template
    Created on : 28 oct. 2015, 14:14:42
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Navigateur</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Site Streaming</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li > <a href="lister_films">Film</a></li>
            <li><a href="">Serie</a></li>

            <c:choose>
                <c:when test="${estLogge!=true}">
                    <li><a href="login.jsp">LogIn</a></li>
                    </c:when>
                    <c:otherwise>
                    <li><a href="logout">LogOut</a></li>
                    </c:otherwise>
                </c:choose>
        </ul>


    </div><!-- /.navbar-collapse -->
</nav>

<div>
    <c:if test="${user!=null}">
        <div>
            <p>Bonjour ${user} !</p>    
        </div>
    </c:if>
    <div>
         <p>${dateJour}</p>      
    </div>
</div>