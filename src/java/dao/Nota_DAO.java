package dao;

import conexion.PoolConexiones;
import dto.Curso_DTO;
import dto.Estudiante_DTO;
import dto.Nota_DTO;
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
public class Nota_DAO implements CRUD<Nota_DTO, Integer>{

    private Connection conexion;
    
    @Override
    public List<Nota_DTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Nota_DTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota_DTO obtenerUno(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Nota_DTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float acumulado(int codigo, int registro)
    {
        String sql = "select sum(nota*(porcentaje/100)) as acumulado from tb_Nota, tb_registro, tb_Estudiante, tb_Curso where tb_Estudiante.codigo_E = tb_registro.codigo_E and tb_registro.ID_R = tb_Nota.ID_R and tb_Curso.ID_C = tb_registro.ID_C and tb_Estudiante.codigo_E = ? and tb_registro.ID_R = ? group by tb_registro.ID_R";
        float acumulado = 0;
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, codigo);
                consulta.setInt(2, registro);
                ResultSet r = consulta.executeQuery();
                
                if(r.next())
                {
                    acumulado = r.getFloat("acumulado");
                }
                
                r.close();
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
                JOptionPane.showMessageDialog(null, "Error en cerrar: " + e.getMessage());
            }
        }
        return  acumulado;
    }

    public float necesito(int registro)
    {
        String sql = "select cuantoNecesito(?) as necesito";
        float necesito = 0;
        
        try {
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, registro);
                ResultSet r = consulta.executeQuery();
                
                if(r.next())
                {
                    necesito = r.getFloat("necesito");
                }
                
                r.close();
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
                JOptionPane.showMessageDialog(null, "Error en cerrar: " + e.getMessage());
            }
        }
        return necesito;
    }
    
    @Override
    public Nota_DTO convertir(ResultSet r) throws SQLException {
        
        Registro_DTO registro = new Registro_DTO();
        registro.setId(r.getInt("ID"));
        registro.setCursoDTO(new Curso_DTO(0, r.getString("Curso")));
        
        Nota_DTO nota = new Nota_DTO();
        
        nota.setRegistroDTO(registro);
        nota.setNota(r.getInt("Nota"));
        nota.setPorcentaje(r.getInt("Porcentaje"));
        
        return nota;
        
    }

    @Override
    public Connection getConexion() throws SQLException {
        return PoolConexiones.getConexion();
    }
    
    public List<Nota_DTO> mostrarNotas(int codigo)
    {
        String sql = "select tb_Registro.ID_R as ID, tb_Curso.Nombre_C as Curso, nota as Nota, porcentaje as Porcentaje " +
                    "from tb_Curso, tb_Estudiante, tb_registro, tb_Nota " +
                    "where tb_Estudiante.codigo_E = tb_registro.codigo_E and tb_registro.ID_C = tb_Curso.ID_C and tb_registro.ID_r = Tb_nota.ID_R and tb_estudiante.codigo_e = ?";    
        List<Nota_DTO> notas = new ArrayList<>();
        
        try {
            
            conexion = getConexion();
            
            if(conexion!=null)
            {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setInt(1, codigo);
                ResultSet r = consulta.executeQuery();
                
                while(r.next())
                {
                    notas.add(convertir(r));
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
        return  notas;
    }
    
}
