package Controllers;

import Models.PartidaPresupuestaria;
import Services.PartidaPresupuestariaService;
import java.util.Date;

public class PartidaPresupuestariaController {
    private PartidaPresupuestariaService partidaService;

    public PartidaPresupuestariaController() {
        this.partidaService = new PartidaPresupuestariaService();
    }

    public void insertarPartida(PartidaPresupuestaria partida) {
        if (partida == null) {
            System.err.println("Error: La partida presupuestaria no puede ser nula.");
            return;
        }

        partidaService.agregarPartida(partida);
        System.out.println("Partida presupuestaria registrada con éxito.");
    }

    public void actualizarPartida(PartidaPresupuestaria partida) {        
        partidaService.editarPartida(partida);
        System.out.println("Partida presupuestaria actualizada con éxito.");
    }

    public void eliminarPartida(int id) {
        partidaService.eliminarPartida(id);
        System.out.println("Partida presupuestaria eliminada correctamente.");
    }

    public void listarPartidas() {
        partidaService.MostrarPaertidas();
     }
}