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
        if (presupuesto == null) {
            System.err.println("Error: El presupuesto no puede ser nulo.");
            return;
        }

        presupuestoService.agregarPresupuesto(presupuesto);
        System.out.println("Presupuesto registrado con éxito.");
    }

    public void actualizarPresupuesto(PresupuestoGeneral presupuesto) {
        presupuestoService.editarPresupuesto(presupuesto);
        System.out.println("Presupuesto actualizado con éxito.");
    }

    public void eliminarPresupuesto(int id) {
        presupuestoService.eliminarPresupuesto(id);
        System.out.println("Presupuesto eliminado correctamente.");
    }

    public void listarPresupuestos() {
        presupuestoService.MostrarPresupuetsos();
        }
 }


