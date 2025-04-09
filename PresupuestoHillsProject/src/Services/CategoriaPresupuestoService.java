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
        String sql = "INSERT INTO categoriapresupuesto(id, nombreCategoria) VALUES (?, ?)";
        
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
        String sql = "DELETE FROM categoriapresupuesto WHERE id = ?";
        
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
    
    public void EditarCategoriaPresupuesto(CategoriaPresupuesto categoria, int id) {
    Connection conexion = DataBaseSQL.Conectar();
    String sql = "UPDATE categoriapresupuesto SET nombreCategoria = ? WHERE id = ?";
    
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, categoria.getNombreCategoria());
        stmt.setInt(2, id); 
        stmt.executeUpdate();
        System.out.println("La categoría de presupuesto se editó correctamente");
    } catch (SQLException e) {
        System.out.println("ERROR: Al editar categoría de presupuesto " + e.getMessage());
    } finally {
        DataBaseSQL.Desconectar(conexion);
    }
}

    
    public ResultSet MostrarCategoriasPresupuesto(String ConsultaSQL) {
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
