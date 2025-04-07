package Controllers;

import Models.TipoPartida;
import Services.TipoPartidaService;
import java.sql.*;

public class TipoPartidaController {
    
    public TipoPartidaService tipoService;
    
    public TipoPartidaController() {
        this.tipoService = new TipoPartidaService();
    }
    
    public void insertarTipoPartida(TipoPartida tipopartida) {
        tipoService.agregarTipoPartida(tipopartida);
    }
    
     public void eliminarTipoPartida(int id) {
       tipoService.EliminarTipoPartida(id);
   }
    

   public void actualizarTipoPartida(TipoPartida tipopartida, int id) {
       tipoService.EditarTipoPartida(tipopartida, id);
   }
   
   public ResultSet listarTipoPartida(String ConsultaSQL){
       return tipoService.listarTipoPartida(ConsultaSQL);
   }
}
