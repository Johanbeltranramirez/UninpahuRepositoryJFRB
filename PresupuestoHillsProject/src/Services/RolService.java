package Services;

import Models.Rol;
import java.util.ArrayList;
import java.util.List;

public class RolService {
    private List<Rol> roles;

    public RolService() {
        this.roles = new ArrayList<>();
    }

    public boolean agregarRol(Rol rol) {
        if (rol == null) {
            return false;
        }
        return roles.add(rol);
    }

    public boolean actualizarRol(int id, String descRol) {
        for (Rol rol : roles) {
            if (rol.getId() == id) {
                rol.setDescRol(descRol);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarRol(int id) {
        return roles.removeIf(rol -> rol.getId() == id);
    }

    public Rol obtenerRolPorId(int id) {
        for (Rol rol : roles) {
            if (rol.getId() == id) {
                return rol;
            }
        }
        return null;
    }

    public List<Rol> listarRoles() {
        return new ArrayList<>(roles);
    }
}