package Services;

import Models.PresupuestoGeneral;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class PresupuestoGeneralService {
    public void agregarPresupuesto(PresupuestoGeneral presupuesto) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO presupuesto_general(id, nombre, descripcion, monto_total, estado_id, categoria_id, fecha_creacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, presupuesto.getId());
            stmt.setString(2, presupuesto.getNombre());
            stmt.setString(3, presupuesto.getDescripcion());
            stmt.setDouble(4, presupuesto.getMontoTotal());
            stmt.setInt(5, presupuesto.estado.getId());
            stmt.setInt(6, presupuesto.categoria.getId());
            stmt.setDate(7, new java.sql.Date(presupuesto.getFechaCreacion().getTime()));
            stmt.executeUpdate();
            System.out.println("El presupuesto se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void eliminarPresupuesto(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM presupuesto_general WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El presupuesto se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void editarPresupuesto(PresupuestoGeneral presupuesto) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE presupuesto_general SET nombre = ?, descripcion = ?, monto_total = ?, estado_id = ?, categoria_id = ?, fecha_creacion = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, presupuesto.getNombre());
            stmt.setString(2, presupuesto.getDescripcion());
            stmt.setDouble(3, presupuesto.getMontoTotal());
            stmt.setInt(4, presupuesto.estado.getId());
            stmt.setInt(5, presupuesto.categoria.getId());
            stmt.setDate(6, new java.sql.Date(presupuesto.getFechaCreacion().getTime()));
            stmt.setInt(7, presupuesto.getId());
            stmt.executeUpdate();
            System.out.println("El presupuesto se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarPresupuetsos() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM presupuesto_general";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                double montoTotal = rs.getDouble(4);
                int estadoId = rs.getInt(5);
                int categoriaId = rs.getInt(6);
                Date fechaCreacion = rs.getDate(7);
                
                System.out.println("id" + id);
                System.out.println("nombre" +nombre);
                System.out.println("descripcion" + descripcion);
                System.out.println("monto_total" + montoTotal);
                System.out.println("estado_id" + estadoId);
                System.out.println("categoria_id" + categoriaId);
                System.out.println("fecha_creacion" + fechaCreacion);
                System.out.println("-------------------");
                
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar presupuestos " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
