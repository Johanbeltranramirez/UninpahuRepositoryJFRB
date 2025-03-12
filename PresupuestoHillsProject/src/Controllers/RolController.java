package Controllers;

import Models.Rol;
import Services.RolService;
import java.util.List;

public class RolController {
    private RolService rolService;

    public RolController() {
        this.rolService = new RolService();
    }

    public void insertarRol(Rol rol) {
        if (rol == null) {
            System.out.println("Error: El rol no puede ser nulo.");
            return;
        }

        boolean respuesta = rolService.agregarRol(rol);
        if (respuesta) {
            System.out.println("Rol registrado con éxito.");
        } else {
            System.out.println("Error al registrar rol. Contacte al administrador.");
        }
    }

    public void actualizarRol(int id, String nuevaDescRol) {
        boolean respuesta = rolService.actualizarRol(id, nuevaDescRol);

        if (respuesta) {
            System.out.println("Rol actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar rol. Contacte al administrador.");
        }
    }

    public void eliminarRol(int id) {
        boolean respuesta = rolService.eliminarRol(id);
        if (respuesta) {
            System.out.println("Rol eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar rol. Contacte al administrador.");
        }
    }

    public void obtenerRol(int id) {
        Rol rol = rolService.obtenerRolPorId(id);
        if (rol != null) {
            System.out.println("Rol encontrado: " + rol.getDescRol());
        } else {
            System.out.println("No se encontró el rol con ID: " + id);
        }
    }

    public void listarRoles() {
        List<Rol> roles = rolService.listarRoles();
        if (roles.isEmpty()) {
            System.out.println("No hay roles registrados.");
        } else {
            for (Rol rol : roles) {
                System.out.println("ID: " + rol.getId() + ", Rol: " + rol.getDescRol());
            }
        }
    }
}
