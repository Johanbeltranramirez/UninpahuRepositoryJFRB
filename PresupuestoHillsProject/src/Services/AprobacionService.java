package Services;

import Models.Aprobacion;
import Models.EstadoAprobacion;
import DB.DataBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AprobacionService {
    private DataBase db;

    public AprobacionService() {
        this.db = new DataBase();
        this.db.getAprobaciones();
    }

    public boolean agregarAprobacion(Aprobacion nuevaAprobacion) {
        return this.db.lstAprobaciones.add(nuevaAprobacion);
    }

    public Aprobacion obtenerAprobacionPorId(int id) {
        for (Aprobacion aprobacion : db.lstAprobaciones) {
            if (aprobacion.getId() == id) {
                return aprobacion;
            }
        }
        return null;
    }

    public boolean actualizarAprobacion(int id, EstadoAprobacion estado, String comentarios, String fechaStr) {
        Aprobacion aprobacion = obtenerAprobacionPorId(id);
        if (aprobacion == null) {
            System.out.println("Error: No se encontró la aprobación con ID " + id);
            return false;
        }

        aprobacion.setComentarios(comentarios);

        // Convertir String a Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaAprobacion = sdf.parse(fechaStr);
            aprobacion.setFechaAprobacion(fechaAprobacion);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            return false;
        }

        aprobacion.estado = estado; // Asignación directa al atributo público
        return true;
    }

    public boolean eliminarAprobacion(int id) {
        return this.db.lstAprobaciones.removeIf(aprobacion -> aprobacion.getId() == id);
    }

    public List<Aprobacion> listarAprobaciones() {
        return db.lstAprobaciones;
    }
}
