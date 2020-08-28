package dao;

import conexion.PoolConexiones;
import dto.Curso_DTO;
import dto.Estudiante_DTO;
import dto.Registro_DTO;
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
public class Registro_DAO implements CRUD<Registro_DTO, Integer>{

    private Connection conexion;
    private String mensaje;

    public Registro_DAO() {
        this.mensaje = "";
    }

    public Registro_DAO(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    @Override
    public List<Registro_DTO> listar() {
        
        String sql = "select tb_Registro.ID_R as ID, Nombre_E, Nombre_C, Fecha_R from Tb_Registro, tb_estudiante, tb_Curso where tb_estudiante.codigo_e = Tb_Registro.codigo_E and TB_Curso.ID_C = tb_Registro.ID_C";
        List<Registro_DTO> registros = new ArrayList<>();
        try {

            conexion = getConexion();

            if (conexion != null) {

                PreparedStatement psmt;
                psmt = conexion.prepareStatement(sql);
                ResultSet rs;
                rs = psmt.executeQuery();

                while (rs.next()) {
                    registros.add(convertir(rs));
                }
                rs.close();
                psmt.close();

            } else {
                //JOptionPane.showMessageDialog(null, "Conexion nula");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error aca: " + ex);
        } finally {
            try {
                    conexion.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en conexion: " + ex);
                }
        }
        return registros;
        
    }

    @Override
    public void insertar(Registro_DTO o) {
        
        String sql = "insert into tb_registro(codigo_E, ID_C, fecha_R) values (?,?,now())";
        
        try {
            
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareCall(sql);
                consulta.setInt(1, o.getEstudianteDTO().getCodigo());
                consulta.setInt(2, o.getCursoDTO().getId());
                
                consulta.executeUpdate();
            }
            
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        
    }

    @Override
    public Registro_DTO obtenerUno(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Registro_DTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer i) {
      
        String sql = "delete from tb_registro where ID_R = ?";
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareCall(sql);
                consulta.setInt(1, i);
                
                consulta.executeUpdate();
                
                consulta.close();
                consulta.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }finally{
            try {
                if(conexion!=null)
                {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar: " + e.getMessage());
            }
        }
        
    }

    @Override
    public Registro_DTO convertir(ResultSet r) throws SQLException {
        
        Registro_DTO registro = new Registro_DTO(r.getInt("ID"), r.getString("Fecha_R"), new Estudiante_DTO(0, r.getString("Nombre_E"), "", "", "", 0), new Curso_DTO(0, r.getString("Nombre_C")));
        return registro;
    }

    @Override
    public Connection getConexion() throws SQLException {
        return PoolConexiones.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
