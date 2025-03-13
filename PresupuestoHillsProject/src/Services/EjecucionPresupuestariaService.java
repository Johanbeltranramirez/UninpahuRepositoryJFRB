package Services;
import DB.DataBaseSQL;
import java.sql.Connection;
import Models.EjecucionPresupuestaria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EjecucionPresupuestariaService {
    private List<EjecucionPresupuestaria> ejecuciones;

    public EjecucionPresupuestariaService() {
        this.ejecuciones = new ArrayList<>();
    }

    public boolean agregarEjecucion(EjecucionPresupuestaria ejecucion) {
        if (ejecucion == null) {
            return false;
        }
        return ejecuciones.add(ejecucion);
    }

    public boolean actualizarEjecucion(int id, double montoReal, Date fecha) {
        for (EjecucionPresupuestaria ejecucion : ejecuciones) {
            if (ejecucion.getId() == id) {
                ejecucion.setMontoReal(montoReal);
                ejecucion.setFecha(fecha);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEjecucion(int id) {
        return ejecuciones.removeIf(ejecucion -> ejecucion.getId() == id);
    }

    public EjecucionPresupuestaria obtenerEjecucionPorId(int id) {
        for (EjecucionPresupuestaria ejecucion : ejecuciones) {
            if (ejecucion.getId() == id) {
                return ejecucion;
            }
        }
        return null;
    }

    public List<EjecucionPresupuestaria> listarEjecuciones() {
        return new ArrayList<>(ejecuciones);
    }
}
