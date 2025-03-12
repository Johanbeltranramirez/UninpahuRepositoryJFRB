package Controllers;

import Models.PartidaPresupuestaria;
import Models.CategoriaPresupuesto;
import Models.TipoPartida;
import Services.PartidaPresupuestariaService;
import java.util.Date;
import java.util.List;

public class PartidaPresupuestariaController {
    private PartidaPresupuestariaService partidaService;

    public PartidaPresupuestariaController(PartidaPresupuestariaService partidaService) {
        this.partidaService = partidaService;
    }

    public void insertarPartida(PartidaPresupuestaria partida) {
        if (partida == null) {
            System.err.println("Error: La partida presupuestaria no puede ser nula.");
            return;
        }

        boolean respuesta = partidaService.agregarPartida(partida);
        if (respuesta) {
            System.out.println("Partida presupuestaria registrada con éxito.");
        } else {
            System.err.println("Error al registrar la partida. Contacte al administrador.");
        }
    }

    public void actualizarPartida(int id, CategoriaPresupuesto categoria, String descripcion, double monto, TipoPartida tipo, Date fecha) {
        boolean respuesta = partidaService.actualizarPartida(id, categoria, descripcion, monto, tipo, fecha);
        if (respuesta) {
            System.out.println("Partida presupuestaria actualizada con éxito.");
        } else {
            System.err.println("Error al actualizar la partida. Contacte al administrador.");
        }
    }

    public void eliminarPartida(int id) {
        boolean respuesta = partidaService.eliminarPartida(id);
        if (respuesta) {
            System.out.println("Partida presupuestaria eliminada correctamente.");
        } else {
            System.err.println("Error al eliminar la partida. Contacte al administrador.");
        }
    }

    public void obtenerPartida(int id) {
        PartidaPresupuestaria partida = partidaService.obtenerPartidaPorId(id);
        if (partida != null) {
            System.out.println("Partida encontrada: " + partida.getDescripcion() + ", Monto: " + partida.getMonto());
        } else {
            System.err.println("No se encontró la partida con ID: " + id);
        }
    }

    public void listarPartidas() {
        List<PartidaPresupuestaria> partidas = partidaService.listarPartidas();
        if (partidas.isEmpty()) {
            System.out.println("No hay partidas presupuestarias registradas.");
        } else {
            for (PartidaPresupuestaria partida : partidas) {
                System.out.println("ID: " + partida.getId() + ", Descripción: " + partida.getDescripcion() + ", Monto: " + partida.getMonto());
            }
        }
    }
}
