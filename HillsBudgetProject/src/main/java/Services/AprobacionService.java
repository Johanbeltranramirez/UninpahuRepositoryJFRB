package Services;

import Models.Aprobacion;
import DB.AprobacionDB;
import java.util.Date;

public class AprobacionService {
    private AprobacionDB dbAprobacion;

    public AprobacionService(AprobacionDB db) {
        this.dbAprobacion = new AprobacionDB();
    }

    public boolean agregarAprobacion(Aprobacion aprobacion) {
        return dbAprobacion.getAprobaciones().add(aprobacion);  // Accede a la DB
    }

    public Aprobacion obtenerAprobacionPorId(int id) {
        for (Aprobacion aprobacion : dbAprobacion.getAprobaciones()) {
            if (aprobacion.getId() == id) {
                return aprobacion;
            }
        }
        return null;
    }

    public boolean actualizarAprobacion(int id, String estado, String comentarios, Date fechaAprobacion) {
        Aprobacion aprobacion = obtenerAprobacionPorId(id);
        if (aprobacion != null) {
            aprobacion.setEstado(estado);
            aprobacion.setComentarios(comentarios);
            aprobacion.setFechaAprobacion(fechaAprobacion);
            return true;
        }
        return false;
    }

    public boolean eliminarAprobacion(int id) {
        return dbAprobacion.getAprobaciones().removeIf(aprobacion -> aprobacion.getId() == id);
    }

    public boolean listarAprobaciones() {
        return dbAprobacion.getAprobaciones();
    }
}
