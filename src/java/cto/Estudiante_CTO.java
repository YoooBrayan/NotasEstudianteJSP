
package cto;

import dao.Estudiante_DAO;
import dto.Estudiante_DTO;
import java.util.List;

/**
 *
 * @author YO
 */
public class Estudiante_CTO {
    
    private Estudiante_DAO estudianteDAO;
    
    public Estudiante_CTO()
    {
        estudianteDAO = new Estudiante_DAO();
    }
    
    public List<Estudiante_DTO> listar()
    {
        return estudianteDAO.listar();
    }
    
    public Estudiante_DTO obtenerUno(int i)
    {
        return estudianteDAO.obtenerUno(i);
    }
    
    public void insertar(Estudiante_DTO estudianteN)
    {
        estudianteDAO.insertar(estudianteN);
    }
    
    public void actualizar(Estudiante_DTO estudianteA)
    {
        estudianteDAO.actualizar(estudianteA);
    }
    
    public void eliminar(int i)
    {
        estudianteDAO.eliminar(i);
    }
    
    public Estudiante_DTO validar(int user, String pass)
    {
        return estudianteDAO.validar(user, pass);
    }
    
}

