package Services;

import Models.PresupuestoGeneral;
import Models.EstadoPresupuesto;
import Models.CategoriaPresupuesto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PresupuestoGeneralService {
    private List<PresupuestoGeneral> presupuestos;

    public PresupuestoGeneralService() {
        this.presupuestos = new ArrayList<>();
    }

    public boolean agregarPresupuesto(PresupuestoGeneral presupuesto) {
        if (presupuesto == null) {
            return false;
        }
        return presupuestos.add(presupuesto);
    }

    public boolean actualizarPresupuesto(int id, String nombre, String descripcion, double montoTotal, EstadoPresupuesto estado, CategoriaPresupuesto categoria, Date fechaCreacion) {
        for (PresupuestoGeneral presupuesto : presupuestos) {
            if (presupuesto.getId() == id) {
                presupuesto.setNombre(nombre);
                presupuesto.setDescripcion(descripcion);
                presupuesto.setMontoTotal(montoTotal);
                presupuesto.estado = estado;
                presupuesto.categoria = categoria;
                presupuesto.setFechaCreacion(fechaCreacion);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPresupuesto(int id) {
        return presupuestos.removeIf(presupuesto -> presupuesto.getId() == id);
    }

    public PresupuestoGeneral obtenerPresupuestoPorId(int id) {
        for (PresupuestoGeneral presupuesto : presupuestos) {
            if (presupuesto.getId() == id) {
                return presupuesto;
            }
        }
        return null;
    }

    public List<PresupuestoGeneral> listarPresupuestos() {
        return new ArrayList<>(presupuestos);
    }
}