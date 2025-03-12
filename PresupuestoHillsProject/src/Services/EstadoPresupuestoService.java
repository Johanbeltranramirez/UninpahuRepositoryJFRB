package Services;

import Models.EstadoPresupuesto;
import java.util.ArrayList;
import java.util.List;

public class EstadoPresupuestoService {
    private List<EstadoPresupuesto> estados;

    public EstadoPresupuestoService() {
        this.estados = new ArrayList<>();
    }

    public boolean agregarEstado(EstadoPresupuesto estado) {
        if (estado == null) {
            return false;
        }
        return estados.add(estado);
    }

    public boolean actualizarEstado(int id, String nuevaDescripcion) {
        for (EstadoPresupuesto estado : estados) {
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

    public EstadoPresupuesto obtenerEstadoPorId(int id) {
        for (EstadoPresupuesto estado : estados) {
            if (estado.getId() == id) {
                return estado;
            }
        }
        return null;
    }

    public List<EstadoPresupuesto> listarEstados() {
        return new ArrayList<>(estados);
    }
}
