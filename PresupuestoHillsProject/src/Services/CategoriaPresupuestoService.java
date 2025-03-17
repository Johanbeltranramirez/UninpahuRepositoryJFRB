package Services;
import Models.CategoriaPresupuesto;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaPresupuestoService {
    public void AgregarCategoriaPresupuesto(CategoriaPresupuesto categoria) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "INSERT INTO categoria_presupuesto(id, nombreCategoria) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNombreCategoria());
            stmt.executeUpdate();
            System.out.println("La categoría de presupuesto se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar categoría de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EliminarCategoriaPresupuesto(int id) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "DELETE FROM categoria_presupuesto WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La categoría de presupuesto se eliminó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar categoría de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void EditarCategoriaPresupuesto(CategoriaPresupuesto categoria) {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "UPDATE categoria_presupuesto SET nombreCategoria = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
            System.out.println("La categoría de presupuesto se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar categoría de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
    
    public void MostrarCategoriasPresupuesto() {
        Connection conexion = DataBaseSQL.Conectar();
        String sql = "SELECT * FROM categoria_presupuesto";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombreCategoria = rs.getString(2);
                
                System.out.println("ID: " + id);
                System.out.println("Nombre Categoría: " + nombreCategoria);
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar categorías de presupuesto " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
    }
}
