package Controllers;

import Models.EstadoPresupuesto;
import Services.EstadoPresupuestoService;
import java.util.List;

public class EstadoPresupuestoController {
    private EstadoPresupuestoService estadoService;

    public EstadoPresupuestoController(EstadoPresupuestoService estadoService) {
        this.estadoService = estadoService;
    }

    public void insertarEstado(EstadoPresupuesto estado) {
        if (estado == null) {
            System.err.println("Error: El estado del presupuesto no puede ser nulo.");
            return;
        }

        boolean respuesta = estadoService.agregarEstado(estado);
        if (respuesta) {
            System.out.println("Estado del presupuesto registrado con éxito.");
        } else {
            System.err.println("Error al registrar el estado. Contacte al administrador.");
        }
    }

    public void actualizarEstado(int id, String nuevaDescripcion) {
        boolean respuesta = estadoService.actualizarEstado(id, nuevaDescripcion);
        if (respuesta) {
            System.out.println("Estado del presupuesto actualizado con éxito.");
        } else {
            System.err.println("Error al actualizar el estado. Contacte al administrador.");
        }
    }

    public void eliminarEstado(int id) {
        boolean respuesta = estadoService.eliminarEstado(id);
        if (respuesta) {
            System.out.println("Estado del presupuesto eliminado correctamente.");
        } else {
            System.err.println("Error al eliminar el estado. Contacte al administrador.");
        }
    }

    public void obtenerEstado(int id) {
        EstadoPresupuesto estado = estadoService.obtenerEstadoPorId(id);
        if (estado != null) {
            System.out.println("Estado encontrado: " + estado.getDescEstado());
        } else {
            System.err.println("No se encontró el estado con ID: " + id);
        }
    }

    public void listarEstados() {
        List<EstadoPresupuesto> estados = estadoService.listarEstados();
        if (estados.isEmpty()) {
            System.out.println("No hay estados de presupuesto registrados.");
        } else {
            for (EstadoPresupuesto estado : estados) {
                System.out.println("ID: " + estado.getId() + ", Descripción: " + estado.getDescEstado());
            }
        }
    }
}
