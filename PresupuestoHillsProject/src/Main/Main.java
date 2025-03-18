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
         //rol
        RolController rolcontroller = new RolController();
        
        //instanciar el objero 
        Rol rol;
        
        //insertar
        rol = new Rol(1, "Administrador");
        rolcontroller.insertarRol(rol);
        
        //eliminar
        rolcontroller.eliminarRol(1);
        
        //editar
        rol = new Rol(1, "CONTADOR");
        rolcontroller.insertarRol(rol);
        
        //leer
        rolcontroller.listarRoles();
        
        //USUARIO
        //INSTANCIAR
        UsuarioController usuarioController = new UsuarioController();
        
        //intacia del objeto
        Usuario usuario;
        
        //INSERTAR
        usuario = new Usuario(1, "123456789", "Natalia", "natisjcl02@gmail.com", rol);
        usuarioController.insertarUsuario(usuario);
        
        //Eliminar
        usuarioController.eliminarUsuario(1);
        
        // Editar
        usuario = new Usuario(1, "123456789", "Judy", "judy02@gmail.com", rol);
        usuarioController.actualizarUsuario(usuario);
        
        //leer usuario
        usuarioController.listarUsuarios();
        
        //tipo partida 
        //instancia
        TipoPartidaController tipopartidacontroller = new TipoPartidaController();
        
        //instancia del objeto 
        TipoPartida tipopartida;
        
        //insertar
        tipopartida  = new TipoPartida(1, "INGRESO");
        tipopartidacontroller.insertarTipoPartida(tipopartida);
        
        //eliminar
        tipopartidacontroller.eliminarTipoPartida(1);
        
        tipopartida = new TipoPartida(1,"GASTO");
        tipopartidacontroller.insertarTipoPartida(tipopartida);
        
        //Leer
        tipopartidacontroller.listarTipoPartida();
       
        
        //ESTADO PRESUPUESTO 

        EstadoPresupuestoController estadoController = new EstadoPresupuestoController();

        EstadoPresupuesto estado;

        estado = new EstadoPresupuesto(1, "Pendiente");
        estadoController.insertarEstado(estado);
 
        estadoController.eliminarEstado(1);

        estado = new EstadoPresupuesto(1, "aprobado");
        estadoController.actualizarEstado(estado);
             
        estadoController.listarEstados();

        //ESTADO APROBACION

        EstadoAprobacionController estadoAprobacionController = new EstadoAprobacionController();

        EstadoAprobacion estadoAprobacion;

        estadoAprobacion = new EstadoAprobacion(0, "En revisión");
        estadoAprobacionController.insertarEstado(estadoAprobacion);

        estadoAprobacionController.eliminarEstado(1);

        estadoAprobacion = new EstadoAprobacion(3, "Rechazado");
        estadoAprobacionController.actualizarEstado(estadoAprobacion);
    
        estadoAprobacionController.listarEstados();

        //EJECUCION PRESUPUESTARIA 

        EjecucionPresupuestariaController ejecucionController = new EjecucionPresupuestariaController();

        EjecucionPresupuestaria ejecucion;

        ejecucion = new EjecucionPresupuestaria(0, null, 15000.75, new Date());
        ejecucionController.insertarEjecucion(ejecucion);

        ejecucionController.eliminarEjecucion(2);

        ejecucion = new EjecucionPresupuestaria(3, null, 18000.00, new SimpleDateFormat("yyyy-MM-dd").parse("2025-06-15"));
        ejecucionController.actualizarEjecucion(ejecucion);
   
        ejecucionController.listarEjecuciones();

        //CATEGORIA PRESUPUESTO

        CategoriaPresupuestoController categoriaController = new CategoriaPresupuestoController();

        CategoriaPresupuesto categoria;

        categoria = new CategoriaPresupuesto(0, "Operaciones");
        categoriaController.insertarCategoria(categoria);
   
        categoriaController.eliminarCategoria(2);

        categoria = new CategoriaPresupuesto(4, "Inversión");
        categoriaController.actualizarCategoria(categoria);
    
        categoriaController.listarCategorias();


        //APROBACION

        AprobacionController aprobacionController = new AprobacionController();

        Aprobacion aprobacion;

        aprobacion = new Aprobacion(0, null, null, null, "Aprobación inicial", new Date());
        aprobacionController.insertarAprobacion(aprobacion);

        aprobacionController.eliminarCategoria(1);

        aprobacion = new Aprobacion(3, null, null, new EstadoAprobacion(1, "Aprobado"), "Revisión final", new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-20"));
        aprobacionController.actualizarAprobacion(aprobacion);
   
        aprobacionController.listarAprobacion();

    }
}