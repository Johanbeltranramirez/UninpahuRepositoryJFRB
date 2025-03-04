package DB;
import Models.Usuario;
import Models.PresupuestoGeneral;
import Models.Aprobacion;
import java.util.ArrayList;


public class Database{
    
    ArrayList<Usuario> lstUsuarios;
    ArrayList<PresupuestoGeneral> lstPresupuestos;
    ArrayList<Aprobacion> lstAprobaciones;
    

    
    public Database(){
    }
    
    public void getUsuario(){
        lstUsuarios = new ArrayList<>();
        
        lstUsuarios.add(new Usuario(1, "Johan Ramirez", "jhoan123@gmail.com", "administrador"));
        lstUsuarios.add(new Usuario(2, "Andres Jimenez", "Jimenez02@gmail.com", "finanzas"));
        lstUsuarios.add(new Usuario(3, "Maria Gonzalez", "maria.g@gmail.com", "administrador"));
        lstUsuarios.add(new Usuario(4, "Carlos Perez", "carlos.perez@yahoo.com", "contable"));
        lstUsuarios.add(new Usuario(5, "Laura Torres", "laura.t@gmail.com", "finanzas"));

    }
    
        public void getPresupuestoGeneral(){
        lstPresupuestos = new ArrayList<>();
        
        lstPresupuestos.add(new PresupuestoGeneral(1, "Presupuesto 2025", "Presupuesto anual para operaciones generales", 50000, "Pendiente", '02/03/2025'));

    }
        
    public void getAprobaciones(){
        lstAprobaciones = new ArrayList<>();
        
        lstAprobaciones.add(new Aprobacion(1, "Presupuesto 2025", 1, "pendiente" ));
        
    }
    
}
