package Controllers;

import Models.TipoPartida;
import Services.TipoPartidaService;
import java.util.List;

public class TipoPartidaController {
    private TipoPartidaService tipoService;

    public TipoPartidaController(TipoPartidaService tipoService) {
        this.tipoService = tipoService;
    }

    public void insertarTipoPartida(TipoPartida tipo) {
        if (tipo == null) {
            System.err.println("Error: El tipo de partida no puede ser nulo.");
            return;
        }

        boolean respuesta = tipoService.agregarTipoPartida(tipo);
        if (respuesta) {
            System.out.println("Tipo de partida registrado con éxito.");
        } else {
            System.err.println("Error al registrar el tipo de partida. Contacte al administrador.");
        }
    }

    public void actualizarTipoPartida(int id, String descTipo) {
        boolean respuesta = tipoService.actualizarTipoPartida(id, descTipo);
        if (respuesta) {
            System.out.println("Tipo de partida actualizado con éxito.");
        } else {
            System.err.println("Error al actualizar el tipo de partida. Contacte al administrador.");
        }
    }

    public void eliminarTipoPartida(int id) {
        boolean respuesta = tipoService.eliminarTipoPartida(id);
        if (respuesta) {
            System.out.println("Tipo de partida eliminado correctamente.");
        } else {
            System.err.println("Error al eliminar el tipo de partida. Contacte al administrador.");
        }
    }

    public void obtenerTipoPartida(int id) {
        TipoPartida tipo = tipoService.obtenerTipoPartidaPorId(id);
        if (tipo != null) {
            System.out.println("Tipo de partida encontrado: " + tipo.getDescTipo());
        } else {
            System.err.println("No se encontró el tipo de partida con ID: " + id);
        }
    }

    public void listarTiposPartida() {
        List<TipoPartida> tipos = tipoService.listarTiposPartida();
        if (tipos.isEmpty()) {
            System.out.println("No hay tipos de partida registrados.");
        } else {
            for (TipoPartida tipo : tipos) {
                System.out.println("ID: " + tipo.getId() + ", Tipo: " + tipo.getDescTipo());
            }
        }
    }
}
