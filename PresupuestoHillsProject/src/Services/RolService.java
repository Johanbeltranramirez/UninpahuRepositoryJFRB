package Services;

import Models.Rol;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



    public class RolService {

    public void AgregarRol(Rol rol) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO Rol (id, descRol) VALUES (?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, rol.getRolId());
            stmt.setString(2, rol.getDescRol());
            stmt.executeUpdate(); 
            System.out.println("El Rol se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar el rol " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }

    public void EliminarRol(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM Rol WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El rol se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar el rol: " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }

    public void EditarRol(Rol rol, int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE Rol SET descRol = ? WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, rol.getDescRol());
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("El Rol se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar el rol: " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }

    
    public ResultSet listarRoles(String ConsultaSQL) {
        Connection conexion = DataBaseSQL.Conectar();
        ResultSet rs = null;
        
        if (conexion != null){
            try {
                PreparedStatement stmt = conexion.prepareStatement(ConsultaSQL);
                rs = stmt.executeQuery();
            } catch (SQLException e) {
                System.out.print("ERROR: Al consultar Roles: " + e.getMessage());
            }

        }
      return rs;
        
    }
    
   
    public List<Rol> listarRol() {
    List<Rol> listaRol = new ArrayList<>();
    String consultaSQL = "SELECT * FROM Rol";

    try (Connection conexion = DataBaseSQL.Conectar();
         PreparedStatement stmt = conexion.prepareStatement(consultaSQL);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Rol rol = new Rol();
            rol.setId(rs.getInt("id"));
            rol.setDescRol(rs.getString("descRol"));
            listaRol.add(rol);
        }

    } catch (SQLException e) {
        System.out.println("ERROR al listar roles: " + e.getMessage());
    }

    return listaRol;
}

    

    public Rol ConsultarRol(int id) {
    String sql = "SELECT descRol FROM Rol WHERE id = ?";
    Rol RolEncontrado = new Rol();

    try (Connection conexion = DataBaseSQL.Conectar();
         PreparedStatement consulta = conexion.prepareStatement(sql)) {
        
        consulta.setInt(1, id);
        try (ResultSet resultado = consulta.executeQuery()) {
            if (resultado.next()) {
                RolEncontrado.setDescRol(resultado.getString("descRol"));
                RolEncontrado.setId(id);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se encontraron registros", "Error al recuperar el rol", JOptionPane.ERROR_MESSAGE);
        System.out.println("Error de tipo: " + e);
        System.out.println("Error en la clase: " + this.getClass().getName());
    }

    return RolEncontrado;
}


}