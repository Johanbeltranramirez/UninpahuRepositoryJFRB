package Services;

import DB.DataBase;
import Models.Usuario;

public class UsuarioService {
    private DataBase db;

    public UsuarioService() {
        this.db = new DataBase();
        this.db.getUsuario();
        
    }
    public boolean agregarUsuario(Usuario nuevoUsuario) {

        return this.db.lstUsuarios.add(nuevoUsuario);

    }

    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : Usuario.getUsuario()) { 
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
        return db.getUsuario().removeIf(usuario -> usuario.getId() == id);
    }

    public boolean listarUsuarios() {
        return db.getUsuario();  
    }
}
