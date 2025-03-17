package Controllers;
import Models.Aprobacion;
import Services.AprobacionService;
import java.util.Date;
import java.util.List;

public class AprobacionController {
    private AprobacionService aprobacionService;

    public AprobacionController(AprobacionService categoriaService) {
        this.aprobacionService = aprobacionService;
    }

    public void insertarCategoria(Aprobacion aprobacion) {
        if (aprobacion == null) {
            System.err.println("Error: La aprobación no puede ser nula.");
            return;
        }

        aprobacionService.AgregarAprobacion(aprobacion);
        System.out.println("Categoría registrada con éxito.");
    }

    public void actualizarCategoria(Aprobacion aprobacion) {
        aprobacionService.EditarAprobacion(aprobacion);
        System.out.println("Categoría actualizada con éxito.");
    }

    public void eliminarCategoria(int id) {
        aprobacionService.EliminarAprobacion(id);
        System.out.println("Categoría eliminada correctamente.");
    }

    public void listarCategorias() {
        aprobacionService.MostrarAprobaciones();
    }
}
