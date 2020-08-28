<%-- 
    Document   : notas
    Created on : 17/07/2019, 10:50:23 PM
    Author     : YO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            if (session.getAttribute("estudiante") == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="d-flex">
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-header">
                        Nombre Estudiante
                    </div>
                    <div class="card-body">
                        <blockquote class="blockquote mb-0">
                            <p>${estudiante.getNombre()}</p>
                        </blockquote>
                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        Codigo de Estudiante
                    </div>
                    <div class="card-body">
                        <blockquote class="blockquote mb-0">
                            <p>${estudiante.getCodigo()}</p>
                        </blockquote>
                    </div>
                </div>
            </div>
            
            <div class="col-sm-7">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Curso</th>
                            <th>Nota</th>
                            <th>Porcentaje</th>
                            <th>Acumulado</th>
                            <th>Necesita</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="n" items="${notas}">
                        <tr>
                            <td>${n.getRegistroDTO().getId()}</td>
                            <td>${n.getRegistroDTO().getCursoDTO().getNombre()}</td>
                            <td>${n.getNota()}</td>
                            <td>${n.getPorcentaje()}</td>
                            <td>
                            <a class="btn btn-warning" href="Controlador?menu=notas&accion=Acumulado&id=${n.getRegistroDTO().getId()}&curso=${n.getRegistroDTO().getCursoDTO().getNombre()}">Acumulado</a>
                            </td>
                            <td>
                            <a class="btn btn-warning" href="Controlador?menu=notas&accion=Necesita&id=${n.getRegistroDTO().getId()}&curso=${n.getRegistroDTO().getCursoDTO().getNombre()}">Necesita</a>
                            </td
                        </tr>
                        
                    </c:forEach>


                    </tbody>
                </table>
                
                <div class="d-flex">
                    <div class="card col-sm-6">
                        <div class="card-header">
                            Acumulado
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>${nota.getRegistroDTO().getCursoDTO().getNombre()}</p>
                                <p>${nota.getAcumulado()}</p>

                            </blockquote>
                        </div>
                    </div>

                    <div class="card col-sm-6">
                        <div class="card-header">
                            Necesita
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>${nota.getRegistroDTO().getCursoDTO().getNombre()}</p>
                                <p>${nota.getCuantoNecesito()}</p>

                            </blockquote>
                        </div>
                    </div>
                </div>
                
                
            </div>
            
        </div>
        
        
        <script> src="js/jquery-3.4.1.min"</script>
        <script> src="js/bootstrap.min"</script>
    </body>
</html>
