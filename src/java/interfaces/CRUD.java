
package interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YO
 * @param <O>
 * @param <I>
 */
public interface CRUD <O, I> {
    
    
    public List<O> listar();
    
    public void insertar(O o);
    
    public O obtenerUno(I i);
    
    public void actualizar(O o);
    
    public void eliminar(I i);
    
    public O convertir(ResultSet r) throws SQLException;
    
    public Connection getConexion() throws SQLException;
    
}
