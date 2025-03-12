package Controllers;

import Models.EstadoAprobacion;
import Services.EstadoAprobacionService;
import java.util.List;

public class EstadoAprobacionController {
    private EstadoAprobacionService estadoService;

    public EstadoAprobacionController(EstadoAprobacionService estadoService) {
        this.estadoService = estadoService;
    }

    public void insertarEstado(EstadoAprobacion estado) {
        if (estado == null) {
            System.err.println("Error: El estado de aprobación no puede ser nulo.");
            return;
        }

        boolean respuesta = estadoService.agregarEstado(estado);
        if (respuesta) {
            System.out.println("Estado de aprobación registrado con éxito.");
        } else {
            System.err.println("Error al registrar el estado. Contacte al administrador.");
        }
    }

    public void actualizarEstado(int id, String nuevaDescripcion) {
        boolean respuesta = estadoService.actualizarEstado(id, nuevaDescripcion);
        if (respuesta) {
            System.out.println("Estado de aprobación actualizado con éxito.");
        } else {
            System.err.println("Error al actualizar el estado. Contacte al administrador.");
        }
    }

    public void eliminarEstado(int id) {
        boolean respuesta = estadoService.eliminarEstado(id);
        if (respuesta) {
            System.out.println("Estado de aprobación eliminado correctamente.");
        } else {
            System.err.println("Error al eliminar el estado. Contacte al administrador.");
        }
    }

    public void obtenerEstado(int id) {
        EstadoAprobacion estado = estadoService.obtenerEstadoPorId(id);
        if (estado != null) {
            System.out.println("Estado encontrado: " + estado.getDescEstado());
        } else {
            System.err.println("No se encontró el estado con ID: " + id);
        }
    }

    public void listarEstados() {
        List<EstadoAprobacion> estados = estadoService.listarEstados();
        if (estados.isEmpty()) {
            System.out.println("No hay estados de aprobación registrados.");
        } else {
            for (EstadoAprobacion estado : estados) {
                System.out.println("ID: " + estado.getId() + ", Descripción: " + estado.getDescEstado());
            }
        }
    }
}
