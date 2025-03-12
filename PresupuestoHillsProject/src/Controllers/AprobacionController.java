package Controllers;

import Models.Aprobacion;
import Models.EstadoAprobacion;
import Services.AprobacionService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AprobacionController {
    private AprobacionService aprobacionService;

    public AprobacionController() {
        this.aprobacionService = new AprobacionService();
    }

    public void insertarAprobacion(Aprobacion aprobacion) {
        boolean respuesta = aprobacionService.agregarAprobacion(aprobacion);
        if (respuesta) {
            System.out.println("Aprobación registrada con éxito.");
        } else {
            System.out.println("Error al registrar aprobación. Contacte al administrador.");
        }
    }

    public void actualizarAprobacion(int id, EstadoAprobacion estado, String comentarios, String fechaStr) {
        boolean respuesta = aprobacionService.actualizarAprobacion(id, estado, comentarios, fechaStr);
        if (respuesta) {
            System.out.println("Aprobación actualizada con éxito.");
        } else {
            System.out.println("Error al actualizar aprobación. Contacte al administrador.");
        }
    }

    public void eliminarAprobacion(int id) {
        boolean respuesta = aprobacionService.eliminarAprobacion(id);
        if (respuesta) {
            System.out.println("Aprobación eliminada correctamente.");
        } else {
            System.out.println("Error al eliminar aprobación. Contacte al administrador.");
        }
    }

    public void obtenerAprobacion(int id) {
        Aprobacion aprobacion = aprobacionService.obtenerAprobacionPorId(id);
        if (aprobacion != null) {
            System.out.println(aprobacion);
        } else {
            System.out.println("Aprobación no encontrada.");
        }
    }

    public void listarAprobaciones() {
        List<Aprobacion> aprobaciones = aprobacionService.listarAprobaciones();
        if (aprobaciones.isEmpty()) {
            System.out.println("No hay aprobaciones registradas.");
        } else {
            aprobaciones.forEach(System.out::println);
        }
    }
}
