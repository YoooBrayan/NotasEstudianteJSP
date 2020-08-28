<%-- 
    Document   : home
    Created on : 9/07/2019, 10:21:34 AM
    Author     : YO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Home</title>
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
        
        <nav class="navbar navbar-expand-lg navbar-light bg-info" style="margin-left: 130px; margin-right: 130px">
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=home">Home</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=registrar&accion=Listar" target="myFrame">Registrar Curso</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=notas&accion=verNotas" target="myFrame">Ver Notas</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=registro&accion=Listar" target="myFrame">Certificados</a>
                </li>
              </ul>
            </div>  
            
            <div class="login">
                    <ul>
                        <li><a href="#">${estudiante.getNombre()}</a>
                            <ul>
                                <li>
                                    <a class="ani" href="#">
                                        <img src="img/IMG_20180220_091211.jpg" alt="60" width="60"/>
                                    </a>
                                </li>
                                <li><a class="an" href="#">${estudiante.getApellido()}</a></li>
                                <li><a class="an" href="#">${estudiante.getCorreo()}</a></li>
                                <form action="Validar" method="POST">
                                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                                </form> 
                            </ul>
                        </li>
                    </ul>
                </div>
        </nav>

        <div class="m-4" style="height: 550px">              
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"><iframe>
        </div>
            
        </div>
                        
                        
        <script> src="js/jquery-3.4.1.min"</script>
        <script> src="js/bootstrap.min"</script>
    </body>
</html>