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
        String sql = "INSERT INTO usuario (id, nDocId, nombre, email, password, rol) VALUES (?, ?, ?, ?)";
        
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
    
    public void EliminarUsuario(int id){
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
    
    public void EditarUsuario(Usuario usuario){
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE usuario SET nDocId = ?, nombre = ?, email = ?, rol = ? WHERE id = ?";
        
        try(PreparedStatement stmt = conexion.prepareStatement(sql)) {
           stmt.setInt(1, usuario.getId());
           stmt.setString(2, usuario.getNDocId());
           stmt.setString(3, usuario.getNombre());
           stmt.setString(4, usuario.getEmail());
           stmt.setInt(5, usuario.rol.getRolId());
            stmt.executeUpdate();
            System.out.println("El usuario se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar Usuario " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }

    public void MostrarUsuarios(){
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM usuario";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nDocId = rs.getString(2);
                String nombre = rs.getString(3);
                String email = rs.getString(4);
                int rol = rs.getInt(5);
                
                System.out.println("ID: " + id);
                System.out.println("NdocId" + nDocId);
                System.out.println("Nombre" + nombre);
                System.out.println("email" + email);
                System.out.println("rol" + rol);
                System.out.println("-------------------");
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar los usuarios " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
