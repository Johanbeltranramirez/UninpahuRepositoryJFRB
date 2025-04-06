package Services;

import Models.Rol;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RolService {
    public void AgregarRol(Rol rol){
        Connection conexion = DataBaseSQL.Conectar();
        
        String sql="INSETR INTO Rol (id, descRol) VALUES (?,?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setInt(1, rol.getRolId());
            stmt.setString(2, rol.getDescRol());
            System.out.println("El Rol se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar el rol " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarRol(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM Rol WHERE id =  ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
         stmt.setInt(1, id);
         stmt.executeUpdate();
         System.out.println("El rol se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar el rol" + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
     public void EditarRol(Rol rol, int is) {
         Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE Rol SET getDescRol=? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, rol.getRolId());
            stmt.setString(2, rol.getDescRol());
            stmt.executeUpdate();
            System.out.println("El Rol se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar el rol" + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
            
     }

    public ResultSet listarRoles(String ConsultaSQL){
        
        Connection conexion = DataBaseSQL.Conectar();
        
        ResultSet rs = null;
        
        try{
            PreparedStatement stmt = conexion.prepareStatement(ConsultaSQL);
            
            rs = stmt.executeQuery();
        }catch(SQLException e){
            System.out.print("ERROR: Al consultar Roles:" + e.getMessage());
        }
                
        return rs;
    }
}