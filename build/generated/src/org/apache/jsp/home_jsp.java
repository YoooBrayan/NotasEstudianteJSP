package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            if (session.getAttribute("estudiante") == null) {
                response.sendRedirect("index.jsp");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-info\" style=\"margin-left: 130px; margin-right: 130px\">\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("              <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=home\">Home</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=persona&accion=Listar\" target=\"myFrame\">Registrar Curso</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador\" target=\"myFrame\">Ver Notas</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=registro&accion=Listar\" target=\"myFrame\">Certificados</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("            </div>  \n");
      out.write("            \n");
      out.write("            <div class=\"login\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${estudiante.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li>\n");
      out.write("                                    <a class=\"ani\" href=\"#\">\n");
      out.write("                                        <img src=\"img/IMG_20180220_091211.jpg\" alt=\"60\" width=\"60\"/>\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a class=\"an\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${estudiante.getApellido()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                                <li><a class=\"an\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${estudiante.getCorreo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                                <form action=\"Validar\" method=\"POST\">\n");
      out.write("                                    <button name=\"accion\" value=\"Salir\" class=\"dropdown-item\" href=\"#\">Salir</button>\n");
      out.write("                                    <label name=\"usuario\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${estudiante.getCodigo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>\n");
      out.write("                                </form> \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"m-4\" style=\"height: 550px\">              \n");
      out.write("            <iframe name=\"myFrame\" style=\"height: 100%; width: 100%; border: none\"><iframe>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("        <script> src=\"js/jquery-3.4.1.min\"</script>\n");
      out.write("        <script> src=\"js/bootstrap.min\"</script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
