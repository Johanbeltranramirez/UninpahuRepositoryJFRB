package Controllers;

import Models.Rol;
import Services.RolService;
import java.util.Date;

public class RolController {
    public RolService rolService;

    public RolController() {
        this.rolService = new RolService();
    }

    public void insertarRol(Rol rol) {
        if (rol == null) {
            System.out.println("Error: El rol no puede ser nulo.");
            return;
        }
        
        rolService.AgregarRol(rol);
        System.out.println("Rol registrado con éxito");
    }

    public void actualizarRol(Rol rol){
        rolService.EditarRol(rol);
        System.out.println("Rol actualizado con éxito.");
    }

    public void eliminarRol(int id) {
        rolService.EliminarRol(id);
        System.out.println("Rol eliminado correctamente ");
    }

    public void listarRoles() {
        rolService.MostrarRoles();
    }
}
