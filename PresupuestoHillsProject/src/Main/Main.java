package Main;
//Models
import Models.Usuario;
import Models.TipoPartida;
import Models.Rol;
import Models.PresupuestoGeneral;
import Models.PartidaPresupuestaria;
import Models.EstadoPresupuesto;
import Models.EstadoAprobacion;
import Models.EjecucionPresupuestaria;
import Models.CategoriaPresupuesto;
import Models.Aprobacion;
//Controllers
import Controllers.UsuarioController;
import Controllers.TipoPartidaController;
import Controllers.RolController;
import Controllers.PresupuestoGeneralController;
import Controllers.PartidaPresupuestariaController;
import Controllers.EstadoPresupuestoController;
import Controllers.EstadoAprobacionController;
import Controllers.EjecucionPresupuestariaController;
import Controllers.CategoriaPresupuestoController;
import Controllers.AprobacionController;
//Function
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws ParseException {
        //USUARIO
        
        //ESTADO PRESUPUESTO 

        EstadoPresupuestoController estadoController = new EstadoPresupuestoController();

        EstadoPresupuesto estadoPresupuesto;

        estadoPresupuesto = new EstadoPresupuesto(0, "Pendiente");
        estadoController.insertarEstado(estadoPresupuesto);
 
        estadoController.eliminarEstado(1);

        estadoPresupuesto = new EstadoPresupuesto(2, "Aprobado");
        estadoController.actualizarEstado("", "Aprobado");
             
        estadoController.listarEstados();

        //ESTADO APROBACION

        EstadoAprobacionController estadoAprobacionController = new EstadoAprobacionController();

        EstadoAprobacion estadoAprobacion;

        estadoAprobacion = new EstadoAprobacion(0, "En revisión");
        estadoAprobacionController.insertarEstado(estadoAprobacion);

        estadoAprobacionController.eliminarEstado(1);

        estadoAprobacion = new EstadoAprobacion(3, "Rechazado");
        estadoAprobacionController.actualizarEstado(3, "Rechazado");
    
        estadoAprobacionController.listarEstados();

        //EJECUCION PRESUPUESTARIA 

        EjecucionPresupuestariaController ejecucionController = new EjecucionPresupuestariaController();

        EjecucionPresupuestaria ejecucion;

        ejecucion = new EjecucionPresupuestaria(0, null, 15000.75, new Date());
        ejecucionController.insertarEjecucion(ejecucion);

        ejecucionController.eliminarEjecucion(2);

        ejecucion = new EjecucionPresupuestaria(3, null, 18000.00, new SimpleDateFormat("yyyy-MM-dd").parse("2025-06-15"));
        ejecucionController.actualizarEjecucion(3, 18000.00, new SimpleDateFormat("yyyy-MM-dd").parse("2025-06-15"));
   
        ejecucionController.listarEjecuciones();

        //CATEGORIA PRESUPUESTO

        CategoriaPresupuestoController categoriaController = new CategoriaPresupuestoController();

        CategoriaPresupuesto categoria;

        categoria = new CategoriaPresupuesto(0, "Operaciones");
        categoriaController.insertarCategoria(categoria);
   
        categoriaController.eliminarCategoria(2);

        categoria = new CategoriaPresupuesto(4, "Inversión");
        categoriaController.actualizarCategoria(4, "Inversión");
    
        categoriaController.listarCategorias();


        //APROBACION

        AprobacionController aprobacionController = new AprobacionController();

        Aprobacion aprobacion;

        aprobacion = new Aprobacion(0, null, null, null, "Aprobación inicial", new Date());
        aprobacionController.insertarAprobacion(aprobacion);

        aprobacionController.eliminarAprobacion(1);

        aprobacion = new Aprobacion(3, null, null, new EstadoAprobacion(1, "Aprobado"), "Revisión final", new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-20"));
        aprobacionController.actualizarAprobacion(3, new EstadoAprobacion(1, "Aprobado"), "Revisión final", "2025-07-20");
   
        aprobacionController.listarAprobacion();

    }
}