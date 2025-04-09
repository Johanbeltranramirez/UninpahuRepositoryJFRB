package Services;

import Models.Usuario;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioService {
    
    public void AgregarUsuario(Usuario usuario){
        Connection conexion = DataBaseSQL.Conectar();
        
        String sql = "INSERT INTO usuario (id, nDocId, nombre, email, password, rol) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNDocId());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getPassword());
            stmt.setInt(6, usuario.rol.getRolId());
            stmt.executeUpdate();
            System.out.println("Elusuario se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar el usuario " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarUsuario(Usuario usuario, int id) {
    Connection conexion = DataBaseSQL.Conectar();
    String sql = "UPDATE usuario SET nDocId = ?, nombre = ?, email = ?, rol = ? WHERE id = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, usuario.getNDocId());
        stmt.setString(2, usuario.getNombre());
        stmt.setString(3, usuario.getEmail());
        stmt.setInt(4, usuario.getRol().getRolId());
        stmt.setInt(5, id);

        stmt.executeUpdate();
        System.out.println("El usuario se editó correctamente");
    } catch (SQLException e) {
        System.out.println("ERROR: Al editar Usuario " + e.getMessage());
    } finally {
        DataBaseSQL.Desconectar(conexion);
    }
}
    public ResultSet ConsultarUsuario(String ConsultaSQL){
        
        Connection conexion = DataBaseSQL.Conectar();
        
        ResultSet rs = null;
        
        try{
            PreparedStatement stmt = conexion.prepareStatement(ConsultaSQL);
            
            rs = stmt.executeQuery();
        }catch(SQLException e){
            System.out.print("ERROR: Al consultar Usuario" + e.getMessage());
        }
                
        return rs;
    }
    
    
    public void EliminarUsuario(int id) {
    Connection conexion = DataBaseSQL.Conectar();
    String sql = "DELETE FROM usuario WHERE id = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("El usuario se eliminó correctamente");
    } catch (SQLException e) {
        System.out.println("ERROR: Al eliminar usuario " + e.getMessage());
    } finally {
        DataBaseSQL.Desconectar(conexion);
    }
}

    
    
    
   
}
