package Controllers;
import Models.Aprobacion;
import Services.AprobacionService;
import java.util.Date;

public class AprobacionController {
    public AprobacionService aprobacionService;

    public AprobacionController() {
        this.aprobacionService = new AprobacionService();
    }

    public void insertarAprobacion(Aprobacion aprobacion) {
        if (aprobacion == null) {
            System.err.println("Error: La aprobación no puede ser nula.");
            return;
        }

        aprobacionService.AgregarAprobacion(aprobacion);
        System.out.println("Categoría registrada con éxito.");
    }

    public void actualizarAprobacion(Aprobacion aprobacion) {
        aprobacionService.EditarAprobacion(aprobacion);
        System.out.println("Categoría actualizada con éxito.");
    }

    public void eliminarCategoria(int id) {
        aprobacionService.EliminarAprobacion(id);
        System.out.println("Categoría eliminada correctamente.");
    }

    public void listarAprobacion() {
        aprobacionService.MostrarAprobaciones();
    }
}
