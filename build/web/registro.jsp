<%-- 
    Document   : registro
    Created on : 9/07/2019, 08:32:33 PM
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

            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=registrar" method="POST">
                        <div class="card-body">

                            <div class="card">
                                <div class="card-header">
                                    Datos del Estudiante
                                </div>
                                <div class="card-body">
                                    <blockquote class="blockquote mb-0">
                                        <p>Nombre: ${estudiante.getNombre()}</p>
                                        <p>Codigo: ${estudiante.getCodigo()}</p>
                                        <p>CC: ${estudiante.getCc()}</p>
                                    </blockquote>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del Curso</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="d-flex">
                                    <input type="text" name="idCurso" value="${cursoB.getID()}" class="form-control col-sm-6" placeholder="ID">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info col-sm-4">
                                </div>
                                <div>
                                    <input type="text" name="nombreCurso" value="${cursoB.getNombre()}" placeholder="Datos Curso" class="form-control col-sm-12">
                                </div>
                            </div>

                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info"> 

                        </div>
                        <label>${mensaje}</label>
                    </form>

                </div>
            </div>


            <div class="col-sm-7">

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Curso</th>
                            <th>Fecha</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="r" items="${registros}">
                            <tr>
                                <td>${r.getId()}</td>
                                <td>${r.getEstudianteDTO().getNombre()}</td>
                                <td>${r.getCursoDTO().getNombre()}</td>
                                <td>${r.getFecha()}</td>
                                <td>
                                    <a class="btn btn-danger" href="Controlador?menu=registrar&accion=Eliminar&id=${r.getId()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>

            </div>

        </div>


        
        
        <script> src="js/jquery-3.4.1.min"</script>
        <script> src="js/bootstrap.min"</script>
    </body>
</html>
