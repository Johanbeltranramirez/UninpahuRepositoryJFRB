package Services;

import Models.PartidaPresupuestaria;
import Models.CategoriaPresupuesto;
import Models.TipoPartida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartidaPresupuestariaService {
    private List<PartidaPresupuestaria> partidas;

    public PartidaPresupuestariaService() {
        this.partidas = new ArrayList<>();
    }

    public boolean agregarPartida(PartidaPresupuestaria partida) {
        if (partida == null) {
            return false;
        }
        return partidas.add(partida);
    }

    public boolean actualizarPartida(int id, CategoriaPresupuesto categoria, String descripcion, double monto, TipoPartida tipo, Date fecha) {
        for (PartidaPresupuestaria partida : partidas) {
            if (partida.getId() == id) {
                partida.categoria = categoria;
                partida.setDescripcion(descripcion);
                partida.setMonto(monto);
                partida.tipo = tipo;
                partida.setFecha(fecha);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPartida(int id) {
        return partidas.removeIf(partida -> partida.getId() == id);
    }

    public PartidaPresupuestaria obtenerPartidaPorId(int id) {
        for (PartidaPresupuestaria partida : partidas) {
            if (partida.getId() == id) {
                return partida;
            }
        }
        return null;
    }

    public List<PartidaPresupuestaria> listarPartidas() {
        return new ArrayList<>(partidas);
    }
}
