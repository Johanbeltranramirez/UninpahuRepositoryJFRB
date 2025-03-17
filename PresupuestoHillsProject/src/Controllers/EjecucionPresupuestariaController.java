package Controllers;
import Models.EjecucionPresupuestaria;
import Services.EjecucionPresupuestariaService;
import java.util.Date;
import java.util.List;

public class EjecucionPresupuestariaController {
    private EjecucionPresupuestariaService ejecucionService;

    public EjecucionPresupuestariaController(EjecucionPresupuestariaService ejecucionService) {
        this.ejecucionService = ejecucionService;
    }

    public void insertarEjecucion(EjecucionPresupuestaria ejecucion) {
        if (ejecucion == null) {
            System.err.println("Error: La ejecución presupuestaria no puede ser nula.");
            return;
        }

        ejecucionService.AgregarEjecucionPresupuestaria(ejecucion);
        System.out.println("Ejecución presupuestaria registrada con éxito.");
    }

    public void actualizarEjecucion(EjecucionPresupuestaria ejecucion) {
        ejecucionService.EditarEjecucionPresupuestaria(ejecucion);
        System.out.println("Ejecución presupuestaria actualizada con éxito.");
    }

    public void eliminarEjecucion(int id) {
        ejecucionService.EliminarEjecucionPresupuestaria(id);
        System.out.println("Ejecución presupuestaria eliminada correctamente.");
    }

    public void listarEjecuciones() {
        ejecucionService.MostrarEjecucionesPresupuestarias();
    }
}