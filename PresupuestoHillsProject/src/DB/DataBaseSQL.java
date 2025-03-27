package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSQL {
    
    private static final String url = "jdbc:mysql://localhost:3306/presupuestodb";
    private static final String usuario = "root"; 
    private static final String clave = ""; 
    
    public static Connection Conectar () {
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.print("Conexión establecida con éxito");
        } catch (ClassNotFoundException ex){
              System.out.print("No se pudo establecer la conexión :c");  
        } catch (SQLException ex){
              System.out.print("EROOR DE CONEXIÓN"); 
              ex.getStackTrace();
        }
        
        return conexion;
    }
    
    public static void Desconectar (Connection conexion){
        if (conexion != null)
        {
            try {
                conexion.close();
                System.out.print("La conexión se ha cerrado");
             } catch (SQLException ex){
                System.out.print("Error: Mal cierre de la conexión" + ex.getMessage());
            }
        }
    }
    
    
}
