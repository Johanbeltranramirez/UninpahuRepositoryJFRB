package Services;
import DB.DataBaseSQL;
import java.sql.Connection;
import Models.EstadoAprobacion;
import java.util.ArrayList;
import java.util.List;

public class EstadoAprobacionService {
    private List<EstadoAprobacion> estados;

    public EstadoAprobacionService() {
        this.estados = new ArrayList<>();
    }

    public boolean agregarEstado(EstadoAprobacion estado) {
        if (estado == null) {
            return false;
        }
        return estados.add(estado);
    }

    public boolean actualizarEstado(int id, String nuevaDescripcion) {
        for (EstadoAprobacion estado : estados) {
            if (estado.getId() == id) {
                estado.setDescEstado(nuevaDescripcion);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstado(int id) {
        return estados.removeIf(estado -> estado.getId() == id);
    }

    public EstadoAprobacion obtenerEstadoPorId(int id) {
        for (EstadoAprobacion estado : estados) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        return null;
    }

    public List<EstadoAprobacion> listarEstados() {
        return new ArrayList<>(estados);
    }
}
