package Controllers;

import Models.PresupuestoGeneral;
import Models.EstadoPresupuesto;
import Models.CategoriaPresupuesto;
import Services.PresupuestoGeneralService;
import java.util.Date;
import java.util.List;

public class PresupuestoGeneralController {
    private PresupuestoGeneralService presupuestoService;

    public PresupuestoGeneralController(PresupuestoGeneralService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    public void insertarPresupuesto(PresupuestoGeneral presupuesto) {
        if (presupuesto == null) {
            System.err.println("Error: El presupuesto no puede ser nulo.");
            return;
        }

        boolean respuesta = presupuestoService.agregarPresupuesto(presupuesto);
        if (respuesta) {
            System.out.println("Presupuesto registrado con éxito.");
        } else {
            System.err.println("Error al registrar presupuesto. Contacte al administrador.");
        }
    }

    public void actualizarPresupuesto(int id, String nombre, String descripcion, double montoTotal, EstadoPresupuesto estado, CategoriaPresupuesto categoria, Date fechaCreacion) {
        boolean respuesta = presupuestoService.actualizarPresupuesto(id, nombre, descripcion, montoTotal, estado, categoria, fechaCreacion);
        if (respuesta) {
            System.out.println("Presupuesto actualizado con éxito.");
        } else {
            System.err.println("Error al actualizar presupuesto. Contacte al administrador.");
        }
    }

    public void eliminarPresupuesto(int id) {
        boolean respuesta = presupuestoService.eliminarPresupuesto(id);
        if (respuesta) {
            System.out.println("Presupuesto eliminado correctamente.");
        } else {
            System.err.println("Error al eliminar presupuesto. Contacte al administrador.");
        }
    }

    public void obtenerPresupuesto(int id) {
        PresupuestoGeneral presupuesto = presupuestoService.obtenerPresupuestoPorId(id);
        if (presupuesto != null) {
            System.out.println("Presupuesto encontrado: " + presupuesto.getNombre());
        } else {
            System.err.println("No se encontró el presupuesto con ID: " + id);
        }
    }

    public void listarPresupuestos() {
        List<PresupuestoGeneral> presupuestos = presupuestoService.listarPresupuestos();
        if (presupuestos.isEmpty()) {
            System.out.println("No hay presupuestos registrados.");
        } else {
            for (PresupuestoGeneral presupuesto : presupuestos) {
                System.out.println("ID: " + presupuesto.getId() + ", Nombre: " + presupuesto.getNombre() + ", Monto Total: " + presupuesto.getMontoTotal());
            }
        }
    }
}
