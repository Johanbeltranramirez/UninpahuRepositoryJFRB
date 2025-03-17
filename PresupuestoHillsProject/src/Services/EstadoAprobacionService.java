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
        String sql = "INSERT INTO estado_aprobacion(id, descEstado) VALUES (?, ?)";
        
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
        String sql = "DELETE FROM estado_aprobacion WHERE id = ?";
        
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
    
    public void EditarEstadoAprobacion(EstadoAprobacion estado) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE estado_aprobacion SET descEstado = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado.getDescEstado());
            stmt.setInt(2, estado.getId());
            stmt.executeUpdate();
            System.out.println("El estado de aprobación se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar estado de aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarEstadosAprobacion() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM estado_aprobacion";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String descEstado = rs.getString(2);
                
                System.out.println("ID: " + id);
                System.out.println("Estado: " + descEstado);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar estados de aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
