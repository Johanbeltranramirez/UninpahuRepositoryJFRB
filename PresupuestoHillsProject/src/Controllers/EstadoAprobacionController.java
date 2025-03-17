package Controllers;
import Models.EstadoAprobacion;
import Services.EstadoAprobacionService;
import java.util.List;

public class EstadoAprobacionController {
    private EstadoAprobacionService estadoService;

    public EstadoAprobacionController(EstadoAprobacionService estadoService) {
        this.estadoService = estadoService;
    }

    public void insertarEstado(EstadoAprobacion estado) {
        if (estado == null) {
            System.err.println("Error: El estado de aprobación no puede ser nulo.");
            return;
        }

        estadoService.AgregarEstadoAprobacion(estado);
        System.out.println("Estado de aprobación registrado con éxito.");
    }

    public void actualizarEstado(EstadoAprobacion estado) {
        estadoService.EditarEstadoAprobacion(estado);
        System.out.println("Estado de aprobación actualizado con éxito.");
    }

    public void eliminarEstado(int id) {
        estadoService.EliminarEstadoAprobacion(id);
        System.out.println("Estado de aprobación eliminado correctamente.");
    }

    public void listarEstados() {
        estadoService.MostrarEstadosAprobacion();
    }
}
