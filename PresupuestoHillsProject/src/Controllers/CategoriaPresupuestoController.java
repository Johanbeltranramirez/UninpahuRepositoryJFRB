package Controllers;
import Models.CategoriaPresupuesto;
import Services.CategoriaPresupuestoService;
import java.util.List;

public class CategoriaPresupuestoController {
    private CategoriaPresupuestoService categoriaService;

    public CategoriaPresupuestoController(CategoriaPresupuestoService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public void insertarCategoria(CategoriaPresupuesto categoria) {
        if (categoria == null) {
            System.err.println("Error: La categoría no puede ser nula.");
            return;
        }

        categoriaService.AgregarCategoriaPresupuesto(categoria);
        System.out.println("Categoría registrada con éxito.");
    }

    public void actualizarCategoria(CategoriaPresupuesto categoria) {
        categoriaService.EditarCategoriaPresupuesto(categoria);
        System.out.println("Categoría actualizada con éxito.");
    }

    public void eliminarCategoria(int id) {
        categoriaService.EliminarCategoriaPresupuesto(id);
        System.out.println("Categoría eliminada correctamente.");
    }

    public void listarCategorias() {
        categoriaService.MostrarCategoriasPresupuesto();
    }
}
