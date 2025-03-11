package DB;
import Models.Usuario;
import Models.PresupuestoGeneral;
import Models.Aprobacion;
import java.util.ArrayList;


public class DataBase{
    
    public ArrayList<Usuario> lstUsuarios;
    public ArrayList<PresupuestoGeneral> lstPresupuestos;
    public ArrayList<Aprobacion> lstAprobaciones;
    

    
    public DataBase(){
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
        
        lstPresupuestos.add(new PresupuestoGeneral(1, "Presupuesto 2025", "Presupuesto anual para operaciones generales", 6.2500, "Pendiente", "2025-03-25"));
        lstPresupuestos.add(new PresupuestoGeneral(2, "Presupuesto Marketing", "Campañas publicitarias y estrategias de mercado", 4.8000, "Aprobado", "2025-04-10"));
        lstPresupuestos.add(new PresupuestoGeneral(3, "Presupuesto Tecnología", "Inversión en hardware y software", 10.5000, "Pendiente", "2025-05-15"));
        lstPresupuestos.add(new PresupuestoGeneral(4, "Presupuesto RRHH", "Capacitación y contratación de personal", 3.2000, "Rechazado", "2025-06-05"));
        lstPresupuestos.add(new PresupuestoGeneral(5, "Presupuesto Infraestructura", "Mantenimiento y mejoras en instalaciones", 7.7500, "Aprobado", "2025-07-20"));
        lstPresupuestos.add(new PresupuestoGeneral(6, "Presupuesto Innovación", "Investigación y desarrollo de nuevos productos", 5.6000, "Pendiente", "2025-08-12"));
        lstPresupuestos.add(new PresupuestoGeneral(7, "Presupuesto Seguridad", "Mejoras en seguridad física y digital", 4.9500, "Aprobado", "2025-09-30"));


    }
        
   public void getAprobaciones() {
    lstAprobaciones = new ArrayList<>();

    // Aseguramos que las listas de usuarios y presupuestos tengan datos
    getUsuario();
    getPresupuestoGeneral();

    // Obtenemos un usuario y un presupuesto de las listas
    Usuario usuario = lstUsuarios.get(0); // Tomamos el primer usuario (ID 1)
    PresupuestoGeneral presupuesto = lstPresupuestos.get(0); // Tomamos el primer presupuesto (ID 1)

  

    // Agregamos la aprobación con los objetos correctos
    lstAprobaciones.add(new Aprobacion(1, presupuesto, usuario, "Aprobado", "Se aprueba de manera exitosa", "2025-03-05"));
    lstAprobaciones.add(new Aprobacion(2, lstPresupuestos.get(1), lstUsuarios.get(2), "Pendiente", "En espera de revisión", ("2025-04-01")));
    lstAprobaciones.add(new Aprobacion(3, lstPresupuestos.get(2), lstUsuarios.get(3), "Rechazado", "No cumple con los requisitos", ("2025-05-10")));
    lstAprobaciones.add(new Aprobacion(4, lstPresupuestos.get(3), lstUsuarios.get(0), "Aprobado", "Validado por dirección", ("2025-06-15")));
    lstAprobaciones.add(new Aprobacion(5, lstPresupuestos.get(4), lstUsuarios.get(1), "Pendiente", "Esperando aprobación de gerencia", ("2025-07-20")));
    lstAprobaciones.add(new Aprobacion(6, lstPresupuestos.get(5), lstUsuarios.get(4), "Aprobado", "Autorizado para ejecución", ("2025-08-05")));
    lstAprobaciones.add(new Aprobacion(7, lstPresupuestos.get(6), lstUsuarios.get(3), "Rechazado", "Presupuesto insuficiente", ("2025-09-18")));


   }

    
    
}