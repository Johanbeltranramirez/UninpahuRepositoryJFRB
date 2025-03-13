package Services;
import DB.DataBaseSQL;
import java.sql.Connection;
import Models.CategoriaPresupuesto;
import java.util.ArrayList;
import java.util.List;

public class CategoriaPresupuestoService {
    private List<CategoriaPresupuesto> categorias;

    public CategoriaPresupuestoService() {
        this.categorias = new ArrayList<>();
    }

    public boolean agregarCategoria(CategoriaPresupuesto categoria) {
        if (categoria == null) {
            return false;
        }
        return categorias.add(categoria);
    }

    public boolean actualizarCategoria(int id, String nombreCategoria) {
        for (CategoriaPresupuesto categoria : categorias) {
            if (categoria.getId() == id) {
                categoria.setNombreCategoria(nombreCategoria);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCategoria(int id) {
        return categorias.removeIf(categoria -> categoria.getId() == id);
    }

    public CategoriaPresupuesto obtenerCategoriaPorId(int id) {
        for (CategoriaPresupuesto categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public List<CategoriaPresupuesto> listarCategorias() {
        return new ArrayList<>(categorias);
    }
}
