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

        boolean respuesta = categoriaService.agregarCategoria(categoria);
        if (respuesta) {
            System.out.println("Categoría registrada con éxito.");
        } else {
            System.err.println("Error al registrar categoría. Contacte al administrador.");
        }
    }

    public void actualizarCategoria(int id, String nombreCategoria) {
        boolean respuesta = categoriaService.actualizarCategoria(id, nombreCategoria);
        if (respuesta) {
            System.out.println("Categoría actualizada con éxito.");
        } else {
            System.err.println("Error al actualizar categoría. Contacte al administrador.");
        }
    }

    public void eliminarCategoria(int id) {
        boolean respuesta = categoriaService.eliminarCategoria(id);
        if (respuesta) {
            System.out.println("Categoría eliminada correctamente.");
        } else {
            System.err.println("Error al eliminar categoría. Contacte al administrador.");
        }
    }

    public void obtenerCategoria(int id) {
        CategoriaPresupuesto categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria != null) {
            System.out.println("Categoría encontrada: " + categoria.getNombreCategoria());
        } else {
            System.err.println("No se encontró la categoría con ID: " + id);
        }
    }

    public void listarCategorias() {
        List<CategoriaPresupuesto> categorias = categoriaService.listarCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            for (CategoriaPresupuesto categoria : categorias) {
                System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombreCategoria());
            }
        }
    }
}
