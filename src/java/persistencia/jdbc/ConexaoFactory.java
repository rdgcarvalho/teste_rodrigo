package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 */
class ConexaoFactory {

    public static Connection getConnection() throws SQLException {
    
   try{    
   return DriverManager.getConnection("jdbc:mysql://localhost:3306/poo","root", "root");
    }catch(SQLException e){
        //relançando exception
        throw new RuntimeException(e);
    }
   
    }
}
