package Services;

import Models.Aprobacion;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class AprobacionService {
    public void AgregarAprobacion(Aprobacion aprobacion) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO aprobacion(id, presupuesto_id, usuario_id, estado_id, comentarios, fechaAprobacion) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, aprobacion.getId());
            stmt.setInt(2, aprobacion.presupuesto.getId());
            stmt.setInt(3, aprobacion.usuario.getId());
            stmt.setInt(4, aprobacion.estado.getId());
            stmt.setString(5, aprobacion.getComentarios());
            stmt.setDate(6, new java.sql.Date(aprobacion.getFechaAprobacion().getTime()));
            stmt.executeUpdate();
            System.out.println("La aprobación se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarAprobacion(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM aprobacion WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La aprobación se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarAprobacion(Aprobacion aprobacion) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE aprobacion SET presupuesto_id = ?, usuario_id = ?, estado_id = ?, comentarios = ?, fechaAprobacion = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, aprobacion.presupuesto.getId());
            stmt.setInt(2, aprobacion.usuario.getId());
            stmt.setInt(3, aprobacion.estado.getId());
            stmt.setString(4, aprobacion.getComentarios());
            stmt.setDate(5, new java.sql.Date(aprobacion.getFechaAprobacion().getTime()));
            stmt.setInt(6, aprobacion.getId());
            stmt.executeUpdate();
            System.out.println("La aprobación se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar aprobación " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarAprobaciones() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM aprobacion";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int presupuestoId = rs.getInt(2);
                int usuarioId = rs.getInt(3);
                int estadoId = rs.getInt(4);
                String comentarios = rs.getString(5);
                Date fechaAprobacion = rs.getDate(6);
                
                System.out.println("ID: " + id);
                System.out.println("Presupuesto ID: " + presupuestoId);
                System.out.println("Usuario ID: " + usuarioId);
                System.out.println("Estado ID: " + estadoId);
                System.out.println("Comentarios: " + comentarios);
                System.out.println("Fecha Aprobación: " + fechaAprobacion);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar aprobaciones " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
