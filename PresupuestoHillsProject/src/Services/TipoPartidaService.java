package Services;

import Models.TipoPartida;
import java.util.ArrayList;
import java.util.List;

public class TipoPartidaService {
    private List<TipoPartida> tiposPartida;

    public TipoPartidaService() {
        this.tiposPartida = new ArrayList<>();
    }

    public boolean agregarTipoPartida(TipoPartida tipo) {
        if (tipo == null) {
            return false;
        }
        return tiposPartida.add(tipo);
    }

    public boolean actualizarTipoPartida(int id, String descTipo) {
        for (TipoPartida tipo : tiposPartida) {
            if (tipo.getId() == id) {
                tipo.setDescTipo(descTipo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarTipoPartida(int id) {
        return tiposPartida.removeIf(tipo -> tipo.getId() == id);
    }

    public TipoPartida obtenerTipoPartidaPorId(int id) {
        for (TipoPartida tipo : tiposPartida) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null;
    }

    public List<TipoPartida> listarTiposPartida() {
        return new ArrayList<>(tiposPartida);
    }
}
