package Services;
import DB.DataBaseSQL;
import java.sql.Connection;
import Models.EstadoPresupuesto;
import java.util.ArrayList;
import java.util.List;

public class EstadoPresupuestoService {

    public void agregarEstado(EstadoPresupuesto estado) {
        Connection conexion = DataBaseSQL.Conectar ();
        
        String sql = "INSERT INTO EstadoPresupuesto (id, descEstado) VALUES (?,?)";
        
        try (PreparedStatement stmt = conexion.preparedStatement(sql)) {
            stmt setInt = (1, estado.getId());
            stmt setInt = (2, estado.getId());
        
        }
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
