package Controllers;
import Models.EstadoPresupuesto;
import Services.EstadoPresupuestoService;

public class EstadoPresupuestoController {
    public EstadoPresupuestoService estadoService;

    public EstadoPresupuestoController() {
        this.estadoService = new EstadoPresupuestoService ();
    }

    public void insertarEstado(EstadoPresupuesto estado) {
        if (estado == null) {
            System.err.println("Error: El estado del presupuesto no puede ser nulo.");
            return;
        }

        estadoService.AgregarEstadoPresupuesto(estado);
        System.out.println("Estado del presupuesto registrado con éxito.");
    }

    public void actualizarEstado(EstadoPresupuesto estado) {
        estadoService.EditarEstadoPresupuesto(estado);
        System.out.println("Estado del presupuesto actualizado con éxito.");
    }

    public void eliminarEstado(int id) {
        estadoService.EliminarEstadoPresupuesto(id);
        System.out.println("Estado del presupuesto eliminado correctamente.");
    }

    public void listarEstados() {
        estadoService.MostrarEstadosPresupuesto();
    }
}
