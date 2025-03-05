package Services;

import Models.Aprobacion;
import DB.DataBase;
import java.util.Date;

public class AprobacionService {
    private DataBase db;

    public AprobacionService() {
        this.db = new DataBase();
    }

    public boolean agregarAprobacion(Aprobacion nuevaAprobacion) {
        return this.db.lstAprobaciones.add(nuevaAprobacion);
    }

   /* public Aprobacion obtenerAprobacionPorId(int id) {
        for (Aprobacion aprobacion : db.getAprobaciones()) {
            if (aprobacion.getId() == id) {
                return aprobacion;
            }
        }
        return null;
    }

    public boolean actualizarAprobacion(int id, String estado, String comentarios, String fechaAprobacion) {
        Aprobacion aprobacion = obtenerAprobacionPorId(id);
        if (aprobacion != null) {
            aprobacion.setEstado(estado);
            aprobacion.setComentarios(comentarios);
            aprobacion.setFechaAprobacion(fechaAprobacion);
            return true;
        }
        return false;
    }*/

    public boolean eliminarAprobacion(int id) {
        boolean respuesta =false;
        
        for(int i = 0; i < this.db.lstAprobaciones.size(); i++){
            if (this.db.lstAprobaciones.get(i) !=null && this.db.lstAprobaciones.get(i).getId() == id){
                this.db.lstAprobaciones.remove(i);
                respuesta = true;
                break;
            }
        }
       return respuesta;
    }
    
    /*public boolean listarAprobaciones() {
        return db.lstAprobaciones();
    }*/
}
