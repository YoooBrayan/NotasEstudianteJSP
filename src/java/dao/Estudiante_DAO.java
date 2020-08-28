package dao;

import conexion.PoolConexiones;
import dto.Estudiante_DTO;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author YO
 */
public class Estudiante_DAO implements CRUD<Estudiante_DTO, Integer>{

    private Connection conexion = null;

    @Override
    public List<Estudiante_DTO> listar() {
        
        String sql = "select * from tb_estudiante";
        List<Estudiante_DTO> estudiantes = new ArrayList<>();
        
        try {
            
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                ResultSet r = consulta.executeQuery();
                
                while(r.next())
                {
                    estudiantes.add(convertir(r));
                }
                        
                r.close();
                consulta.close();
            }   
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally
        {
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
        
        return estudiantes;
    }

    @Override
    public void insertar(Estudiante_DTO o) {
        
        String sql = "insert into tb_Estudiante () values (?,?,?,?,?,?)";
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, o.getCodigo());
                consulta.setString(2, o.getNombre());
                consulta.setString(3, o.getApellido());
                consulta.setString(4, o.getCorreo());
                consulta.setString(5, o.getClave());
                consulta.setInt(6, o.getCc());
                
                consulta.executeUpdate();
                consulta.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage());
        }finally
        {
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
        
    }

    @Override
    public Estudiante_DTO obtenerUno(Integer i) {
        
        String sql = "select * from tb_estudiante where codigo_E = ?";
        Estudiante_DTO estudianteO = null;
        
        try {
            conexion = getConexion();
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, i);
                ResultSet r = consulta.executeQuery();
                
                if(r.next())
                {
                    estudianteO = convertir(r);
                }
                
                r.close();
                consulta.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: " + e.getMessage());
        }finally
        {
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
        
        return estudianteO;
    }

    @Override
    public void actualizar(Estudiante_DTO o) {
       
        String sql = "call actualizarEstudiante(?,?,?,?)";
        
        try {
            
            conexion = getConexion();
            
            if(conexion != null)
            {
                PreparedStatement consulta = conexion.prepareCall(sql);
                consulta.setString(1, o.getNombre());
                consulta.setString(2, o.getApellido());
                consulta.setString(3, o.getCorreo());
                consulta.setString(4, o.getClave());
                
                consulta.executeUpdate();
                consulta.close();
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }finally{
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
    }

    @Override
    public void eliminar(Integer i) {
        
        String sql = "delete from tb_Estudiante where codigo_E = ?";
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareCall(sql);
                consulta.setInt(1, i);
                
                consulta.executeUpdate();
                consulta.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error  al Eliminar: " + e.getMessage());
        }finally{
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
    }
    
    public Estudiante_DTO validar(int user, String pass)
    {
        String sql = "select * from tb_Estudiante where codigo_E = ? and clave_E = ?";
        Estudiante_DTO estudianteV = new Estudiante_DTO();
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, user);
                consulta.setString(2, pass);
                ResultSet r = consulta.executeQuery();
                
                if(r.next())
                {
                    estudianteV = convertir(r);
                }
                
                r.close();
                consulta.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Validar: " + e.getMessage());            
        }finally
        {
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar Conexion: " + e.getMessage());
            }
        }
        return estudianteV;
    }

    @Override
    public Estudiante_DTO convertir(ResultSet r) throws SQLException {
        
        Estudiante_DTO personaR = new Estudiante_DTO(r.getInt("codigo_E"), r.getString("nombre_E"), r.getString("apellido_E"), r.getString("correo_E"), r.getString("clave_E"), r.getInt("CC_E"));
        return personaR;
    }

    @Override
    public Connection getConexion() throws SQLException {
        
        return PoolConexiones.getConexion();
        
    }

}
