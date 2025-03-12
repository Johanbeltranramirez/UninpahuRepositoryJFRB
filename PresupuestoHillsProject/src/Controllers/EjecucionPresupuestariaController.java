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

        boolean respuesta = ejecucionService.agregarEjecucion(ejecucion);
        if (respuesta) {
            System.out.println("Ejecución presupuestaria registrada con éxito.");
        } else {
            System.err.println("Error al registrar la ejecución. Contacte al administrador.");
        }
    }

    public void actualizarEjecucion(int id, double montoReal, Date fecha) {
        boolean respuesta = ejecucionService.actualizarEjecucion(id, montoReal, fecha);
        if (respuesta) {
            System.out.println("Ejecución presupuestaria actualizada con éxito.");
        } else {
            System.err.println("Error al actualizar la ejecución. Contacte al administrador.");
        }
    }

    public void eliminarEjecucion(int id) {
        boolean respuesta = ejecucionService.eliminarEjecucion(id);
        if (respuesta) {
            System.out.println("Ejecución presupuestaria eliminada correctamente.");
        } else {
            System.err.println("Error al eliminar la ejecución. Contacte al administrador.");
        }
    }

    public void obtenerEjecucion(int id) {
        EjecucionPresupuestaria ejecucion = ejecucionService.obtenerEjecucionPorId(id);
        if (ejecucion != null) {
            System.out.println("Ejecución encontrada: Monto real = " + ejecucion.getMontoReal());
        } else {
            System.err.println("No se encontró la ejecución con ID: " + id);
        }
    }

    public void listarEjecuciones() {
        List<EjecucionPresupuestaria> ejecuciones = ejecucionService.listarEjecuciones();
        if (ejecuciones.isEmpty()) {
            System.out.println("No hay ejecuciones registradas.");
        } else {
            for (EjecucionPresupuestaria ejecucion : ejecuciones) {
                System.out.println("ID: " + ejecucion.getId() + ", Monto Real: " + ejecucion.getMontoReal() + ", Fecha: " + ejecucion.getFecha());
            }
        }
    }
}
