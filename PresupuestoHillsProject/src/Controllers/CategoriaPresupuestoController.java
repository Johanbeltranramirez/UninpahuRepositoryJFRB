package Controllers;
import Models.CategoriaPresupuesto;
import Services.CategoriaPresupuestoService;
import java.sql.ResultSet;

public class CategoriaPresupuestoController {
    
    public CategoriaPresupuestoService categoriaService;

    public CategoriaPresupuestoController() {
        this.categoriaService = new CategoriaPresupuestoService ();
    }

    public void insertarCategoria(CategoriaPresupuesto categoria) {
        categoriaService.AgregarCategoriaPresupuesto(categoria);
    }

    public void eliminarCategoria(int id) {
        categoriaService.EliminarCategoriaPresupuesto(id);
    }
    
    public void actualizarCategoria(CategoriaPresupuesto categoria, int id) {
        categoriaService.EditarCategoriaPresupuesto(categoria, id);
    }    

    public ResultSet listarCategorias(String ConsultaSQL) {
        return categoriaService.MostrarCategoriasPresupuesto(ConsultaSQL);
    }
}
