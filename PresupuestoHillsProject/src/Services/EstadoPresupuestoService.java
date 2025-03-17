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
        String sql = "INSERT INTO estado_presupuesto(id, descEstado) VALUES (?, ?)";
        
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
        String sql = "DELETE FROM estado_presupuesto WHERE id = ?";
        
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
    
    public void EditarEstadoPresupuesto(EstadoPresupuesto estado) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE estado_presupuesto SET descEstado = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado.getDescEstado());
            stmt.setInt(2, estado.getId());
            stmt.executeUpdate();
            System.out.println("El estado de presupuesto se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar estado de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarEstadosPresupuesto() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM estado_presupuesto";
        
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
            System.out.println("ERROR: Al consultar estados de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
