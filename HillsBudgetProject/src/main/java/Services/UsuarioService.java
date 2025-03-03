package Services;

import Models.Usuario;
import DB.UsuarioDB;

public class UsuarioService {
    private UsuarioDB dbUsuario;

    public UsuarioService() {
        this.dbUsuario = new UsuarioDB();
    }

    public boolean agregarUsuario(Usuario usuario) {
        return dbUsuario.getUsuario().add(usuario);  
    }

    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : dbUsuario.getUsuario()) { // Accede correctamente a la lista
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(int id, String nombre, String email, String rol) {
        Usuario usuario = obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setRol(rol);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(int id) {
        return dbUsuario.getUsuario().removeIf(usuario -> usuario.getId() == id);
    }

    public boolean listarUsuarios() {
        return dbUsuario.getUsuario();  
    }
}
