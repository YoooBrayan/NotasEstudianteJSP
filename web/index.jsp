<%-- 
    Document   : login
    Created on : 15/07/2019, 08:38:12 PM
    Author     : YO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10"> 
                <div class="card-body">
                    <form class="form-sing" action="Validar" method="POST"> 
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/e7a5cf5c9e.svg" alt="70" width="170"/>
                            <label>Bienvenidos al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            
                            <input type="text" name="txtUser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtPass" class="form-control">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Home</a>
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                            
                    </form>
                </div>
            </div>
        </div>
        
        <script> src="js/jquery-3.4.1.min"</script>
        <script> src="js/bootstrap.min"</script>
    </body>
    
</html> 