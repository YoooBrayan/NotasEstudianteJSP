package cto;

import dao.Nota_DAO;
import dao.Registro_DAO;
import dto.Curso_DTO;
import dto.Estudiante_DTO;
import dto.Nota_DTO;
import dto.Registro_DTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author YO
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Nota_DAO notaDAO = new Nota_DAO();
    Registro_DAO registroDAO = new Registro_DAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if(menu.equalsIgnoreCase("notas"))
        {
            switch(accion)
            {
                case "verNotas":
                    
                    List<Nota_DTO> notas = notaDAO.mostrarNotas(1000);
                    request.setAttribute("notas", notas);
                    request.getRequestDispatcher("notas.jsp").forward(request, response);
                        
                    break;
                    
                case "Acumulado":
                    
                    Estudiante_DTO idE = (Estudiante_DTO) sesion.getAttribute("estudiante");
                    int idR = Integer.parseInt(request.getParameter("id"));
                    
                    float acumulado = notaDAO.acumulado(idE.getCodigo(), idR);
                    
                    Nota_DTO notaA = new Nota_DTO();
                    notaA.setRegistroDTO(new Registro_DTO(idR, "",  null, new Curso_DTO(0, request.getParameter("curso"))));
                    notaA.setAcumulado(acumulado);
                    
                    request.setAttribute("nota", notaA);
                    
                    request.getRequestDispatcher("Controlador?menu=notas&accion=verNotas").forward(request, response);
                    
                    break;
                    
                case "Necesita":
                    
                    int idRN = Integer.parseInt(request.getParameter("id"));
                    
                    float necesito = notaDAO.necesito(idRN);
                    
                    Nota_DTO notaN = new Nota_DTO();
                    notaN.setRegistroDTO(new Registro_DTO(idRN, "",  null, new Curso_DTO(0, request.getParameter("curso"))));
                    notaN.setCuantoNecesito(necesito);
                    
                    request.setAttribute("nota", notaN);
                    
                    request.getRequestDispatcher("Controlador?menu=notas&accion=verNotas").forward(request, response);
                    
                    break;
            }

        }
        
        if(menu.equalsIgnoreCase("registrar"))
        {
            switch(accion)
            {
                
                case "Listar": 
                    
                    List<Registro_DTO> registros = registroDAO.listar();
                    request.setAttribute("registros", registros);
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                    
                    break;
                case "Agregar":
                    
                    Registro_DTO registroN = new Registro_DTO();
                    
                    int idC = Integer.parseInt(request.getParameter("idCurso"));
                    
                    Estudiante_DTO estudiante = (Estudiante_DTO) sesion.getAttribute("estudiante");
                    Curso_DTO curso = new Curso_DTO();
                    curso.setId(idC);
                    
                    registroN.setEstudianteDTO(estudiante);
                    registroN.setCursoDTO(curso);
                    
                    registroDAO.insertar(registroN);
                    if (registroDAO.getMensaje().contains("estudiante")) {
                        request.setAttribute("mensaje", "El estudiante con ID: " + estudiante.getCodigo() + " no existe");
                    } else if (registroDAO.getMensaje().contains("curso")) {
                        request.setAttribute("mensaje", "El curso con ID: " + curso.getId()+ " no existe");
                    } else if (registroDAO.getMensaje().contains("Duplicate entry")) {
                        request.setAttribute("mensaje", "la Persona con ID: " + estudiante.getCodigo() + " Ya esta registrado en el Curso: " + curso.getId());
                    }
                    
                    request.getRequestDispatcher("Controlador?menu=registrar&accion=Listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    
                    int idR = Integer.parseInt(request.getParameter("id"));
                    registroDAO.eliminar(idR);;
                    request.getRequestDispatcher("Controlador?menu=registrar&accion=Listar").forward(request, response);
                    
                    break;
                    
            }
        }
        
        if(menu.equalsIgnoreCase("home"))
        {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
