package Controllers;

import Models.PresupuestoGeneral;
import Services.PresupuestoGeneralService;
import java.util.List;

public class PresupuestoGeneralController {
    private PresupuestoGeneralService presupuestoService;

    public PresupuestoGeneralController() {
        this.presupuestoService = new PresupuestoGeneralService();
    }

    public void insertarPresupuesto(PresupuestoGeneral presupuesto) {
        boolean respuesta = presupuestoService.agregarPresupuesto(presupuesto);
        if (respuesta) {
            System.out.println("Presupuesto registrado con éxito.");
        } else {
            System.out.println("Error al registrar presupuesto. Contacte al administrador.");
        }
    }

    public void actualizarPresupuesto(PresupuestoGeneral presupuesto) {
        boolean respuesta = presupuestoService.actualizarPresupuesto(presupuesto);
        if (respuesta) {
            System.out.println("Presupuesto actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar presupuesto. Contacte al administrador.");
        }
    }

    public void eliminarPresupuesto(int id) {
        boolean respuesta = presupuestoService.eliminarPresupuesto(id);
        if (respuesta) {
            System.out.println("Presupuesto eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar presupuesto. Contacte al administrador.");
        }
    }

    public void obtenerPresupuesto(int id) {
        PresupuestoGeneral presupuesto = presupuestoService.obtenerPresupuesto(id);
        if (presupuesto != null) {
            System.out.println(presupuesto);
        } else {
            System.out.println("Presupuesto no encontrado.");
        }
    }

    public void imprimirPresupuestos() {
        List<PresupuestoGeneral> presupuestos = presupuestoService.listarPresupuestos();
        if (presupuestos.isEmpty()) {
            System.out.println("No hay presupuestos registrados.");
        } else {
            presupuestos.forEach(System.out::println);
        }
    }
}
