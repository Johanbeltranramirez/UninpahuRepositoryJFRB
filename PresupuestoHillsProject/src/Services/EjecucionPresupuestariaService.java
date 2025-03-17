package Services;
import Models.EjecucionPresupuestaria;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class EjecucionPresupuestariaService {
    public void AgregarEjecucionPresupuestaria(EjecucionPresupuestaria ejecucion) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO ejecucion_presupuestaria(id, partida_id, montoReal, fecha) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, ejecucion.getId());
            stmt.setInt(2, ejecucion.partida.getId());
            stmt.setDouble(3, ejecucion.getMontoReal());
            stmt.setDate(4, new java.sql.Date(ejecucion.getFecha().getTime()));
            stmt.executeUpdate();
            System.out.println("La ejecución presupuestaria se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar ejecución presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarEjecucionPresupuestaria(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM ejecucion_presupuestaria WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La ejecución presupuestaria se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar ejecución presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarEjecucionPresupuestaria(EjecucionPresupuestaria ejecucion) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE ejecucion_presupuestaria SET partida_id = ?, montoReal = ?, fecha = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, ejecucion.partida.getId());
            stmt.setDouble(2, ejecucion.getMontoReal());
            stmt.setDate(3, new java.sql.Date(ejecucion.getFecha().getTime()));
            stmt.setInt(4, ejecucion.getId());
            stmt.executeUpdate();
            System.out.println("La ejecución presupuestaria se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar ejecución presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarEjecucionesPresupuestarias() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM ejecucion_presupuestaria";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int partidaId = rs.getInt(2);
                double montoReal = rs.getDouble(3);
                Date fecha = rs.getDate(4);
                
                System.out.println("ID: " + id);
                System.out.println("Partida ID: " + partidaId);
                System.out.println("Monto Real: " + montoReal);
                System.out.println("Fecha: " + fecha);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar ejecuciones presupuestarias " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
