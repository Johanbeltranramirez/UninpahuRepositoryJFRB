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

    public void actualizarPresupuesto(PresupuestoGeneral editarPresupuesto) {
        boolean respuesta = presupuestoService.actualizarPresupuesto(editarPresupuesto);
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

    public void ObtenerLista() {
        presupuestoService.ObtenerLista();
    }

    
}
