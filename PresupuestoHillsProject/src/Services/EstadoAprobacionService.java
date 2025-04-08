package Services;
import Models.EstadoAprobacion;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstadoAprobacionService {
    
    public void AgregarEstadoAprobacion(EstadoAprobacion estado) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO estadoaprobacion(id, descEstado) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estado.getId());
            stmt.setString(2, estado.getDescEstado());
            stmt.executeUpdate();
            System.out.println("El estado de aprobación se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar estado de aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarEstadoAprobacion(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM estadoaprobacion WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El estado de aprobación se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar estado de aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarEstadoAprobacion(EstadoAprobacion estado, int id) {
    Connection conexion = DataBaseSQL.Conectar();
    String sql = "UPDATE estadoaprobacion SET descEstado = ? WHERE id = ?";
    
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, estado.getDescEstado());
        stmt.setInt(2, id); // CORREGIDO: usar el id recibido por parámetro
        stmt.executeUpdate();
        System.out.println("El estado de aprobación se editó correctamente");
    } catch (SQLException e) {
        System.out.println("ERROR: Al editar estado de aprobación " + e.getMessage());
    } finally {
        DataBaseSQL.Desconectar(conexion);
    }
}

    
    public ResultSet ListarEstadosAprobacion(String ConsultaSQL) {
        Connection conexion = DataBaseSQL.Conectar();
        ResultSet rs = null;
        
        try {
            PreparedStatement stmt = conexion.prepareStatement(ConsultaSQL);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.print("ERROR: Al consultar Roles: " + e.getMessage());
        }

        return rs;
    }
}
