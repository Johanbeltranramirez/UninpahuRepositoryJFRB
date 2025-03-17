package Controllers;

import Models.TipoPartida;
import Services.TipoPartidaService;
import java.util.Date;

public class TipoPartidaController {
    public TipoPartidaService tipoService;
    
    public TipoPartidaController() {
        this.tipoService = new TipoPartidaService();
    }
    
    public void insertarTipoPartida(TipoPartida tipopartida) {
        if(tipopartida == null){
            System.err.println("Error: El tipo de partida no puede ser nulo.");
            return;
        }
        
        tipoService.agregarTipoPartida(tipopartida);
         System.out.println("tipo partida registrado con éxito.");
    }
    

   public void actualizarTipoPartida(TipoPartida tipopartida) {
       tipoService.EditarTipoPartida(tipopartida);
       System.out.println("tipo partida actualizada con éxito");
   }
   
   public void eliminarTipoPartida(int id) {
       tipoService.EliminarTipoPartida(id);
       System.out.println("tipo partida eliminada correctamente");
   }
   
   public void listarTipoPartida(){
       tipoService.MostrarTipoPartidas();
   }
}
