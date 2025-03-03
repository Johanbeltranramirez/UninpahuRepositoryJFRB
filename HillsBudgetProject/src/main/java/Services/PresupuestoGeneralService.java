package Services;

import Models.PresupuestoGeneral;
import DB.PresupuestoGeneralDB;

public class PresupuestoGeneralService {
    private PresupuestoGeneralDB dbPresupuesto;

    public PresupuestoGeneralService() {
        this.dbPresupuesto = new PresupuestoGeneralDB();
    }

    public boolean agregarPresupuesto(PresupuestoGeneral presupuesto) {
        return dbPresupuesto.getPresupuestoGeneral().add(presupuesto);
    }

    public PresupuestoGeneral obtenerPresupuestoPorId(int id) {
        for (PresupuestoGeneral presupuesto : dbPresupuesto.getPresupuestoGeneral()) {
            if (presupuesto.getId() == id) {
                return presupuesto;
            }
        }
        return null;
    }

    public boolean actualizarPresupuesto(int id, String nombre, String descripcion, double montoTotal, String estado) {
        PresupuestoGeneral presupuesto = obtenerPresupuestoPorId(id);
        if (presupuesto != null) {
            presupuesto.setNombre(nombre);
            presupuesto.setDescripcion(descripcion);
            presupuesto.setMontoTotal(montoTotal);
            presupuesto.setEstado(estado);
            return true;
        }
        return false;
    }

    public boolean eliminarPresupuesto(int id) {
        return dbPresupuesto.getPresupuestos().removeIf(presupuesto -> presupuesto.getId() == id);
    }

    public boolean listarPresupuestos() {
        return dbPresupuesto.getPresupuestos();
    }
}
