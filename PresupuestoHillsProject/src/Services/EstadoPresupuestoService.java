package Services;
import Models.EstadoPresupuesto;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstadoPresupuestoService {
    
    public void AgregarEstadoPresupuesto(EstadoPresupuesto estado) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO estadopresupuesto(id, descEstado) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estado.getId());
            stmt.setString(2, estado.getDescEstado());
            stmt.executeUpdate();
            System.out.println("El estado de presupuesto se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar estado de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarEstadoPresupuesto(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM estadopresupuesto WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El estado de presupuesto se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar estado de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarEstadoPresupuesto(EstadoPresupuesto estado, int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE estadopresupuesto SET descEstado = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado.getDescEstado());
            stmt.setInt(2, id); 
            stmt.executeUpdate();
            System.out.println("El estado de presupuesto se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar estado de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public ResultSet listarEstadoPresupuesto(String ConsultaSQL) {
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
