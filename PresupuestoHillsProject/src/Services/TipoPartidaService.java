package Services;

import Models.TipoPartida;
import DB.DataBaseSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class TipoPartidaService {
    
   public void agregarTipoPartida( TipoPartida tipopartida){
       Connection conexion = DataBaseSQL.Conectar();
       String sql = "INSERT INTO tipopartida(id, descTipo) VALUES (?, ?)";
       
       try(PreparedStatement stmt = conexion.prepareStatement(sql)) {
           stmt.setInt(1, tipopartida.getTipoId());
           stmt.setString(2, tipopartida.getDescTipo());
           stmt.executeUpdate();
           System.out.println("El estado del tipo de partida se registró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar de tipo de partida " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
       }
   }

   public void EliminarTipoPartida(int id) {
       Connection conexion = DataBaseSQL.Conectar();
       String sql = "DELETE FROM tipopartida WHERE id = ?";
       
       try( PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El tipo partida se eliminó correctamente");
       }
       catch (SQLException e) {
            System.out.println("ERROR: Al eliminar tipo partida " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
        }
   }
   
   public void EditarTipoPartida(TipoPartida tipopartida, int id){
       Connection conexion = DataBaseSQL.Conectar();
       String sql = "UPDATE tipopartida SET descTipo = ? WHERE id = ?";
       
       try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
          stmt.setString(1, tipopartida.getDescTipo()); 
          stmt.setInt(2, id);
          stmt.executeUpdate();
            System.out.println("El tipo partida se editó correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar tipo de partida " + e.getMessage());
        } finally {
            DataBaseSQL.Desconectar(conexion);
       }
    }
   
    public ResultSet listarTipoPartida(String ConsultaSQL) {
        Connection conexion = DataBaseSQL.Conectar();
        ResultSet rs = null;
        
        try {
            PreparedStatement stmt = conexion.prepareStatement(ConsultaSQL);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.print("ERROR: Al consultar Tipo partida: " + e.getMessage());
        }

        return rs;
        
    }
}
    

