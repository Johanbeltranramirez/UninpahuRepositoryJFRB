package Services;

import Models.PartidaPresupuestaria;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class PartidaPresupuestariaService {
    public void agregarPartida(PartidaPresupuestaria partida) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO partida_presupuestaria(id, categoria_id, descripcion, monto, tipo_id, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, partida.getId());
            stmt.setInt(2, partida.categoria.getId());
            stmt.setString(3, partida.getDescripcion());
            stmt.setDouble(4, partida.getMonto());
            stmt.setInt(5, partida.tipo.getTipoId());
            stmt.setDate(6, new java.sql.Date(partida.getFecha().getTime()));
            stmt.executeUpdate();
            System.out.println("La partida presupuestaria se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar partida presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void eliminarPartida(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM partida_presupuestaria WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La partida presupuestaria se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar partida presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void editarPartida(PartidaPresupuestaria partida) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE partida_presupuestaria SET categoria_id = ?, descripcion = ?, monto = ?, tipo_id = ?, fecha = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, partida.categoria.getId());
            stmt.setString(2, partida.getDescripcion());
            stmt.setDouble(3, partida.getMonto());
            stmt.setInt(4, partida.tipo.getTipoId());
            stmt.setDate(5, new java.sql.Date(partida.getFecha().getTime()));
            stmt.setInt(6, partida.getId());
            stmt.executeUpdate();
            System.out.println("La partida presupuestaria se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar partida presupuestaria " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarPaertidas() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM partida_presupuestaria";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int categoriaId = rs.getInt(2);
                String descripcion = rs.getString(3);
                double monto = rs.getDouble(4);
                int tipoId = rs.getInt(5);
                Date fecha = rs.getDate(6);
                
                System.out.println("ID: " + id);
                System.out.println("Categoría ID: " + categoriaId);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Monto: " + monto);
                System.out.println("Tipo ID: " + tipoId);
                System.out.println("Fecha: " + fecha);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar partidas presupuestarias " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}