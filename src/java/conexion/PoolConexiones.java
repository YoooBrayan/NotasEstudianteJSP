package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author YO
 */
public class PoolConexiones {
    
    private static BasicDataSource dataSource = null;

    private static DataSource getDataSource()
    {
        if(dataSource == null)
        {   
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dataSource.setUrl("jdbc:mysql://localhost:3306/bd_Proyecto");
            dataSource.setMaxActive(30);
            dataSource.setMaxIdle(30);
            dataSource.setRemoveAbandoned(true);
            dataSource.setRemoveAbandonedTimeout(5000);
            dataSource.setMaxWait(6000);
        }
        return dataSource;
    }
    
    public static Connection getConexion() throws SQLException
    {
        return getDataSource().getConnection();
    }
    
}
